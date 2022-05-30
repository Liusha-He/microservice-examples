use {
    uuid::Uuid,
    actix_web::HttpResponse,
    actix_web::web::{Json, Data, Path},

    crate::model::miner::*,
    crate::utils::{NotFoundMessage, ResponseType},
    crate::DBPool,
};

#[get("/miners")]
pub async fn list_miners(pool: Data<DBPool>) -> HttpResponse {
    /*
    Get all MinerDAO from db and convert to Miner object
     */
    let conn = crate::get_connection_to_pool(pool);

    let miners: Vec<Miner> = fetch_all_miners(&conn);
    ResponseType::Ok(miners).get_response()
}

#[get("/miners/{id}")]
pub async fn get_miner(path: Path<(String,)>, pool: Data<DBPool>) -> HttpResponse {
    /*
    Get a MinerDAO by its ID and convert to Miner object
     */
    let conn = crate::get_connection_to_pool(pool);

    let miner: Option<Miner> = fetch_miner_by_id(
        Uuid::parse_str(path.0.0.as_str()).unwrap(), &conn
    );
    match miner {
        Some(miner) => ResponseType::Ok(miner).get_response(),
        None => ResponseType::NotFound(
            NotFoundMessage::new("miner not found!".to_string())
        ).get_response(),
    }
}

#[post("/wallets/{id}/miners")]
pub async fn create_miner(
    path: Path<(String,)>, miner_request: Json<NewMinerRequest>, pool: Data<DBPool>
) -> HttpResponse {
    /*
    Create a new MinerDAO object and write to DB.
     */
    let conn = crate::get_connection_to_pool(pool);

    match create_new_miner(
        miner_request.0,
        Uuid::parse_str(path.0.0.as_str()).unwrap(),
        &conn) {
        Ok(created_miner) => ResponseType::Created(created_miner).get_response(),
        Err(_) => ResponseType::NotFound(
            NotFoundMessage::new("Failed to create miner".to_string())
        ).get_response(),
    }
}

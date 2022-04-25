FROM rust:1.58 as builder

RUN cargo new --bin mining-pool-api

WORKDIR ./mining-pool-api

COPY . .

RUN cargo build --release

FROM centos:latest

COPY --from=builder /mining-pool-api/target/release/mining-pool-api ./mining-pool-api
RUN apt update && apt install libpq-dev -y
CMD ["./mining-pool-api"]

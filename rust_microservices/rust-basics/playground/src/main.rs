use crate::lib::demoobj::DemoObj;

mod lib;

fn main() {
    let mut d = DemoObj {
        field_1: 200,
        field_2: 100,
    };
    let res = d.addone();

    println!("{}", res);
}

pub struct DemoObj {
    pub field_1: i32,
    pub field_2: i32,
}

impl DemoObj {
    pub fn addone(&mut self) -> i32 {
        if self.field_2 == 100 {
            return self.field_2 + 1;
        }
        return 1;
    }
}

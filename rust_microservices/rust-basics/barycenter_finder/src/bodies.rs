use crate::Body;

pub fn get_values() -> [Body; 2] {
    return [
        Body { x: 1.0, y: 100.0, z: 30.0, mass: 50.0 },
        Body { x: 120.25, y: 75.21, z: 10.11, mass: 12.0 }
    ];
}

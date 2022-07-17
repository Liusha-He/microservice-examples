// equality operators
const a = { x: 1 };
const b = { x: 1 };

console.log(a == b);
console.log(a === b);
console.log(a["x"] == b["x"]);

console.log("1" == 1);
console.log("1" === 1);

const x = 100;

switch (x) {
    case 1:
        console.log("it's 1");
    case 2:
        console.log("it's 2");
    default:
        console.log("default 100");
}

// for loop
for (var i=0; i <= 10; i++) {
    if (i === 5) continue;
    console.log(i);
}

// conditional operator
const age = 15;
age >= 21 ? console.log("you can drink") : console.log("no drink for you");


const arr = [1,2,3,4,5,6,7,8,9];
const str = "123456789";
console.log(arr.length);
console.log(str.length);
console.log(arr.pop());
console.log(arr);


// object
obj_a = {
    x: 1,
    add: function(x, y) {
        return x + y;
    }
}

console.log(obj_a["add"](7,8));
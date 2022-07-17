// 1. Constructor function

const Person = function(firstName, birthYear) {
    this.firstName = firstName;
    this.birthYear = birthYear;

    // never to this...
    // this.printAge = function() {
    //     console.log(2022 - this.birthYear);
    // }
}

const p1 = new Person("Degere", 1987);
const p2 = new Person("Liusha", 1988);

console.log(typeof p1);
console.log(p1 instanceof Person);

// prototype inheritance
Person.prototype.printAge = function() {
    console.log(2022 - this.birthYear);
}
// static method for constructor function
Person.hey = function() {
    console.log("hello from constructor function...");
    console.log(this);
}

p1.printAge();
Person.hey();

// ES6 classes
class PersonCl {
    constructor(firstName, birthYear) {
        this.firstName = firstName;
        this.birthYear = birthYear;
    }

    printAge() {
        console.log(2022 - this.birthYear);
    }

    get age() {
        return 2022 - this.birthYear;
    }

    // static method
    static hey() {
        console.log("hey from class...");
        console.log(this);
    }
}

const liusha = new PersonCl("Liusha", 1988);
liusha.printAge();
console.log(liusha.age);
PersonCl.hey();

// inheritance
// constructor function inheritance
const Student = function(firstName, birthYear, program) {
    Person.call(this, firstName, birthYear);
    this.program = program;
}
// inherit prototype
Student.prototype = Object.create(Person.prototype);

Student.prototype.introduce = function() {
    console.log(
        `Hello, I'm ${this.firstName}, and I'm studying ${this.program}`
    );
}

const s1 = new Student("Degere", 1997, "education");
s1.introduce();
s1.printAge();

console.log(s1 instanceof Person);
console.log(s1.__proto__.__proto__ === Person.prototype);

// inheritance between classes
class StudentCl extends PersonCl {
    constructor(firstName, birthYear, program) {
        super(firstName, birthYear);
        this.program = program;
    }
}

s2 = new StudentCl("Liusha", 1988, "psychology");
console.log(s2 instanceof PersonCl);
console.log(s2.__proto__ === PersonCl.prototype);
console.log(s2.age);

// encapsulation

function objectOne() {
    let dog = {
        name: 'Katy',
        age: 3,
        breed: 'Pitbull',
        isFriendly: true
    };
    console.log(dog);
    console.table(dog);

    dog.age++;
    // console.log("Happy Birthday, " + dog.name + "! You are now " + dog.age + " years old!");
    console.log(`Happy Birthday ${dog.name}! You are now ${dog.age} years old!`);
}

function functionOne(a, b, c = 'Katy') {
    console.log(a + b);
    console.log(c);
}

function shortest() {
    // this is my bucket to hold the shortest word
    let short = 'jfkdla;jfkdlafjlkadjfklajkfljakl;jfklajl;f';

    // my for loop to loop through however many words you pass in
    for (let i = 0; i < arguments.length; i++) {
        // if 
        if (arguments[i].length < short.length) {
            short = arguments[i];
        }
    }
    console.log(`The shortest word is ${short}`);
}

function multiplyByTwo(num) {
    console.log(num * 2);
}

function demoOne() {
    let listOfNumbers = [3, 4, 5, 6, 7];


    listOfNumbers.forEach((num) => multiplyByTwo(num));
}

function demoTwo() {
    let listOfNumbers = [3, 4, 5, 6, 7];
    for (let i = 0; i < listOfNumbers.length; i++) {
        multiplyByTwo(listOfNumbers[i]);
    }
}
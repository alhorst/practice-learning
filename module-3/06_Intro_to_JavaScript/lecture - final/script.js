/*
    Example of a multi-line comment just like in C#/Java
*/

// Single line comment

/**
 * Functions start with the word function.
 * They don't have a return type and the naming convention is camel-case.
 */
function variables() {
  // Declares a variable where the value cannot be changed
  const DAYS_PER_WEEK = 7;
  console.log('There are ' + DAYS_PER_WEEK + ' days in the week');
  // Declares a variable those value can be changed
  let daysPerMonth = 31;
  // The backtick is a template literal and makes it so I don't have to 
  // concatenate, but can use ${} surrounding my variable name
  console.log(`There are ${daysPerMonth} days in January`);

  daysPerMonth++;  // add one to variable
  // DAYS_PER_WEEK++;  -- is a const cannot be reassigned
  // Declares a variable that will always be an array
  const WEEK_DAYS = [
    'Sunday',
    'Monday',
    'Tuesday',
    'Wednesday',
    'Thursday',
    'Friday',
    'Saturday'
  ];

  console.log(WEEK_DAYS);
  console.table(WEEK_DAYS);


  let amountOwed = 6.35;
  let amountPaid = 10.00;

  let change = amountPaid - amountOwed;
  console.log(change.toFixed(2));
}


function array() {
  let names = [
    'Bob',
    'Sue',
    'Ann',
    'Ada'
  ];

  console.log(names);
  names.push('Josh');
  console.log("pushed Josh on the end:");
  console.log(names);
  console.log("unshifted Justin to the front:");
  names.unshift('Justin');
  console.log(names);

  if (names.includes('Bob')) {
    console.log('HEY Bob!!!');
  }


}
/**
 * Functions can also accept parameters.
 * Notice the parameters do not have types.
 * @param {Number} param1 The first number to display
 * @param {Number} param2 The second number to display
 */
function printParameters(param1, param2) {
  console.log(`The value of param1 is ${param1}`);
  console.log(`The value of param2 is ${param2}`);
}

/**
 * Compares two values x and y.
 * == is loose equality
 * === is strict equality
 * @param {Object} x
 * @param {Object} y
 */
function equality(x, y) {
  console.log(`x is ${typeof x}`);
  console.log(`y is ${typeof y}`);

  console.log(`x == y : ${x == y}`); // true
  console.log(`x === y : ${x === y}`); // false
}


function builtInFunctions() {
  const numbers = [1, 5, 42];

  console.log(numbers.join(', '));

  console.log(numbers.reverse()); // in memory reversal
  console.log(numbers.reverse());


  let answer = '11' + '1';
  console.log(answer);

}
/**
 * Each value is inherently truthy or falsy.
 * false, 0, '', null, undefined, and NaN are always falsy
 * everything else is always truthy
 * @param {Object} x The object to check for truthy or falsy,
 */
function falsy(x) {
  if (x) {
    console.log(`${x} is truthy`);
  } else {
    console.log(`${x} is falsy`);
  }
}

/**
 *  Objects are simple key-value pairs
    - values can be primitive data types
    - values can be arrays
    - or they can be functions
*/
function objects() {
  const person = {
    firstName: "Bill",
    lastName: "Lumbergh",
    age: 42,
    employees: [
      "Peter Gibbons",
      "Milton Waddams",
      "Samir Nagheenanajar",
      "Michael Bolton"
    ]
  };

  // Log the object
  console.log(person);
  // Log the first and last name
  console.log(person.firstName + ' ' + person.lastName);
  // Log each employee
  console.log('all the employees are:');
  // just like Java!  We declare a looping variable i
  // for loop works while condition (i < person.employees.length)
  // altering says add 1 to i
  for (let i = 0; i < person.employees.length; i++) {
    console.log(person.employees[i]);
  }

  console.log('Joining the employees gives us:');
  console.log(person.employees.join(', '));

  console.log(person.toString());
}



/*
########################
Function Overloading
########################

Function Overloading is not available in Javascript. If you declare a
function with the same name, more than one time in a script file, the
earlier ones are overriden and the most recent one will be used.
*/

function add(num1, num2) {
  return num1 + num2;
}

function add(num1, num2, num3) {
  return num1 + num2 + num3;
}

/*
########################
Math Library
########################

A built-in `Math` object has properties and methods for mathematical constants and functions.
*/

function mathFunctions() {
  console.log("Math.PI : " + Math.PI);
  console.log("Math.LOG10E : " + Math.LOG10E);
  console.log("Math.abs(-10) : " + Math.abs(-10));
  console.log("Math.floor(1.99) : " + Math.floor(1.99));
  console.log("Math.ceil(1.01) : " + Math.ceil(1.01));
  console.log("Math.random() : " + Math.random());
}

/*
########################
String Methods
########################

The string data type has a lot of properties and methods similar to strings in Java/C#
*/

function stringFunctions(value) {
  console.log(`.length -  ${value.length}`);
  console.log(`.endsWith('World') - ${value.endsWith("World")}`);
  console.log(`.startsWith('Hello') - ${value.startsWith("Hello")}`);
  console.log(`.indexOf('Hello') - ${value.indexOf("Hello")}`);
  console.log(`.lastIndexOf('World') - ${value.lastIndexOf("World")}`);


  /*
    Other Methods
        - split(string)
        - substr(number, number)
        - substring(number, number)
        - toLowerCase()
        - trim()
        - https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/String
    */
}

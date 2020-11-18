/**
 * All named functions will have the function keyword and
 * a name followed by parentheses.
 * 
 * @returns {number} 1
 */
function returnOne() {
  return 1;
}

/**
 * Functions can also take parameters. These are just variables that are filled
 * in by whoever is calling the function.
 *
 * Also, we don't *have* to return anything from the actual function.
 *
 * @param {any} value the value to print to the console
 */
function printToConsole(value) {
  console.log(value);
}

/**
 * Write a function called multiplyTogether that multiplies two numbers together. But 
 * what happens if we don't pass a value in? What happens if the value is not a number?
 *
 * @param {number} firstParameter the first parameter to multiply
 * @param {number} secondParameter the second parameter to multiply
 */
  function multiplyTogether(firstParameter, secondParameter){

    let result = firstParameter * secondParameter;
    return result;
    //JavaScript runs in the browser so the longer the function the longer it takes to run.
    //The best return would be return firstParameter * secondParameter
  }
/**
 * This version makes sure that no parameters are ever missing. If
 * someone calls this function without parameters, we default the
 * values to 0. However, it is impossible in JavaScript to prevent
 * someone from calling this function with data that is not a number.
 * Call this function multiplyNoUndefined
 *
 * @param {number} [firstParameter=0] the first parameter to multiply
 * @param {number} [secondParameter=0] the second parameter to multiply
 */
  function multiplyNoUndefined(firstParameter=0, secondParameter=0){
    return firstParameter * secondParameter;
  }

 
/**
 * Functions can return earlier before the end of the function. This could be useful
 * in circumstances where you may not need to perform additional instructions or have to
 * handle a particular situation.
 * In this example, if the firstParameter is equal to 0, we return secondParameter times 2.
 * Observe what's printed to the console in both situations.
 * 
 * @param {number} firstParameter the first parameter
 * @param {number} secondParameter the second parameter
 */
function returnBeforeEnd(firstParameter, secondParameter) {
  console.log("This will always fire.");

  if (firstParameter == 0) {
    console.log("Returning secondParameter times two.");
    return secondParameter * 2;
  }

  //this only runs if firstParameter is NOT 0
  console.log("Returning firstParameter + secondParameter.");
  return firstParameter + secondParameter;
}

/**
 * Scope is defined as where a variable is available to be used.
 *
 * If a variable is declare inside of a block, it will only exist in
 * that block and any block underneath it. Once the block that the
 * variable was defined in ends, the variable disappears.
 */
function scopeTest() {
  // This variable will always be in scope in this function
  let inScopeInScopeTest = true;

  {
    // this variable lives inside this block and doesn't
    // exist outside of the block
    let scopedToBlock = inScopeInScopeTest;
  }

  // scopedToBlock doesn't exist here so an error will be thrown
  if (inScopeInScopeTest && scopedToBlock) {
    console.log("This won't print!");
  }
}
/**
 * JSDoc example: Generate documentation using /** *"/" and tab
 * @param {string} name name of the person
 * @param {number} age age of the person
 * @param {string[]} listOfQuirks a string array listing their quirks
 * @param {string} [separator = ","] the list separator
 * @returns {string} A sentence describing the person and their quirks 
 */
function createSentenceFromUser(name, age, listOfQuirks = [], separator = ', ') {
  let description = `${name} is currently ${age} years old. Their quirks are: `;
  return description + listOfQuirks.join(separator);
}
//===================================================
// Arrow functions
//===================================================

//For Each Demo

function forEachDemo() {

  let numbers = [0,1,2,3,4];
  let counter = 0;

  numbers.forEach((num) => {
      numbers[counter] = num * 2;
      counter++;
    }
  )
  return numbers;
}

//Map Demo

function mapDemo(){
  
  let numbers = [0,1,2,3,4];
  
  let newNumbers = numbers.map(
    (num) => {
      return num * 3;
    }
  );

  return newNumbers;
}

/**
 * Takes an array and, using the power of anonymous functions, generates
 * their sum.
 *
 * @param {number[]} numbersToSum numbers to add up
 * @returns {number} sum of all the numbers
 */
function sumAllNumbers1(numbersToSum) {
  return numbersToSum.reduce(reducer);
}

function reducer(sum, number){
  return sum + number;
}

let variable = (sum, number) => {return sum + number;};

function sumAllNumbers2(numbersToSum) {
  return numbersToSum.reduce(variable);
}

function sumAllNumbers3(numbersToSum) {
  return numbersToSum.reduce((sum, number) => {return sum + number;});
}

function makeOneString(inputArray) {
  return inputArray.reduce((accum, val) => {return accum + ', ' + val;});
}

/**
 * Takes an array and returns a new array of only numbers that are
 * multiples of 3
 *
 * @param {number[]} numbersToFilter numbers to filter through
 * @returns {number[]} a new array with only those numbers that are
 *   multiples of 3
 */
function allDivisibleByThree(numbersToFilter) {

  return numbersToFilter.filter(
    (num) =>{
    return num % 3 === 0;
  }
  );
}

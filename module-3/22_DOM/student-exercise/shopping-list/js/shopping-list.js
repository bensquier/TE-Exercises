// add pageTitle
const pageTitle = 'My Shopping List';
// add groceries
const groceries = ['Milk', 'Eggs', 'Butter', 'Cheese', 'Apples', 'Steak', 'Carrots', 'Chips', 'Cookies', 'Candy'];
/**
 * This function will get a reference to the title and set its text to the value
 * of the pageTitle variable that was set above.
 */
function setPageTitle() {
  document.getElementById('title').innerHTML = pageTitle;

}
/**
 * This function will loop over the array of groceries that was set above and add them to the DOM.
 */
function displayGroceries() {
  const ul = document.getElementById('groceries');

  groceries.forEach(grocery =>{
    const container = document.createElement('li');
    container.setAttribute('id', 'grocery');
    container.innerText = grocery;
    ul.insertAdjacentElement('beforeend', container);
  })
}

/**
 * This function will be called when the button is clicked. You will need to get a reference
 * to every list item and add the class completed to each one
 */
function markCompleted() {

  let list = document.querySelectorAll('li');

  list.forEach(element => {
    element.classList.add('completed');
  })
}

setPageTitle();

displayGroceries();

// Don't worry too much about what is going on here, we will cover this when we discuss events.
document.addEventListener('DOMContentLoaded', () => {
  // When the DOM Content has loaded attach a click listener to the button
  const button = document.querySelector('.btn');
  button.addEventListener('click', markCompleted);
});

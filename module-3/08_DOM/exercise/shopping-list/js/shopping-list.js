// add pageTitle
let pageTitle = 'My Shopping List';
// add groceries
let groceries = ['Milk', 'Apples', 'Bananas', 'Pretzels', 'Cheese',
  'Eggs', 'Bread', 'Pasta', 'Rice', 'Chicken'];
/**
 * This function will get a reference to the title and set its text to the value
 * of the pageTitle variable that was set above.
 */
function setPageTitle() {
  let title = document.getElementById('title');
  title.innerText = 'My Shopping List';
}

/**
 * This function will loop over the array of groceries that was set above and add them to the DOM.
 */
function displayGroceries() {
  const ul = document.getElementById('groceries');

  groceries.forEach((grocery) => {
    const container = document.createElement('li');
    container.innerText = grocery
    ul.appendChild(container);
  });
}

/**
 * This function will be called when the button is clicked. You will need to get a reference
 * to every list item and add the class completed to each one
 */
function markCompleted() {
  const items = document.querySelectorAll('li');
  for (let i = 0; i < items.length; i++) {
    items[i].classList.add('completed');
  }
}

setPageTitle();

displayGroceries();

// Don't worry too much about what is going on here, we will cover this when we discuss events.
document.addEventListener('DOMContentLoaded', () => {
  // When the DOM Content has loaded attach a click listener to the button
  const button = document.querySelector('.btn');
  button.addEventListener('click', markCompleted);
});

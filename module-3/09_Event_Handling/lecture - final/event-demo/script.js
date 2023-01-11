function displayDate() {
    document.getElementById('demoId').innerText = Date();
}

function displayDate2() {
    window.alert(Date());
}


document.addEventListener('DOMContentLoaded', () => {

    const button = document.getElementById('myButton');
    button.addEventListener('click', displayDate);

    // JAVASCRIPT IS WEIRD!!!!
    document.getElementById('body').addEventListener('click', () => {
        window.alert('BOO YA!!!!');
    });

    document.getElementById('div1').addEventListener('click', displayDate2);

    const childDiv = document.createElement('div');
    childDiv.setAttribute('id', 'childDiv');


    document.getElementById('div1').insertAdjacentElement('beforebegin', childDiv);
    childDiv.addEventListener('click', () => {
        alert('Child firing!');
    });

});
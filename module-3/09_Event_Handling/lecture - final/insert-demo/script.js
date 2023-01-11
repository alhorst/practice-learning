function addStuff() {
    const mainElement = document.getElementById('main');
    // const paragraph = mainElement.querySelector('p');

    // getElementById must be done on the document
    // not on a child
    const paragraph = document.getElementById('para');
    paragraph.innerText = 'Hello';

    const newParagraphBeforeBegin = document.createElement('p');
    newParagraphBeforeBegin.innerText = 'p before begin';
    paragraph.insertAdjacentElement('beforebegin', newParagraphBeforeBegin);

    const newParagraphAfterBegin = document.createElement('p');
    newParagraphAfterBegin.innerText = 'p after begin';
    paragraph.insertAdjacentElement('afterbegin', newParagraphAfterBegin);

    const newParagraphBeforeEnd = document.createElement('p');
    newParagraphBeforeEnd.innerText = 'p before end';
    paragraph.insertAdjacentElement('beforeend', newParagraphBeforeEnd);

    const newParagraphAfterEnd = document.createElement('p');
    newParagraphAfterEnd.innerText = 'p after end';
    paragraph.insertAdjacentElement('afterend', newParagraphAfterEnd);

    const appendChildElement = document.createElement('p');
    appendChildElement.innerText = 'appendChild';
    paragraph.appendChild(appendChildElement);
}


addStuff();
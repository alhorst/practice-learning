

function mapDemo(array) {
    // double every element in the array and save the doubled number in the array
    let newArray = array.map(
        (number) => {
            return number * 2;
        }
    );
    console.log(newArray);

    let newNewArray = [];
    for (let i = 0; i < array.length; i++) {
        newNewArray.push(array[i] * 2);
    }

    console.log(newNewArray);

    let filterArray = array.filter((number) => {
        return number % 2 === 0;
    });
    console.log(filterArray);

    let newFilterArray = [];

    for (let i = 0; i < array.length; i++) {
        if (array[i] % 2 === 0) {
            newFilterArray.push(array[i]);
        }
    }

}
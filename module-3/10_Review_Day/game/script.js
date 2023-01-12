/*
Checkerboard
have 2 icons, one is us, another one?
we will start in upper left corner
computer will start in bottom right corner
we will move our icon using arrows
computer will move 
when computer catches us, we lose
*/

const BOARD_SIZE = 8;
const BOARD_SQUARES = [];

const player = {
     icon: '🤠',
     row: 0,
     column: 0,
     startRow: 0,
     startColumn: 0,
     collide: '🧨',
};

const computer = {
     icon: '🎯',
     row: BOARD_SIZE - 1,
     column: BOARD_SIZE - 1,
     startRow: BOARD_SIZE - 1,
     startColumn: BOARD_SIZE - 1,
};

document.addEventListener('DOMContentLoaded', () => {
     setUpBoard();
     //handle moves
     document.body.addEventListener('keyup', handleTurn);
     //handle reset
});

function setUpBoard() {
     const html = document.querySelector('html');
     html.style.setProperty('--grid-size', BOARD_SIZE);
     //create grid items
     const gameboard = document.getElementById('checkerboard');
     for (let row = 0; row < BOARD_SIZE; row++) {
          BOARD_SQUARES[row] = [];
          for (let column = 0; column < BOARD_SIZE; column++); {
               const div = document.createElement('div');
               if ((row + column) % 2 === 0) {
                    div.setAttribute('class', 'black');
               }
               checkerboard.appendChild(div);
               BOARD_SQUARES[row][column] = div;
          }

     }
     //move player onto the board in starting position
     move(player, player.row, player.column);
     //move computer onto board in starting position
     move(computer, computer.row, computer.column);
}

function move(character, row, column) {
     //row and column are where player is going to move
     if (row >= 0 && column >= 0 && row < BOARD_SIZE && column < BOARD_SIZE) {
          //clear player from old location
          BOARD_SQUARES[row][column].innerText = '';
          //move player to new location
          BOARD_SQUARES[row][column].innerText = character.icon;
          //save player's new location
          character.row = row;
          character.column = column;
     }
}

function handleTurn(event) {
     //what arrows did the player press
     handleKeyUp(event);
     //check for collision
     checkForCollision();
     //move computer to chase
     moveComputer();
     //check for collision
     checkForCollision();
}

function handleKeyUp(event) {
     if (event.key === 'ArrowLeft') {
          move(player, player.row, player.column - 1);
     }
     if (event.key === 'ArrowRight') {
          move(player, player.row, player.column + 1);
     }
     if (event.key === 'ArrowUp') {
          move(player, player.row - 1, player.column);
     }
     if (event.key === 'ArrowDown') {
          move(player, player.row + 1, player.column);
     }
}

function moveComputer() {
     //where the computer is now
     let row = computer.row;
     let column = computer.column;
     //move the computer randomly
     const randomMove = Math.floor((Math.random() * 4));
     if (randomMove == 0) {
          row++;
     } else if (randomMove == 1) {
          row--;
     } else if (randomMove == 2) {
          column++;
     } else {
          column--;
     }
     move(computer, row, column);
}

function checkForCollision() {
     if (computer.row === player.row && computer.column === player.column) {
          BOARD_SQUARES[player.row][player.column].innerText = player.collide;
          BOARD_SQUARES[player.row][player.column].style.backgroundColor = 'red';
          //game over!
          document.body.removeEventListener('keyup', handleTurn);
     }
}
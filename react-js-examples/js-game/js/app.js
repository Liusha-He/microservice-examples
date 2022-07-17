let scores, roundScore, activePlayer, gamePlaying;
let diceDOM = document.querySelector(".dice");

init();

document.querySelector(".btn-roll").addEventListener("click", function()
{
    if (gamePlaying) {
        // 1. random number
        let dice = Math.floor(Math.random() * 6) + 1;

        // 2. display the result
        diceDOM.style.display = "block";
        diceDOM.src = "images/dice/dice-" + dice + ".png";

        // game logic
        if (dice !== 1) {
            //add score
            roundScore += dice;
            document.getElementById("current-" + activePlayer).textContent = roundScore;
        } else {
            //next player
            nextPlayer();
        }
    }
});

document.querySelector(".btn-hold").addEventListener("click", function ()
{
    if (gamePlaying) {
        scores[activePlayer] += roundScore;
        document.getElementById("score-" + activePlayer).textContent = scores[activePlayer];

        if (scores[activePlayer] >= 100) {
            document.getElementById("name-" + activePlayer).textContent = "WINNER!";
            diceDOM.style.display = "none";
            document.querySelector(".player-" + activePlayer + "-panel").classList.add("winner");
            document.querySelector(".player-" + activePlayer + "-panel").classList.remove("active");
            gamePlaying = false;
        } else {
            //next player
            nextPlayer();
        }
    }
});

document.querySelector(".btn-new").addEventListener("click", init);

function nextPlayer() {
    activePlayer = activePlayer === 0 ? 1 : 0;
    roundScore = 0;

    document.getElementById("current-0").textContent = "0";
    document.getElementById("current-1").textContent = "0";

    document.querySelector(".player-0-panel").classList.toggle("active");
    document.querySelector(".player-1-panel").classList.toggle("active");

    diceDOM.style.display = "none";
}

function init() {
    scores = [0, 0];
    roundScore = 0;
    activePlayer = 0;
    gamePlaying = true;

    // initialize elements
    document.querySelector(".dice").style.display = "none";
    document.getElementById("score-0").textContent = "0";
    document.getElementById("score-1").textContent = "0";
    document.getElementById("current-0").textContent = "0";
    document.getElementById("current-1").textContent = "0";
    document.getElementById("name-0").textContent = "PLAYER 1";
    document.getElementById("name-1").textContent = "PLAYER 2";
    document.querySelector(".player-0-panel").classList.remove("winner");
    document.querySelector(".player-1-panel").classList.remove("winner");
    document.querySelector(".player-0-panel").classList.remove("active");
    document.querySelector(".player-0-panel").classList.add("active");
    document.querySelector(".player-1-panel").classList.remove("active");
}

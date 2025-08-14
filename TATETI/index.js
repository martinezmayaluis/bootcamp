const celdas = document.querySelectorAll(".celda");
const estadoTexto = document.querySelector("#estado");
const restart = document.querySelector("#restart");
const Condiciones = [
    [0, 1, 2],
    [3, 4, 5],
    [6, 7, 8],
    [0, 3, 6],
    [1, 4, 7],
    [2, 5, 8],
    [0, 4, 8],
    [2, 4, 6]
];
let opciones = ["", "", "", "", "", "", "", "", ""];
let JugadorActivo = "X";
let running = false;

initializeGame();

function initializeGame(){
    celdas.forEach(cell => cell.addEventListener("click", cellClicked));
    restart.addEventListener("click", restartGame);
    estadoTexto.textContent = `turno de ${JugadorActivo}`;
    running = true;
}
function cellClicked(){
    const celdaIndex = this.getAttribute("cellIndex");

    if(opciones[celdaIndex] != "" || !running){
        return;
    }

    updateCell(this, celdaIndex);
    checkWinner();
}
function updateCell(celda, index){
    opciones[index] = JugadorActivo;
    celda.textContent = JugadorActivo;
}
function changePlayer(){
    JugadorActivo = (JugadorActivo == "X") ? "O" : "X";
    estadoTexto.textContent = `turno de ${JugadorActivo}`;
}
function checkWinner(){
    let Ganar = false;

    for(let i = 0; i < Condiciones.length; i++){
        const condicion = Condiciones[i];
        const celdaA = opciones[condicion[0]];
        const celdaB = opciones[condicion[1]];
        const celdaC = opciones[condicion[2]];

        if(celdaA == "" || celdaB == "" || celdaC == ""){
            continue;
        }
        if(celdaA == celdaB && celdaB == celdaC){
            Ganar = true;
            break;
        }
    }

    if(Ganar){
        estadoTexto.textContent = `${JugadorActivo} Ganó!`;
        running = false;
    }
    else if(!opciones.includes("")){
        estadoTexto.textContent = `Empate!`;
        running = false;
    }
    else{
        changePlayer();
    }
}
function restartGame(){
    JugadorActivo = "X";
    opciones = ["", "", "", "", "", "", "", "", ""];
    estadoTexto.textContent = `turno de ${JugadorActivo}`;
    celdas.forEach(cell => cell.textContent = "");
    running = true;
}
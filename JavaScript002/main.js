let display = document.getElementById('display');

function agregar(valor) {
  display.value += valor;
}

function limpiar() {
  display.value = '';
}

function borrar() {
  display.value = display.value.slice(0, -1);
}

function calcular() {
  try {
    display.value = eval(display.value);
  } catch (e) {
    display.value = 'Error';
  }
}
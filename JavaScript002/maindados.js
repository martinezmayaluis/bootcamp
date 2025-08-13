

function TirarDados(){


    let resultado = document.getElementById("Resultado");
    let imagen =document.getElementById("Imagenes");

    let valores = [];
    let imagenes = [];

    for(i = 1; i <= 5; i++){
    const value = Math.floor(Math.random() * 6) + 1;
    valores.push(value);
    imagenes.push(`<img src="dados/${value}.png">`)
    }

    resultado.textContent = ` dados: ${valores.join(', ')} `;
    imagen.innerHTML = imagenes.join('');
}
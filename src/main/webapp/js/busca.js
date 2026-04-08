
    document.getElementById("busca").addEventListener("keyup", function() {

    let termo = this.value;

    fetch("buscar?termo=" + termo)
    .then(response => response.text())
    .then(data => {
    document.getElementById("resultados").innerHTML = data;
});

});

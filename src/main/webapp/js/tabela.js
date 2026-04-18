// Mudamos o seletor para pegar apenas o span com o texto
const elementos = document.querySelectorAll('.resumo-texto');
const LIMIT = 30;

elementos.forEach(span => {
    const textoOriginal = span.innerText.trim();

    if (textoOriginal.length > LIMIT) {
        // Substitui apenas o conteúdo do span
        span.innerText = textoOriginal.substring(0, LIMIT) + '...';
    }
});
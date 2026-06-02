// ==================== TELA 1 ====================

// Item 1.b: calcular a soma dos dois números
function calcularSoma() {
    var num1 = parseFloat(document.getElementById("valor1").value);
    var num2 = parseFloat(document.getElementById("valor2").value);
    
    var soma = num1 + num2;
    document.getElementById("resultado-soma").innerHTML = "A soma é: " + soma;
}

// Item 1.c: mostrar informações de comparação com cores
function compararNumeros() {
    var num1 = parseFloat(document.getElementById("valor1").value);
    var num2 = parseFloat(document.getElementById("valor2").value);
    var divResultado = document.getElementById("resultado-comparacao");

    // Limpa as classes de cores antigas antes de aplicar a nova
    divResultado.className = ""; 

    // 1.c.i: Primeiro número é maior (fundo vermelho)
    if (num1 > num2) {
        divResultado.innerHTML = "Primeiro número é maior";
        divResultado.className = "fundo-vermelho";
    } 
    // 1.c.ii: Segundo número é maior (fundo verde)
    else if (num2 > num1) {
        divResultado.innerHTML = "Segundo número é maior";
        divResultado.className = "fundo-verde";
    } 
    // 1.c.iii: Ambos são iguais (fundo amarelo)
    else if (num1 == num2) {
        divResultado.innerHTML = "Ambos são iguais";
        divResultado.className = "fundo-amarelo";
    }
}


// ==================== TELA 2 ====================

// Item 2.b: A cada tecla digitada, mostrar o conteúdo
function copiarTexto() {
    var texto = document.getElementById("campoTexto").value;
    document.getElementById("texto-espelho").innerHTML = texto;
}

// Item 2.d: Mostrar o tamanho do campo usando o atributo length
function verTamanho() {
    var texto = document.getElementById("campoTexto").value;
    var tamanho = texto.length; // Aqui usamos o atributo length exigido
    
    document.getElementById("resultado-tamanho").innerHTML = "O tamanho atual do campo é de: " + tamanho;
}


// ==================== TELA 3 ====================

// Item 3.c: Contador com setInterval (começa em 0 e incrementa a cada segundo)
var contadorCliques = 0;
setInterval(function() {
    var divContador = document.getElementById("meu-contador");
    if (divContador) { // Só roda se a div existir na tela
        contadorCliques++;
        divContador.innerHTML = contadorCliques;
    }
}, 1000); // 1000 milissegundos = 1 segundo

// Item 3.b: Criar uma nova linha com 3 colunas na tabela
function adicionarLinhaTabela() {
    var tabela = document.getElementById("minha-tabela");
    var novaLinha = tabela.insertRow(-1); // -1 insere no final da tabela

    var celula1 = novaLinha.insertCell(0);
    var celula2 = novaLinha.insertCell(1);
    var celula3 = novaLinha.insertCell(2);

    celula1.innerHTML = "Nova Col 1";
    celula2.innerHTML = "Nova Col 2";
    celula3.innerHTML = "Nova Col 3";
}

// Item 3.d: Alterar o texto do item clicado para "Concluído"
function concluirAtividade(item) {
    // 'item' recebe o próprio 'this' que foi clicado lá no HTML
    item.innerHTML = "Concluído";
}
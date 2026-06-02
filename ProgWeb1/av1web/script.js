// se a pagina carregar, vê se o usuário está logado
window.onload = function() {
    verificarLogin();
};

function verificarLogin() {
    var divUsuario = document.getElementById("info-usuario");
    var estaLogado = localStorage.getItem("autenticado");
    var nomeLogin = localStorage.getItem("loginDoUsuario");

    if (estaLogado == "sim") {
        // se esta logado = nome e a foto que vai para a pag 3 
        divUsuario.innerHTML = "Olá, " + nomeLogin + " <a href='cadastro.html'><img src='usericon.png' alt='Foto'></a>";
    } else {
        // se nao ta logado
        divUsuario.innerHTML = "Usuário não autenticado";
    }
}

function fazerLogin() {
    var campoLogin = document.getElementById("login").value;
    var campoSenha = document.getElementById("senha").value;

    // ve se os dois campos tao preenchidos
    if (campoLogin != "" && campoSenha != "") {
        // indo pro localStorage
        localStorage.setItem("autenticado", "sim");
        localStorage.setItem("loginDoUsuario", campoLogin);
        
        // voltando pra pagina principal
        window.location.href = "index.html";
    } else {
        alert("Erro: Você precisa digitar o Login e a Senha!");
    }
}
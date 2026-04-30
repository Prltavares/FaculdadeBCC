package testes3;

// "NÓ (NODE  CÉLULA): Unidade fundamental de uma lista encadeada"
public class No<T> {
    
    // "cada nó guarda uma informação de interesse (ex: dado)"
    public T elemento; 
    
    // "PONTEIRO(REFERÊNCIA): É a variável que guarda o “endereço” de um Nó na memória"
    // "semelhante a uma seta lógica que aponta para o próximo objeto."
    public No<T> proximo; 

    public No(T elemento) {
        this.elemento = elemento;
        // O nó nasce apontando para o vazio (null) até ser conectado a alguém.
        this.proximo = null; 
    }
}
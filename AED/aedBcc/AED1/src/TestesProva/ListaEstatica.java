// <t> = tipo genérico, ou seja, a classe pode ser usada para criar listas de strings,integer,aluno
//elementos = array que vai servir de base
//tamanho = é o nosso contador de quantos elementos tem na lista



public class ListaEstatica {
    private T[] elementos;//O array que vai guardar os dados de fato
    private int tamanho; //Quantos elementos realmente estão na lista no momento

public ListaEstatica(int capacidademaxima){
//// Truque do Java: não podemos fazer 'new T[]', então criamos um array de Object e convertemos para T    
this.elementos = (T[])new Object[capacidademaxima];
this.tamanho = 0; //Inicialmente a lista está vazia 

public void adicionar(T elementos){
    if(this.tamanho == this.elementos.length){
       System.out.println("Erro:Lista cheia!"); //Lança uma exceção se tentarmos adiciona
       return;
    }
    this.elementos[this.tamanho] = elementos; //Coloca o elemento na posição do tamanho atual
    this.tamanho++; //Aumenta o tamanho, pois adicionamos um elemento
    public T buscar(int posicao){
        if(posicao < 0 || posicao >=this.tamanho){
            System.out.println("erro: essa posisão não existe!"); //Lança uma exceção se a posição for inválida
            return null;
        }
        return this.elementos[posicao]; //Retorna o elemento na posição dada    
        
    }
    public remover (int posicao){
        if(posicao < 0 || posicao >=this.tamanho){
            System.out.println("erro: essa posisão não existe!"); 
            return;
        
        }
        for(int i = posicao; i < this.tamanho - 1; i++){
            
        }

    }

}   


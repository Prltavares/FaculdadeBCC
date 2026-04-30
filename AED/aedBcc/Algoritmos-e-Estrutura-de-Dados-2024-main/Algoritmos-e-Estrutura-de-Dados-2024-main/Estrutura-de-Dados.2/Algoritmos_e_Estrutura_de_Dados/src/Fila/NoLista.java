package Fila;
/**
 * 
 * @autor Larissa Zózimo Antunes
 */
public class NoLista<T> {//T identificando que é um parametro

	private T info;
	private NoLista<T> proximo; //autorefencia //T está passando o tipo usando a variavel parametrica

	public T getInfo() {
		return info;
	}

	public void setInfo(T info) {
		this.info = info;
	}

	public NoLista<T> getProximo() {
		return proximo;
	}

	public void setProximo(NoLista<T> proximo) {
		this.proximo = proximo;
	}

}
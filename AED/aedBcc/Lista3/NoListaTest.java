package ListaEncadeada;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NoListaTest<T> {

	private ListaEncadeada<Integer> listaEncad;

	@BeforeEach
	void setUp() {
		listaEncad = new ListaEncadeada<Integer>();
	}

//	caso 1
	@Test
	public void testEstaVazia() {
		assertTrue(listaEncad.estaVazia());
		System.out.println(listaEncad.estaVazia());
	}

//	//caso 2
	@Test
	public void testSeTaFalso() {
		listaEncad.inserir(5);
		assertFalse(listaEncad.estaVazia());
		System.out.println(listaEncad.estaVazia());
	}

	// caso 3
	@Test
	public void testValidarInsericaoNumero() {
		listaEncad.inserir(5);

		System.out.println(listaEncad.getPrimeiro());
		System.out.println(listaEncad.getPrimeiro().getInfo());
		System.out.println(listaEncad.obterComprimento());
	}

	// caso 4
	@Test
	public void testValidarInsericoes3Numeros() {
		listaEncad.inserir(5);
		listaEncad.inserir(10);
		listaEncad.inserir(15);

		System.out.println(listaEncad.obterComprimento());
		System.out.println(listaEncad.toString());
	}

	// caso 5
	@Test
	public void testValidarBuscar() {
		listaEncad.inserir(5);
		listaEncad.inserir(10);
		listaEncad.inserir(15);
		listaEncad.inserir(20);

		System.out.println(listaEncad.buscar(20));
	}

	// caso 6
	@Test
	public void testValidarBuscarMeioLista() {
		listaEncad.inserir(5);
		listaEncad.inserir(10);
		listaEncad.inserir(15);
		listaEncad.inserir(20);

		System.out.println(listaEncad.buscar(15));
	}

	// caso 7
	@Test
	public void testValidarBuscarInexistente() {
		listaEncad.inserir(5);
		listaEncad.inserir(10);
		listaEncad.inserir(15);
		listaEncad.inserir(20);

		System.out.println(listaEncad.buscar(50));
	}

	// caso 8
	@Test
	public void testValidarExluirPrimeiro() {
		listaEncad.inserir(5);
		listaEncad.inserir(10);
		listaEncad.inserir(15);
		listaEncad.inserir(20);

		listaEncad.retirar(20);

		System.out.println(listaEncad.toString());
	}

	// caso 9
	@Test
	public void testValidarExluirMeio() {
		listaEncad.inserir(5);
		listaEncad.inserir(10);
		listaEncad.inserir(15);
		listaEncad.inserir(20);

		listaEncad.retirar(15);

		System.out.println(listaEncad.toString());
	}

	// caso 10
	@Test
	public void testValidarObterNo0() {
		listaEncad.inserir(5);
		listaEncad.inserir(10);
		listaEncad.inserir(15);
		listaEncad.inserir(20);

		System.out.println(listaEncad.obterNo(0));
		System.out.println(listaEncad.obterNo(0).getInfo());
	}

	// caso 11
	@Test
	public void testValidarObterNoUltima() {
		listaEncad.inserir(5);
		listaEncad.inserir(10);
		listaEncad.inserir(15);
		listaEncad.inserir(20);

		System.out.println(listaEncad.obterNo(3));
		System.out.println(listaEncad.obterNo(3).getInfo());
	}

	// caso 12
	@Test
	public void testValidarObterNoInvalido() {
		listaEncad.inserir(5);
		listaEncad.inserir(10);
		listaEncad.inserir(15);
		listaEncad.inserir(20);

		System.out.println(listaEncad.obterNo(10));
	}

	// caso 13
	@Test
	public void testValidarObterComprimentoListaVazia() {

		System.out.println(listaEncad.obterComprimento());
	}

	// caso 14
	@Test
	public void testValidarObterComprimento() {
		listaEncad.inserir(5);
		listaEncad.inserir(10);
		listaEncad.inserir(15);
		listaEncad.inserir(20);

		System.out.println(listaEncad.obterComprimento());
	}

}


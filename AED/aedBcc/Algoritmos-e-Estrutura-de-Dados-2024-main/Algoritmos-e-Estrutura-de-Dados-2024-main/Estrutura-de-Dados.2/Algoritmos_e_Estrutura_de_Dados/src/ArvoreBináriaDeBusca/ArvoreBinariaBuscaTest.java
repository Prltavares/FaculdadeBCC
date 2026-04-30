package ArvoreBináriaDeBusca;
/**
 * 
 * @autor Larissa Zózimo Antunes
 */
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArvoreBinariaBuscaTest {
	
	private ArvoreBinariaBusca<Integer> arvore = new ArvoreBinariaBusca<>();
	
	@Test
	public void test1Insercao() {
		arvore.inserir(50);
		arvore.inserir(30);
		arvore.inserir(70);
		arvore.inserir(40);
		arvore.inserir(25);
		arvore.inserir(75);
		arvore.inserir(65);
		arvore.inserir(35);
		arvore.inserir(60);
		assertEquals("<50<30<25<><>><40<35<><>><>>><70<65<60<><>><>><75<><>>>>", 
					arvore.toString());
	}
		
	public void test2RemoverFolha() {
		arvore.inserir(50);
		arvore.inserir(30);
		arvore.inserir(25);
		arvore.inserir(40);
		arvore.retirar(40);
		assertEquals("<50<30<25<><>><>><>>", arvore.toString());
	}
	
	public void test3RemoverNoUmFilho() {
		arvore.inserir(80);
		arvore.inserir(52);
		arvore.inserir(90);
		arvore.inserir(48);
		arvore.inserir(71);
		arvore.inserir(63);
		arvore.inserir(67);
		arvore.retirar(71);
		assertEquals("<80<52<48<><>><63<><67<><>>>><90<><>>>", arvore.toString());
	}

	public void test4RemoverNoDoisFilhos() {
		arvore.inserir(250);
		arvore.inserir(38);
		arvore.inserir(26);
		arvore.inserir(72);
		arvore.inserir(55);
		arvore.inserir(90);
		arvore.inserir(41);
		arvore.inserir(60);
		arvore.inserir(43);
		arvore.inserir(78);
		arvore.inserir(92);
		arvore.inserir(74);
		arvore.retirar(38);
		assertEquals("<250<41<26<><>><72<55<43<><>><60<><>>><90<78<74<><>><>><92<><>>>>><>>", arvore.toString());
	}


}

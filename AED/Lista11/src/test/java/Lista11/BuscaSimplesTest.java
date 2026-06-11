package Lista11;

import org.junit.Test;
import static org.junit.Assert.*;

public class BuscaSimplesTest {

    @Test
    public void testNullArray() {
        assertEquals(-1, BuscaSimples.buscaLinear(null, 5));
    }

    @Test
    public void testEmptyArray() {
        assertEquals(-1, BuscaSimples.buscaLinear(new int[0], 1));
    }

    @Test
    public void testFoundFirstOccurrence() {
        int[] a = {7, 3, 3, 9};
        // first occurrence of 3 is at index 1
        assertEquals(1, BuscaSimples.buscaLinear(a, 3));
    }

    @Test
    public void testNotFound() {
        int[] a = {1, 2, 4};
        assertEquals(-1, BuscaSimples.buscaLinear(a, 5));
    }
}


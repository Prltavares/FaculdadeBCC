package Lista11;

import org.junit.Test;
import static org.junit.Assert.*;

public class BuscaBinariaIterativaTest {

    @Test
    public void testNullArray() {
        assertEquals(-1, BuscaBinariaIterativa.buscaBinaria(null, 10));
    }

    @Test
    public void testEmptyArray() {
        assertEquals(-1, BuscaBinariaIterativa.buscaBinaria(new int[0], 1));
    }

    @Test
    public void testFound() {
        int[] a = {1, 2, 3, 4, 5};
        assertEquals(2, BuscaBinariaIterativa.buscaBinaria(a, 3));
    }

    @Test
    public void testNotFound() {
        int[] a = {1, 2, 4, 6};
        assertEquals(-1, BuscaBinariaIterativa.buscaBinaria(a, 5));
    }
}


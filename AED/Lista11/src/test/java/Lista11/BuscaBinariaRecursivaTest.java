package Lista11;

import org.junit.Test;
import static org.junit.Assert.*;

public class BuscaBinariaRecursivaTest {

    @Test
    public void testNullArray() {
        assertEquals(-1, BuscaBinariaRecursiva.buscaBinariaRec(null, 0));
    }

    @Test
    public void testEmptyArray() {
        assertEquals(-1, BuscaBinariaRecursiva.buscaBinariaRec(new int[0], 1));
    }

    @Test
    public void testFound() {
        int[] a = {2, 4, 6, 8, 10};
        assertEquals(3, BuscaBinariaRecursiva.buscaBinariaRec(a, 8));
    }

    @Test
    public void testNotFound() {
        int[] a = {2, 4, 6, 8};
        assertEquals(-1, BuscaBinariaRecursiva.buscaBinariaRec(a, 5));
    }
}


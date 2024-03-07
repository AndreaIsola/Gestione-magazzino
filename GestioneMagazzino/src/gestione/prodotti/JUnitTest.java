package Progetto;

/**
 * La classe JUnitTest e' una classe utilizzata per fare dei test su dei metodi utilizzati all'interno delle classi.
 * Autore: Isola Andrea, Tenti Kevin, Pellegrini Marta, Del Magro Federico
 * Data: 03/03/2024
 */

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Questa classe contiene i test JUnit per la classe Magazzino.
 */
public class JUnitTest {

    private Magazzino magazzino;

    /**
     * Imposta l'oggetto Magazzino prima di ogni test.
     */
    @BeforeEach
    public void setUp() {
        magazzino = new Magazzino(2, 2);
    }

    /**
     * Test per aggiungere un prodotto al Magazzino.
     *
     * @throws Exception se si verifica un errore durante il test
     */
    @Test
    public void testAggiungiProdotto() throws Exception {
        Prodotto prodotto1 = new Prodotto("Marca1", "Modello1", 10, 50.0f);
        Prodotto prodotto2 = new Prodotto("Marca2", "Modello2", 5, 30.0f);

        assertTrue(magazzino.aggiungiProdotto(prodotto1));
        assertTrue(magazzino.aggiungiProdotto(prodotto2));

        assertEquals(prodotto1, magazzino.getScaffale().get(0).get(0));
        assertEquals(prodotto2, magazzino.getScaffale().get(0).get(1));
    }

    /**
     * Test per l'eccezione quando si tenta di aggiungere un prodotto nullo.
     */
    @Test
    public void testAggiungiProdottoException() {
        Exception exception = assertThrows(Exception.class, () -> {
            magazzino.aggiungiProdotto(null);
        });

        assertEquals("Il prodotto non esiste", exception.getMessage());
    }
}

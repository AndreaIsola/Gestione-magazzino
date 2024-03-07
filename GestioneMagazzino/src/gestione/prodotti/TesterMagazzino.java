package Progetto;

/**
 * La classe TesterMagazzino rappresenta il main del progetto dove verranno richiamati i metodi creati nelle classi Magazzino e Prodotto.
 * Autore: Isola Andrea, Tenti Kevin, Pellegrini Marta, Del Magro Federico
 * Data: 15/02/2024
 */
public class TesterMagazzino {
    public static void main(String[] args) throws Exception {
        Magazzino magazzino = new Magazzino(2, 1);

        Prodotto b = new Prodotto("Marca", "Modello", 10, 50);
        Prodotto c = new Prodotto("samsumg", "televisione", 5, 99);
        Prodotto d = new Prodotto("apple", "Modello", 12, 50);
        Prodotto e = new Prodotto("nokia", "3310", 99, 20);

        magazzino.aggiungiProdotto(b);
        magazzino.stampa();
        System.out.println("------------------");

        magazzino.aggiungiProdotto(c);
        magazzino.stampa();
        System.out.println("------------------");

        magazzino.aggiungiProdotto(d);
        magazzino.stampa();
        System.out.println("------------------");

        magazzino.modificaProdotto(c);
        magazzino.ricercaProdotto(c);
        
        magazzino.rimuoviProdotto(b);
        magazzino.aggiungiProdotto(e);

        System.out.println("------------------");
        magazzino.stampa();
    }
}
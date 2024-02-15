/**
 * La classe TesterMagazzino rappresenta il main del progetto dove verranno richiamati i metodi creati nelle classi Magazzino e Prodotto.
 * Autore: Isola Andrea, Pellegrini Marta, Tenti Kevin, Del Magro Federico
 * Data: 15/02/2024
 */
package gestione.prodotti;

public class TesterMagazzino {
	public static void main(String[] args) throws Exception {
		Magazzino a = new Magazzino(2, 2);
		Prodotto b = new Prodotto("Marca", "Modello", 10, 50);
		Prodotto c = new Prodotto("Marca", "Modello", 10, 50);
		Prodotto d = new Prodotto("apple", "Modello", 10, 50);

		a.aggiungiProdotto(b);
		a.aggiungiProdotto(c);
		a.aggiungiProdotto(d);
		a.modificaProdotto(c);
		a.ricercaProdotto(c);
		a.rimuoviProdotto(b);
		a.stampa();
	}
}

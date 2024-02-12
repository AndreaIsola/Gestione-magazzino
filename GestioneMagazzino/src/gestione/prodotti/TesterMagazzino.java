package gestione.prodotti;
public class TesterMagazzino {
	public static void main(String[] args) throws Exception {
		Magazzino a = new Magazzino(1, 1);
		Prodotto b = new Prodotto("Marca", "Modello", 10, 50);
		Prodotto c = new Prodotto("Marca", "Modello", 10, 50);
		a.aggiungiProdotto(b);
		a.aggiungiProdotto(c);
	}
}

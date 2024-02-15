/**
 * La classe Magazzino rappresenta un magazzino che contiene prodotti, con operazioni per aggiungere, rimuovere, cercare, modificare e stampare i prodotti.
 * Autore: Isola Andrea, Pellegrini Marta, Tenti Kevin, Del Magro Federico
 * Data: 15/02/2024
 */
package gestione.prodotti; // Il pacchetto in cui si trova questa classe
import java.util.*; // Importa tutte le classi nel pacchetto java.util

/**
 * La classe Magazzino rappresenta un magazzino che contiene prodotti.
 */
public class Magazzino { // Definizione della classe Magazzino
    
    Scanner s = new Scanner(System.in); // Crea un oggetto Scanner per leggere l'input dell'utente
    private Prodotto[][] scaffale; // Dichiarazione di un array bidimensionale di oggetti Prodotto
    
    /**
     * Costruisce un nuovo oggetto Magazzino con il numero specificato di righe e colonne.
     * @param righe il numero di righe dello scaffale
     * @param colonne il numero di colonne dello scaffale
     */
    public Magazzino(int righe, int colonne) { // Costruttore della classe Magazzino
        this.scaffale = new Prodotto[righe][colonne]; // Inizializza l'array con il numero di righe e colonne specificato    
    }
    
    /**
     * Restituisce lo scaffale del magazzino.
     * @return lo scaffale del magazzino
     */
    public Prodotto[][] getScaffale() { // Metodo getter per ottenere l'array scaffale
        return scaffale;
    }
    
    /**
     * Aggiunge un prodotto al magazzino.
     * @param p il prodotto da aggiungere
     * @return true se il prodotto è stato aggiunto con successo, false altrimenti
     * @throws Exception se il prodotto è null o lo scaffale è pieno
     */
    public boolean aggiungiProdotto(Prodotto p) throws Exception { // Metodo per aggiungere un prodotto al magazzino
        // Il codice qui verifica se il prodotto esiste e se c'è spazio nel magazzino. Se entrambe le condizioni sono vere, il prodotto viene aggiunto.
        int i = 0;
        int j = 0;
        
        if(p == null) {
            throw new Exception("Il prodotto non esiste");
        } else {
            while(i < scaffale.length ) {
                while(j < scaffale[i].length) {
                    if (scaffale[i][j] == null) {
                        scaffale[i][j] = p;
                        return true;
                    }
                }
            }
            throw new Exception("Il prodotto non è stato inserito perché lo scaffale è pieno.");
        }
    }
    
    /**
     * Rimuove un prodotto dal magazzino.
     * @param p il prodotto da rimuovere
     * @return true se il prodotto è stato rimosso con successo, false altrimenti
     * @throws Exception se il prodotto non esiste nel magazzino
     */
    public boolean rimuoviProdotto(Prodotto p) throws Exception { // Metodo per rimuovere un prodotto dal magazzino
        // Il codice qui cerca il prodotto nel magazzino e, se lo trova, lo rimuove.
        int i = 0;
        int j = 0;
        
        while(i < scaffale.length ) {
            while(j < scaffale[i].length) {
                if(scaffale[i][j].equals(p)) {
                    scaffale[i][j] = null;
                    return true;
                }
            }
        }
        throw new Exception("Il prodotto non è stato eliminato perché non esiste.");
    }
    
    /**
     * Cerca un prodotto nel magazzino e restituisce la sua posizione.
     * @param p il prodotto da cercare
     * @return una stringa che indica la posizione del prodotto
     * @throws Exception se il prodotto non è stato trovato nel magazzino
     */
    public String ricercaProdotto(Prodotto p) throws Exception { // Metodo per cercare un prodotto nel magazzino
        // Il codice qui cerca il prodotto nel magazzino e restituisce la sua posizione se lo trova.
        int i = 0;
        int j = 0;
        
        while(i < scaffale.length ) {
            while(j < scaffale[i].length) {
                if(scaffale[i][j].equals(p)) {
                    return "Il prodotto cercato si trova alla riga "+ i +" e alla colonna "+ j;
                }
            }
        }
        throw new Exception("Il prodotto non è stato trovato.");
    }
    
    /**
     * Stampa tutti i prodotti nel magazzino.
     */
    public void stampa() {    // Metodo per stampare tutti i prodotti nel magazzino
                            // Il codice qui stampa tutti i prodotti nel magazzino.
        for(int i = 0; i < scaffale.length; i++) {
            for(int j = 0; j < scaffale[i].length; j++) {
                System.out.println(scaffale[i][j]);
            }
        }
    }
    
    
    /**
     * Modifica le informazioni di un prodotto nel magazzino.
     * @param p il prodotto da modificare
     * @throws Exception se il prodotto non esiste
     */
    public void modificaProdotto(Prodotto p) throws Exception { // Metodo per modificare le informazioni di un prodotto
        // Il codice qui permette all'utente di scegliere quale informazione del prodotto modificare e poi la modifica.
        if(p == null) {
            throw new Exception("Il prodotto non esiste.");
        } else {
            int scelta=0;
            System.out.println("1) marca");
            System.out.println("2) modello");
            System.out.println("3) quantita'");
            System.out.println("4) prezzo");
            do {
                System.out.println("Inserisci il parametro che vuoi modificare: ");
                scelta = s.nextInt();
            } while(scelta < 0 || scelta > 4);
            System.out.println("Scelta= " + scelta);
            
            switch(scelta) {
            case 1:                 //Marca
                String ma = null;
                System.out.println("Ora stai modificando la marca.");
                System.out.println("Inserisci la nuova marca: ");
                ma = s.nextLine();
                p.setMarca(ma);
                break;
            case 2:                 //Modello
                String mo = null;
        		System.out.println("Ora stai modificando il modello.");
				System.out.println("Inserisci il nuovo modello: ");
				mo = s.nextLine();
				p.setModello(mo);
				break;
			case 3:					//Quantita
				int qu = 0;
				System.out.println("Ora stai modificando la quantita'.");
				System.out.println("Inserisci la nuova quantita': ");
				qu = s.nextInt();
				p.setQuantita(qu);
				break;
			case 4:					//Prezzo
				float pr = 0;
				System.out.println("Ora stai modificando il prezzo.");
				System.out.println("Inserisci il nuovo prezzo: ");
				pr = s.nextInt();
				p.setPrezzo(pr);
				break;
			}
		}
	}
}

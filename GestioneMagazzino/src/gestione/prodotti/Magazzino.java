package Progetto;
import java.util.*;

/**
 * La classe Magazzino rappresenta un magazzino che contiene prodotti, con operazioni per aggiungere, rimuovere, cercare, modificare e stampare i prodotti.
 * Autore: Isola Andrea, Tenti Kevin, Pellegrini Marta, Del Magro Federico
 * Data: 15/02/2024
 */
public class Magazzino {
    Scanner s = new Scanner(System.in); 
    private List<List<Prodotto>> scaffale;

    /**
     * Costruisce un nuovo oggetto Magazzino con il numero specificato di righe e colonne.
     * @param righe il numero di righe dello scaffale
     * @param colonne il numero di colonne dello scaffale
     */
    public Magazzino(int righe, int colonne) { 
        this.scaffale = new ArrayList<>();

        for (int i = 0; i < righe; i++) {
            List<Prodotto> riga = new ArrayList<>(colonne);
            for (int j = 0; j < colonne; j++) {
                riga.add(null);
            }
            this.scaffale.add(riga);
        }
    }

    /**
     * Restituisce lo scaffale del magazzino.
     * @return lo scaffale del magazzino
     */
    public List<List<Prodotto>> getScaffale() {
        return scaffale;
    }

    /**
     * Aggiunge un prodotto al magazzino.
     * @param p il prodotto da aggiungere
     * @return true se il prodotto è stato aggiunto con successo, false altrimenti
     * @throws Exception se il prodotto è null o lo scaffale è pieno
     */
    public boolean aggiungiProdotto(Prodotto p) throws Exception {
        if (p == null) {
            throw new Exception("Il prodotto non può essere null.");
        } else {

            for (List<Prodotto> riga : scaffale) {
                for (int j = 0; j < riga.size(); j++) {
                    Prodotto prodottoEsistente = riga.get(j);
                    if (prodottoEsistente == null) {
                        riga.set(j, p);
                        return true;
                    } else if (prodottoEsistente.equals(p)) {
                        prodottoEsistente.setQuantita(prodottoEsistente.getQuantita() + p.getQuantita());
                        return true;
                    }
                }
            }
            List<Prodotto> nuovaRiga = new ArrayList<>();
            nuovaRiga.add(p);
            scaffale.add(nuovaRiga);
        }
        return false;
    }

    /**
     * Rimuove un prodotto dal magazzino.
     * @param p il prodotto da rimuovere
     * @return true se il prodotto è stato rimosso con successo, false altrimenti
     * @throws Exception se il prodotto non esiste nel magazzino
     */
    public boolean rimuoviProdotto(Prodotto p) throws Exception {
        for (List<Prodotto> riga : scaffale) {
            for (int j = 0; j < riga.size(); j++) {
                if (riga.get(j) != null && riga.get(j).equals(p)) {
                    riga.set(j, null);
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
    public String ricercaProdotto(Prodotto p) throws Exception {
        int i = 0;
        int j = 0;

        while (i < scaffale.size()) {
            List<Prodotto> riga = scaffale.get(i);
            while (j < riga.size()) {
                if (riga.get(j) != null && riga.get(j).equals(p)) {
                    return "Il prodotto cercato si trova alla riga " + i + " e alla colonna " + j;
                }
                j++;
            }
            i++;
        }
        throw new Exception("Il prodotto non è stato trovato.");
    }

    /**
     * Stampa tutti i prodotti nel magazzino.
     */
    public void stampa() {
        for (List<Prodotto> riga : scaffale) {
            for (Prodotto prodotto : riga) {
                if (prodotto != null) {
                    System.out.println(prodotto);
                }
            }
        }
    }

    /**
     * Modifica le informazioni di un prodotto nel magazzino.
     * @param p il prodotto da modificare
     * @throws Exception se il prodotto non esiste
     */
    public void modificaProdotto(Prodotto p) throws Exception {
        if (p == null) {
            throw new Exception("Il prodotto non esiste.");
        } else {
            int scelta = 0;
            do {
                System.out.println("1) marca");
                System.out.println("2) modello");
                System.out.println("3) quantita'");
                System.out.println("4) prezzo");
                System.out.println("Inserisci il parametro che vuoi modificare: ");
                scelta = s.nextInt();
            } while (scelta < 0 || scelta > 4);
            System.out.println("Scelta= " + scelta);

            switch (scelta) {
                case 1:
                    String ma = null;
                    System.out.println("Ora stai modificando la marca.");
                    System.out.println("Inserisci la nuova marca: ");
                    ma = s.next();
                    p.setMarca(ma);
                    break;
                case 2:
                    String mo = null;
                    System.out.println("Ora stai modificando il modello.");
                    System.out.println("Inserisci il nuovo modello: ");
                    mo = s.next();
                    p.setModello(mo);
                    break;
                case 3:
                    int qu = 0;
                    System.out.println("Ora stai modificando la quantità.");
                    System.out.println("Inserisci la nuova quantità: ");
                    qu = s.nextInt();
                    p.setQuantita(qu);
                    break;
                case 4:
                    float pr = 0;
                    System.out.println("Ora stai modificando il prezzo.");
                    System.out.println("Inserisci il nuovo prezzo: ");
                    pr = s.nextFloat();
                    p.setPrezzo(pr);
                    break;
            }
        }
    }
}
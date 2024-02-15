/**
 * La classe Prodotto ricrea un prodotto con relativa Marca, Modello, Seriale, Quantità, Prezzo, Disponibilità
 * Autore: Isola Andrea, Pellegrini Marta, Tenti Kevin, Del Magro Federico
 * Data: 15/02/2024
 */
package gestione.prodotti; // Il pacchetto in cui si trova questa classe

import java.util.*; // Importa tutte le classi nel pacchetto java.util

/**
 * La classe Prodotto rappresenta un oggetto prodotto con attributi come marca, modello, seriale, quantità, prezzo e disponibilità.
 */
public class Prodotto { // Definizione della classe Prodotto
    private String marca; // Marca del prodotto
    private String modello; // Modello del prodotto
    private static int seriale = 0; // Numero seriale del prodotto, comune a tutti i prodotti
    private int quantita; // Quantità del prodotto disponibile
    private float prezzo; // Prezzo del prodotto
    private int disponibilita; // Disponibilità del prodotto

    /**
     * Costruisce un nuovo oggetto Prodotto con i parametri forniti.
     * @param marc la marca del prodotto
     * @param mod il modello del prodotto
     * @param quant la quantità del prodotto disponibile
     * @param prez il prezzo del prodotto
     */
    public Prodotto(String marc, String mod, int quant, float prez) { // Costruttore della classe Prodotto
        this.setMarca(marc);            // Inizializza le variabili di istanza con i valori forniti
        this.setModello(mod);
        this.setSeriale();
        this.setQuantita(quant);
        this.setPrezzo(prez);
        this.setDisponibilita(quant);
    }

    /**
     * Restituisce la marca del prodotto.
     * @return la marca del prodotto
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Imposta la marca del prodotto.
     * @param marca la nuova marca del prodotto
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Restituisce il modello del prodotto.
     * @return il modello del prodotto
     */
    public String getModello() {
        return modello;
    }

    /**
     * Imposta il modello del prodotto.
     * @param modello il nuovo modello del prodotto
     */
    public void setModello(String modello) {
        this.modello = modello;
    }

    /**
     * Restituisce il numero seriale del prodotto.
     * @return il numero seriale del prodotto
     */
    public static int getSeriale() {
        return seriale;
    }

    /**
     * Incrementa il numero seriale del prodotto.
     */
    private static void setSeriale() {
        Prodotto.seriale++ ;
    }

    /**
     * Restituisce la quantità del prodotto disponibile.
     * @return la quantità del prodotto disponibile
     */
    public int getQuantita() {
        return quantita;
    }

    /**
     * Imposta la quantità del prodotto disponibile.
     * @param quantita la nuova quantità del prodotto disponibile
     */
    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    /**
     * Restituisce il prezzo del prodotto.
     * @return il prezzo del prodotto
     */
    public float getPrezzo() {
        return prezzo;
    }

    /**
     * Imposta il prezzo del prodotto.
     * @param prezzo il nuovo prezzo del prodotto
     */
    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }

    /**
     * Restituisce la disponibilità del prodotto.
     * @return la disponibilità del prodotto
     */
    public int getDisponibilita() {
        return disponibilita;
    }

    /**
     * Imposta la disponibilità del prodotto.
     * @param disponibilita la nuova disponibilità del prodotto
     */
    private void setDisponibilita(int disponibilita) {
    	
    	this.disponibilita = disponibilita-1;
    }

    /**
     * Converte le informazioni del prodotto in una stringa.
     * @return una stringa che rappresenta le informazioni del prodotto
     */
    public String toString() { // Metodo per convertire le informazioni del prodotto in una stringa
        return "Prodotto [marca= " + marca + ", modello= " + modello + " ,seriale= "+ seriale + ", quantita= " + quantita + ", prezzo= " + prezzo // Restituisce una stringa che rappresenta le informazioni del prodotto
                + ", disponibilita= " + disponibilita + "]";
    }
}

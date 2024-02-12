package gestione.prodotti;
import java.util.*;


public class Prodotto {

	private String marca;
	private String modello;
	private static int seriale=0;
	private int quantita;
	private float prezzo;
	private int disponibilita;
	
	public Prodotto(String marc, String mod, int quant, float prez){
		this.setMarca(marc);
		this.setModello(mod);
		this.setSeriale();
		this.setQuantita(quant);
		this.setPrezzo(prez);
		this.setDisponibilita(getQuantita()-5);
	}
	
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public static int getSeriale() {
		return seriale;
	}

	private static void setSeriale() {
		Prodotto.seriale ++ ;
	}

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

	public float getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}

	public int getDisponibilita() {
		return disponibilita;
	}
	
	private void setDisponibilita(int disponibilita) {
		this.disponibilita = disponibilita;
	}
	/*
		public boolean confrontoProdotti(Prodotto a, Prodotto p) {
			
	    	if(a.getMarca()==p.getMarca() && a.getModello()==p.getModello() && 
	    	   a.getQuantita()==p.getQuantita() && a.getPrezzo()==p.getPrezzo()) {
	    		return true;
	    	}
	
			
			return false;
		}
	*/
	public String toString() {
		return "Prodotto [marca=" + marca + ", modello=" + modello + ",seriale"+ seriale + ", quantita=" + quantita + ", prezzo=" + prezzo
				+ ", disponibilita=" + disponibilita + "]";
	}

	public static void main(String[] args) {

	}
}

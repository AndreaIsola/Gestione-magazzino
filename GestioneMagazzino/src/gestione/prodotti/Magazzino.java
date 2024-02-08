package gestione.prodotti;

import java.util.*;

public class Magazzino{
	
	Scanner s=new Scanner(System.in);
	
	private Prodotto[][] scaffale;
	
	public Magazzino(int righe, int colonne) {
		
		this.scaffale=new Prodotto[righe][colonne];	
		}

	public Prodotto[][] getScaffale() {
		return scaffale;
	}

	public boolean aggiungiProdotto(Prodotto p) throws Exception {
		
		int i=0;
		int j=0;
		
		if(p==null) {
			 throw new Exception("Il prodotto non esiste");
		}else {
			while(i<scaffale.length ) {
				while(j<scaffale[i].length) {
		        	if(scaffale[i][j].getMarca()==p.getMarca() && scaffale[i][j].getModello()==p.getModello() && 
		        			scaffale[i][j].getQuantita()==p.getQuantita() && scaffale[i][j].getPrezzo()==p.getPrezzo()) {
		        		scaffale[i][j].setQuantita(scaffale[i][j].getQuantita()+p.getQuantita());
		        		return true;
		        	}
		        	if (scaffale[i][j] == null) {
		                scaffale[i][j] = p;
		                return true;
		            }
		        }
		    }
		    throw new Exception("Il prodotto non è stato inserito perché lo scaffale è pieno.");
		}

	}
	
	public boolean rimuoviProdotto(Prodotto p) throws Exception{
		int i=0;
		int j=0;
		
		while(i<scaffale.length ) {
			while(j<scaffale[i].length) {
				if (scaffale[i][j].equals(p)) {
	                scaffale[i][j] = null;
	                return true;
	            }
	        }
		}
		    throw new Exception("Il prodotto non è stato eliminato perchè non esiste.");
	}
	
	public String ricercaProdotto(Prodotto p) throws Exception{
		int i=0;
		int j=0;
		
		while(i<scaffale.length ) {
			while(j<scaffale[i].length) {
		        	if (scaffale[i][j].equals(p)) {
		                return "Il prodotto cercato si trova alla riga "+ i +" e alla colonna "+ j;
		            }
		        }
		    }
		    throw new Exception("Il prodotto non è stato trovato.");
		
	}
	
	public void stampa() {
		
		for (int i = 0; i < scaffale.length; i++) {
	        for (int j = 0; j < scaffale[i].length; j++) {
	        	System.out.println(scaffale[i][j]);
	        }
	    }
	}
	
	public void modificaProdotto(Prodotto p)throws Exception {
		
		if(p==null) {
			 throw new Exception("Il prodotto non esisteeeeeeeeeeeeeeeee.");
		 }else {
			int scelta=0;
			System.out.println("1) marca");
			System.out.println("2) modello");
			System.out.println("3) quantità");
			System.out.println("4) prezzo");
			do {
				System.out.println("Inserisci il parametro che vuoi modificare:");
				scelta=s.nextInt();
			}while(scelta < 0 || scelta > 4);
			System.out.println("Scelta="+scelta);
			

			
			switch(scelta) {
			
			case 1:					//Marca
				String ma=null;
				System.out.println("Ora stai modificando la marca.");
				System.out.println("Inserisci la nuova marca:");
				ma=s.nextLine();
				p.setMarca(ma);
				break;
			case 2:					//Modello
				String mo=null;
				System.out.println("Ora stai modificando il modello.");
				System.out.println("Inserisci il nuovo modello:");
				mo=s.nextLine();
				p.setModello(mo);
				break;
			case 3:					//Quantita
				int qu=0;
				System.out.println("Ora stai modificando la quantità.");
				System.out.println("Inserisci la nuova quantità:");
				qu=s.nextInt();
				p.setQuantita(qu);
				break;
			case 4:					//Prezzo
				float pr=0;
				System.out.println("Ora stai modificando il prezzo.");
				System.out.println("Inserisci il nuovo prezzo:");
				pr=s.nextInt();
				p.setPrezzo(pr);
				break;
			case 0:
				
				break;
			}
		}
		
	}

	public static void main(String[] args) throws Exception {

	}
}
package strutturaStadio;


import contabilita.Cassa;

import java.io.Serializable;
import java.util.ArrayList;

/**Stadio
 * uno stadio ha un nome(String), una collezione di partite(ArrayList<Partita>, una collezione di tribune(ArryList<Ala>)
 * tre oggetti sconto(booleano)
 * 
 *
 */
public class Stadio implements Serializable {

	private String nomeStadio;
	private ArrayList<Partita> partite;
	private int capienza;
	private boolean sconto1;
	private boolean sconto2;
	private boolean sconto3;
	private Cassa cassa;
	
	/**Costruttore uno stadio � costituito da un nomeStadio(String)
	 * 
	 * @param nomeStadio, identifica univocamente lo stadio
	 */
	public Stadio(String nomeStadio){
		sconto1 = false;
		sconto2 = false;
		sconto3 = false;
		this.nomeStadio = nomeStadio;
		partite= new ArrayList<Partita>();
		cassa = new Cassa();
	}

	public Cassa getCassa() {
		return cassa;
	}

	public int getCapienza() {
		return capienza;
	}

	public void setCapienza(int capienza) {
		this.capienza = capienza;
	}
	/**Adder
	 * prende in input un attributo partita(Partita)
	 * @param , aggiunge una partita all'arrayList di Partite
	 */
	public void addPartita(Partita p){
		partite.add(p);
	}
	
	/**Confronto booleano
	 * restituisce true or false se sconto1 � attivo
	 * @return true or false
	 */
	public boolean isSconto1() {
		return sconto1;
	}
	/**Setter booleano
	 * prende in input un oggetto di tipo boolean e assegna tale variabile a sconto1
	 * @param sconto1
	 */
	public void setSconto1(boolean sconto1) {
		this.sconto1 = sconto1;
	}
	/**Confronto booleano
	 * restituisce true or false se sconto2 � attivo
	 * @return true or false
	 */
	public boolean isSconto2() {
		return sconto2;
	}
	/**Setter booleano
	 * prende in input un oggetto di tipo boolean e assegna tale variabile a sconto1
	 * @param sconto2
	 */
	public void setSconto2(boolean sconto2) {
		this.sconto2 = sconto2;
	}
	/**Confronto booleano
	 * restituisce true or false se sconto1 � attivo
	 * @return true or false
	 */
	public boolean isSconto3() {
		return sconto3;
	}
	/**Setter booleano
	 * prende in input un oggetto di tipo boolean e assegna tale variabile a sconto3
	 * @param sconto3
	 */
	public void setSconto3(boolean sconto3) {
		this.sconto3 = sconto3;
	}
	/**Getter del nome dello stadio
	 * restituisce il nome dello stadio
	 * @return nomeStadio(String)
	 */
	public String getNomeStadio(){
		return nomeStadio;
	}
	/**Getter della collezione di partite
	 * restituisce una collezione di partite
	 * @return partite(ArrayList<Partita>)
	 */
	public ArrayList<Partita> getPartite() {
		return partite;
	}
	
}

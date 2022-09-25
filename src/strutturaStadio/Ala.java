package strutturaStadio;

import java.io.Serializable;
import java.util.ArrayList;
/** Ala
 * un'ala ha un id(String), un nome(String) e una collezione di posti
 * 
 * 
 *
 */
public class Ala implements Serializable {

	private String id;
	private String nomeAla;
	private ArrayList<Posto> posti;
	
	/**
	 * Costruttore: un'Ala è costituita da un id(String) e un nomeAla (String)
	 * @param nomeAla definisce il nome dell'ala
	 * @param id identifica univocamente lo stadio
	 */
	public Ala(String nomeAla,String id){
		this.id = id;
		this.nomeAla= nomeAla;
		posti = new ArrayList<Posto>();
		for(int i=1; i<261; i++){
			posti.add(new Posto(this.id,i));
		}
	}
	/**Getter Id
	 * restituisce la stringa id
	 * @return id(String)
	 */
	public String getId(){
		return id;
	}
	/**Getter ArrayList di tipo posto
	 * restituisce una collezione di oggetti di tipo Posto
	 * @return posti(ArrayList<Posto>)
	 */
	public ArrayList<Posto> getArray(){
		return posti;
	}
	
}

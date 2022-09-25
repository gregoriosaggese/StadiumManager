package strutturaStadio;

import java.io.Serializable;


/**
 *Classe che definisce un <i>Posto</i>.
 *Un posto ha un id (String), uno stato (int) e un numero (int).
 */


public class Posto implements Serializable {

	/**
	 * Costruttore, un posto è costruito mediante un id (String) ,un numero(int) e uno stato(int)
	 * @param id, stringa identificativa del posto
	 * @param numero, intero che definisce il numero del posto
	 */
	public Posto(String id, int numero){
		this.id = id + numero;
		this.numero = numero;
		stato = 0;
	}

	/**
	 * Setter di stato, setta lo stato del posto mediante un intero
	 * @param stato ,stato del posto 
	 */

	public void setStato(int stato){
		this.stato = stato;  
	}

	/**
	 * Getter di id, prende l'id(String) del posto
	 * @return una stringa ,id(String) identificativo del posto
	 */
	public String getId(){
		return id;
	}


	/**
	 * Getter di stato, prende lo stato(int) del posto
	 * @return un'intero ,stato(int) identificativo del posto
	 */

	public int getStato(){
		return stato;
	}

	/** id del posto.
	 */
	private String id;

	/** stato del posto.
	 */
	private int stato; 

	/** numero del posto.
	 */
	private int numero;
	// 0 = libero----verde, 1 = prenotato---giallo;
	//2 = occupato(prenotato da altro utente)-------arancione;
	//3= acquistato-------rosso;
	//4 = indisponibile------grigio;



}
package utente;

import java.io.Serializable;

import java.util.GregorianCalendar;

/**Classe che definisce <i>Gestore</i>
 * Gestore ha un id(String) e una password(String)
 *
 */

public class Gestore extends Utente implements Serializable{ 

	String id;
	String password;
	
	/**Costruttore del Gestore
	 * 
	 * 
	 * @param nomeUtente,cognomeUtente definiscono l'identità del gestore
	 * @param 
	 * @param dataDiNascita definisce la data di nascita del gestore
	 * @param sesso determina il sesso del gestore
	 */
	public Gestore(String nomeUtente, String cognomeUtente,GregorianCalendar dataDiNascita,String sesso) {
		super(nomeUtente, cognomeUtente, dataDiNascita, sesso);
		setAdmin(true);	
	}
	/**Getter di Id
	 * restituisce l'id del gestore
	 * @return id(String)
	 */
	public String getId() {
		return id;
	}
	/**Getter di password
	 * restituisce il parametro password
	 * @return password(String)
	 */
	public String getPassword() {
		return password;
	}
	/**Setter di Id
	 * prende in input una stringa e modifica il valore dell'attributo originale
	 * @param id(String)
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**Setter di password
	 * prende in input una stringa e modifica l'attributo originale password
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}

package utente;

import java.io.Serializable;
import java.util.GregorianCalendar;

/**Classe che definisce <i>Utente</i>
 *   un utente ha un nome(String), un cognome(String), una dataDiNascita(String), il sesso ed un parametro admin(boolean)
 * 
 *
 */

public abstract class Utente implements Serializable {

	private String nome;
	private String cognome;
	private GregorianCalendar dataDiNascita;
	private String sesso;
	private boolean admin;
	
	/**Costruttore di Utente
	 * 
	 * @param nome definisce il nome dell'utente
	 * @param cognome definisce il cognome dell'utente
	 * @param dataDiNascita determina la data di nascita dell'utente
	 * @param sesso determina il sesso dell'utente
	 */
	public Utente(String nome,String cognome,GregorianCalendar dataDiNascita,String sesso){
		this.nome = nome;
		this.cognome = cognome;
		this.dataDiNascita = dataDiNascita;
		this.sesso = sesso;
	}
	
	/**Getter di nome
	 * restituisce l'attributo nome
	 * @return nome(String)
	 */
	public String getNome() {
		return nome;
	}
	/**Getter di cognome
	 * restituisce l'attributo dell'utente
	 * @return cognome(String)
	 */
	public String getCognome() {
		return cognome;
	}
	/**Getter di data di nascita
	 * restiutisce l'attributo dataDiNascita
	 * @return dataDiNascita(String)
	 */
	public GregorianCalendar getDataDiNascita() {
		return dataDiNascita;
	}
	/**Getter di sesso
	 * restituisce il sesso dell'utente
	 * @return sesso(String)
	 */
	public String getSesso() {
		return sesso;
	}
	/**Controllo sul parametro Admin
	 * restituisce true se si tratta effettivamente di un amministratore del sistesta
	 * @return admin(boolean)
	 */
	public boolean isAdmin() {
		return admin;
	}
	/**Setter di Admin
	 * prende in input un parametro true o false e modifica il parametro admin in base a tale input
	 * @param admin
	 */
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	
}

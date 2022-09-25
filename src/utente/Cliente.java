package utente;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import contabilita.Biglietto;
/**Classe che definisce <i>Cliente</i>
 * Cliente ha un id(String), una password personale (String), 
 * un arrayList prenotazioni per biglietto (ArrayList<Biglietto), un arrayList acquisti (ArrayList<Biglietto)
 * 
 *
 */
public class Cliente extends Utente implements Serializable{

	private String id;
	private String password;
	private ArrayList<Biglietto> prenotazioni;
	private ArrayList<Biglietto> acquisti;
	
	/**Costruttore del Cliente
	 * 
	 * @param nomeUtente,cognomeUtente, stringa che definisce l'identit� del cliente
	 * @param dataDiNascita, stringa che indica la data in cui � nato il cliente
	 * @param sesso,stringa che indica il sesso del cliente
	 * @param id, stringa che definisce il nomeUtente di accesso
	 * @param password, stringa che definisce la chiave di accesso corrispondente all'account
	 */
	public Cliente(String nomeUtente, String cognomeUtente, GregorianCalendar dataDiNascita,String sesso,String id,String password) {
		super(nomeUtente, cognomeUtente, dataDiNascita, sesso);
		this.id = id;
		this.password = password;
		setAdmin(false);
		prenotazioni= new ArrayList<Biglietto>();
		acquisti= new ArrayList<Biglietto>();
	}
	/**Controllo booleano
	 * restituisce true se il cliente � nell'et� pensionabile
	 * @return true or false
	 */
	public boolean getDiscountablePensionato() {
		GregorianCalendar dateOfDay = new GregorianCalendar();

		if(dateOfDay.get(1) - getDataDiNascita().get(1) >= 60){
			return true;
		}
		else return false;
	}

	/*public boolean getDiscountableQuantit�() {
		return false;
	}*/
	/**SetPassword
	 * prende in input una stringa e modifica il parametro passato
	 * @param password
	 * @return password(String)
	 */
	public void setPassword(String password){
		this.password = password;
	}
	/**SetID
	 * prende in input una stringa e modifica il parametro
	 */
	public void setId(String id){
		this.id = id; 
	}
	/**Getter ID
	 * restituisce l'id(String) del posto
	 * @return id(String)
	 */
	public String getId(){
		return id;
	}
	/**Getter Passoword
	 * restituisce la password(String)
	 * @return password(String)
	 */
	public String getPassword(){
		return password;
	}
	/**Getter Prenotazioni
	 * restituisce una collezione di oggetti(ArrayList(Biglietto))
	 * @return prenotazioni(ArrayList(Biglietto)
	 */
	public ArrayList<Biglietto> getPrenotazioni(){
		return this.prenotazioni;
	}
	/**Getter Acquisti
	 * restituisce una collezione di oggetti(ArrayList(Biglietto))
	 * @return acquisti(ArrayList(Biglietto)
	 */
	public ArrayList<Biglietto> getAcquisti(){
		return this.acquisti;
	}

	
	
}

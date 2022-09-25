package sistema;

import java.io.Serializable;
import java.util.ArrayList;
import contabilita.Cassa;
import strutturaStadio.Stadio;

/**Classe che definisce <i>StrutturaSportiva</i>
 * , una struttura sportiva ha utenti(RegistroUtenti), stadi(ArryList<Stadio>) e un nomeStruttura(String)
 * 
 *
 */
public class StrutturaSportiva implements Serializable {

	private RegistroUtenti utenti;
	private ArrayList<Stadio> stadi;
	private String nomeStruttura;
		
	/**Costruttuore di nomeStruttura
	 * 
	 * @param nomeStruttura stringa che definisce il nome della struttura
	 */
	public StrutturaSportiva(String nomeStruttura){
		this.nomeStruttura = nomeStruttura;
		stadi = new ArrayList<Stadio>();
	}
	
	/**Adder
	 * Aggiunge all'arrayList stadi un oggetto di tipo Stadio
	 * @param s(Stadio)
	 */
	public void addStadio(Stadio s){
		stadi.add(s);
	}
	/**Getter di Stadi
	 * ,restituisce un oggetto di stadi
	 * @return stadi(ArrayList<Stadio>)
	 */
	public ArrayList<Stadio> getStadi() {
		return stadi;
	}
	/**Metodo Sovrascritto Equals
	 * 
	 * 
	 */
	
	public boolean equals(Object obj){
		
		if(obj== null) return false;
		else if(obj.getClass().getName() == this.getClass().getName())
			return true;
		else return false;
	}
	/**Getter di nomeStruttura
	 * restituisce il nome della struttura sportiva
	 * @return nomeStruttura(String)
	 */
	public String getNomeStruttura() {
		return nomeStruttura;
	}
	/**Getter di RegistroUtenti
	 * restituisce il registro degli utenti
	 * @return utenti(RegistroUtenti)
	 */
	public RegistroUtenti getRegistroUtenti() {
		return utenti;
	}
	/**Setter di Registro utenti
	 * prende in input un oggetto di tipo RegistroUtenti 
	 * @param utenti
	 */
	public void setUtenti(RegistroUtenti utenti) {
		this.utenti = utenti;
	}
	/**Setter di Stadi
	 * prende in input un arrayList di stadi  
	 * @param stadi(ArrayList<Stadio>)
	 */
	public void setStadi(ArrayList<Stadio> stadi) {
		this.stadi = stadi;
	}
	/**Setter di NomeStruttura
	 * prende in input una stringa e modifica l'attributo originale
	 * @param nomeStruttura(String)
	 */
	public void setNomeStruttura(String nomeStruttura) {
		this.nomeStruttura = nomeStruttura;
	}	
}

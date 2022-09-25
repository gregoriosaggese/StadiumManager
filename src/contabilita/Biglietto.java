package contabilita;


import strutturaStadio.Stadio;

import java.io.Serializable;

/**Classe Biglietto
 * , biglietto ha un idPosto(String), una partita(String) e uno stadio(Stadio)
 *
 *
 */
public class Biglietto  implements Serializable {
	
	private String idPosto;
	private String partita;
	private Stadio stadio;
	private float prezzo;
	
	/**Costruttore
	 * 
	 * @param idPosto, identifica univocamente un posto
	 * @param partita, identifica la partita a cui si riferisce il biglietto 
	 * @param stadio determina lo stadio per il quale il biglietto � considerato valido
	 */
	public Biglietto(String idPosto, String partita,Stadio stadio, float prezzo){
		this.idPosto=idPosto;
		this.partita=partita;
		this.stadio=stadio;
		this.prezzo = prezzo;
	}
	
	/**Getter di prezzo
	 * restituisce un oggetto di tipo prezzo
	 * @return prezzo(Float)
	 * */
	public float getPrezzo() {
		return prezzo;
	}
	
	/**Getter di Stadio
	 * restituisce un oggetto di tipo Stadio 
	 * @return stadio(Stadio)
	 */
	public Stadio getStadio() {
		return stadio;
	}

	/**Getter di IdPosto
	 * restituisce il parametro che rende univoco un Posto
	 * @return idPosto(String)
	 */
	public String getIdPosto() {
		return idPosto;
	}
	/**Getter di Partita
	 * restituisce il nome della partita
	 * @return partita(String)
	 */
	public String getPartita() {
		return partita;
	}

}

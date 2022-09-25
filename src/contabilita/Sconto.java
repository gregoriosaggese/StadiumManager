package contabilita;


import sistema.FileManager;

public class Sconto {
	
	/**Classe che definisce <i>Sconto</i>
	 * uno Sconto ha una percentualeSconto(int) ed un oggetto di tipo FileManager
	 * 
	 */
	//implementare 3 politiche di conto : sconto del 20% se il cliente ha piu di 60 anni
	//sconto del 10% in una certa fascia oraria (dalle 10:00 alle 12:00)
	//sconto del 25% se la partita si gioca di lunedi pomeriggio (dalle 15:00 alle 17:00)
	
	public int percentualeSconto;
	protected FileManager f;
	
	/**Costruttore
	 * 
	 * @param f, definisce l'oggetto File Manager da utilizzare
	 */
	public Sconto(FileManager f){
		this.f=f;
		percentualeSconto=0;
	}
	/**Getter di percentualeSconto
	 * restituisce un oggetto di tipo int
	 * @return percentualeSconto
	 */
	public int getPercentualeSconto() {
		return percentualeSconto;
	}
	/**Setter di percentualeSconto
	 * prende in input un oggetto di tipo int e modifica il paramentro percentuale Sconto
	 * @param percentualeSconto
	 */
	public void setPercentualeSconto(int percentualeSconto) {
		this.percentualeSconto = percentualeSconto;
	}



}

package contabilita;

import java.io.Serializable;

/**Classe che definisce <i>Cassa</i>
 * una cassa ha un saldo(Double)
 * 
 *
 */
public  class Cassa implements Serializable{

	private double saldo;//ogni stadio ha una cassa, la cassa della struttura sportiva � composta dal totale delle casse degli stadi
	
	/**Costruttore di Cassa
	 *
	 */
	public Cassa(){
		saldo = 0;
	}
	
	/**Getter di saldo
	 * restituisce un oggetto di tipo double
	 * @return saldo(double)
	 */
	
	public double getSaldo() {
		return saldo;
	}
	
	/**Setter di saldo
	 * prende in input un oggetto di tipo double e modifica il parametro saldo
	 * @param saldo
	 */

	public void setSaldo(double saldo) {
		this.saldo = this.saldo + saldo;
	}
	
}

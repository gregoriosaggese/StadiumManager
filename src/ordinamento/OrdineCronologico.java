package ordinamento;

import strutturaStadio.Partita;

import java.util.Comparator;


/**Classe che definisce <i>OrdineCronologico</i>
 *, non � caratterizzata da un costruttore
 * 
 *
 */
public class OrdineCronologico implements Comparator<Partita>{
	/**Funzione compare
	 * prende in input due oggetti di tipo Partita e confronta le date degli incontri per definirne l'ordine in cui apparire
	 * , inoltre ordina l'arrayList di oggetti di tipo Partita
	 */
	public int compare(Partita p, Partita p1) {
		
		if (p.getData().before(p1.getData())) 
			return -1;
		
		else if (p.getData().after(p1.getData())) 
			return 1;
		
		return 0;
	}

}

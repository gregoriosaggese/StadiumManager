package ordinamento;

import java.util.Comparator;
/**Classe che definisce <i>OrdineCrescente</i>
 *, non è caratterizzata da un costruttore
 * 
 *
 */
public class OrdineCrescente implements Comparator<Integer>{
	/**Funzione compare
	 * prende in input due oggetti di tipo integer e crea un ordina partendo dal più piccolo al più grande,
	 * restituisce un oggetto di tipo int
	 * @return 
	 */
	public int compare(Integer p, Integer p1) {

		if (p < p1) 
			return -1;

		else if (p > p1) 
			return 1;

		return 0;
	}
}

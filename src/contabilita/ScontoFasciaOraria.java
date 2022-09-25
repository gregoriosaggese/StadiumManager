package contabilita;


import sistema.FileManager;

/**Classe che definisce <i>ScontoFasciaOraria</i>
 * classe che eredita metodi e variabili dalla classe Sconto
 *
 *
 */

public class ScontoFasciaOraria extends Sconto {

	public ScontoFasciaOraria(FileManager f) {
		super(f);
		setPercentualeSconto(10);
	}

	/**Adder di ScontoFasciaOraria
	 * prende in input l'indice dello stadio e l'indice della partita associata 
	 * ed applica uno sconto di tipo fascia oraria
	 * 
	 * @return
	 */
	public int addScontoFasciaOraria(int indiceStadio,int indicePartita){

		int sconto = f.getS().getStadi().get(indiceStadio).getPartite().get(indicePartita).getPrezzo() 
				- f.getS().getStadi().get(indiceStadio).getPartite().get(indicePartita).getPrezzo() * getPercentualeSconto() / 100;

		return sconto;
	}

}

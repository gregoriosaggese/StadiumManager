package contabilita;


import sistema.FileManager;

/**Classe che definisce <i>ScontoLuned�</i>
 * classe che eredita metodi e variabili dalla classe Sconto
 *
 *
 */

public class ScontoPensionati extends Sconto{

	public ScontoPensionati(FileManager f) {
		super(f);
		setPercentualeSconto(20);
	}
	
	/**Adder di ScontoLuned�
	 * prende in input l'indice dello stadio e l'indice della partita associata 
	 * ed applica uno sconto di tipo giornaliero
	 * 
	 * @return
	 */
	public int addScontoPensionati(int indiceStadio,int indicePartita){

		int sconto = f.getS().getStadi().get(indiceStadio).getPartite().get(indicePartita).getPrezzo() 
				- f.getS().getStadi().get(indiceStadio).getPartite().get(indicePartita).getPrezzo() * getPercentualeSconto() / 100;

		return sconto;
	}
}
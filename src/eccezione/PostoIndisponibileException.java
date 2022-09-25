package eccezione;

public class PostoIndisponibileException extends RuntimeException {
	
	/**Classe che definisce l'eccezione non controllata <i>PostoIndisponibileException</i>
	 * 
	 */
	public PostoIndisponibileException() {
		super("Posto indisponibile");
	}
	
	/**Metodo toString della classe
	 * 
	 */
	public String toString(){
		return getMessage();
	}
	
}

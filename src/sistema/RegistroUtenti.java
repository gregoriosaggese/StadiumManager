package sistema;

import utente.Utente;

import java.io.Serializable;
import java.util.ArrayList;


public class RegistroUtenti implements Serializable {
	
	private ArrayList<Utente> utenti= null;
	
	public RegistroUtenti(){
		this.utenti= new ArrayList<Utente>();
	}

	public void setUtenti(ArrayList<Utente> utenti) {
		this.utenti = utenti;
	}

	public ArrayList<Utente> getUtenti() {
		return utenti;
	}	
	
	
	

}

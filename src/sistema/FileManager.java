package sistema;

import strutturaStadio.Stadio;
import utente.Gestore;
import utente.Utente;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


/**Classe che definisce <i>FileManager</i>
 * un fileManager ha una struttura(StrutturaSportiva)
 * 
 *
 */
public class FileManager {
	
	private StrutturaSportiva s;
	
	/**Costruttore vuoto
	 * 
	 */
	public FileManager() {
	}
	/**Costruttore
	 * 
	 * @param s definisce la struttura sportiva
	 */
	public FileManager(StrutturaSportiva s) {
		this.s=s;
	}
	
	/**Getter di Struttura Sportiva
	 * restituisce la struttura sportiva a cui fare riferimento
	 * @return struttura(StrutturaSportiva)
	 */
	public StrutturaSportiva getS() {
		return s;
	}
	
	/**Funzione salvaStruttura,
	 * aggiorna e sovrascrive la struttura memorizzata nel file StrutturaSportiva.Fizz
	 *
	 * @throws IOException
	 */
	public void salvaStruttura() throws FileNotFoundException, IOException
	{
		File f = new File("StrutturaSportiva.fizz");
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f));
		out.writeObject(s);
		out.close();
	}
	/**Funzione caricaStruttura
	 * ,carica dal file StrutturaSportiva.Fizz i dati riguardanti la struttura, quali il gestore, il registro utenti e gli stadi
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public void caricaStruttura() throws FileNotFoundException, IOException, ClassNotFoundException
	{
		File f = new File("StrutturaSportiva.fizz");
		if(!f.exists()){
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f));
			Gestore g= new Gestore("admin", "admin", null, "M");
			g.setAdmin(true);
			g.setPassword("admin");
			g.setId("admin");
			this.s= new StrutturaSportiva("Struttura");
			getS().setUtenti(new RegistroUtenti());
			getS().setStadi(new ArrayList<Stadio>());
			getS().getRegistroUtenti().getUtenti().add((Utente)g);
			out.writeObject(s);
			out.close();
		}
		
		ObjectInputStream in =new ObjectInputStream(new FileInputStream(f));
		s= (StrutturaSportiva) in.readObject();
		in.close();
	}
	
}

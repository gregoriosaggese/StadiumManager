package strutturaStadio;


import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
/**Classe che definisce un <i>Partita</i>.
*Una partita ha due nomi di squadre (String), una data (String), un prezzo (int) e un arrayList di tribune(Ala).*/

public class Partita implements Serializable{

	private String partita;
	private String parsedData;
	private GregorianCalendar data;
	private SimpleDateFormat sdf;
	private int prezzo;
	private ArrayList<Ala> tribune;
	private Stadio stadio;

	/**Costruttore
	 * @param PrimaSquadra,SecondaSquadra, identificano i nomi delle due partite in gioco
	 * @param data, la data in cui verr� disputata tale partita
	 * @param stadio, un oggetto di tipo Stadio che definisce lo stadio in cui verr� disputata la partita
	 * @param prezzo, intero/double che definisce il costo per osservare la partita
	 */
	
	public Partita(String PrimaSquadra,String SecondaSquadra,String data,int prezzo,Stadio stadio){
		
		tribune = new ArrayList<Ala>();
		for(int i=0; i<4; i++){
			if(i==0)
				tribune.add(new Ala("Nord",stadio.getNomeStadio()+"N"));
			else if(i==1)
				tribune.add(new Ala("Est",stadio.getNomeStadio()+"E"));
			else if(i==2)
				tribune.add(new Ala("Sud",stadio.getNomeStadio()+"S"));
			else if(i==3)
				tribune.add(new Ala("Ovest",stadio.getNomeStadio()+"O"));
		}

		this.stadio=stadio;
		this.prezzo=prezzo;
		this.sdf = new SimpleDateFormat("EEE dd/MMM/yyyy HH:mm");
		this.data = new GregorianCalendar();

		partita = PrimaSquadra +" vs " + SecondaSquadra ;

		try{
			this.data.setTime(sdf.parse(data));
		}
		catch (ParseException e){
			e.printStackTrace();
		}
	}
	/**Getter di Stadio
	 * restituisce un oggetto di tipo Stadio
	 * @return stadio(Stadio)
	 */
	public Stadio getStadio() {
		return stadio;
	}
	/**Getter della tribuna
	 * restituisce un array di tribune
	 * @return tribune(ArrayList)
	 */
	public ArrayList<Ala> getTribune() {
		return tribune;
	}
	/**Getter di Partita completa di data
	 * restituisce un oggetto composto da una partita(Partita) e un
	 * @return
	 */
	public String getPartitaComplet() {
		return partita+" "+this.getParsedData() ;
	}
	/**Getter Partita
	 * restituisce il nome di una partita
	 * @return partita(string)
	 */
	public String getPartita() {
		return partita;
	}
	/**Getter di una parte specifica della data
	 * restituisce un parte della data
	 * @return parsedData(String)
	 */
	public String getParsedData(){
		parsedData = sdf.format(data.getTime());
		return parsedData;
	}
	/**Getter data
	 * restituisce una data
	 * @return data(GregorianCalendar)
	 */
	public GregorianCalendar getData() {
		return data;
	}
	/** Getter del prezzo, 
	 * restituisce una variabile int
	 * @return
	 */
	public int getPrezzo() {
		return prezzo;
	}
	/**Setter del prezzo
	    * prende in input una variabile int e modifica il valore di prezzo
	    * @param prezzo, prezzo della partita
	    */
	public void setPrezzo(int prezzo) {
		this.prezzo = prezzo;
	}
	/**Metodo equals sovrascritto
	 * 
	 */
	public boolean equals(Object obj){
		if(obj==null) return false;
		else if(obj.getClass()!=this.getClass()) return false;
		else if(obj.getClass().getName().equalsIgnoreCase(this.getClass().getName())) return false;
		else if(!(((Partita)obj).getPartita().equalsIgnoreCase(this.getPartita()))) return false;
		else return true;
	}
	
	/**Getter booleano Sconto in base alla fascia oraria
	 * restituisce true se una partita si svolge
	 * in una fascia oraria che definisce uno sconto sul prezzo
	 * @return true or false(boolean)
	 */
	public boolean getDiscountableFasciaOraria(){

		if(data.getTime().getHours() >= 10 && data.getTime().getHours() <= 12){
			return true;
		}

		else return false;
	}
	/**Getter booleano Sconto in base al giorno
	 * restituisce true se la partita si svolge di Luned�
	 * @return true or false(boolean)
	 */
	public boolean getDiscountableLunedi(){

		if(data.getTime().getDay() == 1){
			return true;
		}

		else return false;
	}








}

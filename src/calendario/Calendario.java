package calendario;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.GregorianCalendar;

/**Classe che definisce <i>Calendario</i>
 * ha un parametro date(Local), un attributo leap(boolean), un insiemeDate(ArrayList<GregorianCalendar>),
 *  un insiemeDateString(ArrayList<String>)
 * 
 *
 */
public class Calendario{

	private LocalDate date;
	private boolean leap;
	private ArrayList<GregorianCalendar> insiemeDate;
	private ArrayList<String> insiemeDateString;
	
	/**Costruttore
	 * crea due ArrayList contenenti in uno un elenco di anni in formato GregorianCalendar
	 * e nell'altro lo stesso elenco ma in formato stringa
	 */
	public Calendario(){
		
		insiemeDateString = new ArrayList<String>();
		insiemeDate = new ArrayList<GregorianCalendar>();
		
		Month mon = null;
		int anno = 2016;
		int mese = 1;
		int giorno = 1;
		
		date = LocalDate.of(anno, mese, giorno);
		leap = date.isLeapYear();

		for(int j=0; j<12; j++){
			mon = date.getMonth();
			for(int k=0; k<mon.length(leap); k++){
				if(k < mon.length(leap)){
					GregorianCalendar d = new GregorianCalendar(anno,mese-1,giorno);
					insiemeDate.add(d);
					SimpleDateFormat sdf = new SimpleDateFormat("EEE dd/MMM/yyyy");
					insiemeDateString.add(sdf.format(d.getTime()));
				}
				giorno++;
				if(giorno <= mon.length(leap))
					date = LocalDate.of(2016, mese, giorno);
			}
			giorno = 1;
			mese++;
			if (mese == 13)
				break;
			date = LocalDate.of(2016, mese, giorno);
		}
	}
	/**Getter di insiemeDateString
	 * restituisce l'arrayList di date
	 * @return insiemeDateString(ArrayList<String>)
	 */
	public ArrayList<String> getInsiemeDateString() {
		return insiemeDateString;
	}
	/**Getter di insiemeDate
	 * restituisce l'arrayList di date
	 * @return insiemeDateString(ArrayList<GregorianCalendar>)
	 */
	public  ArrayList<GregorianCalendar> getArrayDate(){
		return insiemeDate;
	}
}

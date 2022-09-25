package tester;

import grafica.HomePage;
import sistema.FileManager;
import strutturaStadio.Partita;
import strutturaStadio.Stadio;

import java.io.FileNotFoundException;
import java.io.IOException;



public class Tester {
	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException{

		FileManager f= new FileManager();
		f.caricaStruttura();

		if(f.getS().getStadi().size() == 0){
			
			Stadio s = new Stadio("San Siro");
			s.addPartita(new Partita("Napoli", "Atalanta", "dom 15/feb/2016 15:00", 50,s));
			s.addPartita(new Partita("Chievo", "Inter", "dom 30/mar/2016 10:00",50,s));
			s.addPartita(new Partita("Juventus", "Milan", "dom 25/giu/2016 17:00",50,s));

			Stadio t = new Stadio("Juventus Stadium");
			t.addPartita(new Partita("Palermo", "Atalanta", "dom 21/nov/2016 10:00",50,t));
			t.addPartita(new Partita("Chievo", "Milan", "dom 30/mag/2015 17:00",50,t));
			t.addPartita(new Partita("Milan", "Lazio", "dom 15/set/2016 21:00",50,t));
			t.addPartita(new Partita("Napoli", "Inter", "dom 17/mar/2016 18:00",50,t));
			t.addPartita(new Partita("Juventus", "Napoli", "dom 14/nov/2016 11:00",50,t));

			Stadio w = new Stadio("Olimpico");
			w.addPartita(new Partita("Monaco", "Inter", "dom 12/mar/2016 11:00",50,w));
			w.addPartita(new Partita("Juventus", "Barcellona", "dom 15/dic/2016 13:30",50,w));
			w.addPartita(new Partita("Brasile", "Italia", "dom 17/mar/2016 16:00",50,w));
			w.addPartita(new Partita("Germania", "Olanda", "dom 14/mar/2016 21:45",50,w));
			w.addPartita(new Partita("Lille", "Real Madrid", "dom 14/lug/2016 19:00",50,w));
			w.addPartita(new Partita("Bergamo", "Benfica", "dom 15/mar/2016 10:30",50,w));
			w.addPartita(new Partita("Lazio", "Lecce", "dom 13/mar/2016 9:00",50,w));

			f.getS().getStadi().add(s);
			f.getS().getStadi().add(t);
			f.getS().getStadi().add(w);
		}
	
		HomePage home = new HomePage(f);
		home.creaHomePage();

	}
}

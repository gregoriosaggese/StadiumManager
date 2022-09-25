package grafica;

import ordinamento.OrdineCrescente;
import ordinamento.OrdineCronologico;
import sistema.FileManager;
import strutturaStadio.Partita;
import strutturaStadio.Stadio;
import utente.Gestore;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;


/**Classe che definisce <i>FrameHomeGestore</i>
 * ha un parametro s(FileManager), un gestore(Gestore), un indiceStadio(int), una classe interna JTextFieldLimit
 * 
 *
 */
public class FrameHomeGestore {

	private FileManager s;
	private Gestore gestore;
	private int indiceStadio;
	/**Costruttore
	 * 
	 * @param s definisce il FileManger
	 * @param c definisce il gestore a cui far� riferimento l'interfaccia
	 */
	public FrameHomeGestore(FileManager s, Gestore g){
		this.s=s;
		this.gestore=g;
	}
	
	/** Funzione creaHome
	 * genera l'interfaccia grafica iniziale
	 */
	public void creaHome(){

		JFrame frame = new JFrame();
		frame.setSize(800, 320);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setTitle("Gestore");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JPanel controlPanel = new JPanel();
		controlPanel.setLayout(null);

		JPanel defaultPanel = new JPanel();
		defaultPanel.setBounds(10, 30, 800, 220);
		controlPanel.add(defaultPanel);

		JMenuBar opzioni = new JMenuBar();

		JMenu menuAggiungi = new JMenu("Aggiungi");

		JMenuItem insertMatch = new JMenuItem("Aggiungi Partite");
		insertMatch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				defaultPanel.removeAll();
				JPanel panel = insertMatch();
				panel.setBounds(0, 0, 780, 200);
				defaultPanel.add(panel);
				defaultPanel.repaint();
			}
		});
		menuAggiungi.add(insertMatch);

		JMenuItem addStadium = new JMenuItem("Aggiungi Stadio");
		addStadium.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				defaultPanel.removeAll();
				JPanel panel = addStadium();
				panel.setBounds(0 , 0, 780, 200);			
				defaultPanel.add(panel);
				defaultPanel.repaint();	
			}
		});
		menuAggiungi.add(addStadium);
		opzioni.add(menuAggiungi);

		JMenu menuModifica = new JMenu("Modifica");

		JMenuItem doPrice = new JMenuItem("Modifica prezzo partite");
		doPrice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				defaultPanel.removeAll();
				JPanel panel = doPrice();
				panel.setBounds(0, 0, 780, 200);			
				defaultPanel.add(panel);
				defaultPanel.repaint();
			}
		});
		menuModifica.add(doPrice);

		JMenuItem stadiumDimension = new JMenuItem("Modifica capienza stadio");
		stadiumDimension.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				defaultPanel.removeAll();
				JPanel panel = stadiumDimension();
				panel.setBounds(0, 0, 780, 200);
				defaultPanel.add(panel);
				defaultPanel.repaint();
			}
		});
		menuModifica.add(stadiumDimension);

		JMenuItem activeDiscount = new JMenuItem("Attiva sconti");
		activeDiscount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				defaultPanel.removeAll();
				JPanel panel = activeDiscount();
				panel.setBounds(0, 0, 780, 200);				
				defaultPanel.add(panel);
				defaultPanel.repaint();
			}
		});
		menuModifica.add(activeDiscount);		
		opzioni.add(menuModifica);

		JMenu menuVisualizza = new JMenu("Visualizza");

		JMenuItem viewerMatch = new JMenuItem("Visualizza partite");
		viewerMatch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				defaultPanel.removeAll();
				JPanel panel = viewerMatch();
				panel.setBounds(0, 0, 780, 200);				
				defaultPanel.add(panel);
				defaultPanel.repaint();
			}
		});
		menuVisualizza.add(viewerMatch);

		JMenuItem visualizzaIncasso = new JMenuItem("Visualizza incasso");
		visualizzaIncasso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				defaultPanel.removeAll();
				JPanel panel = visualizzaIncasso();
				panel.setBounds(0, 0, 780, 200);				
				defaultPanel.add(panel);
				defaultPanel.repaint();
			}
		});
		menuVisualizza.add(visualizzaIncasso);
		opzioni.add(menuVisualizza);

		frame.add(controlPanel);
		frame.add(opzioni,BorderLayout.NORTH);

	}
	/**Funzione visualizzaIncasso
	 * visualizza l'incasso di ogni stadio e la somma totale degli incassi della struttura
	 * restituisce un oggetto di tipo JPanel
	 * @return JControlPanel
	 */
	private JPanel visualizzaIncasso() {

		JPanel controlPanel = new JPanel();

		JComboBox<String> stadi = new JComboBox<String>();
		stadi.setBounds(210, 10, 150, 20);
		for(int i=0; i<s.getS().getStadi().size(); i++)
			stadi.addItem(s.getS().getStadi().get(i).getNomeStadio());
		controlPanel.add(stadi);

		JLabel labelVisualizzazione = new JLabel("Visualizza l incasso dello stadio : ");
		labelVisualizzazione.setBounds(10, 10, 190, 20);
		controlPanel.add(labelVisualizzazione);

		stadi.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				controlPanel.remove(label);
				label.setText(""+s.getS().getStadi().get(stadi.getSelectedIndex()).getCassa().getSaldo());
				label.setBounds(10, 40, 150, 20);
				controlPanel.add(label);
				controlPanel.repaint();
			}
		});

		JButton buttonVisualizzazioneTotale = new JButton("Visualizza l incasso totale della struttura");
		buttonVisualizzazioneTotale.setBounds(10, 80, 300, 20);
		buttonVisualizzazioneTotale.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {

				double incassoTotale=0;
				for(int i=0; i<s.getS().getStadi().size(); i++){
					incassoTotale = incassoTotale + s.getS().getStadi().get(i).getCassa().getSaldo();
				}

				JLabel labelVisualizzazioneTotale = new JLabel(""+incassoTotale);
				labelVisualizzazioneTotale.setBounds(10, 120, 200, 20);
				controlPanel.add(labelVisualizzazioneTotale);
				controlPanel.repaint();
			}
		});
		controlPanel.add(buttonVisualizzazioneTotale);


		return controlPanel;
	}

	private JPanel activeDiscount() {

		JPanel controlPanel = new JPanel();

		JLabel choosestadium = new JLabel("Seleziona stadio");
		choosestadium.setBounds(10, 10, 150, 20);
		controlPanel.add(choosestadium);

		JComboBox<String> stadi = new JComboBox<String>();
		stadi.setBounds(140, 10, 150, 20);
		for(int i=0; i<s.getS().getStadi().size(); i++)
			stadi.addItem(s.getS().getStadi().get(i).getNomeStadio());
		stadi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlPanel.remove(label);
				controlPanel.repaint();
			}
		});
		controlPanel.add(stadi);

		JButton scontoAnzianita = new JButton("Attiva sconto pensionati");
		scontoAnzianita.setBounds(10, 80, 170, 20);
		scontoAnzianita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!s.getS().getStadi().get(stadi.getSelectedIndex()).isSconto1()){
					s.getS().getStadi().get(stadi.getSelectedIndex()).setSconto1(true);
					try {
						s.salvaStruttura();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					controlPanel.remove(label);
					label.setText("Sconto aggiunto");
					label.setBounds(550, 80, 100, 20);
					controlPanel.add(label);
					controlPanel.repaint();
				}else{
					controlPanel.remove(label);
					label.setText("Gia Attivo");
					label.setBounds(550, 80, 100, 20);
					controlPanel.add(label);
					controlPanel.repaint();
				}
			}
		});
		controlPanel.add(scontoAnzianita);

		JLabel infoSconto1 = new JLabel("Sconto del 20% ai pensionati (+60 anni)");
		infoSconto1.setBounds(190, 80, 250, 20);
		controlPanel.add(infoSconto1);

		JButton scontoFasciaOraria = new JButton("Attiva sconto fascia oraria");
		scontoFasciaOraria.setBounds(10, 110, 170, 20);
		scontoFasciaOraria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!s.getS().getStadi().get(stadi.getSelectedIndex()).isSconto2()){
					s.getS().getStadi().get(stadi.getSelectedIndex()).setSconto2(true);
					try {
						s.salvaStruttura();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					controlPanel.remove(label);
					label.setText("Sconto aggiunto");
					label.setBounds(550, 110, 100, 20);
					controlPanel.add(label);
					controlPanel.repaint();
				}else{
					controlPanel.remove(label);
					label.setText("Gia Attivo");
					label.setBounds(550, 110, 100, 20);
					controlPanel.add(label);
					controlPanel.repaint();
				}
			}
		});
		controlPanel.add(scontoFasciaOraria);

		JLabel infoSconto2 = new JLabel("Sconto del 10% se la partita si gioca dalle 10 alle 12");
		infoSconto2.setBounds(190, 110, 450, 20);
		controlPanel.add(infoSconto2);

		JButton scontoLunedi = new JButton("Attiva sconto del lunedi");
		scontoLunedi.setBounds(10, 140, 170, 20);
		scontoLunedi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!s.getS().getStadi().get(stadi.getSelectedIndex()).isSconto3()){
					s.getS().getStadi().get(stadi.getSelectedIndex()).setSconto3(true);
					try {
						s.salvaStruttura();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					controlPanel.remove(label);
					label.setText("Sconto aggiunto");
					label.setBounds(550, 140, 100, 20);
					controlPanel.add(label);
					controlPanel.repaint();
				}else{
					controlPanel.remove(label);
					label.setText("Gia Attivo");
					label.setBounds(550, 140, 100, 20);
					controlPanel.add(label);
					controlPanel.repaint();
				}
			}
		});
		controlPanel.add(scontoLunedi);

		JLabel infoSconto3 = new JLabel("Sconto del 25% se la partita � di lunedi");
		infoSconto3.setBounds(190, 140, 450, 20);
		controlPanel.add(infoSconto3);

		JButton disattivaScontoAnzianita = new JButton("Disattiva");
		disattivaScontoAnzianita.setBounds(650, 80, 90, 20);
		disattivaScontoAnzianita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				if(s.getS().getStadi().get(stadi.getSelectedIndex()).isSconto1()){
					s.getS().getStadi().get(stadi.getSelectedIndex()).setSconto1(false);
					try {
						s.salvaStruttura();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					controlPanel.remove(label);
					label.setText("Sconto rimosso");
					label.setBounds(550, 80, 100, 20);
					controlPanel.add(label);
					controlPanel.repaint();
				}
				else{
					controlPanel.remove(label);
					label.setText("Non Attivo");
					label.setBounds(550, 80, 100, 20);
					controlPanel.add(label);
					controlPanel.repaint();
				}
			}
		});
		controlPanel.add(disattivaScontoAnzianita);

		JButton disattivaScontoFasciaOraria = new JButton("Disattiva");
		disattivaScontoFasciaOraria.setBounds(650, 110, 90, 20);
		disattivaScontoFasciaOraria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(s.getS().getStadi().get(stadi.getSelectedIndex()).isSconto2()){
					s.getS().getStadi().get(stadi.getSelectedIndex()).setSconto2(false);
					try {
						s.salvaStruttura();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					controlPanel.remove(label);
					label.setText("Sconto rimosso");
					label.setBounds(550, 110, 100, 20);
					controlPanel.add(label);
					controlPanel.repaint();
				}else{
					controlPanel.remove(label);
					label.setText("Non Attivo");
					label.setBounds(550, 110, 100, 20);
					controlPanel.add(label);
					controlPanel.repaint();
				}
			}
		});
		controlPanel.add(disattivaScontoFasciaOraria);

		JButton disattivaScontoLunedi = new JButton("Disattiva");
		disattivaScontoLunedi.setBounds(650, 140, 90, 20);
		disattivaScontoLunedi.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {				

				if(s.getS().getStadi().get(stadi.getSelectedIndex()).isSconto3()){
					s.getS().getStadi().get(stadi.getSelectedIndex()).setSconto3(false);
					try {
						s.salvaStruttura();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					controlPanel.remove(label);
					label.setText("Sconto rimosso");
					label.setBounds(550, 140, 100, 20);
					controlPanel.add(label);
					controlPanel.repaint();
				}else{
					controlPanel.remove(label);
					label.setText("Non Attivo");
					label.setBounds(550, 140, 100, 20);
					controlPanel.add(label);
					controlPanel.repaint();
				}
			}
		});
		controlPanel.add(disattivaScontoLunedi);

		return controlPanel;
	}

	private JPanel viewerMatch() { 

		JPanel controlPanel = new JPanel();

		JLabel choosestadium = new JLabel("Visualizza partite :");
		choosestadium.setBounds(10, 10, 150, 20);
		controlPanel.add(choosestadium);

		JLabel labelDimStadio = new JLabel("In base alla capienza dello stadio");
		labelDimStadio.setBounds(10, 40, 250, 20);
		controlPanel.add(labelDimStadio);

		JLabel labelCronologico = new JLabel("In ordine cronologico");
		labelCronologico.setBounds(10, 70, 150, 20);
		controlPanel.add(labelCronologico);

		JRadioButton dimStadio = new JRadioButton();
		dimStadio.setBounds(260, 45, 20, 15);

		controlPanel.add(dimStadio);

		JRadioButton cronologico = new JRadioButton();
		cronologico.setBounds(260, 75, 20, 15);
		controlPanel.add(cronologico);

		JRadioButton defaultButton = new JRadioButton();
		defaultButton.setSelected(true);

		ButtonGroup group = new ButtonGroup();
		group.add(defaultButton);
		group.add(cronologico);
		group.add(dimStadio);

		JButton visualizza = new JButton("Visualizza");
		visualizza.setBounds(200, 120, 100, 20);
		visualizza.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				controlPanel.remove(bar);
				controlPanel.repaint();

				ArrayList<Partita> allMatchAllStadium = new ArrayList<Partita>();

				for(int i=0; i<s.getS().getStadi().size(); i++){
					for(int j=0; j<s.getS().getStadi().get(i).getPartite().size(); j++){
						allMatchAllStadium.add(s.getS().getStadi().get(i).getPartite().get(j));
					}
				}

				if(cronologico.isSelected()){
					allMatchAllStadium.sort(new OrdineCronologico());
					JTextArea area = new JTextArea();
					area.setBounds(0, 0, 100, 100);
					area.setEditable(false);

					for(int j=0; j<allMatchAllStadium.size(); j++)
						area.append(allMatchAllStadium.get(j).getPartita() +" - "+ allMatchAllStadium.get(j).getStadio().getNomeStadio()+"\n");

					bar = new JScrollPane(area);
					bar.setBounds(350, 0, 350, 200);
					controlPanel.add(bar);
				}

				if(dimStadio.isSelected()){

					ArrayList<Integer> AllStadiumCapienza = new ArrayList<Integer>();
					ArrayList<Stadio> AllStadium = new ArrayList<Stadio>();


					for(int i=0; i<s.getS().getStadi().size(); i++){
						AllStadiumCapienza.add(s.getS().getStadi().get(i).getCapienza());
						AllStadium.add(s.getS().getStadi().get(i));
					}

					AllStadiumCapienza.sort(new OrdineCrescente());

					JTextArea area = new JTextArea();
					area.setBounds(0, 0, 100, 100);
					area.setEditable(false);

					for(int i=0; i<AllStadiumCapienza.size(); i++){
						int tempCap = AllStadiumCapienza.get(i);
						for(int j=0; j<AllStadium.size(); ){
							if(AllStadium.get(j).getCapienza() == tempCap){
								for(int f=0; f<AllStadium.get(j).getPartite().size(); f++)
									area.append(AllStadium.get(j).getPartite().get(f).getPartita()+" - "+ AllStadium.get(j).getNomeStadio()+"\n");
								AllStadium.remove(j);
								j=0;
							}else{
								j++;
							}
						}
					}
					bar = new JScrollPane(area);
					bar.setBounds(350, 0, 350, 200);
					controlPanel.add(bar);
				}
			}
		});

		controlPanel.add(visualizza);

		return controlPanel;
	}

	private JPanel addStadium() {

		JPanel controlPanel = new JPanel();

		JLabel insertNameStadium = new JLabel("Inserisci nome stadio");
		insertNameStadium.setBounds(10, 10, 150, 20);
		controlPanel.add(insertNameStadium);

		JTextField nameStadium = new JTextField();
		nameStadium.setBounds(160, 10, 100, 20);
		controlPanel.add(nameStadium);

		JButton addStadium = new JButton("Aggiungi stadio");
		addStadium.setBounds(140, 120, 130, 20);
		addStadium.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if(!nameStadium.getText().isEmpty()){	
					Stadio stadium = new Stadio(nameStadium.getText());
					s.getS().getStadi().add(stadium);
					try {
						s.salvaStruttura();
					} catch (IOException e1) {

						e1.printStackTrace();
					}

					controlPanel.remove(label);
					label.setText("Stadio inserito");
					label.setBounds(200, 80, 150, 20);
					controlPanel.add(label);
					controlPanel.repaint();
					nameStadium.setText(null);						

				}else {

					controlPanel.remove(label);
					label.setText("Stadio non inserito");
					label.setBounds(200, 80, 150, 20);
					controlPanel.add(label);
					controlPanel.repaint();
				}
			}
		});

		controlPanel.add(addStadium);

		return controlPanel;
	}
	/** Funzione stadiumDimension
	 * , gestisce la capienza dello stadio
	 * @return
	 */
	private JPanel stadiumDimension(){

		JPanel controlPanel = new JPanel();

		JLabel labelStadi = new JLabel("Seleziona stadio");
		labelStadi.setBounds(10, 10, 150, 20);
		controlPanel.add(labelStadi);

		JComboBox<String> stadi = new JComboBox<String>();
		stadi.setBounds(200, 10, 150, 20);
		for(int i=0; i<s.getS().getStadi().size(); i++)
			stadi.addItem(s.getS().getStadi().get(i).getNomeStadio());
		controlPanel.add(stadi);

		JLabel labelCapienza = new JLabel("Rendi indisponibile");
		labelCapienza.setBounds(10, 60, 150, 20);
		controlPanel.add(labelCapienza);

		JTextField capienza = new JTextField();
		capienza.setDocument(new JTextFieldLimit(3));
		capienza.setBounds(320, 60, 30, 20);
		controlPanel.add(capienza);

		JButton modificaCapienza = new JButton("Modifica capienza");
		modificaCapienza.setBounds(200, 120, 140, 20);
		controlPanel.add(modificaCapienza);

		ActionListener listener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try{
					s.getS().getStadi().get(stadi.getSelectedIndex()).setCapienza(Integer.parseInt(capienza.getText()));
					if(Integer.parseInt(capienza.getText()) > 260){
						controlPanel.remove(label);
						label.setText("Superato il limite massimo, max 260");
						label.setBounds(200, 80, 250, 20);
						controlPanel.add(label);
						controlPanel.repaint();
					}else{
						controlPanel.remove(label);
						controlPanel.repaint();

						try {
							s.salvaStruttura();
						} catch (IOException e1) {

							e1.printStackTrace();
						}
					}
				}catch(NumberFormatException eccezione){
					controlPanel.remove(label);
					label.setText("Valore non valido");
					label.setBounds(200, 80, 150, 20);
					controlPanel.add(label);
					controlPanel.repaint();
				}
			}
		};

		modificaCapienza.addActionListener(listener);


		return controlPanel;
	}
	/**Funzione doPrice
	 * , crea un pannello di assegnazione di un determinato prezzo alle partite
	 * @return
	 */
	private JPanel doPrice() {

		JPanel controlPanel = new JPanel();
		controlPanel.setLayout(null);

		JLabel choosestadium = new JLabel("Seleziona stadio");
		choosestadium.setBounds(10, 10, 150, 20);
		controlPanel.add(choosestadium);

		JLabel chooseMatch = new JLabel("Seleziona partita");
		chooseMatch.setBounds(10, 40, 150, 20);
		controlPanel.add(chooseMatch);

		String defaultComboBoxItem = "Stadi";
		JComboBox<String> stadi = new JComboBox<String>();
		stadi.addItem(defaultComboBoxItem);
		stadi.setBounds(140, 10, 150, 20);
		for(int i=0; i<s.getS().getStadi().size(); i++)
			stadi.addItem(s.getS().getStadi().get(i).getNomeStadio());
		stadi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(!stadi.getSelectedItem().equals(defaultComboBoxItem)){
					indiceStadio = stadi.getSelectedIndex()-1;
					controlPanel.remove(partite);
					partite.removeAllItems();
					partite.setBounds(140, 40, 150, 20);
					for(int i=0; i<s.getS().getStadi().get(indiceStadio).getPartite().size(); i++){
						GregorianCalendar c = new GregorianCalendar();
						if(s.getS().getStadi().get(indiceStadio).getPartite().get(i).getData().getTimeInMillis() > c.getTimeInMillis()){
							partite.addItem(s.getS().getStadi().get(indiceStadio).getPartite().get(i).getPartita());
						}			
					}
					controlPanel.add(partite);
				}else{
					controlPanel.remove(partite);
					partite.removeAllItems();
				}
			}
		});
		controlPanel.add(stadi);

		JLabel insertPrice = new JLabel("Inserisci prezzo");
		insertPrice.setBounds(10, 80, 150, 20);
		controlPanel.add(insertPrice);

		JTextField price = new JTextField();
		price.setBounds(140, 80, 30, 20);
		price.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		price.setDocument(new JTextFieldLimit(3));
		controlPanel.add(price);

		JButton setPrice = new JButton("Assegna prezzo");
		setPrice.setBounds(140, 120, 130, 20);
		setPrice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(!price.getText().isEmpty() && !stadi.getSelectedItem().equals(defaultComboBoxItem)){		
					try{		
						int	p = Integer.parseInt(price.getText());

						for(int i=0; i<s.getS().getStadi().get(indiceStadio).getPartite().size(); i++){
							if(s.getS().getStadi().get(indiceStadio).getPartite().get(i).getPartita().equals(partite.getSelectedItem())){
								s.getS().getStadi().get(indiceStadio).getPartite().get(i).setPrezzo(p);
								controlPanel.remove(label);
								label.setText("Prezzo inserito");
								label.setBounds(200, 80, 150, 20);
								controlPanel.add(label);
								controlPanel.repaint();
								try {
									s.salvaStruttura();
								} catch (IOException e1) {
									e1.printStackTrace();
								}
								price.setText(null);	
							}
						}
					}catch(NumberFormatException eccezione){
						controlPanel.remove(label);
						label.setText("Prezzo non valido");
						label.setBounds(200, 80, 150, 20);
						controlPanel.add(label);
						controlPanel.repaint();
					}
				}else{
					controlPanel.remove(label);
					label.setText("Prezzo non modificato");
					label.setBounds(200, 80, 150, 20);
					controlPanel.add(label);
					controlPanel.repaint();
				}
			}
		});
		controlPanel.add(setPrice);

		JLabel euro = new JLabel("�");
		euro.setBounds(170, 80, 150, 20);
		controlPanel.add(euro);

		return controlPanel;
	}
	/**Funzione insertMatch
	 * ,crea un pannello che permettere la creazione di una nuova partita,
	 * mediante inserimento delle due squadre, dello stadio in cui verr� disputata tale partita, della data e del prezzo
	 * @return
	 */
	private JPanel insertMatch()  {

		JPanel controlPanel = new JPanel();
		controlPanel.setLayout(null);

		JLabel primaSquadra = new JLabel("Inserisci squadra 1");
		primaSquadra.setBounds(10, 10, 150, 20);
		controlPanel.add(primaSquadra);

		JLabel secondaSquadra = new JLabel("Inserisci squadra 2");
		secondaSquadra.setBounds(10, 40, 150, 20);
		controlPanel.add(secondaSquadra);

		JTextField inPrimaSquadra = new JTextField();
		inPrimaSquadra.setBounds(170, 10, 80, 20);
		controlPanel.add(inPrimaSquadra);

		JTextField inSecondaSquadra = new JTextField();
		inSecondaSquadra.setBounds(170, 40, 80, 20);
		controlPanel.add(inSecondaSquadra);	

		JLabel scegliStadio = new JLabel("Stadio in cui si disputa");
		scegliStadio.setBounds(10, 70, 150, 20);
		controlPanel.add(scegliStadio);

		JComboBox<String> stadi = new JComboBox<String>();
		stadi.setBounds(170, 70, 150, 20);
		for(int i=0; i<s.getS().getStadi().size(); i++){
			stadi.addItem(s.getS().getStadi().get(i).getNomeStadio());
		}
		controlPanel.add(stadi);

		JLabel data = new JLabel("Inserisci data");
		data.setBounds(10, 110, 120, 20);
		controlPanel.add(data);

		JTextField giorno = new JTextField();
		giorno.setDocument(new JTextFieldLimit(2));
		giorno.setBounds(170, 110, 20, 20);
		controlPanel.add(giorno);

		JTextField mese = new JTextField();
		mese.setDocument(new JTextFieldLimit(2));
		mese.setBounds(195, 110, 20, 20);
		controlPanel.add(mese);

		JTextField anno = new JTextField();
		anno.setDocument(new JTextFieldLimit(4));
		anno.setBounds(220, 110, 35, 20);
		controlPanel.add(anno);

		int x = 190;
		for(int i=0; i<2;  i++){
			JLabel slash = new JLabel("/");
			slash.setBounds(x, 110, 20, 20);
			x = x +25;
			controlPanel.add(slash);
		}

		JLabel orario = new JLabel("Inserisci ora");
		orario.setBounds(10, 140, 100, 20);
		controlPanel.add(orario);

		JTextField ore = new JTextField();
		ore.setDocument(new JTextFieldLimit(2));
		ore.setBounds(170, 140, 20, 20);
		controlPanel.add(ore);

		JLabel duePunti = new JLabel(":");
		duePunti.setBounds(190, 140, 20, 20);
		controlPanel.add(duePunti);

		JTextField minuti = new JTextField();
		minuti.setDocument(new JTextFieldLimit(2));
		minuti.setBounds(195, 140, 20, 20);
		controlPanel.add(minuti);

		JLabel prezzo = new JLabel("Prezzo");
		prezzo.setBounds(10, 170, 50, 20);
		controlPanel.add(prezzo);

		JTextField price = new JTextField();
		price.setBounds(70, 170, 30, 20);
		price.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		price.setDocument(new JTextFieldLimit(3));
		controlPanel.add(price);

		JLabel euro = new JLabel("�");
		euro.setBounds(100, 170, 30, 20);
		controlPanel.add(euro);

		JButton inserisciPartita = new JButton("Aggiungi Partita");
		inserisciPartita.setBounds(170, 170, 130, 20);
		inserisciPartita.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				SimpleDateFormat sdf = new SimpleDateFormat("EEE dd/MMM/yyyy HH:mm");

				if( !anno.getText().isEmpty() && !mese.getText().isEmpty() && !giorno.getText().isEmpty() && !ore.getText().isEmpty()
						&& !minuti.getText().isEmpty() && !price.getText().isEmpty()&& 
						!inPrimaSquadra.getText().isEmpty() && !inSecondaSquadra.getText().isEmpty())
				{
					try{

						GregorianCalendar g = new GregorianCalendar(Integer.parseInt(anno.getText()), 
								Integer.parseInt(mese.getText())-1, Integer.parseInt(giorno.getText()),
								Integer.parseInt(ore.getText()), Integer.parseInt(minuti.getText()) ,0);

						String primaSquadra = inPrimaSquadra.getText();
						String secondaSquadra = inSecondaSquadra.getText();
						String data = sdf.format(g.getTime());
						int prezzo = Integer.parseInt(price.getText());

						for(int i=0; i<s.getS().getStadi().size(); i++)
						{
							if(s.getS().getStadi().get(i).getNomeStadio().equals(stadi.getSelectedItem()))

							{
								controlPanel.remove(label);
								label.setText("Partita aggiunta");
								label.setBounds(260, 110, 220, 20);
								controlPanel.add(label);
								controlPanel.repaint();
								s.getS().getStadi().get(i).addPartita(new Partita(primaSquadra, secondaSquadra, 
										data,prezzo,s.getS().getStadi().get(i)));
								try {
									s.salvaStruttura();
								} 
								catch (IOException e1) {
									e1.printStackTrace();
								}
								inPrimaSquadra.setText(null);
								inSecondaSquadra.setText(null);
								giorno.setText(null);
								mese.setText(null);
								anno.setText(null);
								price.setText(null);
								ore.setText(null);
								minuti.setText(null);
							}
						}
					}
					catch(NumberFormatException f){
						controlPanel.remove(label);
						label.setText("Valore non valido, Partita non aggiunta");
						label.setBounds(260, 110, 220, 20);
						controlPanel.add(label);
						controlPanel.repaint();
					}

				}else{
					controlPanel.remove(label);
					label.setText("Partita non aggiunta");
					label.setBounds(260, 110, 220, 20);
					controlPanel.add(label);
					controlPanel.repaint();
				}
			}
		});
		controlPanel.add(inserisciPartita);

		return controlPanel;
	}

	JScrollPane bar  = new JScrollPane();
	JLabel label = new JLabel();
	JComboBox<String> partite =  new JComboBox<String>();
}
package grafica;

import calendario.Calendario;
import ordinamento.OrdineCronologico;
import ordinamento.OrdineLessicografico;
import sistema.FileManager;
import strutturaStadio.Partita;
import utente.Cliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EtchedBorder;

/**Classe che definisce <i>FrameHomeCliente</i>
 * , un frameHomeCliente ha un cliente(Cliente), un oggetto s(FileManager), un flag(boolean), filtra(JButton), e stadi(JComboBox)
 * 
 *
 */
public class FrameHomeCliente{

	private JComboBox<String> stadi;
	private JButton filtra;
	private boolean flag;
	private Cliente cliente;
	private FileManager s;

	/**Costruttore di FrameHomeCliente
	 * 
	 * @param s definisce il FileManager
	 * @param c definisce il Cliente cui l'interfaccia far� riferimento
	 */
	public FrameHomeCliente(FileManager s,Cliente c){

		this.s=s;
		this.cliente=c;
		stadi = new JComboBox<String>();
		stadi.setBounds(160, 120, 150, 30);
		for(int i=0; i<s.getS().getStadi().size(); i++)
			stadi.addItem(s.getS().getStadi().get(i).getNomeStadio());
		stadi.setEditable(false);
		filtra = new JButton("Filtra");
	}
	
	/** Funzione creaHome
	 * , crea l'interfaccia grafica di accesso per il cliente e delle operazioni che pu� effettuare
	 * @throws ParseException
	 */
	public void creaHome() throws ParseException{

		JFrame frame = new JFrame();
		frame.setSize(1300, 700);
		frame.setTitle("Benvenuto "+cliente.getId());
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);//posiziono il frame al centro del monitor
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JPanel controlPanel = new JPanel();
		controlPanel.setLayout(null);

		JPanel allMatch = allMatch();
		allMatch.setBounds(10, 10, 180, 650);
		controlPanel.add(allMatch);

		JPanel programMatch = programMatch();
		programMatch.setBounds(190, 10, 735, 650);
		controlPanel.add(programMatch);

		JPanel viewerMatch = viewerMatch();
		viewerMatch.setBounds(925, 10, 350, 650);
		controlPanel.add(viewerMatch);

		frame.add(controlPanel);
	}
	/** Funzione viewerMatch
	 * restituisce un pannello di visualizzazione delle
	 * prenotazioni e degli acquisti effettuati dagli utenti
	 * 
	 * @return controlPanel(JPanel)
	 */
	private JPanel viewerMatch() {

		JPanel controlPanel = new JPanel();
		controlPanel.setBorder(new EtchedBorder());
		controlPanel.setLayout(null);

		JLabel label = new JLabel("Visualizza :");		
		label.setBounds(10, 10, 100, 30);
		controlPanel.add(label);

		JPanel showPanel = new JPanel();
		showPanel.setBounds(10, 50, 330, 590);
		showPanel.setBorder(new EtchedBorder());
		controlPanel.add(showPanel);

		JButton viewerPrenotazione = new JButton("Prenotazioni");
		viewerPrenotazione.setBounds(90, 10, 120, 30);
		viewerPrenotazione.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				showPanel.removeAll();

				int y=0;
				int y1=15;

				for(int i=0; i<cliente.getPrenotazioni().size(); i++){

					JButton button = new JButton((String)cliente.getPrenotazioni().get(i).getPartita());
					JLabel label= new JLabel(cliente.getPrenotazioni().get(i).getIdPosto());

					button.setName("" + i);
					button.setBounds(10, y, 300, 30);
					label.setBounds(125, y1, 300, 30);
					button.setBorderPainted(false);
					button.setContentAreaFilled(false);
					y = y + 35;
					y1=y1 + 35;
					showPanel.add(button);
					showPanel.add(label);

					button.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {

							JFrame frameMenuPrenotazione = new JFrame("Men� prenotazione");
							frameMenuPrenotazione.setSize(500, 250);
							frameMenuPrenotazione.setLayout(null);
							frameMenuPrenotazione.setVisible(true);
							frameMenuPrenotazione.setLocationRelativeTo(null);
							frameMenuPrenotazione.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

							JLabel info= new JLabel(cliente.getPrenotazioni()
									.get(Integer.parseInt(button.getName())).getPartita());
							info.setBounds(120, 40, 400, 20);
							frameMenuPrenotazione.add(info);

							JLabel info2= new JLabel(cliente.getPrenotazioni().get(Integer.parseInt(button.getName()))
									.getIdPosto());
							info2.setBounds(200, 70, 400, 20);
							frameMenuPrenotazione.add(info2);

							JLabel info3= new JLabel("Prezzo : "  +
									cliente.getPrenotazioni().get(Integer.parseInt(button.getName())).getPrezzo() +"�");
							info3.setBounds(200, 100, 400, 20);
							frameMenuPrenotazione.add(info3);

							JButton acquista = new JButton("Acquista");
							acquista.setName(button.getName());
							acquista.setBounds(50, 150, 100, 30);
							frameMenuPrenotazione.add(acquista);

							acquista.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {

									s.getS().getStadi().get(stadi.getSelectedIndex()).getCassa().
										setSaldo(cliente.getPrenotazioni().get(Integer.parseInt(button.getName())).getPrezzo());
									
									showPanel.removeAll();

									for(int i=0;i<s.getS().getStadi().size();i++){
										if(s.getS().getStadi().get(i).getNomeStadio().equals(cliente.getPrenotazioni().get(Integer.parseInt(acquista.getName())).getStadio().getNomeStadio()))
											for(int j=0;j<s.getS().getStadi().get(i).getPartite().size();j++){
												if(s.getS().getStadi().get(i).getPartite().get(j).getPartitaComplet().equals(cliente.getPrenotazioni().get(Integer.parseInt(acquista.getName())).getPartita()))
													for(int k=0;k<s.getS().getStadi().get(i).getPartite().get(j).getTribune().size();k++)
														for(int l=0;l<s.getS().getStadi().get(i).getPartite().get(j).getTribune().get(k).getArray().size();l++)
															if(s.getS().getStadi().get(i).getPartite().get(j).getTribune().get(k).getArray().get(l).getId()
																	.equals(cliente.getPrenotazioni().get(Integer.parseInt(acquista.getName())).getIdPosto()))
																s.getS().getStadi().get(i).getPartite().get(j).getTribune().get(k).getArray().get(l).setStato(0);
											}
									}

									cliente.getAcquisti().add(cliente.getPrenotazioni().get(Integer.parseInt(acquista.getName())));
									cliente.getPrenotazioni().remove(Integer.parseInt(acquista.getName()));
									
									try {
										s.salvaStruttura();
									} catch (IOException e1) {
										e1.printStackTrace();
									}

									frameMenuPrenotazione.setVisible(false);

								}
							});

							JButton cancella = new JButton("Cancella");
							cancella.setName(button.getName());
							cancella.setBounds(193, 153, 100, 27);

							cancella.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {

									showPanel.removeAll();

									for(int i=0;i<s.getS().getStadi().size();i++){
										if(s.getS().getStadi().get(i).getNomeStadio().equals(cliente.getPrenotazioni().get(Integer.parseInt(cancella.getName())).getStadio().getNomeStadio()))
											for(int j=0;j<s.getS().getStadi().get(i).getPartite().size();j++){
												if(s.getS().getStadi().get(i).getPartite().get(j).getPartitaComplet().equals(cliente.getPrenotazioni().get(Integer.parseInt(cancella.getName())).getPartita()))
													for(int k=0;k<s.getS().getStadi().get(i).getPartite().get(j).getTribune().size();k++)
														for(int l=0;l<s.getS().getStadi().get(i).getPartite().get(j).getTribune().get(k).getArray().size();l++)
															if(s.getS().getStadi().get(i).getPartite().get(j).getTribune().get(k).getArray().get(l).getId()
																	.equals(cliente.getPrenotazioni().get(Integer.parseInt(cancella.getName())).getIdPosto()))
																s.getS().getStadi().get(i).getPartite().get(j).getTribune().get(k).getArray().get(l).setStato(0);
											}
									}

									cliente.getPrenotazioni().remove(Integer.parseInt(cancella.getName()));


									try {
										s.salvaStruttura();
									} catch (IOException e1) {
										e1.printStackTrace();
									}
									frameMenuPrenotazione.setVisible(false);
								}
							});							
							frameMenuPrenotazione.add(cancella);

							JButton annulla = new JButton("Annulla");
							annulla.setBounds(333, 153, 100, 27);
							annulla.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									frameMenuPrenotazione.setVisible(false);
								}
							});
							frameMenuPrenotazione.add(annulla);
						}
					});
				}

				y=15;
				showPanel.repaint();

			}
		});
		controlPanel.add(viewerPrenotazione);

		JButton viewerAcquisti = new JButton("Acquisti");
		viewerAcquisti.setBounds(220, 10, 120, 30);
		viewerAcquisti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showPanel.removeAll();
				int y=0;
				int y1=15;

				for(int i=0; i<cliente.getAcquisti().size(); i++){

					JButton button = new JButton((String)cliente.getAcquisti().get(i).getPartita());
					JLabel label= new JLabel(cliente.getAcquisti().get(i).getIdPosto());

					button.setName("" + i);
					button.setBounds(10, y, 300, 30);
					label.setBounds(125, y1, 300, 30);
					button.setBorderPainted(false);
					button.setContentAreaFilled(false);
					y = y + 35;
					y1=y1 + 35;
					showPanel.add(button);
					showPanel.add(label);
				}
				showPanel.repaint();
			}
		});

		controlPanel.add(viewerAcquisti);
		return controlPanel;
	}
	
	/**Funzione allMatch
	 * , restituisce un pannello di visualizzazione di tutte le partite contenute nello stadio selezionato
	 * @return controlPanel(JPanel)
	 */
	private JPanel allMatch() {

		JPanel controlPanel = new JPanel();
		controlPanel.setBorder(new EtchedBorder());
		controlPanel.setLayout(null);

		JLabel label = new JLabel("Tutte le partite");		
		label.setBounds(10, 0, 100, 30);
		controlPanel.add(label);

		JPanel firstPanel = new JPanel();
		firstPanel.setBounds(10, 30, 160, 610);
		firstPanel.setBorder(new EtchedBorder());		

		filtra.addActionListener(new  ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstPanel.removeAll();
				int x=5,y=0;
				for(int j=0; j<s.getS().getStadi().size(); j++){
					if(stadi.getSelectedItem().equals(s.getS().getStadi().get(j).getNomeStadio()))
						for(int i=0; i<s.getS().getStadi().get(j).getPartite().size(); i++){
							JLabel labalPartite = new JLabel(s.getS().getStadi().get(j).getPartite().get(i).getPartita());
							labalPartite.setBounds(x, y, 160, 30);
							y = y + 20;
							firstPanel.repaint();
							firstPanel.add(labalPartite);
						}
				}
			}
		});

		controlPanel.add(firstPanel);
		return controlPanel;
	}
	
	/**Funzione programMatch
	 * restituisce un pannello di visualizzazione della programmazione in ordine lessicografico o cronologico
	 * @return controlPanel(JPanel)
	 * @throws ParseException
	 */
	private JPanel programMatch() throws ParseException {//si occupa del calcolo

		JPanel controlPanel = new JPanel();
		controlPanel.setBorder(new EtchedBorder());
		controlPanel.setLayout(null);

		JLabel label = new JLabel("Programmazione completa dello stadio");
		label.setBounds(10, 0, 300, 30);
		controlPanel.add(label);

		JPanel firstPanel = new JPanel();
		firstPanel.setBounds(10, 30, 385, 610);
		firstPanel.setBorder(new EtchedBorder());

		JLabel labelOrdinamento = new JLabel("Ordina partite in ordine : ");
		labelOrdinamento.setBounds(405, 0, 300, 30);
		controlPanel.add(labelOrdinamento);

		JPanel secondPanel = new JPanel();
		secondPanel.setLayout(null);
		secondPanel.setBounds(405, 30, 320, 610);
		secondPanel.setBorder(new EtchedBorder());

		JLabel secondLabel = new JLabel("Cronologico");
		secondLabel.setBounds(10, 40, 250, 30);
		secondPanel.add(secondLabel);

		JLabel thirdLabel = new JLabel("Lessicografico");
		thirdLabel.setBounds(10, 80, 250, 30);
		secondPanel.add(thirdLabel);

		JRadioButton cronologico = new JRadioButton();//radio button 2
		cronologico.setBounds(280, 50, 20, 15);
		secondPanel.add(cronologico);

		JRadioButton lessicografico = new JRadioButton();//radio button 3
		lessicografico.setBounds(280, 90, 20, 15);
		secondPanel.add(lessicografico);

		ButtonGroup group = new ButtonGroup();//inserisco i radio button in un group
		JRadioButton buttonDefault = new JRadioButton(); 
		group.add(cronologico);
		group.add(lessicografico);
		group.add(buttonDefault);
		buttonDefault.setSelected(true);//setto il rbutton di default come selezionato

		JLabel forthLabel = new JLabel("Scegli stadio");
		forthLabel.setBounds(10, 120, 100, 30);
		secondPanel.add(forthLabel);

		secondPanel.add(stadi);//aggiungo la combobox al pannello

		flag = false;
		JButton reset = new JButton("Reset");
		reset.setBounds(150, 160, 70, 25);
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstPanel.removeAll();
				int x=0,y=0;
				for(int j=0; j<s.getS().getStadi().size(); j++)
					if(stadi.getSelectedItem().equals(s.getS().getStadi().get(j).getNomeStadio()) && flag != false)
						for(int i=0; i<s.getS().getStadi().get(j).getPartite().size(); i++){	
							GregorianCalendar c = new GregorianCalendar();
							if(s.getS().getStadi().get(j).getPartite().get(i).getData().getTimeInMillis() > c.getTimeInMillis()){
								JButton button = new JButton(s.getS().getStadi().get(j).getPartite().get(i).getPartita()+" "
										+ s.getS().getStadi().get(j).getPartite().get(i).getParsedData());
								button.setBounds(x, y, 300, 30);
								JLabel label = new JLabel(String.valueOf(s.getS().getStadi().get(j).getPartite().get(i).getPrezzo())+" Euro");
								label.setBounds(x+300, y, 100, 30);

								y = y + 20;

								ActionListener action=new ActionListener() {
									public void actionPerformed(ActionEvent arg0) {

										FrameHomePrenotazione p = new FrameHomePrenotazione();
										p.FramePrenotazioneAla(s, cliente, stadi.getSelectedIndex(),button.getText());
									}
								};
								button.addActionListener(action);

								button.setBorderPainted(false);
								button.setContentAreaFilled(false);
								firstPanel.add(button);
								firstPanel.add(label);
							}
						}	
				firstPanel.repaint();
			}
		});
		secondPanel.add(reset);

		filtra.setBounds(240, 160, 70, 25);

		filtra.addActionListener(new ActionListener() {
			int mn;
			public void actionPerformed(ActionEvent e) {	
				flag = true;
				ArrayList<Partita> tempMatch = new ArrayList<Partita>();
				for(int j=0; j<s.getS().getStadi().size(); j++){
					if(stadi.getSelectedItem().equals(s.getS().getStadi().get(j).getNomeStadio()))
						for(int i=0; i<s.getS().getStadi().get(j).getPartite().size(); i++){	
							GregorianCalendar c = new GregorianCalendar();
							if(s.getS().getStadi().get(j).getPartite().get(i).getData().getTimeInMillis() > c.getTimeInMillis()){
								tempMatch.add(s.getS().getStadi().get(j).getPartite().get(i));
							}
						}			
				}
				firstPanel.removeAll();
				int x=0,y=0;

				if(tempMatch.isEmpty()){
					JLabel label2 = new JLabel("Nessuna partita in programma");
					label2.setBounds(10, 0, 300, 30);
					firstPanel.add(label2);
					firstPanel.repaint();
				}

				for(mn=0; mn<tempMatch.size(); mn++){
					JButton button = new JButton(tempMatch.get(mn).getPartita()+" "+ tempMatch.get(mn).getParsedData());
					JLabel label = new JLabel(String.valueOf(tempMatch.get(mn).getPrezzo())+" Euro");
					label.setBounds(x+300, y, 100, 30);
					button.setName(""+mn);
					button.setBounds(x, y, 300, 30);

					ActionListener action=new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {

							FrameHomePrenotazione p = new FrameHomePrenotazione();
							p.FramePrenotazioneAla(s, cliente, stadi.getSelectedIndex(),button.getText());
						}
					};

					button.addActionListener(action);

					y = y + 20;
					button.setBorderPainted(false);
					button.setContentAreaFilled(false);
					firstPanel.repaint();
					firstPanel.add(label);
					firstPanel.add(button);
				}

				if(cronologico.isSelected()){
					x=0; y=0;

					tempMatch.sort(new OrdineCronologico());
					firstPanel.removeAll();

					if(tempMatch.isEmpty()){
						JLabel label2 = new JLabel("Nessuna partita in programma");
						label2.setBounds(10, 0, 300, 30);
						firstPanel.add(label2);
						firstPanel.repaint();
					}

					for(int i=0; i<tempMatch.size(); i++){
						JButton button = new JButton(tempMatch.get(i).getPartita()+" "+ tempMatch.get(i).getParsedData());
						button.setBounds(x, y, 300, 30);
						JLabel label = new JLabel(String.valueOf(tempMatch.get(i).getPrezzo())+" Euro");
						label.setBounds(x+300, y, 100, 30);
						y = y + 20;

						ActionListener action=new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {

								FrameHomePrenotazione p = new FrameHomePrenotazione();
								p.FramePrenotazioneAla(s, cliente, stadi.getSelectedIndex(),button.getText());
							}
						};

						button.addActionListener(action);

						button.setBorderPainted(false);
						button.setContentAreaFilled(false);
						firstPanel.repaint();
						firstPanel.add(button);
						firstPanel.add(label);
					}
				}

				if(lessicografico.isSelected()){
					x=0; y=0;

					tempMatch.sort(new OrdineLessicografico());
					firstPanel.removeAll();

					if(tempMatch.isEmpty()){
						JLabel label2 = new JLabel("Nessuna partita in programma");
						label2.setBounds(10, 0, 300, 30);
						firstPanel.add(label2);
						firstPanel.repaint();
					}

					for(int i=0; i<tempMatch.size(); i++){
						JButton button = new JButton(tempMatch.get(i).getPartita()+" "+ tempMatch.get(i).getParsedData());
						button.setBounds(x, y, 300, 30);
						JLabel label = new JLabel(String.valueOf(tempMatch.get(i).getPrezzo())+" Euro");
						label.setBounds(x+300, y, 100, 30);
						y = y + 20;

						ActionListener action=new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {

								FrameHomePrenotazione p = new FrameHomePrenotazione();
								p.FramePrenotazioneAla(s, cliente, stadi.getSelectedIndex(),button.getText());
							}
						};

						button.addActionListener(action);

						button.setBorderPainted(false);
						button.setContentAreaFilled(false);
						firstPanel.repaint();
						firstPanel.add(button);
						firstPanel.add(label);
					}		
				}	

			}
		});

		secondPanel.add(filtra);

		JPanel weeklyMatch = weeklyMatch();
		weeklyMatch.setBounds(10, 200, 300, 400);
		secondPanel.add(weeklyMatch);

		controlPanel.add(firstPanel);
		controlPanel.add(secondPanel);

		return controlPanel;
	}
	
	/** Funzione weeklyMatch
	 * ,restitusce un pannello di visualizzazione nel quale � possibile selezionare la settimana
	 * a cui la programmazione degli eventi dello stadio far� riferimento
	 * @return
	 * @throws ParseException
	 */
	private JPanel weeklyMatch() throws ParseException {

		JPanel controlPanel = new JPanel();
		controlPanel.setLayout(null);

		JPanel firstPanel = new JPanel();
		firstPanel.setBounds(5, 5, 290, 50);
		firstPanel.setLayout(null);

		JPanel secondPanel = new JPanel();
		secondPanel.setBounds(5, 60, 290, 330);
		secondPanel.setLayout(null);

		Calendario d = new Calendario();

		ArrayList<ArrayList<String>> listaSettimane = new ArrayList<>();
		ArrayList<String> settimane = new ArrayList<>();
		ArrayList<String> se = new ArrayList<>();
		ArrayList<String> lastDecemberDay = new ArrayList<>();
		lastDecemberDay.add(d.getInsiemeDateString().get(364));
		lastDecemberDay.add(d.getInsiemeDateString().get(365));

		int cont=0;
		for(int i=0; i<d.getArrayDate().size(); i++){
			settimane.add(d.getInsiemeDateString().get(i));
			cont++;
			if(cont == 7){
				se.add(settimane.get(0));
				se.add(settimane.get(6));
				listaSettimane.add(se);
				settimane = new ArrayList<>();
				se = new ArrayList<>();
				cont = 0;
			}
			if(i==364){
				listaSettimane.add(lastDecemberDay);
			}
		}

		ArrayList<String> textComboBoxDefalut = new ArrayList<>();
		textComboBoxDefalut.add("Programma Settimanale");

		JComboBox<ArrayList<String>> j = new JComboBox<ArrayList<String>>();
		j.addItem(textComboBoxDefalut);
		j.setBounds(50, 10, 230, 25);	
		j.setEditable(false);

		for(int w=0; w<listaSettimane.size(); w++){
			j.addItem(listaSettimane.get(w));
			j.addActionListener(new ActionListener() {	
				public void actionPerformed(ActionEvent e) {

					if(!j.getSelectedItem().equals(textComboBoxDefalut)){
						secondPanel.removeAll();
						SimpleDateFormat sdf = new SimpleDateFormat("EEE dd/MMM/yyyy");
						JLabel butt;
						Date b = null;
						try {
							b = sdf.parse(j.getItemAt(j.getSelectedIndex()).get(0));
						} catch (ParseException e1) {
							e1.printStackTrace();
						}
						Date c = null;
						try {
							c = sdf.parse(j.getItemAt(j.getSelectedIndex()).get(1));
						} catch (ParseException e1) {
							e1.printStackTrace();
						}
						int y = 10;
						int y2 = 10;
						for(int j=0; j<s.getS().getStadi().size(); j++){
							if(stadi.getSelectedItem().equals(s.getS().getStadi().get(j).getNomeStadio()))
								for(int i=0; i<s.getS().getStadi().get(j).getPartite().size(); i++){
									if(s.getS().getStadi().get(j).getPartite().get(i).getData().getTimeInMillis() >= b.getTime() && 
											s.getS().getStadi().get(j).getPartite().get(i).getData().getTimeInMillis() <= c.getTime()){

										butt = new JLabel(s.getS().getStadi().get(j).getPartite().get(i).getPartita());
										butt.setBounds(0, y, 150, 20);
										y = y + 20;
										if(secondPanel.getBounds().getHeight() < butt.getY()+20){
											butt.setBounds(120, y2, 150, 20);
											y2 = y2 + 20;
										}
										secondPanel.add(butt);
										secondPanel.repaint();
									}			
								}
						}
						if(secondPanel.getComponentCount() == 0){
							JLabel label = new JLabel("Nessuna partita trovata");
							label.setBounds(10, 10, 150, 20);
							secondPanel.add(label);
							secondPanel.repaint();
						}
					}
				}
			});		
		}
		firstPanel.add(j);

		controlPanel.add(firstPanel);
		controlPanel.add(secondPanel);
		return controlPanel;
	}
}
package grafica;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.GregorianCalendar;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import contabilita.ScontoPensionati;
import contabilita.Biglietto;
import contabilita.ScontoFasciaOraria;
import contabilita.ScontoLunedi;
import eccezione.PostoIndisponibileException;
import sistema.FileManager;
import utente.Cliente;


/** Classe che definisce <i>FrameHomePrenotazione</i>
 * un FrameHomePrenotazione ha un parametro s(FileManager), c(Cliente) e un indicePartita(int)
 * 
 *
 */
public class FrameHomePrenotazione {

	private FileManager s;
	private Cliente c;
	private int indicePartita=0;
	float prezzoBiglietto=0;
	public FrameHomePrenotazione( ){

	}
	/**FramePrenotazioneAla
	 * Crea l'interfaccia grafica che si occupera della visualizzazione dei posti, la prenotazione di questi ultimi
	 * indicandone lo stato mediante colori differenti
	 * @param s determina il FileManager
	 * @param c definisce il cliente che potr� effettuare le prenotazioni
	 * @param indicestadio definisce l'indice dello stadio all'interno dell'ArrayList di tipo Stadio
	 * @param nomePartita indica il nome della partita
	 */
	public void FramePrenotazioneAla(FileManager s,Cliente c,int indicestadio,String nomePartita){

		this.c=c;
		this.s=s;

		JFrame Ala= new JFrame("Ala");
		Ala.setVisible(true);
		Ala.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Ala.setBounds(100, 100, 450, 300);
		Ala.setResizable(false);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		Ala.setContentPane(contentPane);
		contentPane.setLayout(null);

		for(int b=0;b<4;b++){
			JButton btn=new JButton();
			if(b==0){	
				btn.setText("Nord");
				btn.setBounds(112, 28, 200, 50);
			}
			else if(b==2){
				btn.setText("Sud");
				btn.setBounds(112, 171, 200, 50);
			}
			else if(b==3){
				btn.setText("Ovest");
				btn.setBounds(44, 28, 70, 193);
			}
			else{
				btn.setText("Est");
				btn.setBounds(309, 28, 70, 193);
			}
			btn.setName(""+b);
			contentPane.add(btn);

			FormaStadio form = new FormaStadio();////////////////////////
			form.setBounds(24,-11, 284, 200);//////////////////////////
			contentPane.add(form);//////////////////////////////////////

			ActionListener selectArea = new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Ala.setVisible(false);
					JFrame posti= new JFrame("Posti");
					posti.setSize(1300, 600);
					posti.setVisible(true);
					posti.setLocationRelativeTo(null);
					posti.setResizable(false);
					posti.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					JPanel contentPane4 = new JPanel();
					contentPane4.setBorder(new EmptyBorder(5, 5, 5, 5));
					JPanel contentPane5= new JPanel();
					contentPane4.setLayout(new GridLayout(13,20));
					contentPane5.add(contentPane4,BorderLayout.CENTER);
					posti.add(contentPane5);
					JButton prenotaButton = new JButton("Prenota");
					contentPane5.add(prenotaButton,BorderLayout.SOUTH);
					JButton acquistaButton = new JButton("Acquista");
					contentPane5.add(acquistaButton,BorderLayout.SOUTH);
					int cont=0;


					for(int j=0;j<s.getS().getStadi().get(indicestadio).getPartite().size();j++){
						if((s.getS().getStadi().get(indicestadio).getPartite().get(j).getPartita()
								+ " "+ s.getS().getStadi().get(indicestadio).getPartite().get(j).getParsedData())
								.equalsIgnoreCase(nomePartita)){
							indicePartita=j;
						}
					}

					prezzoBiglietto = s.getS().getStadi().get(indicestadio).getPartite().get(indicePartita).getPrezzo();

					for(int i=0;i<s.getS().getStadi().get(indicestadio).getPartite().get(indicePartita)
							.getTribune().get(Integer.parseInt(btn.getName())).getArray().size();i++){

						s.getS().getStadi().get(indicestadio).getPartite()
						.get(indicePartita)
						.getTribune().get(Integer.parseInt(btn.getName())).getArray()
						.get(i).setStato(0);

						for(int client=1;client<s.getS().getRegistroUtenti().getUtenti().size() ;client++){
							for(int acq=0;acq<((Cliente)s.getS().getRegistroUtenti().getUtenti().get(client)).getAcquisti().size();acq++)
								if(((Cliente)s.getS().getRegistroUtenti().getUtenti().get(client)).getAcquisti().get(acq).getPartita()
										.equalsIgnoreCase(
												nomePartita) && ((Cliente)s.getS().getRegistroUtenti().getUtenti().get(client)).getAcquisti()
										.get(acq).getIdPosto().equalsIgnoreCase(s.getS().getStadi().get(indicestadio).getPartite()
												.get(indicePartita)
												.getTribune().get(Integer.parseInt(btn.getName())).getArray()
												.get(i).getId()) )

									s.getS().getStadi().get(indicestadio).getPartite()
									.get(indicePartita)
									.getTribune().get(Integer.parseInt(btn.getName())).getArray()
									.get(i).setStato(3);

							for(int pren=0;pren<((Cliente)s.getS().getRegistroUtenti().getUtenti().get(client)).getPrenotazioni().size();pren++)
								if(((Cliente)s.getS().getRegistroUtenti().getUtenti().get(client)).getPrenotazioni().get(pren).getPartita()
										.equalsIgnoreCase(
												nomePartita) && ((Cliente)s.getS().getRegistroUtenti().getUtenti().get(client)).getPrenotazioni()
										.get(pren).getIdPosto().equalsIgnoreCase(s.getS().getStadi().get(indicestadio).getPartite()
												.get(indicePartita)
												.getTribune().get(Integer.parseInt(btn.getName())).getArray()
												.get(i).getId()) )

									s.getS().getStadi().get(indicestadio).getPartite()
									.get(indicePartita)
									.getTribune().get(Integer.parseInt(btn.getName())).getArray()
									.get(i).setStato(2);
						}

						for(int pren=0;pren<c.getPrenotazioni().size();pren++)
							if(c.getPrenotazioni().get(pren).getPartita().equalsIgnoreCase(
									nomePartita) && c.getPrenotazioni().get(pren).getIdPosto().equalsIgnoreCase(
											s.getS().getStadi().get(indicestadio).getPartite()
											.get(indicePartita)
											.getTribune().get(Integer.parseInt(btn.getName())).getArray()
											.get(i).getId()) )

								s.getS().getStadi().get(indicestadio).getPartite()
								.get(indicePartita)
								.getTribune().get(Integer.parseInt(btn.getName())).getArray()
								.get(i).setStato(1);

						for(int c=0;c<s.getS().getStadi().size();c++){
							for(int b=0; b<s.getS().getStadi().get(c).getPartite().size(); b++){
								for(int j=0; j<s.getS().getStadi().get(c).
										getPartite().get(b).getTribune().size(); j++){
									for(int k=0; k<s.getS().getStadi().get(c).getCapienza(); k++){
										s.getS().getStadi().get(c).getPartite().get(b).
										getTribune().get(j).getArray().get(k).setStato(4);
									}
								}
							}
						}

						ImageIcon img = new ImageIcon(""+s.getS().getStadi().get(indicestadio).getPartite()
								.get(indicePartita)
								.getTribune().get(Integer.parseInt(btn.getName())).getArray()
								.get(i).getStato()
								+".png");
						JButton d= new JButton(img);
						d.setName(""+cont);
						d.setOpaque(true); 
						d.setBorder(null); 

						ActionListener prenotaposto= new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {

								GregorianCalendar g = new GregorianCalendar();

								infoFrameErrore.setVisible(false);
								infoLabelErrore.setVisible(false);

								if(s.getS().getStadi().get(indicestadio).getPartite()
										.get(indicePartita).getData().getTimeInMillis() - g.getTimeInMillis() >= 1000*60*60*12){
									if(
											s.getS().getStadi().get(indicestadio).getPartite().get(indicePartita).getTribune()
											.get(Integer.parseInt(btn.getName())).getArray()
											.get(Integer.parseInt(d.getName())).getStato()==1
											)
										s.getS().getStadi().get(indicestadio).getPartite().get(indicePartita).getTribune()
										.get(Integer.parseInt(btn.getName())).getArray()
										.get(Integer.parseInt(d.getName())).setStato(0);
									else if(s.getS().getStadi().get(indicestadio).getPartite().get(indicePartita).getTribune()
											.get(Integer.parseInt(btn.getName())).getArray()
											.get(Integer.parseInt(d.getName())).getStato()==0){
										s.getS().getStadi().get(indicestadio).getPartite().get(indicePartita).getTribune()
										.get(Integer.parseInt(btn.getName())).getArray()
										.get(Integer.parseInt(d.getName())).setStato(1);
									}
									ImageIcon img2 = new ImageIcon(""+s.getS().getStadi().get(indicestadio).getPartite()
											.get(indicePartita)
											.getTribune().get(Integer.parseInt(btn.getName())).getArray()
											.get(Integer.parseInt(d.getName())).getStato()
											+".png");
									d.setIcon(img2);

									try{
										if(s.getS().getStadi().get(indicestadio).getPartite().get(indicePartita).getTribune()
												.get(Integer.parseInt(btn.getName())).getArray()
												.get(Integer.parseInt(d.getName())).getStato()!=0 && (s.getS().getStadi().get(indicestadio).getPartite().get(indicePartita).getTribune()
														.get(Integer.parseInt(btn.getName())).getArray()
														.get(Integer.parseInt(d.getName())).getStato()!=1) ){

											throw new PostoIndisponibileException();
										}
									}catch(PostoIndisponibileException e){
										infoFrameErrore.setTitle("Errore");
										infoFrameErrore.setSize(350, 90);
										infoFrameErrore.setLayout(null);
										infoFrameErrore.setLocationRelativeTo(null);
										infoFrameErrore.setResizable(false);
										infoLabelErrore.setText(e.toString());
										infoLabelErrore.setBounds(100, 25, 150, 20);
										infoFrameErrore.add(infoLabelErrore);
										infoLabelErrore.setVisible(true);
										infoFrameErrore.setVisible(true);
										infoFrameErrore.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
									}

									SwingUtilities.updateComponentTreeUI(posti);

								}else{
									infoFrameErrore.setTitle("Errore");
									infoFrameErrore.setSize(350, 90);
									infoFrameErrore.setLayout(null);
									infoFrameErrore.setLocationRelativeTo(null);
									infoFrameErrore.setResizable(false);
									infoLabelErrore.setText("Prenotazione scaduta");
									infoLabelErrore.setBounds(100, 25, 150, 20);
									infoFrameErrore.add(infoLabelErrore);
									infoLabelErrore.setVisible(true);
									infoFrameErrore.setVisible(true);
									infoFrameErrore.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
								}
							}
						};
						d.addActionListener(prenotaposto);
						contentPane4.add(d);
						cont++;
					}

					ActionListener salvaPrenotazione= new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {

							for(int i=0;i<c.getPrenotazioni().size();)
								if(c.getPrenotazioni().size()>=1)
								{
									if(c.getPrenotazioni().get(i).getPartita().equals(nomePartita)){
										c.getPrenotazioni().remove(i);
										i=0;
									}
									else i++;
								}

							for(int j=0;j<s.getS().getStadi().get(indicestadio).getPartite().get(indicePartita)
									.getTribune().size();j++){
								for(int x=0;x<s.getS().getStadi().get(indicestadio).getPartite().get(indicePartita)
										.getTribune().get(j).getArray().size();x++){
									if(s.getS().getStadi().get(indicestadio).getPartite().get(indicePartita)
											.getTribune().get(j).getArray().get(x).getStato()==1){


										if(c.getDiscountablePensionato() && s.getS().getStadi().get(indicestadio).isSconto1()){
											ScontoPensionati sconto = new ScontoPensionati(s);
											prezzoBiglietto =  sconto.addScontoPensionati(indicestadio, indicePartita);

										}

										if(s.getS().getStadi().get(indicestadio).getPartite().get(indicePartita).
												getDiscountableFasciaOraria() && s.getS().getStadi().get(indicestadio).isSconto2()){
											ScontoFasciaOraria sconto = new ScontoFasciaOraria(s);
											prezzoBiglietto =  sconto.addScontoFasciaOraria(indicestadio, indicePartita);
										}

										if(s.getS().getStadi().get(indicestadio).getPartite().get(indicePartita).
												getDiscountableLunedi() && s.getS().getStadi().get(indicestadio).isSconto3()){
											ScontoLunedi sconto = new ScontoLunedi(s);
											prezzoBiglietto =  sconto.addScontoLunedi(indicestadio, indicePartita);

										}

										Biglietto b= new Biglietto(s.getS().getStadi().get(indicestadio).getPartite()
												.get(indicePartita)
												.getTribune().get(j).getArray().get(x).getId(),
												nomePartita,
												s.getS().getStadi().get(indicestadio),
												prezzoBiglietto);

										c.getPrenotazioni().add(b);
									}
								}
							}

							try {
								s.salvaStruttura();
							} catch (IOException e) {
								e.printStackTrace();
							}
							posti.setVisible(false);
						}

					};
					prenotaButton.addActionListener(salvaPrenotazione);

					ActionListener salvaAcquisto= new ActionListener() {
						public void actionPerformed(ActionEvent e) {

							for(int x=0;x<s.getS().getStadi().get(indicestadio).getPartite().get(indicePartita).getTribune()
									.get(Integer.parseInt(btn.getName())).getArray().size();x++){

								if(s.getS().getStadi().get(indicestadio).getPartite().get(indicePartita).getTribune()
										.get(Integer.parseInt(btn.getName())).getArray().get(x).getStato()==1){

									if(c.getDiscountablePensionato() && s.getS().getStadi().get(indicestadio).isSconto1()){
										ScontoPensionati sconto = new ScontoPensionati(s);
										prezzoBiglietto =  sconto.addScontoPensionati(indicestadio, indicePartita);

									}

									if(s.getS().getStadi().get(indicestadio).getPartite().get(indicePartita).
											getDiscountableFasciaOraria() && s.getS().getStadi().get(indicestadio).isSconto2()){
										ScontoFasciaOraria sconto = new ScontoFasciaOraria(s);
										prezzoBiglietto =  sconto.addScontoFasciaOraria(indicestadio, indicePartita);
									}

									if(s.getS().getStadi().get(indicestadio).getPartite().get(indicePartita).
											getDiscountableLunedi() && s.getS().getStadi().get(indicestadio).isSconto3()){
										ScontoLunedi sconto = new ScontoLunedi(s);
										prezzoBiglietto =  sconto.addScontoLunedi(indicestadio, indicePartita);

									}

									Biglietto b= new Biglietto(s.getS().getStadi().get(indicestadio).getPartite().get(indicePartita).getTribune()
											.get(Integer.parseInt(btn.getName())).getArray().get(x).getId(),
											nomePartita,
											s.getS().getStadi().get(indicestadio),prezzoBiglietto);

									s.getS().getStadi().get(indicestadio).getCassa().setSaldo(prezzoBiglietto);

									c.getAcquisti().add(b);
								}
							}

							for(int i=0;i<c.getPrenotazioni().size();i++)
								for(int h=0;h<c.getAcquisti().size();h++)
									if(c.getPrenotazioni().get(i).getIdPosto().equals(c.getAcquisti().get(h).getIdPosto()) &&
											c.getPrenotazioni().get(i).getPartita().equals(c.getAcquisti().get(h).getPartita())){
										c.getPrenotazioni().remove(i);
										i=0;
										h=0;
									}

							try {
								s.salvaStruttura();
							} catch (IOException e1) {
								e1.printStackTrace();
							}
							posti.setVisible(false);
						}
					};
					acquistaButton.addActionListener(salvaAcquisto);
					SwingUtilities.updateComponentTreeUI(posti);
				}

			};

			btn.addActionListener(selectArea);
		}
	}
	JFrame infoFrameErrore = new JFrame();
	JLabel infoLabelErrore = new JLabel();
}

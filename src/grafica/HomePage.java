package grafica;

import sistema.FileManager;
import utente.Cliente;
import utente.Gestore;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.text.ParseException;
import java.util.GregorianCalendar;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;


/**Classe che definisce <i>HomePage</i>
 * una HomePage ha un parametro f( FileManager)
 * 
 *
 */
public class HomePage {

	private FileManager f;
	private JLabel errorMessage = new JLabel();
	/**Costruttore
	 * 
	 * @param f definisce il fileManager da utilizzare
	 */
	public HomePage(FileManager f){
		this.f = f;
	}
	/**Funzione creaHomePage
	 * ,crea l'interfaccia grafica riguardante il Login come gestore o cliente, 
	 * controllando la correttezza dei dati inseriti e consentendo la registrazione di un nuovo utente
	 * definisce quindi l'accesso all'interfaccia iniziale come Cliente o Gestore
	 * 
	 */
	public void creaHomePage(){

		JFrame mainFrame = new JFrame();
		mainFrame.setSize(400, 300);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setTitle("Accesso");
		mainFrame.setVisible(true);
		mainFrame.setResizable(false);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(null);
		mainPanel.setFocusable(true);

		JLabel nomeUtente = new JLabel("Nome Utente");
		nomeUtente.setBounds(60, 40, 100, 20);
		mainPanel.add(nomeUtente);

		JTextField nUtente = new JTextField();
		nUtente.setBounds(180, 40, 100, 25);
		mainPanel.add(nUtente);

		JLabel password = new JLabel("Password");
		password.setBounds(60, 90, 100, 20);
		mainPanel.add(password);

		JPasswordField pass = new JPasswordField();
		pass.setBounds(180, 85, 100, 25);
		mainPanel.add(pass);

		JButton button = new JButton("Accedi");
		button.setBounds(70, 150, 90, 30);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(((Gestore)f.getS().getRegistroUtenti().getUtenti().get(0)).getId().equals(nUtente.getText())
						&& ((Gestore)f.getS().getRegistroUtenti().getUtenti().get(0)).getPassword().equals(pass.getText()))
				{
					Gestore c=(Gestore) f.getS().getRegistroUtenti().getUtenti().get(0);
					FrameHomeGestore fg = new FrameHomeGestore(f, c);	
					fg.creaHome();
					nUtente.setText(null);
					pass.setText(null);
				}

				else {
					boolean flag = false;

					for(int j=1;j<f.getS().getRegistroUtenti().getUtenti().size();j++){

						Cliente c=(Cliente) f.getS().getRegistroUtenti().getUtenti().get(j);

						if(c.getId().equals(nUtente.getText()) && c.getPassword().equals(pass.getText())){

							flag = true;

							FrameHomeCliente frmStd = new FrameHomeCliente(f,c);

							try {
								frmStd.creaHome();
							} catch (ParseException e1) {
								e1.printStackTrace();
							}
							nUtente.setText(null);
							pass.setText(null);

						}
					}if(flag == false){

						nUtente.setText(null);
						pass.setText(null);
						errorMessage.setForeground(null);
						mainPanel.remove(errorMessage);
						errorMessage.setText("Dati di accesso non validi");
						errorMessage.setBounds(200, 200, 180, 20);
						mainPanel.add(errorMessage);
						mainPanel.repaint();
					}else{
						mainPanel.remove(errorMessage);
						mainPanel.repaint();
					}

				}
			}
		});
		mainPanel.add(button);

		KeyListener l = new KeyListener() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					button.doClick();
				}
			}			
			public void keyReleased(KeyEvent e) {
			}		
			public void keyTyped(KeyEvent e) {	
			}
		};

		button.addKeyListener(l);
		nUtente.addKeyListener(l);
		pass.addKeyListener(l);

		JButton registrazione = new JButton("Registrati");
		registrazione.setBounds(180, 150, 90, 30);
		registrazione.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String[] mesi = {"Gennaio","Febraio","Marzo","Aprile","Maggio","Giugno","Luglio","Agosto","Settembre","Ottobre","Novembre","Dicembre"};

				JFrame frame = new JFrame();
				frame.setSize(400, 300);
				frame.setTitle("Registrazione");
				frame.setResizable(false);
				frame.setLocationRelativeTo(null);	
				frame.setVisible(true);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				JPanel panel = new JPanel();
				panel.setLayout(null);

				JLabel nomeUtente = new JLabel("Nome Utente");
				nomeUtente.setBounds(10, 5, 100, 35);
				panel.add(nomeUtente);

				JTextField nameUtente = new JTextField();
				nameUtente.setBounds(110, 10, 100, 25);
				panel.add(nameUtente);

				JLabel nome = new JLabel("Nome");
				nome.setBounds(10, 40, 100, 35);
				panel.add(nome);

				JTextField nomeField = new JTextField();
				nomeField.setBounds(110, 45, 100, 25);
				panel.add(nomeField);

				JLabel cognome = new JLabel("Cognome");
				cognome.setBounds(10, 75, 100, 35);
				panel.add(cognome);

				JTextField surname = new JTextField();
				surname.setBounds(110, 80, 100, 25);
				panel.add(surname);

				JLabel data = new JLabel("Data di Nascita");
				data.setBounds(10, 110, 100, 35);
				panel.add(data);

				JComboBox<Integer> giorno = new JComboBox<>();	
				giorno.setBounds(110, 115, 70, 25);
				for(int i=0; i<31; i++){
					giorno.addItem(i+1);
				}
				giorno.setEditable(false);
				panel.add(giorno);

				JComboBox<String> mese = new JComboBox<>();
				mese.setBounds(180, 115, 90, 25);
				for(int i=0; i<12; i++){
					mese.addItem(mesi[i]);
				}
				mese.setEditable(false);
				panel.add(mese);

				JComboBox<Integer> anno = new JComboBox<>();
				anno.setBounds(270, 115, 70, 25);
				for(int i=0; i<65; i++){
					anno.addItem(i+1950);
				}
				anno.setEditable(false);
				panel.add(anno);

				JLabel sesso = new JLabel("Sesso");
				sesso.setBounds(10, 145, 100, 35);
				panel.add(sesso);

				JLabel uomo = new JLabel("Uomo");
				uomo.setBounds(110, 150, 100, 25);
				panel.add(uomo);

				ButtonGroup group = new ButtonGroup();	
				JRadioButton male = new JRadioButton("M");
				male.setBounds(145, 155, 20, 15);	
				panel.add(male);
				JLabel donna = new JLabel("Donna");
				donna.setBounds(200, 150, 100, 25);
				panel.add(donna);
				JRadioButton female = new JRadioButton("F");
				female.setBounds(240, 155, 20, 15);	
				group.add(male);
				group.add(female);
				male.setSelected(true);
				panel.add(female);

				JLabel l = new JLabel("Inserisci password");
				l.setBounds(50, 185, 180, 30);
				panel.add(l);

				JPasswordField passwordField = new JPasswordField();
				passwordField.setBounds(180, 190, 180, 25);
				panel.add(passwordField);

				JButton button1 = new JButton("Registrati");
				button1.setBounds(50, 220, 100, 30);
				button1.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						boolean exist = false;

						if(!nomeField.getText().isEmpty() && !surname.getText().isEmpty() 
								&& !nameUtente.getText().isEmpty() && !passwordField.getText().isEmpty()){

							String sex;

							if(male.isSelected()) sex="M";
							else sex="F";

							GregorianCalendar dataDiNascita = new GregorianCalendar((int)anno.getSelectedItem(), mese.getSelectedIndex(), (int)giorno.getSelectedItem());

							if(f.getS().getRegistroUtenti().getUtenti().size() == 1){

								Cliente cliente = new Cliente(nomeField.getText(), surname.getText(),
										dataDiNascita,sex,nameUtente.getText(),passwordField.getText());

								f.getS().getRegistroUtenti().getUtenti().add(cliente);

								try {
									f.salvaStruttura();
								} catch (IOException e1) {
									e1.printStackTrace();
								}

								nomeField.setText(null);
								surname.setText(null);
								nameUtente.setText(null);
								passwordField.setText(null);

								panel.remove(errorMessage);	
								errorMessage.setForeground(null);
								errorMessage.setText("Registrazione effettuata");
								errorMessage.setBounds(220, 10, 180, 20);
								panel.add(errorMessage);
								panel.repaint();

							}else{

								Cliente cliente = new Cliente(nomeField.getText(), surname.getText(),
										dataDiNascita,sex,nameUtente.getText(),passwordField.getText());

								for(int i=1; i<f.getS().getRegistroUtenti().getUtenti().size(); i++){
									Cliente c = (Cliente) f.getS().getRegistroUtenti().getUtenti().get(i);

									if(cliente.getId().equals(c.getId())){											
										exist = true;												
									}
								}

								if(exist){

									panel.remove(errorMessage);
									Color c1 = Color.red;
									errorMessage.setForeground(c1);
									errorMessage.setText("Nome utente esistente");
									errorMessage.setBounds(220, 10, 180, 20);
									panel.add(errorMessage);
									panel.repaint();

								}else{
									f.getS().getRegistroUtenti().getUtenti().add(cliente);

									try {
										f.salvaStruttura();
									} catch (IOException e1) {
										e1.printStackTrace();
									}

									nomeField.setText(null);
									surname.setText(null);
									nameUtente.setText(null);
									passwordField.setText(null);

									panel.remove(errorMessage);
									errorMessage.setForeground(null);
									errorMessage.setText("Registrazione effettuata");
									errorMessage.setBounds(220, 10, 180, 20);
									panel.add(errorMessage);
									panel.repaint();
								}										
							}
						}
						else{
							panel.remove(errorMessage);
							Color c = Color.red;
							errorMessage.setForeground(c);
							errorMessage.setText("Registrazione non effettuata");
							errorMessage.setBounds(220, 10, 180, 20);
							panel.add(errorMessage);
							panel.repaint();
						}
					}
				});
				panel.add(button1);

				JButton indietro = new JButton("Indietro");
				indietro.setBounds(250, 220, 90, 30);
				indietro.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						frame.setVisible(false);		
					}
				});
				panel.add(indietro);

				frame.add(panel);
				frame.setVisible(true);
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

			}
		});
		mainPanel.add(registrazione);

		mainFrame.add(mainPanel);
		SwingUtilities.updateComponentTreeUI(mainFrame);
	}

}

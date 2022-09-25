package grafica;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class JTextFieldLimit extends PlainDocument{
	
	/**Classe che definisce <i>JTextFieldLimit</i>
	 * un JTextFieldLimit ha un limit(int)
	 */
	private int limit;

		/**Costruttore
		 * 
		 * @param limit 
		 */
	JTextFieldLimit(int limit) {
		super();
		this.limit = limit;
	}
	
	/**Funzione insertString
	 * prende in input offset(int), str(String), attr(AttributeSet)
	 * applica un limite alle textfield contenute nell'interfaccia gestore
	 */

	public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
		if (str == null)
			return;

		if ((getLength() + str.length()) <= limit) {
			super.insertString(offset, str, attr);
		}
	}
}

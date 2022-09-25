package grafica;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import javax.swing.JComponent;
/**Classe che definisce un oggetto JComponent
 * 
 * 
 *
 */
public class FormaStadio extends JComponent {
	
	public void paintComponent(Graphics g) {
		
		Graphics2D g2 = (Graphics2D) g;	
		Rectangle r = new Rectangle(90, 90, 193, 90);
		g2.draw(r);
		Ellipse2D.Double e = new Ellipse2D.Double(160,110,50,50);
		g2.draw(e);	
		Rectangle r2 = new Rectangle(90, 90, 95, 90);
		g2.draw(r2);		
		Rectangle r3 = new Rectangle(90, 110, 30, 50);
		g2.draw(r3);
		Rectangle r4 = new Rectangle(253, 110, 30, 50);
		g2.draw(r4);	
	}

}

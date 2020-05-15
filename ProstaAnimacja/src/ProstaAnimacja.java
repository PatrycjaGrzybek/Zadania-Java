import javax.swing.*;
import java.awt.*;

	public class ProstaAnimacja {
		int x = 70;
		int y = 70;
		
		public static void main(String[] args) {
			ProstaAnimacja gui = new ProstaAnimacja();
			gui.doRoboty();
		}
		
		public void doRoboty() {
			JFrame ramka = new JFrame();
			
			ramka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			MojPanelRysunkowy panel = new MojPanelRysunkowy();
			
			ramka.getContentPane().add(panel);
			ramka.setSize(300,300);
			ramka.setVisible(true);

			for (int i = 0; i < 100; i++) {
				x++;
				y++;
				panel.repaint();
				
				try {
					Thread.sleep(100);
				} catch (Exception ex) { }
			}
		} 

		class MojPanelRysunkowy extends JPanel {
			public void paintComponent(Graphics g) {
				
				/* JEDEN KOLOR 
				g.setColor(Color.white);
				g.fillRect(0, 0, this.getWidth(), this.getHeight());
				g.setColor(Color.green);
				g.fillOval(x,y,40,40); */
				
				/* GRADIENT
				Graphics2D g2d = (Graphics2D) g;
				g2d.setColor(Color.white);
				g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
				GradientPaint gradient = new GradientPaint(70,70, Color.pink, 150,150, Color.red);
				g2d.setPaint(gradient);
				g2d.fillOval(x,y,40,40); */
				
				//LOSOWY GRADIENT 
				Graphics2D g2d = (Graphics2D) g; 
				
				g2d.setColor(Color.white);
				g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
				
				int czerwony = (int) (Math.random() * 256);
				int zielony = (int) (Math.random() * 256);
				int niebieski = (int) (Math.random() * 256);
				Color kolorPoczatku = new Color(czerwony, zielony, niebieski);
				
				czerwony = (int) (Math.random() * 256);
				zielony = (int) (Math.random() * 256);
				niebieski = (int) (Math.random() * 256);
				Color kolorKonca = new Color(czerwony, zielony, niebieski);
				
				GradientPaint gradient = new GradientPaint(70,70, kolorPoczatku, 150,150, kolorKonca);
				g2d.setPaint(gradient);
				g2d.fillRect(x,y,40,40);
				
			}
		} 
} 
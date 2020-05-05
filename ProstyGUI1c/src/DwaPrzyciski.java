import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

	public class DwaPrzyciski {
	JFrame ramka;
	JLabel etykieta; 
	
	public static void main(String[] args) {
		DwaPrzyciski gui = new DwaPrzyciski();
		gui.doRoboty();
}
	public void doRoboty() {
		ramka = new JFrame();
		ramka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton przyciskEtyk = new JButton("Zmien etykiete");
		przyciskEtyk.addActionListener(new EtykietaListener());
		
		JButton przyciskKolor = new JButton("Zmien kolor");
		przyciskKolor.addActionListener(new KolorListener());
		
		etykieta = new JLabel("Oto etykieta");
		MojPanelRysunkowy panel = new MojPanelRysunkowy();
		
		ramka.getContentPane().add(BorderLayout.SOUTH, przyciskKolor);
		ramka.getContentPane().add(BorderLayout.CENTER, panel);
		ramka.getContentPane().add(BorderLayout.EAST, przyciskEtyk);
		ramka.getContentPane().add(BorderLayout.WEST, etykieta);
		
		ramka.setSize(300,300);
		ramka.setVisible(true);
	}
	
	class EtykietaListener implements ActionListener {
		public void actionPerformed(ActionEvent zdarzenie) {
			etykieta.setText("Auuu!");
		}
	}
	
	class KolorListener implements ActionListener {
		public void actionPerformed(ActionEvent zdarzenie){
			ramka.repaint();
		}
	}
}
	class MojPanelRysunkowy extends JPanel {
		public void paintComponent(Graphics g) {
			g.fillRect(0,0,this.getWidth(),this.getHeight());
			int czerwony = (int) (Math.random() * 256);
			int zielony = (int) (Math.random() * 256);
			int niebieski = (int) (Math.random() * 256);
			Color kolorLosowy = new Color(czerwony, zielony, niebieski);
			g.setColor(kolorLosowy);
			g.fillOval(70,70,100,100);
		}
	}
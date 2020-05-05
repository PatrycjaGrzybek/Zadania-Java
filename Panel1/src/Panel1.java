import javax.swing.*;
import java.awt.*;

public class Panel1 {
	 public static void main(String[] args) {
		Panel1 gui = new Panel1();
		gui.doRoboty();
	}
	 public void doRoboty() {
		 JFrame ramka = new JFrame();
		 JPanel panel = new JPanel();
		 
		 panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		 
		 panel.setBackground(Color.darkGray);
		 
		 JButton przycisk = new JButton("To szok!");
		 JButton przycisk2 = new JButton("Trach");
		 JButton przycisk3 = new JButton("och");
		 
		 panel.add(przycisk);
		 panel.add(przycisk2);
		 panel.add(przycisk3);
		 
		 ramka.getContentPane().add(BorderLayout.EAST, panel);
		 
		 ramka.setSize(300,300);
		 ramka.setVisible(true);
	 }
}

import javax.swing.*;
import java.awt.*;

public class Przycisk1 {
	public static void main(String[] args) {
		Przycisk1 gui = new Przycisk1();
		gui.doRoboty();
	}
	
	public void doRoboty() {
		JFrame ramka = new JFrame();
		
		JButton przyciskW = new JButton("Wsch�d");
		JButton przyciskZ = new JButton("Zach�wd");
		JButton przyciskPn = new JButton("P�noc");
		JButton przyciskPd = new JButton("Po�udnie");
		JButton przyciskC = new JButton("Centrum");
		
		ramka.getContentPane().add(BorderLayout.EAST,przyciskW);
		ramka.getContentPane().add(BorderLayout.WEST,przyciskZ);
		ramka.getContentPane().add(BorderLayout.NORTH,przyciskPn);
		ramka.getContentPane().add(BorderLayout.SOUTH,przyciskPd);
		ramka.getContentPane().add(BorderLayout.CENTER,przyciskC);
		
		ramka.setSize(300,300);
		ramka.setVisible(true);
	}

}

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class PrzyciskWewnetrzny {
	
	JFrame ramka;
	JButton p;
	
	public static void main(String[] args) {
		PrzyciskWewnetrzny gui = new PrzyciskWewnetrzny();
		gui.doRoboty();
	}
	
	public void doRoboty() {
		ramka = new JFrame();
		
		ramka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		p = new JButton("A");
		p.addActionListener(new PListener());
		
		ramka.getContentPane().add(BorderLayout.SOUTH, p);
		ramka.setSize(200, 100);
		ramka.setVisible(true);
	}
	
	class PListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (p.getText().equals("A")) {
				p.setText("B");
			}else {
				p.setText("A");
			}
		}
	}
}
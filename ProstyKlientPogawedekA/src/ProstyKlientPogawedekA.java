import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ProstyKlientPogawedekA {
	
	JTextField wiadomosc;
	PrintWriter pisarz;
	Socket gniazdo;
	
	public void doDziela() {
		JFrame ramka = new JFrame("Smiesznie prosty klient pogawedek");
		JPanel panelGlowny = new JPanel();
		wiadomosc = new JTextField(20);
		JButton przyciskWyslij = new JButton("Wyœlij");
		przyciskWyslij.addActionListener(new PrzyciskWyslijListener());
		panelGlowny.add(wiadomosc);
		panelGlowny.add(przyciskWyslij);
		konfigurujKomunikacje();
		ramka.getContentPane().add(BorderLayout.CENTER, panelGlowny);
		ramka.setSize(400,90);
		ramka.setVisible(true);
	}
	
	private void konfigurujKomunikacje() {
		try {
			gniazdo = new Socket("127.0.0.1", 5000);
			pisarz = new PrintWriter(gniazdo.getOutputStream());
			System.out.println("obsluga sieci gotowa do uzycia");
		} catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public class PrzyciskWyslijListener implements ActionListener {
		public void actionPerformed(ActionEvent ev) {
			try {
				pisarz.println(wiadomosc.getText());
				pisarz.flush();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			wiadomosc.setText("");
			wiadomosc.requestFocus();
		}
	}
	
	public static void main(String[] args) {
		new ProstyKlientPogawedekA().doDziela();
	}
}

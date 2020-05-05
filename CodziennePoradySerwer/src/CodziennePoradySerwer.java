import java.io.*;
import java.net.*;

public class CodziennePoradySerwer {
	
	String[] listaPorad = {"Uzywaj mniejszych bitów", "Chodz w dopasowanych spodniach. Nie, te nie sprawiaja, ze wygldasz grubo.", "Jedno slowo: nieodpowiednie", "Tylko dzis - bod uczciwy - powiedz swojemu szefowi, co *naprawde* czujesz", "Moze chcesz zastanowic sie nad swoja fryzura."};

	public void doDzie³a() {
		
		try {
			ServerSocket gniazdoSrw = new ServerSocket(4242);
			
			while(true) {
				Socket gniazdo = gniazdoSrw.accept();
				
				PrintWriter pisarz = new PrintWriter(gniazdo.getOutputStream());
				String porada = wybierzPorade();
				pisarz.println(porada);
				pisarz.close();
				System.out.println(porada);
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}//koniec metody
	
	public static void main(String[] args) {
		CodziennePoradySerwer serwer = new CodziennePoradySerwer();
		serwer.doDzie³a();
	}
	
	private String wybierzPorade() {
		int random = (int) (Math.random() * listaPorad.length);
		return listaPorad[random];
	}
}

import java.util.*;
import java.io.*;

public class SzafaGrajacaHashSet {
	
	ArrayList<Piosenka> listaPiosenek = new ArrayList<Piosenka>();
	
	public static void main(String[] args) {
		new SzafaGrajacaHashSet().doDziela();
	}
	
	public void doDziela() {
		pobierzPiosenki();
		System.out.println(listaPiosenek);
		Collections.sort(listaPiosenek);
		System.out.println(listaPiosenek);
		
		HashSet<Piosenka> zbiorPiosenek = new HashSet<Piosenka>();
		zbiorPiosenek.addAll(listaPiosenek);
		System.out.println(zbiorPiosenek);
	}
	
	void pobierzPiosenki() {
		try {
			File plik = new File("ListaPiosenek.txt");
			BufferedReader reader = new BufferedReader(new FileReader(plik));
			String wiersz = null;
			while((wiersz = reader.readLine()) !=null) {
				dodajPiosenke(wiersz);
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	void dodajPiosenke(String wierszDoAnalizy) {
		String[] element = wierszDoAnalizy.split("/");
		Piosenka nastepnaPiosenka = new Piosenka(element[0], element[1], element [2], element[3]);
		listaPiosenek.add(nastepnaPiosenka);
	}
}



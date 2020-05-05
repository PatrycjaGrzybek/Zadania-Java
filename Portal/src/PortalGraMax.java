import java.util.*;
	public class PortalGraMax {
	private PomocnikGry pomocnik = new PomocnikGry();
	private ArrayList<Portal> listaPortali = new ArrayList<Portal>();
	private int iloscRuchow = 0;
	
	private void przygotujGre() {
		// najpierw tworzymy portale i okrelamy ich po	oenie
		Portal pierwszy = new Portal();
		pierwszy.setNazwa("onet.pl");
		Portal drugi = new Portal();
		drugi.setNazwa("wp.com");
		Portal trzeci = new Portal();
		trzeci.setNazwa("Go2.com");
		listaPortali.add(pierwszy);
		listaPortali.add(drugi);
		listaPortali.add(trzeci);
		
		System.out.println("Twoim celem jest zatopienie trzech portali.");
		System.out.println("onet.pl, wp.pl, Go2.com");
		System.out.println("Postaraj si je zatopi w jak najmniejszej iloci ruchów.");
		
		for (Portal rozmieszczanyPortal : listaPortali) {
			ArrayList<String> nowePolozenie = pomocnik.rozmiescPortal(3);
			rozmieszczanyPortal.setPolaPolozenia(nowePolozenie);
		} // koniec ptli for
	} // koniec metody
	
	private void rozpocznijGre() {
		while(!listaPortali.isEmpty()) {
			String ruchGracza = pomocnik.pobierzDaneWejsciowe("Podaj pole:");
			sprawdzRuchGracza(ruchGracza);
		} // koniec while
		zakonczGre();
	} // koniec metody
	
	private void sprawdzRuchGracza(String ruch) {
		iloscRuchow++;
		String wynik = "pudlo";
		for (Portal portalDoSprawdzenia : listaPortali) {
			wynik = portalDoSprawdzenia.sprawdz(ruch);
			if (wynik.equals("trafiony")) {
				break;
			}
			if (wynik.equals("zatopiony")) {
				listaPortali.remove(portalDoSprawdzenia);
				break;
			}
		} // koniec ptli for
		System.out.println(wynik);
	} // koniec metody
	
	private void zakonczGre() {
		System.out.println("Wszystkie Portale zosta	y zatopione! Teraz Twoje informacje nie maj znaczenia.");
		if (iloscRuchow <= 18) {
			System.out.println("Wykona	e jedynie " + iloscRuchow + " ruchów.");
			System.out.println("Wydosta	e si, zanim Twoje informacje zaton	y.");
		} else {
			System.out.println("Ale si grzeba	e!. Wykona	e a "+ iloscRuchow + " ruchów.");
			System.out.println("Teraz rybki p	ywaj pomidzy Twoimi informacjami.");
		}
	} // koniec metody
	
public static void main (String[] args) {
	PortalGraMax gra = new PortalGraMax();
	gra.przygotujGre();
	gra.rozpocznijGre();
	} // koniec metody
}
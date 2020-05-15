import java.util.*;

public class SortowanieGor {
	LinkedList<Gora> mtn = new LinkedList<Gora>();
	class NazwaCompare implements Comparator<Gora> {
		public int compare(Gora g1, Gora g2) {
			return g1.nazwa.compareTo(g2.nazwa);
		}
	}
	class WysokoscCompare implements Comparator<Gora> {
		public int compare(Gora g1, Gora g2) {
			return (g2.wysokosc - g1.wysokosc);
		}
	}
	public static void main(String [] args) {
		new SortowanieGor().doDziela();
	}
	public void doDziela() {
		mtn.add(new Gora("Kasprowy", 1987));
		mtn.add(new Gora("Koscielec", 2155));
		mtn.add(new Gora("Swinica", 2301));
		mtn.add(new Gora("Rysy", 2499));
		System.out.println("Bez sortowania: \n" + mtn);
		NazwaCompare nc = new NazwaCompare();
		Collections.sort(mtn, nc);
		System.out.println("Wg. nazwy:\n" + mtn);
		WysokoscCompare wc = new WysokoscCompare();
		Collections.sort(mtn,wc);
		System.out.println("Wg. wysokosci:\n" + mtn);
		}
	}
	class Gora {
	String nazwa;
	int wysokosc;
	Gora(String n, int w) {
		nazwa = n;
		wysokosc = w;
	}
	public String toString() {
		return nazwa + " " + wysokosc;
	}
}
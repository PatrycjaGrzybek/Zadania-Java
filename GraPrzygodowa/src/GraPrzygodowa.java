import java.io.*;

	class GraPrzygodowa implements Serializable {
		public int x = 3;
		transient long y = 4;
		private short z = 5;
		
		int getX() {
		return x;
		}
		
		long getY() {
		return y;
		}
		
		short getZ() {
		return z;
		}
	}

	class GraPrzygodowaTester {
		public static void main(String[] args) {
			GraPrzygodowa g = new GraPrzygodowa();
			System.out.println(g.getX() + g.getY() + g.getZ());
			try {
				FileOutputStream fos = new FileOutputStream("gra.ser");
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(g);
				oos.close();
				FileInputStream fis = new FileInputStream("gra.ser");
				ObjectInputStream ois = new ObjectInputStream(fis);
				g = (GraPrzygodowa) ois.readObject();
				ois.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(g.getX() + g.getY() + g.getZ());
		}
	}
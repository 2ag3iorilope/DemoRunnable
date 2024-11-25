package DemoRunnable;

public class DemoRunnable implements Runnable {
	private String nombre;

	public DemoRunnable(String nom) {
		nombre = nom;
	}

	public void run() {
		try {
			int x = (int) (Math.random() * 5000);
			Thread.sleep(x);
			System.out.println("Soy: " + nombre + " He estado dormido " + x + " milisegundos");
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public static void main(String[] args) {
		Thread t1 = new Thread(new DemoRunnable("Ana"));
		Thread t2 = new Thread(new DemoRunnable("Luis"));
		Thread t3 = new Thread(new DemoRunnable("Jon"));

		t1.start();
		t2.start();
		t3.start();

		try {
			// Join-en bitartez progrma bukatu harte itxarongo du mezua erakusteko
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException e) {
			System.out.println("Haria eten egin da: " + e.getMessage());
		}

		System.out.println("Final del main() y por tanto fin de programa");

	}
}
/**
 * Programa honek Hiru hari sortzen ditu Bakooitzari pertsona baten izena emanez
 * Honen bidez ematen du pertsona abt lo egon dela x ms bitartean baina izen
 * horiek Hariak dira
 */

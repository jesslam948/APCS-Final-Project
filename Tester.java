import java.awt.EventQueue;


public class Tester {
	public static void main(String[] args) {
		JarLoader j = new JarLoader();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CSGUI window = new CSGUI(j);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}

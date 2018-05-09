import java.awt.EventQueue;


public class FSTester {

	public static void main (String[] args)
	{
		FSController fight = new FSController();
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						FSGUI window = new FSGUI(fight);
						fight.setGui(window);
						//window.frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
	}
}

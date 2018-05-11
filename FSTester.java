import java.awt.EventQueue;


public class FSTester {

	public static void main (String[] args)
	{
		Cat myCat = new Cat ("Black", 30, 12, 14, 14);
		FSController fight = new FSController(myCat);
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

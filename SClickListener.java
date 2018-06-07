
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SClickListener implements ActionListener{
	private final StoreGUI fscreen;
	
	public SClickListener(StoreGUI gui){
		fscreen = gui;
	}
	
	
	public void actionPerformed(ActionEvent e)
	{
		
		
		if (e.getActionCommand().equals("Fish")){
			fscreen.initFish();
		}
		else if (e.getActionCommand().equals("Salmon juice")){
			fscreen.initPink();
		}
		else if (e.getActionCommand().equals("Cheese juice")){
			fscreen.initOrange();
		}
		else if (e.getActionCommand().equals("Catnip juice")){
			fscreen.initGreen();
		}
		else if(e.getActionCommand().equals("Check out")){
			fscreen.buy();
		}
		else if(e.getActionCommand().equals("Back")){
			fscreen.back();
		}
		
	}

}

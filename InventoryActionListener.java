import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class InventoryActionListener implements ActionListener{
	private final InventoryGUI iscreen;

	public InventoryActionListener(InventoryGUI gui)
	{
		iscreen = gui;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		FSController control = iscreen.getControl();
		boolean isChosen = false;
		boolean isCaught = false;
		
		if (e.getActionCommand().equals("Pink"))
		{
			if (iscreen.checkPotion("Pink"))
			{
				control.incRP("my", 5);
				isChosen = true;
			}
		}
		else if (e.getActionCommand().equals("Green"))
		{
			if (iscreen.checkPotion("Green"))
			{
				control.incRP("my", 6);
				isChosen = true;
			}
		}
		else if (e.getActionCommand().equals("Orange"))
		{
			if (iscreen.checkPotion("Orange"))
			{
				control.incRP("my", 7);
				isChosen = true;
			}
		}
		else if (e.getActionCommand().equals("Fish"))
		{
			if (control.fishCaught())
			{
				isCaught = true;
			}
		}
		
		if (!isCaught && isChosen)
		{
			control.compAttack();
		}
		
	}

}

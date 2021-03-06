import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class FSActionListener implements ActionListener{
	private final FSGUI fscreen;
	
	public FSActionListener(FSGUI gui)
	{
		fscreen = gui;
	}
	
	
	public void actionPerformed(ActionEvent e)
	{
		FSController control = fscreen.getControl();
		boolean invClicked = false;
		
		if (e.getActionCommand().equals("Move 1"))
		{
			control.decRP("my", 1);
		}
		else if (e.getActionCommand().equals("Move 2"))
		{
			control.decRP("my", 2);
		}
		else if (e.getActionCommand().equals("Move 3"))
		{
			control.decRP("my", 3);
		}
		else if (e.getActionCommand().equals("Move 4"))
		{
			control.decRP("my", 4);
		}
		else if (e.getActionCommand().equals("Inventory"))
		{
			invClicked = true;
			control.openInv();
		}
		
		if (!fscreen.hasEnded() && !invClicked)
		{
			control.compAttack();
		}
	}

}

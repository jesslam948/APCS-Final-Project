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
		else
		{
			control.decRP("my", 4);
		}
		
		if (!fscreen.hasEnded())
			control.compAttack();
	}

}


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MenuClickListener implements ActionListener{
	private final MenuGUI fscreen;
	
	public MenuClickListener(MenuGUI gui)
	{
		fscreen = gui;
	}
	
	
	public void actionPerformed(ActionEvent e)
	{
		
		
		if (e.getActionCommand().equals("Cats"))
		{
			fscreen.cats();
		}
		else if (e.getActionCommand().equals("Store"))
		{
			fscreen.store();
		}
		fscreen.delete();
		
	}

}

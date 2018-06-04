
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CLClickListener implements ActionListener{
	private final CLGUI fscreen;
	
	public CLClickListener(CLGUI gui)
	{
		fscreen = gui;
	}
	
	
	public void actionPerformed(ActionEvent e)
	{
		
		
		if (e.getActionCommand().equals("Mottled"))
		{
			fscreen.setCat(0);
			
		}
		else if (e.getActionCommand().equals("Black"))
		{
			fscreen.setCat(1);
		}
		else if (e.getActionCommand().equals("Tabby"))
		{
			fscreen.setCat(2);
		}
		else if (e.getActionCommand().equals("White"))
		{
			fscreen.setCat(3);
		}
		else if (e.getActionCommand().equals("Siamese"))
		{
			fscreen.setCat(4);
		}
		else if (e.getActionCommand().equals("Tuxedo"))
		{
			fscreen.setCat(5);
		}
		else if (e.getActionCommand().equals("Calico"))
		{
			fscreen.setCat(6);
		}
		else if (e.getActionCommand().equals("Turkish Angora"))
		{
			fscreen.setCat(7);
		}
		else if (e.getActionCommand().equals("Russian Blue"))
		{
			fscreen.setCat(8);
		}
		else if (e.getActionCommand().equals("Lucky Cat"))
		{
			fscreen.setCat(9);
		}
		else if(e.getActionCommand().equals("Fight!")){
			fscreen.fight();
		}
		else if(e.getActionCommand().equals("Stats")){
			fscreen.stats();
		}
		else if(e.getActionCommand().equals("Back")){
			fscreen.back();
		}
		
	}
	

}

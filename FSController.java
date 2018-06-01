import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.ImageIcon;


public class FSController {
	private FSGUI myGui;
	private Cat myCat;
	private Cat otherCat;
	private int myRP;
	private int otherRP;
	private boolean isEnded;
	private ArrayList<Integer> potions;
	
	public FSController(Cat cat)
	{
		myCat = cat;
		myRP = myCat.getRP();
		
		otherCat = setOtherCat();
		otherRP = otherCat.getRP();
		
		isEnded = false;
		
		potions = new ArrayList<Integer>();
		
		potions.add(1);
		potions.add(2);
		potions.add(3);
	}

	public void setGui (FSGUI gui)
	{
		myGui = gui;
		setRP();
	}
	
	public Cat setOtherCat()
	{
		int cute = myCat.getCuteness() + (int)(Math.random() * 5);
		int smart = myCat.getIntelligence() + (int)(Math.random() * 5);
		int friendly = myCat.getFriendliness() + (int)(Math.random() * 5);
		int R = myCat.getRP() + (int)(Math.random() * 5);
		
		Cat other = new Cat(2, cute, smart, friendly, R); // need a way to randomly generate breed 
		//New Thought: have an arrayList of breeds and choose a random number that corresponds with a spot in the list
		
		return other;
	}
	
	public void setRP()
	{
		myGui.setRP(myCat, otherCat);
	}
	
	public ImageIcon setCat(String cat, JarPictLoader j)
	{
		if (cat.equals("my"))
			return myCat.getImgIcon(j);
		else
			return otherCat.getImgIcon(j);
	}
	
	public int getMRP()
	{
		return myRP;
	}
	
	public int getORP()
	{
		return otherRP;
	}
	
	public boolean isDone()
	{
		return isEnded;
	}
	
	public void compAttack()
	{
		int randNum = (int)(Math.random() * 4) + 1;
		
		int altRandNum = (int) (Math.random() * 20) + 1;
		
		int move = 0;
		
		if (otherRP <= 3)
			move = potions.remove((int)(Math.random() * potions.size()));
		else if (otherRP <= 6 && altRandNum <= 5)
			move = potions.remove((int)(Math.random() * potions.size()));
		else if (otherRP <= 9 && altRandNum <= 3)
			move = potions.remove((int)(Math.random() * potions.size()));
		
		if (move == 0)
			decRP("other", randNum);
		else
			incRP("other", move);
	}
	
	public void decRP(String attacker, int move)
	{
		int pts = 0;
		Cat theCat = null;
		
		if (attacker.equals("my"))
			theCat = myCat;
		else
			theCat = otherCat;
		
		switch (move)
		{
		case 1:
			pts = (int)((theCat.getCuteness()/2) * Math.random()) + 1;
			break;
		case 2:
			pts = (int)((theCat.getIntelligence()/2) * Math.random()) + 1;
			break;
		case 3:
			pts = (int)((theCat.getFriendliness()/2) * Math.random()) + 1;
			break;
		case 4:
			pts = (int)((theCat.getCuteness()/2) * Math.random()) + 1;
			break;
		}
		
		///CAN CHANGE PTS VALUE AT A LATER TIME!

		if (theCat.equals(myCat))
		{
			if (pts >= otherRP)
				otherRP = 0;
			else
				otherRP -= pts;
			myGui.changeRP("other", otherRP, otherCat.getRP());
			myGui.moveDone("other", move , pts);
		}
		else
		{
			if (pts >= myRP)
				myRP = 0;
			else
				myRP -= pts;
			myGui.changeRP("my", myRP, myCat.getRP());
			myGui.moveDone("my", move , pts);
		}
		
		if (myRP == 0)
		{
			isEnded = true;
			myGui.isEnd("lost");
		}
		else if (otherRP == 0)
		{
			isEnded = true;
			myGui.isEnd("won");
		}
	}
	
	public void incRP(String user, int potion)
	{
		int pts = 0;
		Cat theCat = null;
		
		if (user.equals("my"))
			theCat = myCat;
		else
			theCat = otherCat;
		
		switch (potion)
		{
		case 1:
			pts = 5;
			break;
		case 2:
			pts = 10;
			break;
		case 3:
			pts = 15;
			break;
		}
		
		if (theCat.equals(myCat))
		{
			if (pts + myRP >= myCat.getRP())
				myRP = myCat.getRP();
			else
				myRP += pts;
			myGui.changeRP("my", myRP, myCat.getRP());
			myGui.moveDone("my", potion , pts);
		}
		else
		{
			if (pts + otherRP >= otherCat.getRP())
				otherRP = otherCat.getRP();
			else
				otherRP += pts;
			myGui.changeRP("other", otherRP, otherCat.getRP());
			myGui.moveDone("other", potion , pts);
		}
	}
	
	public boolean fishCaught()
	{
		boolean isCaught = false;
		int random = (int)(10 * Math.random()) + 1;
		
		if (otherRP <= 3)
			isCaught = true;
		else if (otherRP <= 6 && random <= 5)
			isCaught = true;
		else if (otherRP <= 9 && random <= 3)
			isCaught = true;
		
/////add the other cat to the catlist
		
		return isCaught;
	}
	
	public void openInv()
	{
		InventoryGUI window = new InventoryGUI(this);
	}
}

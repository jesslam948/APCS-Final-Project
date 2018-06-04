import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.ImageIcon;


public class FSController {
	private FSGUI myGui;
	private Cat myCat;
	private Cat otherCat;
	private int myRP;
	private int otherRP;
	private int counter;
	private boolean isEnded;
	private ArrayList<Integer> potions;
	private JarPictLoader j;
	private CatList cl;
	private InventoryController invControl;
	
	public FSController(Cat cat, JarPictLoader jar)
	{
		myCat = cat;
		myRP = myCat.getRP();
		
		otherCat = setOtherCat();
		otherRP = otherCat.getRP();
		
		counter = 1;
		
		isEnded = false;
		
		potions = new ArrayList<Integer>();
		
		potions.add(5);
		potions.add(6);
		potions.add(7);
		
		j = jar;
		
		invControl = new InventoryController();
		
		//TODO/////CHANGE LATER/////
		invControl.setFish(2);
		invControl.setOrange(2);
		invControl.setGreen(2);
		invControl.setPink(2);
	}

	public void setGui (FSGUI gui)
	{
		myGui = gui;
		setRP();
		cl = myGui.getList();
	}
	
	public Cat setOtherCat()
	{
		int cute = myCat.getCuteness() + (int)(Math.random() * 5);
		int smart = myCat.getIntelligence() + (int)(Math.random() * 5);
		int friendly = myCat.getFriendliness() + (int)(Math.random() * 5);
		int R = myCat.getRP() + (int)(Math.random() * 5);
		
		if (counter == myCat.getBreed())
			counter++;
		
		Cat other = new Cat(counter, cute, smart, friendly, R);
		
		counter++;
		return other;
	}
	
	public void setRP()
	{
		myGui.setRP(myCat, otherCat);
	}
	
	public ImageIcon setCat(String cat)
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
		
		if (otherRP <= 3 && altRandNum <= 7)
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
			pts = (int)((theCat.getCuteness()/3) * Math.random()) + 1;
			break;
		case 2:
			pts = (int)((theCat.getIntelligence()/3) * Math.random()) + 1;
			break;
		case 3:
			pts = (int)((theCat.getFriendliness()/3) * Math.random()) + 1;
			break;
		case 4:
			pts = (int)((theCat.getCuteness()/3) * Math.random()) + 1;
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
			myGui.isEnd("You lost! Let your cat rest!");
		}
		else if (otherRP == 0)
		{
			isEnded = true;
			myGui.isEnd("Oh no! The other cat ran away!");
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
		case 5:
			pts = 5;
			break;
		case 6:
			pts = 10;
			break;
		case 7:
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
		
		if (isCaught)
		{
			cl.addCat(otherCat);
			myGui.isEnd("caught the other cat! Congratulations!");
		}
		
		return isCaught;
	}
	
	public void openInv()
	{	
		InventoryGUI window = new InventoryGUI(this, invControl, j);
	}
}


public class FSController {
	private FSGUI myGui;
	private Cat myCat;
	private Cat otherCat;
	private int myRP;
	private int otherRP;
	
	public FSController(Cat cat)
	{
		myCat = cat;
		myRP = myCat.getRP();
		
		otherCat = setOtherCat();
		otherRP = otherCat.getRP();
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
		
		Cat other = new Cat("Tabby", cute, smart, friendly, R); // need a way to randomly generate breed
		
		return other;
	}
	
	public void setRP()
	{
		myGui.setRP(myCat, otherCat);
	}
	
	public void myAttack(String move)
	{
		
	}
	
	public void otherAttack()
	{
		int ran = (int)(Math.random() * 4) + 1;
		
		switch (ran)
		{
			case 1:
				
		}
	}
	
	public void play()
	{
		
	}
}

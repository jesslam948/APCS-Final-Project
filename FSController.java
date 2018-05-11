
public class FSController {
	private FSGUI myGui;
	private Cat myCat;
	
	public FSController(Cat cat)
	{
		myCat = cat;
		Cat other = setOtherCat();
	}

	public void setGui (FSGUI gui)
	{
		myGui = gui;
	}
	
	public Cat setOtherCat()
	{
		int cute = myCat.getCuteness() + (int)(Math.random() * 10);
		int smart = myCat.getIntelligence() + (int)(Math.random() * 10);
		int friendly = myCat.getFriendliness() + (int)(Math.random() * 10);
		int R = myCat.getRP() + (int)(Math.random() * 10);
		
		Cat other = new Cat("Tabby", cute, smart, friendly, R); // need a way to randomly generate breed
		
		return other;
	}
	
	public void setRP()
	{
		
	}
}

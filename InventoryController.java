
public class InventoryController {

	private static int pinkNum;
	private static int greenNum;
	private static int orangeNum;
	private static int fishNum;
	private static int coinNum;
	
	public InventoryController()
	{
		
	}
	
	public int getPink()
	{
		return pinkNum;
	}
	
	public int getGreen()
	{
		return greenNum;
	}

	public int getOrange()
	{
		return orangeNum;
	}
	
	public int getFish()
	{
		return fishNum;
	}
	
	public int getCoin()
	{
		return coinNum;
	}
	
	public void setPink(int newPink)
	{
		pinkNum += newPink;
	}
	
	public void setGreen(int newGreen)
	{
		greenNum += newGreen;
	}

	public void setOrange(int newOrange)
	{
		orangeNum += newOrange;
	}
	
	public void setFish(int newFish)
	{
		fishNum += newFish;
	}
	
	public void setCoin(int newCoin)
	{
		coinNum += newCoin;
	}
	
}

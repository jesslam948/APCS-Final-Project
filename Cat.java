import javax.swing.ImageIcon;
public class Cat {
	private int breed;
	private int cuteness;
	private int intelligence;
	private int friendliness;
	private int RP;
	
	public Cat(int bre, int cute, int smart, int friendly, int R){
		breed = bre;
		cuteness = cute;
		intelligence = smart;
		friendliness = friendly;
		RP = R;
	}
	public int getBreed(){
		return breed;
	}
	public String breedToString(){
		if(breed == 0)
			return "Mottled";
		if(breed == 1)
			return "Black";
		if(breed==2)
			return "Tabby";
		if(breed==3)
			return "White";
		if(breed==4)
			return "Siamese";
		if(breed == 5)
			return "Tuxedo";
		if(breed == 6)
			return "Calico";
		if(breed==7){
			return "Bengal";
		}
		if(breed == 8)
			return "Russian Blue";
		return null;
	}
	
	public ImageIcon getImgIcon(){
		if(breed == 0)
			return new ImageIcon("H:\\MottledCat.png");
		if(breed == 1)
			return new ImageIcon("\\\\dohome5\\home5$\\Student5\\1848534\\blackcat.png");
		if(breed==2)
			return new ImageIcon("\\\\dohome5\\home5$\\Student5\\1848534\\tabbycat.png");
		if(breed==3)
			
		if(breed==4)
			
		if(breed == 5)
			
		if(breed == 6)
			
		if(breed==7){
			
		}
		if(breed == 8){
			
		}
			
		
		return new ImageIcon("H:\\New Folder\\questionmark.png");
	}

	public int getCuteness(){
		return cuteness;
	}
	public int getIntelligence(){
		return intelligence;
	}
	public int getFriendliness(){
		return friendliness;
	}
	public int getRP(){
		return RP;
	}
}

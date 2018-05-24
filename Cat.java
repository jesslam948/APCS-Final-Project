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

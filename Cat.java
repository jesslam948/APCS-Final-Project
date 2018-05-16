public class Cat {
	private String breed;
	private int cuteness;
	private int intelligence;
	private int friendliness;
	private int RP;
	
	public Cat(String bre, int cute, int smart, int friendly, int R){
		breed = bre;
		cuteness = cute;
		friendliness = friendly;
		RP = R;
	}
	/*
	public void doesMove(FightScreen screen, ){
	//communicates to the screen a move
*/
	public String getBreed(){
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
	public void getsHurt(int damage){
		RP -= damage;
	}
	public void usesPotion(Potion potion){
		int p = potion.getRP();
		RP += p;
	}
	public boolean wins(Cat otherCat){
		return (otherCat.getRP() <=0);
	}
	
}

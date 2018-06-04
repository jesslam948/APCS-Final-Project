import java.awt.Image;

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
		if(breed == 0){
			return "Mottled";
		}
		if(breed == 1){
			return "Black";
		}
		if(breed==2){
			return "Tabby";
		}
		if(breed==3){
			return "White";
		}
		if(breed==4){
			return "Siamese";
		}
		if(breed == 5){
			return "Tuxedo";
		}
		if(breed == 6){
			return "Calico";
		}
		if(breed==7){
			return "Bengal";
		}
		if(breed == 8){
			return "Russian Blue";
		}
		return null;
	}
	
	public ImageIcon getImgIcon(JarLoader j, String s){
		ImageIcon mcat;
		if(s.equals("front")){
			if(breed == 0){
				mcat = j.getMottledCat();
			}
			else if(breed == 1){
				mcat = j.getBlackCat();
			}
			else if(breed== 2){
				mcat = j.getTabbyCat();
			}
			else if(breed== 3){
				mcat = j.getWhiteCat();
			}
			else if(breed== 4){
				mcat = j.getSiameseCat();
			}
			else if(breed == 5){
				mcat = j.getTuxedoCat();
			}
			else if(breed == 6){
				mcat = j.getCalicoCat();
			}
			else if(breed==7){
				mcat = j.getTurkishAngoraCat();
			}
			else if(breed == 8){
				mcat = j.getRussianBlueCat();
			}
			else{
				return null;
			}
		}
		else if(s.equals("back")){ // HELLO YOU WILL NEED TO CHANGE THESE TO THE BACK IMAGE
			if(breed == 0){
				mcat = j.getbMottledCat();
			}
			else if(breed == 1){
				mcat = j.getBlackCat();
			}
			else if(breed== 2){
				mcat = j.getTabbyCat();
			}
			else if(breed== 3){
				mcat = j.getWhiteCat();
			}
			else if(breed== 4){
				mcat = j.getSiameseCat();
			}
			else if(breed == 5){
				mcat = j.getTuxedoCat();
			}
			else if(breed == 6){
				mcat = j.getCalicoCat();
			}
			else if(breed==7){
				mcat = j.getTurkishAngoraCat();
			}
			else if(breed == 8){
				mcat = j.getRussianBlueCat();
			}
			else{
				return null;
			}
		}
		else{
			return null;
		}
		Image mcat1 = mcat.getImage();
		Image mcat2 = mcat1.getScaledInstance(500, 600, Image.SCALE_SMOOTH);
		mcat = new ImageIcon (mcat2);
		return mcat;
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
	public int setCuteness(){
		return cuteness;
	}
	public int setIntelligence(){
		return intelligence;
	}
	public int setFriendliness(){
		return friendliness;
	}
	public int setRP(){
		return RP;
	}
}

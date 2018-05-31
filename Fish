

import javax.swing.ImageIcon;
import java.awt.Image;


public class Fish implements Item{
	private int FISH_PRICE;
	private ImageIcon fishPic;
	private int F_INDEX;
	
	public Fish(){
		FISH_PRICE = 5;
		F_INDEX = 0;
		fishPic = new ImageIcon("H:\\New Folder\\fish.png");
		Image fishPic1 = fishPic.getImage();
		Image fishPic2 = fishPic1.getScaledInstance(500, 500, Image.SCALE_SMOOTH);
		fishPic = new ImageIcon (fishPic2);
		
	}
	
	public int getPrice(){
		return FISH_PRICE;
	}
	public ImageIcon getImgIcon(){
		return fishPic;
	}
	public int getIndex(){
		return F_INDEX;
	}
}

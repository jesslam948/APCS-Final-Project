

import javax.swing.*;
import java.io.*;

public class JarLoader {

	private ImageIcon backMottledCat, blackCat, fightScreenBG, whiteCat, tabbyCat, siameseCat, mottledCat, CSBG, statsBG, qMark, oPotion, pPotion, gPotion, fish, menuBG, storeBG, CLBG;
	private ImageIcon turkishCat, tuxedoCat, calicoCat, russianCat;
	private CatList cats;
	
	public JarLoader() {
		ClassLoader cldr = this.getClass().getClassLoader();
		cats = new CatList();
		
		try{
			
			backMottledCat = new ImageIcon(cldr.getResource("backmottledcat.png"));
			CSBG = new ImageIcon(cldr.getResource("pawsbackground.jpg"));
			statsBG = new ImageIcon(cldr.getResource("pawsbackground.jpg"));
			oPotion = new ImageIcon(cldr.getResource("orangepotion.jpg"));
			pPotion = new ImageIcon(cldr.getResource("pinkpotion.jpg"));
			gPotion = new ImageIcon(cldr.getResource("greenpotion.jpg"));
			fish = new ImageIcon(cldr.getResource("fish.png"));
			whiteCat = new ImageIcon(cldr.getResource("whitecat.png"));
			qMark = new ImageIcon(cldr.getResource("questionmark.png"));
			tabbyCat = new ImageIcon(cldr.getResource("tabbycat.png"));
			mottledCat = new ImageIcon(cldr.getResource("mottledcat.png"));
			blackCat = new ImageIcon(cldr.getResource("blackcat.png"));
			siameseCat = new ImageIcon(cldr.getResource("siamesecat.png"));
			fightScreenBG = new ImageIcon(cldr.getResource("fightscreen.jpg"));
			menuBG = new ImageIcon(cldr.getResource("catcafeblue.jpg"));
			CLBG = new ImageIcon(cldr.getResource("catbackground.jpg"));
			storeBG = new ImageIcon(cldr.getResource("cafestore.jpg"));
			turkishCat = new ImageIcon(cldr.getResource("turkishangoracat.png"));
			tuxedoCat = new ImageIcon(cldr.getResource("tuxedocat.png"));
			calicoCat = new ImageIcon(cldr.getResource("calicocat.png"));
			russianCat = new ImageIcon(cldr.getResource("russianbluecat.png"));
			
		}
		catch (Exception e) {
			try{
				PrintStream p = new PrintStream (new FileOutputStream(new File("trace.txt")));
				p.println("works");
				e.printStackTrace(p);
			}
			catch (Exception e1)
			{
			}
		}
	}
	
	public ImageIcon getBlackCat()
	{
		return blackCat;
	}
	
	public ImageIcon getbMottledCat()
	{
		return backMottledCat;
	}
	
	public ImageIcon getfightScreenBG()
	{
		return fightScreenBG;
	}
	public ImageIcon getWhiteCat()
	{
		return whiteCat;
	}
	public ImageIcon getMottledCat(){
		return mottledCat;
	}
	public ImageIcon getTabbyCat(){
		return tabbyCat;
	}
	public ImageIcon getSiameseCat(){
		return siameseCat;
	}
	public ImageIcon getTuxedoCat(){
		return tuxedoCat;
	}
	public ImageIcon getCalicoCat(){
		return calicoCat;
	}
	public ImageIcon getTurkishAngoraCat(){
		return turkishCat;
	}
	public ImageIcon getRussianBlueCat(){
		return russianCat;
	}
	public ImageIcon getCSBG(){
		return CSBG;
	}
	public ImageIcon getStatsBG(){
		return statsBG;
	}
	public ImageIcon getOPotion(){
		return oPotion;
	}
	public ImageIcon getGPotion(){
		return gPotion;
	}
	public ImageIcon getPPotion(){
		return pPotion;
	}
	public ImageIcon getQMark(){
		return qMark;
	}
	public ImageIcon getFish(){
		return fish;
	}
	public ImageIcon getstoreBG(){
		return storeBG;
	}
	public ImageIcon getmenuBG(){
		return menuBG;
	}
	public ImageIcon getCLBG(){
		return CLBG;
	}
	
	public CatList getCatList(){
		return cats;
	}
		
}

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.PaintEvent;

import javax.swing.JLabel;

import net.miginfocom.swing.MigLayout;

//import com.jgoodies.forms.layout.FormLayout;
//import com.jgoodies.forms.layout.ColumnSpec;
//import com.jgoodies.forms.layout.RowSpec;






import javax.swing.SwingConstants;
import javax.swing.JScrollBar;
import javax.swing.ScrollPaneConstants;

import java.awt.Color;
import java.awt.Font;


public class StoreGUI {

	private JFrame frame;
	private JarLoader j;
	private InventoryController invControl;
	private JLabel changeLabel;
	private JTextField num;
	private String focusItem;
	private BackgroundPanel b;
	private JLabel GreenName, PinkName, FishName, OrangeName, Coin;



	/**
	 * Create the application.
	 */
	public StoreGUI(JarLoader loader) {
		j = loader;
		invControl = new InventoryController();
		changeLabel = new JLabel("# of _____");
		num = new JTextField();
		focusItem = null;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		
		frame.setBounds(100, 100, 508, 568);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.getContentPane().setLayout(new MigLayout("", "[grow]", "[grow]"));

		
		ImageIcon imgIc = new ImageIcon("H:\\New Folder\\cafestore.jpg");
		Image img = imgIc.getImage();
		Image newImg = img.getScaledInstance(2000, 2000, Image.SCALE_SMOOTH);//lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH);
		imgIc = new ImageIcon (newImg);
		
		JLabel backgnd = new JLabel(imgIc);
		backgnd.setBounds(0, 0, 3000, 5000);
		frame.setSize(800, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		backgnd.setLayout( new BorderLayout() );
		frame.setContentPane( backgnd );
		

		b = new BackgroundPanel(newImg);
		b.setTransparentAdd(true);
		frame.getContentPane().add(b);
		b.setLayout(null);
		
		
		SClickListener click = new SClickListener(this);

		
		
		
		
		JLabel FishPic = new JLabel("");
		b.add(FishPic);
		
		FishPic.setMinimumSize(new Dimension(40, 40));
		ImageIcon pFish = j.getFish();
		
		Image img1 = pFish.getImage();
		Image newImg1 = img1.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
		pFish = new ImageIcon(newImg1);
		
		FishPic.setIcon(pFish);	
		FishPic.setBounds(1000, 125, 150, 150);
		
		JLabel fPic = new JLabel("");
		newImg1 = img1.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		pFish = new ImageIcon(newImg1);
		fPic.setMinimumSize(new Dimension(40, 40));
		fPic.setIcon(pFish);
		fPic.setBounds(100, 190, 50, 50);
		
		FishName = new JLabel("Fish = " + invControl.getFish());
		b.add(FishName);
		FishName.setFont(new Font("Tahoma", Font.PLAIN, 30));
		FishName.setForeground(new Color(102, 204, 255));
		FishName.setBounds(200, 190, 1000, 50);
		
		
		
		JLabel GreenPic = new JLabel("");
		b.add(GreenPic);
		
		
		GreenPic.setMinimumSize(new Dimension(40, 40));
		ImageIcon pGreen = j.getGPotion();
		
		Image img2 = pGreen.getImage();
		Image newImg2 = img2.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
		pGreen = new ImageIcon(newImg2);
		
		GreenPic.setIcon(pGreen);
		GreenPic.setBounds(1000, 725, 150, 150);
		
		JLabel gPic = new JLabel("");
		newImg2 = img2.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		pGreen = new ImageIcon(newImg2);
		gPic.setMinimumSize(new Dimension(40, 40));
		gPic.setIcon(pGreen);
		gPic.setBounds(100, 790, 50, 50);
		
		GreenName = new JLabel("Catnip juice = " + invControl.getGreen());
		b.add(GreenName);
		GreenName.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GreenName.setForeground(new Color(102, 204, 255));
		GreenName.setBounds(200, 790, 1000, 50);
		
		
		
		
		
		JLabel OrangePic = new JLabel("");
		b.add(OrangePic);
		
		
		OrangePic.setMinimumSize(new Dimension(40, 40));
		ImageIcon pOrange = j.getOPotion();
		Image img3 = pOrange.getImage();
		Image newImg3 = img3.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
		pOrange = new ImageIcon(newImg3);
		OrangePic.setIcon(pOrange);
		OrangePic.setBounds(1000, 525, 150, 150);
		
		JLabel oPic = new JLabel("");
		newImg3 = img3.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		pOrange = new ImageIcon(newImg3);
		oPic.setMinimumSize(new Dimension(40, 40));
		oPic.setIcon(pOrange);
		oPic.setBounds(100, 590, 50, 50);
		
		OrangeName = new JLabel("Cheese juice = " + invControl.getOrange());
		OrangeName.setFont(new Font("Tahoma", Font.PLAIN, 30));
		OrangeName.setForeground(new Color(102, 204, 255));
		b.add(OrangeName);
		OrangeName.setBounds(200, 590, 1000, 50);
		
		
		
		JLabel PinkPic = new JLabel("");
		PinkPic.setBounds(1000, 325, 150, 150);
		b.add(PinkPic);
		
		PinkPic.setMinimumSize(new Dimension(40, 40));
		ImageIcon pPink = j.getPPotion();
		
		Image img4 = pPink.getImage();
		Image newImg4 = img4.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
		pPink = new ImageIcon(newImg4);
		
		PinkPic.setIcon(pPink);
		
		JLabel pPic = new JLabel("");
		newImg4 = img4.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		pPink = new ImageIcon(newImg4);
		pPic.setMinimumSize(new Dimension(40, 40));
		pPic.setIcon(pPink);
		pPic.setBounds(100, 390, 50, 50);
		
		
		PinkName = new JLabel("Salmon juice = " + invControl.getPink());
		PinkName.setFont(new Font("Sylfaen", Font.PLAIN, 40));
		PinkName.setForeground(new Color(102, 204, 255));
		b.add(PinkName);
		PinkName.setBounds(200, 390, 1000, 50);
		
		Coin = new JLabel("Coins = " + invControl.getCoin());
		Coin.setFont(new Font("Sylfaen", Font.PLAIN, 40));
		Coin.setForeground(new Color(102, 204, 255));
		b.add(Coin);
		Coin.setBounds(200, 900, 1000, 50);
		
		
		JButton fishButton = new JButton("Fish");
		fishButton.setBackground(new Color(224, 255, 255));
		fishButton.addActionListener(click);
		fishButton.setBounds(1250, 200, 650, 50);
		
		JLabel fishLabel = new JLabel("This tasty seafood snack will entice any cat to join your party, once their resistance is lowered!");
		fishLabel.setFont(new Font("Sylfaen", Font.PLAIN, 23));
		fishLabel.setForeground(new Color(102, 204, 255));
		fishLabel.setBounds(1000, 200, 1500, 200);
		
		JButton pinkButton = new JButton("Salmon juice");
		pinkButton.setBackground(new Color(224, 255, 255));
		pinkButton.addActionListener(click);
		pinkButton.setBounds(1250, 400, 650, 50);
		
		JLabel pinkLabel = new JLabel("Get these good good salmon oils to increase your cat's fighting spirit! Heals 5 RP.");
		pinkLabel.setFont(new Font("Sylfaen", Font.PLAIN, 25));
		pinkLabel.setForeground(new Color(102, 204, 255));
		pinkLabel.setBounds(1000, 400, 1500, 200);
		
		JButton orangeButton = new JButton("Cheese juice");
		orangeButton.setBackground(new Color(224, 255, 255));
		orangeButton.addActionListener(click);
		orangeButton.setBounds(1250, 600, 650, 50);
		
		JLabel orangeLabel = new JLabel("Modern cats prefer eating cheese to eating mice. Less boney. Heals 10 RP.");
		orangeLabel.setFont(new Font("Sylfaen", Font.PLAIN, 25));
		orangeLabel.setForeground(new Color(102, 204, 255));
		orangeLabel.setBounds(1000, 600, 1500, 200);
		
		JButton greenButton = new JButton("Catnip juice");
		greenButton.setBackground(new Color(224, 255, 255));
		greenButton.addActionListener(click);
		greenButton.setBounds(1250, 800, 650, 50);
		
		JLabel greenLabel = new JLabel("Catnip juice. What more needs to be said? Heals 15 RP.");
		greenLabel.setFont(new Font("Sylfaen", Font.PLAIN, 25));
		greenLabel.setForeground(new Color(102, 204, 255));
		greenLabel.setBounds(1000, 800, 1500, 200);
		
		
		JLabel storeLabel = new JLabel("The Cat Cafe");
		storeLabel.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 70));
		storeLabel.setForeground(new Color(0, 0, 0));
		storeLabel.setBounds(1300, 50, 1500, 100);
		
		JLabel infoLabel = new JLabel("Click on an item, then enter the number you want to buy below.");
		infoLabel.setFont(new Font("Sylfaen", Font.PLAIN, 25));
		infoLabel.setForeground(new Color(0, 0, 0));
		infoLabel.setBounds(1200, 100, 1500, 100);
		
		JLabel invLabel = new JLabel("Inventory");
		invLabel.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 70));
		invLabel.setForeground(new Color(0, 0, 0));
		invLabel.setBounds(100, 50, 1500, 100);
		
		
		num.setBounds(1225, 950, 100, 50);
		
		JLabel buyLabel = new JLabel("Buy ");
		buyLabel.setFont(new Font("Sylfaen", Font.PLAIN, 40));
		buyLabel.setForeground(new Color(102, 204, 255));
		buyLabel.setBounds(1150, 925, 100, 100);
		
		JButton enterButton = new JButton("Check out");
		enterButton.setBackground(new Color(224, 255, 255));
		enterButton.addActionListener(click);
		enterButton.setBounds(1750, 950, 150, 50);
		
		changeLabel.setFont(new Font("Sylfaen", Font.PLAIN, 40));
		changeLabel.setForeground(new Color(102, 204, 255));
		changeLabel.setBounds(1350, 925, 1000, 100);
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(click);
		backButton.setBounds(5, 5, 100, 50);
		
		
		b.add(fishLabel);
		b.add(pinkLabel);
		b.add(orangeLabel);
		b.add(greenLabel);
		b.add(buyLabel);
		b.add(changeLabel);
		b.add(storeLabel);
		b.add(invLabel);
		b.add(oPic);
		b.add(pPic);
		b.add(fPic);
		b.add(gPic);
		b.add(infoLabel);
		
		b.setTransparentAdd(false);
		b.add(fishButton);
		b.add(pinkButton);
		b.add(orangeButton);
		b.add(greenButton);
		b.add(num);
		b.add(enterButton);
		b.add(backButton);
		b.add(Coin);
		
		frame.setVisible(true);
		
	}
	
	//TODO
	public void initFish(){
		changeLabel.setText("# of fish");
		focusItem = "fish";
	}
	public void initPink(){
		changeLabel.setText("# of salmon juice");
		focusItem = "pink";
	}
	public void initOrange(){
		changeLabel.setText("# of cheese juice");
		focusItem = "orange";
	}
	public void initGreen(){
		changeLabel.setText("# of catnip juice");
		focusItem = "green";
	}
	public void buy(){
		String text = num.getText();
		int numberToBuy = Integer.parseInt(text);
		int price = 0;
		if (focusItem.equals("fish")){
			price = numberToBuy * 40;
			if(price > invControl.getCoin()){
				JOptionPane.showMessageDialog(frame, "Not enough coins...");
			}
			else{
				invControl.setFish(numberToBuy);
				invControl.setCoin(-price);
				FishName.setText("Fish = " + invControl.getFish());
				JOptionPane.showMessageDialog(frame, "Purchased!");
			}
			
		}
		else if (focusItem.equals("pink")){
			price = numberToBuy * 15;
			if(price > invControl.getCoin()){
				JOptionPane.showMessageDialog(frame, "Not enough coins...");
			}
			else{
				invControl.setFish(numberToBuy);
				invControl.setCoin(-15 * numberToBuy);
				PinkName.setText("Salmon juice = " + invControl.getPink());
				JOptionPane.showMessageDialog(frame, "Purchased!");
			}
			
		}
		else if (focusItem.equals("orange")){
			price = numberToBuy * 30;
			if(price > invControl.getCoin()){
				JOptionPane.showMessageDialog(frame, "Not enough coins...");
			}
			else{
				invControl.setFish(numberToBuy * numberToBuy);
				invControl.setCoin(-30);
				OrangeName.setText("Cheese juice = " + invControl.getOrange());
				JOptionPane.showMessageDialog(frame, "Purchased!");
			}
			
		}
		else if (focusItem.equals("green")){
			price = numberToBuy * 45;
			if(price > invControl.getCoin()){
				JOptionPane.showMessageDialog(frame, "Not enough coins...");
			}
			else{
				invControl.setFish(numberToBuy);
				invControl.setCoin(-45 * numberToBuy);
				GreenName.setText("Catnip juice = " + invControl.getGreen());
				JOptionPane.showMessageDialog(frame, "Purchased!");
			}
		}
		Coin.setText("Coins = " + invControl.getCoin());
	}
	public void back(){
		MenuGUI mgui = new MenuGUI(j);
		frame.dispose();
	}
}

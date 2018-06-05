import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

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



	/**
	 * Create the application.
	 */
	public StoreGUI(JarLoader loader) {
		j = loader;
		invControl = new InventoryController();
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
		

		BackgroundPanel b = new BackgroundPanel(newImg);
		b.setTransparentAdd(true);
		frame.getContentPane().add(b);
		b.setLayout(null);
		
		
		SClickListener click = new SClickListener(this);

		JLabel CoinNum = new JLabel("Coins: " + invControl.getCoin());
		b.add(CoinNum);
		CoinNum.setBounds(100, 50, 50, 20);
		
		
		
		JLabel FishPic = new JLabel("");
		b.add(FishPic);
		
		FishPic.setMinimumSize(new Dimension(40, 40));
		ImageIcon pFish = j.getFish();
		
		Image img1 = pFish.getImage();
		Image newImg1 = img1.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		pFish = new ImageIcon(newImg1);
		
		FishPic.setIcon(pFish);	
		FishPic.setBounds(100, 100, 40, 40);
		
		JLabel FishName = new JLabel("X " + invControl.getFish());
		b.add(FishName);
		FishName.setBounds(100, 150, 50, 20);
		
		
		
		JLabel GreenPic = new JLabel("");
		b.add(GreenPic);
		
		
		GreenPic.setMinimumSize(new Dimension(40, 40));
		ImageIcon pGreen = j.getGPotion();
		
		Image img2 = pGreen.getImage();
		Image newImg2 = img2.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		pGreen = new ImageIcon(newImg2);
		
		GreenPic.setIcon(pGreen);
		GreenPic.setBounds(100, 180, 40, 40);
		
		JLabel GreenName = new JLabel("X " + invControl.getGreen());
		b.add(GreenName);
		GreenName.setBounds(100, 230, 50, 20);
		
		
		
		JLabel OrangePic = new JLabel("");
		b.add(OrangePic);
		
		
		OrangePic.setMinimumSize(new Dimension(40, 40));
		ImageIcon pOrange = j.getOPotion();
		
		Image img3 = pOrange.getImage();
		Image newImg3 = img3.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		pOrange = new ImageIcon(newImg3);
		
		OrangePic.setIcon(pOrange);
		OrangePic.setBounds(100, 260, 40, 40);
		
		JLabel OrangeName = new JLabel("X " + invControl.getOrange());
		b.add(OrangeName);
		OrangeName.setBounds(100, 310, 50, 20);
		
		
		
		JLabel PinkPic = new JLabel("");
		b.add(PinkPic);
		
		PinkPic.setMinimumSize(new Dimension(40, 40));
		ImageIcon pPink = j.getPPotion();
		
		Image img4 = pPink.getImage();
		Image newImg4 = img4.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		pPink = new ImageIcon(newImg4);
		
		PinkPic.setIcon(pPink);
		PinkPic.setBounds(100, 340, 40, 40);
		
		JLabel PinkName = new JLabel("X " + invControl.getPink());
		b.add(PinkName);
		PinkName.setBounds(100, 390, 50, 20);
		
		
		JButton fishButton = new JButton("Fish");
		fishButton.setBackground(new Color(224, 255, 255));
		fishButton.addActionListener(click);
		fishButton.setBounds(1250, 200, 700, 50);
		
		JLabel fishLabel = new JLabel("This tasty seafood snack will entice any cat to join your party, once their resistance is lowered!");
		fishLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		fishLabel.setForeground(new Color(102, 204, 255));
		fishLabel.setBounds(900, 200, 1500, 200);
		
		JButton pinkButton = new JButton("Salmon juice");
		pinkButton.setBackground(new Color(224, 255, 255));
		pinkButton.addActionListener(click);
		pinkButton.setBounds(1250, 400, 700, 50);
		
		JLabel pinkLabel = new JLabel("Get these good good salmon oils to increase your cat's fighting spirit! Heals 5 RP.");
		pinkLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pinkLabel.setForeground(new Color(102, 204, 255));
		pinkLabel.setBounds(900, 400, 1500, 200);
		
		JButton orangeButton = new JButton("Cheese juice");
		orangeButton.setBackground(new Color(224, 255, 255));
		orangeButton.addActionListener(click);
		orangeButton.setBounds(1250, 600, 700, 50);
		
		JLabel orangeLabel = new JLabel("Modern cats prefer eating cheese to eating mice. Less boney. Heals 10 RP.");
		orangeLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		orangeLabel.setForeground(new Color(102, 204, 255));
		orangeLabel.setBounds(900, 600, 1500, 200);
		
		JButton greenButton = new JButton("Catnip juice");
		greenButton.setBackground(new Color(224, 255, 255));
		greenButton.addActionListener(click);
		greenButton.setBounds(1250, 800, 700, 50);
		
		JLabel greenLabel = new JLabel("Catnip juice. What more needs to be said? Heals 15 RP.");
		greenLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		greenLabel.setForeground(new Color(102, 204, 255));
		greenLabel.setBounds(900, 800, 1500, 200);
		
		
		/*JScrollPane scroll = new JScrollPane();
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(0, 0, 1850, 1000);
		b.add(scroll);
		*/
		
		
		b.add(fishLabel);
		b.add(pinkLabel);
		b.add(orangeLabel);
		b.add(greenLabel);
		
		b.setTransparentAdd(false);
		b.add(fishButton);
		b.add(pinkButton);
		b.add(orangeButton);
		b.add(greenButton);
		frame.setVisible(true);
		
	}
	
	//TODO
//	public void buyFish(){
//		Fish f = new Fish();
//	}
//	public void buyPink(){
//		PinkPotion p = new PinkPotion();
//	}
//	public void buyOrange(){
//		OrangePotion o = new OrangePotion();
//	}
//	public void buyGreen(){
//		GreenPotion g = new GreenPotion();
//	}
//	
	public void delete(){
		frame.dispose();
	}
}

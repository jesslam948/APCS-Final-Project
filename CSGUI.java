import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;


import net.miginfocom.swing.MigLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;

public class CSGUI {

	private JFrame frame;
	JButton tabbyBtn;
	JButton blackBtn;
	JButton mottledBtn;
	Cat mottled;
	Cat black;
	Cat tabby;
	JarLoader j;
	
	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */
	public CSGUI(JarLoader loader) {
		j = loader;
		mottled = new Cat(0,5,5,5,5);
		black = new Cat(1,5,5,5,5);
		tabby = new Cat(2, 5, 5, 5, 5);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setAlwaysOnTop(true);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setBounds(0, 0, 2000, 900);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[grow][grow]", "[900px:n:900px][50px:n,grow][50px:n,grow]"));
		frame.setVisible(true);
		
		///These are the instantiated inventory values///
		
		InventoryController invControl = new InventoryController();
		invControl.setCoin(50);
		invControl.setFish(2);
		invControl.setPink(2);
		invControl.setGreen(2);
		invControl.setOrange(2);
		
		
		ImageIcon imgIc = j.getCSBG();
		
		Image img = imgIc.getImage();
		Image newImg = img.getScaledInstance(2000, 900, Image.SCALE_SMOOTH);
		imgIc = new ImageIcon(newImg);
		
		JLabel backgroundPane = new JLabel();
		backgroundPane.setHorizontalAlignment(SwingConstants.CENTER);
		backgroundPane.setVerticalAlignment(SwingConstants.TOP);
		backgroundPane.setIcon(imgIc);
		backgroundPane.setLayout(null);
		
		frame.setContentPane(backgroundPane);
		
		JPanel pane = new JPanel();
		
		pane.setSize(2000, 1100);
		pane.setOpaque(false);
		backgroundPane.add(pane, "cell 0 0 2 1,alignx center,aligny top");
		pane.setLayout(null);
		

		JLabel lblChooseYourStarter = new JLabel("Choose your starter cat!");
		lblChooseYourStarter.setForeground(new Color(0, 206, 209));
		lblChooseYourStarter.setBounds(600, 127, 795, 129);
		lblChooseYourStarter.setFont(new Font("Matura MT Script Capitals", Font.BOLD, 60));
		pane.add(lblChooseYourStarter);
		
		tabbyBtn = new JButton("Tabby Cat");
		tabbyBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tabbyBtn.setBounds(175, 345, 200, 50);
		tabbyBtn.addActionListener(new CSClickListener());
		pane.add(tabbyBtn);

		
		blackBtn = new JButton("Black Cat");
		blackBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		blackBtn.setBounds(775, 345, 200,50);
		blackBtn.addActionListener(new CSClickListener());
		pane.add(blackBtn);
		
		mottledBtn = new JButton("Mottled Cat");
		mottledBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		mottledBtn.setBounds(1375, 345, 200, 50);
		pane.add(mottledBtn);
		mottledBtn.addActionListener(new CSClickListener());
		
		JLabel tabbyLbl = new JLabel("");
		tabbyLbl.setBounds(50, 267, 500, 600);
		tabbyLbl.setIcon(tabby.getImgIcon(j, "front")); 
		pane.add(tabbyLbl);
		
		JLabel blackLbl = new JLabel("");
		blackLbl.setBounds(650, 267, 500, 600);
		blackLbl.setIcon(black.getImgIcon(j, "front"));
		pane.add(blackLbl);
		
		JLabel mottledCatLabel = new JLabel("");
		mottledCatLabel.setBounds(1250, 267, 500, 600);
		mottledCatLabel.setIcon(mottled.getImgIcon(j, "front"));
		pane.add(mottledCatLabel);

	}
	public void exit(){
		frame.dispose();
	}
	private class CSClickListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent event) {
			if (event.getSource() == mottledBtn){
				Cat cat1 = new Cat(0, 20, 20, 20, 20);
				CatList cl = j.getCatList();
				cl.addCat(cat1);
				System.out.println("Button 1 clicked");
				exit();
				MenuGUI menu = new MenuGUI(j);
				
			}
			if (event.getSource() == blackBtn){
				Cat cat1 = new Cat(1, 20, 20, 20, 20);
				CatList cl = j.getCatList();
				cl.addCat(cat1);
				System.out.println("Button clicked");
				exit();
				MenuGUI menu = new MenuGUI(j);

			}
			if (event.getSource() == tabbyBtn){
				Cat cat1 = new Cat(2, 20, 20, 20, 20);
				CatList cl = j.getCatList();
				cl.addCat(cat1);
				System.out.println("Button 2 clicked");
				exit();
				MenuGUI menu = new MenuGUI(j);

			}
		}
		
	}
}

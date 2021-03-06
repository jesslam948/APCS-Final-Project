import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;

import java.awt.GridBagLayout;

import javax.swing.JButton;

import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import net.miginfocom.swing.MigLayout;


public class InventoryGUI {

	private JFrame frame;
	private FSController fsControl;
	private JarLoader jar;
	private InventoryController invControl;
	private JLabel FishLabel;
	private JLabel OrangeLabel;
	private JLabel GreenLabel;
	private JLabel PinkLabel;

	/**
	 * Create the application.
	 */
	public InventoryGUI(FSController fscon, InventoryController invcon, JarLoader j) {
		fsControl = fscon;
		invControl = invcon;
		jar = j;
		
		initialize();
	}

	public FSController getControl() {
		return fsControl;
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setAutoRequestFocus(true);
		frame.setAlwaysOnTop(true);
		frame.setVisible(true);

		
		frame.getContentPane().setLayout(new MigLayout("", "[50px][50px][50px][50px][50px]", "[25px][25px][25px][20px][25px][25px]"));
		
		JLabel lblNewLabel = new JLabel("INVENTORY");
		frame.getContentPane().add(lblNewLabel, "cell 0 0 5 1,alignx center,aligny center");
		
		
		
		JLabel FishPic = new JLabel("");
		frame.getContentPane().add(FishPic, "cell 0 1,alignx center,aligny center");
		
		FishPic.setMinimumSize(new Dimension(40, 40));
		ImageIcon pFish = jar.getFish();
		
		Image img1 = pFish.getImage();
		Image newImg1 = img1.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		pFish = new ImageIcon(newImg1);
		
		FishPic.setIcon(pFish);
		
		JButton Fish = new JButton("Fish");
		frame.getContentPane().add(Fish, "cell 1 1 1 2,grow");
		
		FishLabel = new JLabel("X " + invControl.getFish());
		FishLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(FishLabel, "cell 0 2,alignx center,aligny center");
		
		
		
		JLabel GreenPic = new JLabel("");
		frame.getContentPane().add(GreenPic, "cell 3 1,alignx center,aligny center");
		
		
		GreenPic.setMinimumSize(new Dimension(40, 40));
		ImageIcon pGreen = jar.getGPotion();
		
		Image img2 = pGreen.getImage();
		Image newImg2 = img2.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		pGreen = new ImageIcon(newImg2);
		
		GreenPic.setIcon(pGreen);
		
		JButton Green = new JButton("Green");
		frame.getContentPane().add(Green, "cell 4 1 1 2,grow");
		
		JLabel GreenLabel = new JLabel("X " + invControl.getGreen());
		GreenLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(GreenLabel, "cell 3 2,alignx center,aligny center");
		
		
		
		JLabel OrangePic = new JLabel("");
		frame.getContentPane().add(OrangePic, "cell 0 4,alignx center,aligny center");
		
		
		OrangePic.setMinimumSize(new Dimension(40, 40));
		ImageIcon pOrange = jar.getOPotion();
		
		Image img3 = pOrange.getImage();
		Image newImg3 = img3.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		pOrange = new ImageIcon(newImg3);
		
		OrangePic.setIcon(pOrange);
		
		JButton Orange = new JButton("Orange");
		frame.getContentPane().add(Orange, "cell 1 4 1 2,grow");
		
		OrangeLabel = new JLabel("X " + invControl.getOrange());
		OrangeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(OrangeLabel, "cell 0 5,alignx center,aligny center");
		
		
		
		JLabel PinkPic = new JLabel("");
		frame.getContentPane().add(PinkPic, "cell 3 4,alignx center,aligny center");
		
		PinkPic.setMinimumSize(new Dimension(40, 40));
		ImageIcon pPink = jar.getPPotion();
		
		Image img4 = pPink.getImage();
		Image newImg4 = img4.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		pPink = new ImageIcon(newImg4);
		
		PinkPic.setIcon(pPink);
		
		JButton Pink = new JButton("Pink");
		frame.getContentPane().add(Pink, "cell 4 4 1 2,grow");
		
		PinkLabel = new JLabel("X " + + invControl.getPink());
		frame.getContentPane().add(PinkLabel, "cell 3 5,alignx center,aligny center");
		
		
		
		InventoryActionListener listen = new InventoryActionListener(this);
		
		Orange.addActionListener(listen);
		Green.addActionListener(listen);
		Pink.addActionListener(listen);
		
	}

	///TODO show msg dialoge to make sure option chosen is wanted + pass action into FSCOntroller and close inventory window + decrease item num
	
	public boolean checkPotion(String potion)
	{
		boolean use = false;
		
		if (potion.equals("Orange") && invControl.getOrange() == 0)
		{
			JOptionPane.showMessageDialog(frame, "You currently don't have any Orange Potions left. You can purchase more at the store.");
			return false;
		}
		else if (potion.equals("Green") && invControl.getGreen() == 0)
		{
			JOptionPane.showMessageDialog(frame, "You currently don't have any Green Potions left. You can purchase more at the store.");
			return false;
		}
		else if (potion.equals("Pink") && invControl.getPink() == 0)
		{
			JOptionPane.showMessageDialog(frame, "You currently don't have any Pink Potions left. You can purchase more at the store.");
			return false;
		}
		
		
		int opt = JOptionPane.showConfirmDialog(frame, "You chose a(n) " + potion + " potion" + "!", "Are you sure you want to use it?", JOptionPane.OK_CANCEL_OPTION);
		
		if (opt == JOptionPane.CANCEL_OPTION)
		{
			use = false;
		}
		else if (opt == JOptionPane.YES_OPTION)
		{
			use = true;
			frame.dispose();
			
			if (potion.equals("Orange"))
				invControl.setOrange(-1);
			else if (potion.equals("Green"))
				invControl.setGreen(-1);
			else
				invControl.setPink(-1);
		}
		
		return use;
	}

}

import java.awt.Dimension;
import java.awt.Image;

import javax.swing.JFrame;

import net.miginfocom.swing.MigLayout;

import javax.swing.JButton;


import javax.swing.JLabel;
import javax.swing.ImageIcon;

import javax.swing.JOptionPane;
import javax.swing.SwingConstants;



import javax.swing.JPanel;


import java.awt.Color;

import javax.swing.JProgressBar;


public class FSGUI {

	private JarPictLoader j;
	private CatList catlist;
	private JFrame frame;
	private FSController myControl;
	private JProgressBar OCatRP;
	private JProgressBar MCatRP;
	private JLabel oRP;
	private JLabel mRP;
	private JButton Move1;
	private JButton Move2;
	private JButton Move3;
	private JButton Move4;
	private JButton Inventory;
	private boolean isDone;
	

	/**
	 * Create the application.
	 */
	public FSGUI(FSController control, JarPictLoader loader, CatList cl) {
		myControl = control;
		j = loader;
		catlist = cl;
		initialize();
		
	}
	
	public FSController getControl()
	{
		return myControl;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setAlwaysOnTop(true);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setBounds(0, 0, 800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[grow][grow]", "[900px:n:900px][50px:n,grow][50px:n,grow]"));
		frame.setVisible(true);
		
		
		isDone = false;
		
		ImageIcon imgIc = j.getfightScreenBG();
		
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
		pane.setLayout(new MigLayout("", "[600px][700px][600px]", "[1px][34px][200px][156px][1px][44px][426px][140px]"));
		
		OCatRP = new JProgressBar();
		OCatRP.setForeground(Color.GREEN);
		pane.add(OCatRP, "cell 2 0 1 2,alignx center,aligny center");
		
		
		JLabel OtherCat = new JLabel("");
		OtherCat.setVerticalAlignment(SwingConstants.BOTTOM);
		OtherCat.setHorizontalAlignment(SwingConstants.CENTER);
		pane.add(OtherCat, "cell 2 1 1 5,alignx center,aligny center");
		
		OtherCat.setMinimumSize(new Dimension(400, 400));
		ImageIcon oCat = j.getBlackCat();
		
		Image img1 = oCat.getImage();
		Image newImg1 = img1.getScaledInstance(400, 400, Image.SCALE_SMOOTH);
		oCat = new ImageIcon (newImg1);
		
		OtherCat.setIcon(oCat);
		
		oRP = new JLabel("");
		pane.add(oRP, "cell 2 0,alignx trailing,aligny center");
		
		
		MCatRP = new JProgressBar();
		MCatRP.setForeground(Color.GREEN);
		pane.add(MCatRP, "cell 0 4 1 2,alignx center,aligny top");
		
		
		JLabel MyCat = new JLabel("");
		MyCat.setHorizontalAlignment(SwingConstants.CENTER);
		pane.add(MyCat, "cell 0 5 1 3,alignx center,aligny top");
		
		MyCat.setMinimumSize(new Dimension(600, 600));
		ImageIcon mCat = j.getbMottledCat();
		
		Image img2 = mCat.getImage();
		Image newImg2 = img2.getScaledInstance(600, 600, Image.SCALE_SMOOTH);
		mCat = new ImageIcon (newImg2);
		
		MyCat.setIcon(mCat);
		
		
		mRP = new JLabel("");
		pane.add(mRP, "cell 0 4,alignx trailing,aligny top");
		
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setBackground(Color.BLACK);
		pane.add(panel, "cell 0 7 3 1,alignx left,aligny center");
		panel.setLayout(new MigLayout("", "[790px][790px][305px]", "[60px][60px][20px]"));
		
		Move1 = new JButton("Move 1");
		panel.add(Move1, "cell 0 0,grow");
		
		Move2 = new JButton("Move 2");
		panel.add(Move2, "cell 0 1,grow");
		
		Move3 = new JButton("Move 3");
		panel.add(Move3, "cell 1 0,grow");
		
		Move4 = new JButton("Move 4");
		panel.add(Move4, "cell 1 1,grow");
		
		Inventory = new JButton("Inventory");
		panel.add(Inventory, "cell 2 0 1 2,grow");
		
		FSActionListener l = new FSActionListener(this);
		
		Move4.addActionListener(l);
		Move3.addActionListener(l);
		Move2.addActionListener(l);
		Move1.addActionListener(l);
		Inventory.addActionListener(l);
	}
	
	public void moveDone(String defender, int action, int pts)
	{
		String actionName = "";
		String cat = "";
		
		switch (action)
		{
		case 1:
			actionName = Move1.getText() + "! - " + pts + "pts!";
			break;
		case 2:
			actionName = Move2.getText() + "! - " + pts + "pts!";
			break;
		case 3:
			actionName = Move3.getText() + "! - " + pts + "pts!";
			break;
		case 4:
			actionName = Move4.getText() + "! - " + pts + "pts!";
			break;
		case 5:
			actionName = "Green" + "! + " + pts + "pts!";
			break;
		case 6:
			actionName = "Orange" + "! + " + pts + "pts!";
			break;
		case 7:
			actionName = "Pink" + "! + " + pts + "pts!";
			break;
		}
		
		if (defender.equals("my"))
			cat = "The other cat used ";
		else
			cat = "You used ";
		
		JOptionPane.showMessageDialog(frame, cat + actionName);
	}
	
	public void setRP(Cat my, Cat other)
	{
		int myRP = my.getRP();
		int otRP = other.getRP();
		
		MCatRP.setMaximum(myRP);
		mRP.setText(myRP + " / " + myRP);
		MCatRP.setValue(myRP);
		
		OCatRP.setMaximum(otRP);
		oRP.setText(otRP + " / " + otRP);
		OCatRP.setValue(otRP);
	}
	
	public void changeRP(String defender, int newRP, int oldRP)
	{
		if (defender.equals("my"))
		{
			mRP.setText(newRP + " / " + oldRP);
			MCatRP.setValue(newRP);
		}
		else
		{
			oRP.setText(newRP + " / " + oldRP);
			OCatRP.setValue(newRP);
		}
	}
	
	public void isEnd(String result)
	{
		JOptionPane.showMessageDialog(frame, "You " + result + "!");
		
		isDone = true;
		
		frame.setVisible(false);
		frame.dispose();
		
		MenuGUI menu = new MenuGUI(catlist, j);
	}
	
	public boolean hasEnded()
	{
		return isDone;
	}
}

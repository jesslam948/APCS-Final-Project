import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;

import net.miginfocom.swing.MigLayout;

import javax.swing.JButton;

import java.awt.Panel;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import java.awt.Toolkit;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

import java.awt.Color;

import javax.swing.JProgressBar;


public class FSGUI {

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
	

	/**
	 * Create the application.
	 */
	public FSGUI(FSController control) {
		myControl = control;
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
		frame.getContentPane().setLayout(new MigLayout("", "[grow][grow]", "[grow][grow][grow]"));
		frame.setVisible(true);
		
		JLayeredPane pane = new JLayeredPane();
		pane.setBorder(null);
		frame.getContentPane().add(pane, "cell 0 0 2 1,grow");
		pane.setLayout(new MigLayout("", "[grow][grow][800.00,grow]", "[15.00,grow][15.00,grow][50.00,grow][250.00,grow][15.00,grow][grow][grow]"));
		
		
		
		OCatRP = new JProgressBar();
		OCatRP.setForeground(Color.GREEN);
		pane.setLayer(OCatRP, 1);
		pane.add(OCatRP, "cell 2 1,alignx center,aligny center");
		
		
		JLabel OtherCat = new JLabel("");
		OtherCat.setHorizontalAlignment(SwingConstants.CENTER);
		pane.setLayer(OtherCat, 2);
		pane.add(OtherCat, "cell 2 2 1 2,alignx center,aligny center");
		
		OtherCat.setMinimumSize(new Dimension(500,500));
		ImageIcon imgIc1 = new ImageIcon("\\\\dohome5\\home5$\\Student5\\1837947\\MottledCat.png");
		
		Image img1 = imgIc1.getImage();
		Image newImg1 = img1.getScaledInstance(500, 500, Image.SCALE_SMOOTH);//lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH);
		imgIc1 = new ImageIcon (newImg1);
		
		OtherCat.setIcon(imgIc1);
		
		oRP = new JLabel("");
		pane.add(oRP, "cell 2 1,alignx trailing,aligny center");
		
		mRP = new JLabel("");
		pane.add(mRP, "cell 0 4,alignx trailing,aligny center");
		
		
		
		JLabel Background = new JLabel("");
		pane.setLayer(Background, 0);
		pane.add(Background, "cell 0 0 3 7,grow");
		Background.setHorizontalAlignment(SwingConstants.CENTER);
		
		Background.setMinimumSize(new Dimension(200,100));
		ImageIcon imgIc = new ImageIcon("\\\\dohome5\\home5$\\Student5\\1837947\\fightscreen.jpg");
		
		Image img = imgIc.getImage();
		Image newImg = img.getScaledInstance(1900, 900, Image.SCALE_SMOOTH);//lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH);
		imgIc = new ImageIcon (newImg);
		
		Background.setIcon(imgIc);
		
		
		
		MCatRP = new JProgressBar();
		MCatRP.setForeground(Color.GREEN);
		pane.setLayer(MCatRP, 1);
		pane.add(MCatRP, "cell 0 4,alignx center,aligny center");
		
		
		JLabel MyCat = new JLabel("My Cat");
		MyCat.setHorizontalAlignment(SwingConstants.CENTER);
		pane.setLayer(MyCat, 2);
		pane.add(MyCat, "cell 0 5 1 2,alignx center,aligny center");
		
		
		
		FSActionListener l = new FSActionListener(this);
		
		Move1 = new JButton("Move 1");
		frame.getContentPane().add(Move1, "cell 0 1,grow");
		Move1.addActionListener(l);
		
		Move2 = new JButton("Move 2");
		frame.getContentPane().add(Move2, "cell 1 1,grow");
		Move2.addActionListener(l);
		
		Move3 = new JButton("Move 3");
		frame.getContentPane().add(Move3, "cell 0 2,grow");
		Move3.addActionListener(l);
		
		Move4 = new JButton("Move 4");
		frame.getContentPane().add(Move4, "cell 1 2,grow");
		Move4.addActionListener(l);
	}
	
	public void moveDone(String defender, int move, int pts)
	{
		String moveName = "";
		String cat = "";
		
		switch (move)
		{
		case 1:
			moveName = Move1.getText() + "! - " + pts + "pts!";
			break;
		case 2:
			moveName = Move2.getText() + "! - " + pts + "pts!";
			break;
		case 3:
			moveName = Move3.getText() + "! - " + pts + "pts!";
			break;
		case 4:
			moveName = Move4.getText() + "! - " + pts + "pts!";
			break;
		}
		
		if (defender.equals("my"))
			cat = "The other cat used ";
		else
			cat = "You used ";
		
		JOptionPane.showMessageDialog(frame, cat + moveName);
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
	
	public void decRP(String defender, int newRP, int oldRP)
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
	}
}

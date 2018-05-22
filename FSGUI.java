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
	private boolean isDone;
	

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
		frame.getContentPane().setLayout(new MigLayout("", "[grow][grow]", "[900px:n:900px][50px:n,grow][50px:n,grow]"));
		frame.setVisible(true);
		
		
		isDone = false;
		
		ImageIcon imgIc = new ImageIcon("\\\\dohome5\\home5$\\Student5\\1837947\\fightscreen.jpg");
		
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
		pane.setLayout(new MigLayout("", "[600px][700px][600px]", "[40px][5][200px][200px][10px][5][200px][210px][100px]"));
		
		OCatRP = new JProgressBar();
		OCatRP.setForeground(Color.GREEN);
		pane.add(OCatRP, "cell 2 0 1 2,alignx center,aligny center");
		
		
		JLabel OtherCat = new JLabel("");
		OtherCat.setVerticalAlignment(SwingConstants.BOTTOM);
		OtherCat.setHorizontalAlignment(SwingConstants.CENTER);
		pane.add(OtherCat, "cell 2 1 1 5,alignx center,aligny center");
		
		OtherCat.setMinimumSize(new Dimension(400, 400));
		ImageIcon imgIc1 = new ImageIcon("\\\\dohome5\\home5$\\Student5\\1837947\\BlackCat.png");
		
		Image img1 = imgIc1.getImage();
		Image newImg1 = img1.getScaledInstance(400, 400, Image.SCALE_SMOOTH);
		imgIc1 = new ImageIcon (newImg1);
		
		OtherCat.setIcon(imgIc1);
		
		oRP = new JLabel("");
		pane.add(oRP, "cell 2 0,alignx trailing,aligny center");
		
		
		MCatRP = new JProgressBar();
		MCatRP.setForeground(Color.GREEN);
		pane.add(MCatRP, "cell 0 4 1 2,alignx center,aligny top");
		
		
		JLabel MyCat = new JLabel("");
		MyCat.setHorizontalAlignment(SwingConstants.CENTER);
		pane.add(MyCat, "cell 0 5 1 3,alignx center,aligny top");
		
		MyCat.setMinimumSize(new Dimension(600, 600));
		ImageIcon imgIc2 = new ImageIcon("\\\\dohome5\\home5$\\Student5\\1837947\\BackMottledCat.png");
		
		Image img2 = imgIc2.getImage();
		Image newImg2 = img2.getScaledInstance(600, 600, Image.SCALE_SMOOTH);
		imgIc2 = new ImageIcon (newImg2);
		
		MyCat.setIcon(imgIc2);
		
		
		mRP = new JLabel("");
		pane.add(mRP, "cell 0 4,alignx trailing,aligny top");
		
		
		JPanel panel = new JPanel();
		pane.add(panel, "cell 0 8 3 1,alignx center,aligny bottom");
		panel.setLayout(new MigLayout("", "[800px][800px][300px]", "[50px][50px]"));
		panel.setOpaque(false);
		
		Move1 = new JButton("Move 1");
		panel.add(Move1, "cell 0 0,grow");
		
		Move2 = new JButton("Move 2");
		panel.add(Move2, "cell 0 1,grow");
		
		Move3 = new JButton("Move 3");
		panel.add(Move3, "cell 1 0,grow");
		
		Move4 = new JButton("Move 4");
		panel.add(Move4, "cell 1 1,grow");
		
		FSActionListener l = new FSActionListener(this);
		
		Move4.addActionListener(l);
		Move3.addActionListener(l);
		Move2.addActionListener(l);
		Move1.addActionListener(l);
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
		
		isDone = true;
	}
	
	public boolean hasEnded()
	{
		return isDone;
	}
}

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

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					FSGUI window = new FSGUI();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public FSGUI(FSController control) {
		myControl = control;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setAlwaysOnTop(true);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setBounds(0, 0, 800, 500);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[grow][grow]", "[grow][grow][grow]"));
		
		
		JLayeredPane pane = new JLayeredPane();
		pane.setBorder(null);
		frame.getContentPane().add(pane, "cell 0 0 2 1, grow");
		pane.setLayout(new MigLayout("", "[grow][grow][grow]", "[15.00,grow][15.00,grow][grow][grow][15.00,grow][grow][grow]"));
		
		
		
		OCatRP = new JProgressBar();
		OCatRP.setForeground(Color.GREEN);
		pane.setLayer(OCatRP, 1);
		pane.add(OCatRP, "cell 0 1,alignx center,aligny center");
		
		
		JLabel OtherCat = new JLabel("Other Cat");
		OtherCat.setHorizontalAlignment(SwingConstants.CENTER);
		pane.setLayer(OtherCat, 2);
		pane.add(OtherCat, "flowx,cell 0 2 1 2,alignx center,aligny center");
		
		oRP = new JLabel("");
		pane.add(oRP, "cell 0 1,alignx trailing,aligny center");
		
		mRP = new JLabel("");
		pane.add(mRP, "cell 2 4,alignx trailing,aligny center");
		
		
		
		JLabel Background = new JLabel("");
		pane.setLayer(Background, 0);
		pane.add(Background, "cell 0 0 3 7,grow");
		Background.setHorizontalAlignment(SwingConstants.CENTER);
		
		Background.setMinimumSize(new Dimension(200,100));
		ImageIcon imgIc = new ImageIcon("\\\\dohome5\\home5$\\Student5\\1837947\\grass.jpg");
		Background.setIcon(imgIc);
		
		Image img = imgIc.getImage();
		Image newImg = img.getScaledInstance(1900, 900, Image.SCALE_SMOOTH);//lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH);
		imgIc = new ImageIcon (newImg);
		
		Background.setIcon(imgIc);
		
		
		
		MCatRP = new JProgressBar();
		MCatRP.setForeground(Color.GREEN);
		pane.setLayer(MCatRP, 1);
		pane.add(MCatRP, "cell 2 4,alignx center,aligny center");
		
		
		JLabel MyCat = new JLabel("My Cat");
		MyCat.setHorizontalAlignment(SwingConstants.CENTER);
		pane.setLayer(MyCat, 2);
		pane.add(MyCat, "cell 2 5 1 2,alignx center,aligny center");
		
		
		
		
		JButton btnMove = new JButton("Move 1");
		frame.getContentPane().add(btnMove, "cell 0 1,grow");
		
		JButton btnMove_1 = new JButton("Move 2");
		frame.getContentPane().add(btnMove_1, "cell 1 1,grow");
		
		JButton btnMove_2 = new JButton("Move 3");
		frame.getContentPane().add(btnMove_2, "cell 0 2,grow");
		
		JButton btnMove_3 = new JButton("Move 4");
		frame.getContentPane().add(btnMove_3, "cell 1 2,grow");
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

}

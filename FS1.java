import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;

import net.miginfocom.swing.MigLayout;

import javax.swing.JButton;

import java.awt.Panel;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import java.awt.Toolkit;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

import java.awt.Color;


public class FS1 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FS1 window = new FS1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FS1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setAlwaysOnTop(true);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setBounds(0, 0, 1950, 1050);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[grow,leading][grow,trailing]", "[grow,top][grow][grow,bottom]"));
		frame.setResizable(false);
		
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Fight Screen", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		frame.getContentPane().add(panel, "cell 0 0 2 1,grow");
		panel.setLayout(new MigLayout("", "[100px:n,grow,leading][100px:n,grow,trailing]", "[100px:n,grow,top]"));
		
		JLabel lblNewLabel = new JLabel("");
		panel.add(lblNewLabel, "cell 0 0 2 1,grow");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblNewLabel.setMinimumSize(new Dimension(200,100));
		ImageIcon imgIc = new ImageIcon("\\\\dohome5\\home5$\\Student5\\1837947\\grass.jpg");
		lblNewLabel.setIcon(imgIc);
		
		Image img = imgIc.getImage();
		Image newImg = img.getScaledInstance(1500, 750, Image.SCALE_SMOOTH);//lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH);
		imgIc = new ImageIcon (newImg);
		
		lblNewLabel.setIcon(imgIc);
		
		JButton btnMove = new JButton("Move 1");
		frame.getContentPane().add(btnMove, "cell 0 1,grow");
		
		JButton btnMove_1 = new JButton("Move 2");
		frame.getContentPane().add(btnMove_1, "cell 1 1,grow");
		
		JButton btnMove_2 = new JButton("Move 3");
		frame.getContentPane().add(btnMove_2, "cell 0 2,grow");
		
		JButton btnMove_3 = new JButton("Move 4");
		frame.getContentPane().add(btnMove_3, "cell 1 2,grow");
	}

}

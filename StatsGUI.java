
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jdesktop.swingx.*;


import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.Color;
import java.awt.Image;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import net.miginfocom.swing.MigLayout;


public class StatsGUI {

	private JFrame frame;
	private JButton btnFight;
	private Cat cat;
	private JarLoader j;
	private CatList cl;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					StatsGUI window = new StatsGUI(new Cat(2, 5, 5, 5, 5));
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
	public StatsGUI(Cat c, JarLoader loader, CatList catlist) {
		j = loader;
		cat = c;
		cl = catlist;
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
		
		ImageIcon imgIc = j.getStatsBG();
		
		Image img = imgIc.getImage();
		Image newImg = img.getScaledInstance(2000, 900, Image.SCALE_SMOOTH);
		imgIc = new ImageIcon(newImg);
		
		JLabel backgroundPane = new JLabel();
		backgroundPane.setHorizontalAlignment(SwingConstants.CENTER);
		backgroundPane.setVerticalAlignment(SwingConstants.TOP);
		backgroundPane.setIcon(imgIc);
		backgroundPane.setLayout(null);
		
		frame.setContentPane(backgroundPane);
		String breed = cat.breedToString();

		JPanel pane = new JPanel();
		
		pane.setSize(2000, 1100);
		pane.setOpaque(false);
		backgroundPane.add(pane, "cell 0 0 2 1,alignx center,aligny top");
		pane.setLayout(null);
		
		JLabel lblStatscatName = new JLabel("Stats(" + breed + ")");
		lblStatscatName.setBounds(645, -219, 613, 600);
		lblStatscatName.setForeground(Color.MAGENTA);
		lblStatscatName.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblStatscatName.setHorizontalAlignment(SwingConstants.CENTER);
		pane.add(lblStatscatName);
		
		JXLabel catLbl = new JXLabel("");
		catLbl.setBounds(652, 149, 592, 726);
		catLbl.setLineWrap(true);
		catLbl.setHorizontalAlignment(SwingConstants.CENTER);
		pane.add(catLbl);
		ImageIcon imgIc1 = cat.getImgIcon(j, "front");
		
		Image img1 = imgIc1.getImage();
		Image newImg1 = img1.getScaledInstance(600, 900, Image.SCALE_SMOOTH);//lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH);
		imgIc1 = new ImageIcon (newImg1);
		catLbl.setIcon(imgIc1); 
		
		btnFight = new JButton("Fight");
		btnFight.setBounds(1676, 353, 119, 81);
		btnFight.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnFight.addActionListener(new StatsClickListener());
		JXLabel lblStats = new JXLabel("Stats\nBreed:" + breed + "\nCuteness:" + cat.getCuteness() + "\nIntelligence:" + cat.getIntelligence() + "\nFriendliness:" + cat.getFriendliness() + "\nMax RP:"+ cat.getRP());
		lblStats.setForeground(Color.GREEN);
		lblStats.setBounds(218, 137, 332, 600);
		lblStats.setLineWrap(true);
		lblStats.setFont(new Font("Tahoma", Font.PLAIN, 32));
		pane.add(lblStats);
		btnFight.setForeground(Color.BLACK);
		btnFight.setBackground(Color.CYAN);
		pane.add(btnFight);
		
	}
	private class StatsClickListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent event) {
			if (event.getSource() == btnFight){
				System.out.print("go to fight GUI");
				frame.dispose();
				FSController con = new FSController(cat, j);
				FSGUI gui = new FSGUI(con, j);
				con.setGui(gui);
			}
		}
		
	}

}



import javax.swing.JFrame;

import java.awt.*;          // access to Container

import javax.swing.*;       // access to JFrame and JComponents

import net.miginfocom.swing.MigLayout;



public class MenuGUI{

	private JFrame frame;
	private JarLoader j;
	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */
	
	
	public MenuGUI(JarLoader loader) {
		j = loader;
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		
		frame.setBounds(100, 100, 508, 568);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[grow]", "[grow]"));
		JLayeredPane pane = new JLayeredPane();
		pane.setBorder(null);
		frame.getContentPane().add(pane, "cell 0 0 2 1,grow");

		
		ImageIcon imgIc = j.getfightScreenBG();
		Image img = imgIc.getImage();
		Image newImg = img.getScaledInstance(2000, 2000, Image.SCALE_SMOOTH);//lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH);
		imgIc = new ImageIcon (newImg);
		
		BackgroundPanel backgnd = new BackgroundPanel(newImg);
		backgnd.setTransparentAdd(true);
		frame.getContentPane().add(backgnd);
		backgnd.setLayout(null);
		
		
		MenuClickListener l = new MenuClickListener(this);
		
		JButton catsButton = new JButton("Cats");
		catsButton.setBounds(900, 400, 200, 100);
		backgnd.add(catsButton);
		catsButton.addActionListener(l);
		
		JButton storeButton = new JButton("Store");
		storeButton.setBounds(900, 500, 200, 100);
		backgnd.add(storeButton);
		storeButton.addActionListener(l);
		
		
	}
	public void cats(){
		CLGUI c = new CLGUI(j);
	}
	public void store(){
		StoreGUI s = new StoreGUI(j);
	}
	
	public void delete(){
		frame.dispose();
	}

	

	

//	private static void addPopup(Component component, final JPopupMenu popup) {
//	}
}

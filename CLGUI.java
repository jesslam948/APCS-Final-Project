import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.Image;


import javax.swing.JLabel;

import net.miginfocom.swing.MigLayout;
import java.awt.Font;



public class CLGUI {

	private JFrame frame;
	private Cat focusCat;
	private CatList catList;
	private JarLoader j;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					CatList window = new CatList();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the application.
	 */
	public CLGUI(JarLoader loader) {
		j = loader;
		catList = j.getCatList();
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
		frame.getContentPane().setLayout(new MigLayout("", "[grow]", "[grow]"));

		
		ImageIcon imgIc = j.getStatsBG();
		Image img = imgIc.getImage();
		Image newImg = img.getScaledInstance(2000, 2000, Image.SCALE_SMOOTH);//lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH);
		imgIc = new ImageIcon (newImg);
		
		JLabel backgnd = new JLabel(imgIc);
		backgnd.setBounds(0, 0, 4000, 5000);
		//frame.getContentPane().add(backgnd, "grow");
		frame.setSize(2000, 2000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		backgnd.setLayout( new BorderLayout() );
		frame.setContentPane( backgnd );
		
		JLabel textLabel = new JLabel("It's your cats!");
		textLabel.setFont(new Font("Tahoma", Font.PLAIN, 50));
		textLabel.setBounds(800, 50, 1500, 100);
		
		
		JLabel mLabel = new JLabel("");
		mLabel.setIcon(catList.getCat(0).getImgIcon(j, "front"));
		
		JLabel bLabel = new JLabel("");
		bLabel.setIcon(catList.getCat(1).getImgIcon(j, "front"));
		
		JLabel tLabel = new JLabel("");
		tLabel.setIcon(catList.getCat(2).getImgIcon(j, "front"));
		
		JLabel wLabel = new JLabel("");
		wLabel.setIcon(catList.getCat(3).getImgIcon(j, "front"));
		
		JLabel sLabel = new JLabel("");
		sLabel.setIcon(catList.getCat(4).getImgIcon(j, "front"));
		
		JLabel tuxLabel = new JLabel("");
		tuxLabel.setIcon(catList.getCat(5).getImgIcon(j, "front"));
		
		JLabel cLabel = new JLabel("");
		cLabel.setIcon(catList.getCat(6).getImgIcon(j, "front"));
		
		JLabel turkLabel = new JLabel("");
		turkLabel.setIcon(catList.getCat(7).getImgIcon(j, "front"));
		
		JLabel rLabel = new JLabel("");
		rLabel.setIcon(catList.getCat(8).getImgIcon(j, "front"));
		
		JLabel blankLabel = new JLabel("");
		ImageIcon blank;
		Image blank1;
		Image blank2;
		blank = j.getQMark();
		blank1 = blank.getImage();
		blank2 = blank1.getScaledInstance(250, 250, Image.SCALE_SMOOTH);
		blank = new ImageIcon (blank2);
		blankLabel.setIcon(blank);
		
		JLabel blankLabel1 = new JLabel("");
		blankLabel1.setIcon(blank);
		JLabel blankLabel2 = new JLabel("");
		blankLabel2.setIcon(blank);
		JLabel blankLabel3 = new JLabel("");
		blankLabel3.setIcon(blank);
		JLabel blankLabel4 = new JLabel("");
		blankLabel4.setIcon(blank);
		JLabel blankLabel5 = new JLabel("");
		blankLabel5.setIcon(blank);
		JLabel blankLabel6 = new JLabel("");
		blankLabel6.setIcon(blank);
		JLabel blankLabel7 = new JLabel("");
		blankLabel7.setIcon(blank);
		JLabel blankLabel8 = new JLabel("");
		blankLabel8.setIcon(blank);
		JLabel blankLabel9 = new JLabel("");
		blankLabel9.setIcon(blank);
		
		
		
		CLClickListener click = new CLClickListener(this);
		
		JButton fightButton = new JButton("Fight!");
		fightButton.addActionListener(click);
		JButton statsButton = new JButton("Stats");
		statsButton.addActionListener(click);
		JButton backButton = new JButton("Back");
		backButton.addActionListener(click);
		JButton mButton = new JButton("Mottled");
		mButton.addActionListener(click);
		JButton bButton = new JButton("Black");
		bButton.addActionListener(click);
		JButton tButton = new JButton("Tabby");
		tButton.addActionListener(click);
		JButton wButton = new JButton("White");
		wButton.addActionListener(click);
		JButton sButton = new JButton("Siamese");
		sButton.addActionListener(click);
		JButton tuxButton = new JButton("Tuxedo");
		tuxButton.addActionListener(click);
		JButton cButton = new JButton("Calico");
		cButton.addActionListener(click);
		JButton turkButton = new JButton("Turkish Angora");
		turkButton.addActionListener(click);
		JButton rButton = new JButton("Russian Blue");
		rButton.addActionListener(click);
		JButton lButton = new JButton("???");
		lButton.addActionListener(click);
		
		
		
		BackgroundPanel b = new BackgroundPanel(newImg);
		b.setTransparentAdd(true);
		frame.getContentPane().add(b);
		b.setLayout(null);
		
		if(catList.getCat(0).getBreed() == -1){
			blankLabel.setBounds(75, 175, 250, 250);
			b.add(blankLabel);
		}
		else{
			mLabel.setBounds(-25, 50, 500, 500);
			b.add(mLabel);
		}
		if(catList.getCat(1).getBreed() == -1){
			blankLabel1.setBounds(475, 175, 250, 250);
			b.add(blankLabel1);
		}
		else{
			bLabel.setBounds(375, 50, 500, 500);
			b.add(bLabel);
		}
		if(catList.getCat(2).getBreed() == -1){
			blankLabel2.setBounds(875, 175, 250, 250);
			b.add(blankLabel2);
		}
		else{
			tLabel.setBounds(775, 50, 500, 500);
			b.add(tLabel);
		}
		if(catList.getCat(3).getBreed() == -1){
			blankLabel3.setBounds(1275, 175, 250, 250);
			b.add(blankLabel3);
		}
		else{
			wLabel.setBounds(1175, 50, 500, 500);
			b.add(wLabel);
		}
		if(catList.getCat(4).getBreed() == -1){
			blankLabel4.setBounds(1675, 175, 250, 250);
			b.add(blankLabel4);
		}
		else{
			sLabel.setBounds(1575, 50, 500, 500);
			b.add(sLabel);
		}
		if(catList.getCat(5).getBreed() == -1){
			blankLabel5.setBounds(75, 550, 250, 250);
			b.add(blankLabel5);
		}
		else{
			tuxLabel.setBounds(-25, 450, 500, 500);
			b.add(tuxLabel);
		}
		if(catList.getCat(6).getBreed() == -1){
			blankLabel6.setBounds(475, 550, 250, 250);
			b.add(blankLabel6);
		}
		else{
			cLabel.setBounds(375, 450, 500, 500);
			b.add(cLabel);
		}
		if(catList.getCat(7).getBreed() == -1){
			blankLabel7.setBounds(875, 550, 250, 250);
			b.add(blankLabel7);
		}
		else{
			turkLabel.setBounds(775, 450, 500, 500);
			b.add(turkLabel);
		}
		if(catList.getCat(8).getBreed() == -1){
			blankLabel8.setBounds(1275, 550, 250, 250);
			b.add(blankLabel8);
		}
		else{
			rLabel.setBounds(1175, 450, 500, 500);
			b.add(rLabel);
		}
		if(catList.getCat(9).getBreed() == -1){
			blankLabel9.setBounds(1675, 550, 250, 250);
			b.add(blankLabel9);
		}
		else{
			
		}
		
		fightButton.setBounds(900, 900, 100, 50);
		b.add(fightButton);
		statsButton.setBounds(1000, 900, 100, 50);
		b.add(statsButton);
		backButton.setBounds(5, 5, 100, 50);
		b.add(backButton);
		
		mButton.setBounds(150, 450, 100, 50);
		b.add(mButton);
		bButton.setBounds(550, 450, 100, 50);
		b.add(bButton);
		tButton.setBounds(950, 450, 100, 50);
		b.add(tButton);
		wButton.setBounds(1350, 450, 100, 50);
		b.add(wButton);
		sButton.setBounds(1750, 450, 100, 50);
		b.add(sButton);
		tuxButton.setBounds(150, 850, 100, 50);
		b.add(tuxButton);
		cButton.setBounds(550, 850, 100, 50);
		b.add(cButton);
		turkButton.setBounds(950, 850, 100, 50);
		b.add(turkButton);
		rButton.setBounds(1350, 850, 100, 50);
		b.add(rButton);
		lButton.setBounds(1750, 850, 100, 50);
		b.add(lButton);
		b.add(textLabel);
		frame.setVisible(true);
		
	}
	public void setCat(int i){
		focusCat = catList.getCat(i);
	}
	public void fight(){
		if(focusCat.getBreed() != -1){
			FSController c = new FSController(focusCat, j);
			FSGUI gui = new FSGUI(c, j);
			c.setGui(gui);
			frame.dispose();
		}
	}
	public void stats(){
		if(focusCat.getBreed() != -1){
			StatsGUI sgui = new StatsGUI(focusCat, j, catList);
			frame.dispose();
		}
	}
	public void back(){
		MenuGUI mgui = new MenuGUI(j);
		frame.dispose();
	}
}

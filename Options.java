import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Options extends JFrame{

	private static final long serialVersionUID = 1L;
	private String backgroundName = "WhiteBack.png";
	private String bgTitle = "White";
	
	public Options(final ChooseDifficulty cd){
		super("Select Background");
		super.setLocationRelativeTo(null);
		
		setIconImage(Constants.ICON.getImage());
		
		JButton circle = new JButton("Circles");
		JButton square = new JButton("Squares");
		JButton shape = new JButton("Shapes");
		JButton heart = new JButton("Hearts");
		JButton star = new JButton("Stars");
		JButton white = new JButton("White");
		JButton black = new JButton("Black");
		JButton blue = new JButton("Blue");
		JButton purple = new JButton("Purple");
		
		JLabel bgLabel = new JLabel(bgTitle);
		JPanel buttonPanel = new JPanel();
		
		buttonPanel.setLayout(new GridLayout(3, 1));
		
		
		addWindowListener(new WindowListener() {

	        @Override
	        public void windowClosing(WindowEvent e) {
	        	
	        }

	        @Override 
	        public void windowOpened(WindowEvent e) {}

	        @Override 
	        public void windowClosed(WindowEvent e) {
	        	cd.setOptionsOpen(false);
	        }

	        @Override 
	        public void windowIconified(WindowEvent e) {}

	        @Override 
	        public void windowDeiconified(WindowEvent e) {}

	        @Override 
	        public void windowActivated(WindowEvent e) {}

	        @Override 
	        public void windowDeactivated(WindowEvent e) {}

	    });
		
		
		ActionListener al = new ActionListener(){
			private Background bg = new Background(false);
			private Unlocks u = new Unlocks();
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equalsIgnoreCase("Circles")){
					if(new Record().getRecord().getWins() > 14 && new Record().getRecord().getRatio() > 0.29 || u.loadUnlocks().isCirclesUnlocked()){
						backgroundName = "\\CircleBack.png";
						bg.setPath(backgroundName);
						bg.setPicture(new ImageIcon(Constants.IMAGES_PATH + backgroundName));
						bg.saveBackground(bg);
						u.setCirclesUnlocked(true);
						u.saveUnlocks(u);
						dispose();
					}else{
						new MessageBox("You must have at least 15 total wins and a ratio of 0.3 to unlock this background", "Requirements");
					}
				}
				if(e.getActionCommand().equalsIgnoreCase("Squares")){
					if(new Record().getRecord().getWins() > 64 && new Record().getRecord().getRatio() > 0.19 && new Record().getRecord().getMediumWins() > 19 && new Record().getRecord().getHardWins() > 4 || u.loadUnlocks().isSquaresUnlocked()){
						backgroundName = "\\SquareBack.png";
						bg.setPath(backgroundName);
						bg.setPicture(new ImageIcon(Constants.IMAGES_PATH + backgroundName));
						bg.saveBackground(bg);
						u.setSquaresUnlocked(true);
						u.saveUnlocks(u);
						dispose();
					}else{
						new MessageBox("You must have at least 65 total wins. Including 20 Medium Wins, 5 hard wins, and a ratio of 0.2 to unlock this background", "Requirements");
					}
				}
				if(e.getActionCommand().equalsIgnoreCase("Shapes")){
					if(new Record().getRecord().getWins() > 149 && new Record().getRecord().getRatio() > 0.09 && new Record().getRecord().getHardWins() > 19 && new Record().getRecord().getMediumWins() > 39 || u.loadUnlocks().isShapesUnlocked()){
						backgroundName = "\\ShapesBack.png";
						bg.setPath(backgroundName);
						bg.setPicture(new ImageIcon(Constants.IMAGES_PATH + backgroundName));
						bg.saveBackground(bg);
						u.setShapesUnlocked(true);
						u.saveUnlocks(u);
						dispose();
					}else{
						new MessageBox("You must have at least 150 total wins. Including 40 medium wins, 20 hard wins, and a ratio of 0.1 to unlock this background", "Requirements");
					}
				}
				if(e.getActionCommand().equalsIgnoreCase("Hearts")){
					if(new Record().getRecord().getWins() > 29 && new Record().getRecord().getRatio() > 0.19 && new Record().getRecord().getEasyWins() > 14 && new Record().getRecord().getMediumWins() > 2 || u.loadUnlocks().isHeartsUnlocked()){
						backgroundName = "\\HeartBack.png";
						bg.setPath(backgroundName);
						bg.setPicture(new ImageIcon(Constants.IMAGES_PATH + backgroundName));
						bg.saveBackground(bg);
						u.setHeartsUnlocked(true);
						u.saveUnlocks(u);
						dispose();
					}else{
						new MessageBox("You must have at least 30 total wins, 3 medium wins, 15 Easy wins, and a ratio of 0.2 to unlock this background", "Requirements");
					}
				}
				if(e.getActionCommand().equalsIgnoreCase("Stars")){
					if(new Record().getRecord().getWins() > 99 && new Record().getRecord().getRatio() > 0.16 && new Record().getRecord().getMediumWins() > 29 && new Record().getRecord().getHardWins() > 9 || u.loadUnlocks().isStarsUnlocked()){
						backgroundName = "\\StarBack.png";
						bg.setPath(backgroundName);
						bg.setPicture(new ImageIcon(Constants.IMAGES_PATH + backgroundName));
						bg.saveBackground(bg);
						u.setStarsUnlocked(true);
						u.saveUnlocks(u);
						dispose();
					}else{
						new MessageBox("You must have at least 100 total wins. Including 30 Medium wins, 10 hard wins and a ratio of 0.17 to unlock this background", "Requirements");
					}
				}
				if(e.getActionCommand().equalsIgnoreCase("White")){
					backgroundName = "\\WhiteBack.png";
					bg.setPath(backgroundName);
					bg.setPicture(new ImageIcon(Constants.IMAGES_PATH + backgroundName));
					bg.saveBackground(bg);
					dispose();
				}
				if(e.getActionCommand().equalsIgnoreCase("Black")){
					backgroundName = "\\BlackBack.png";
					bg.setPath(backgroundName);
					bg.setPicture(new ImageIcon(Constants.IMAGES_PATH + backgroundName));
					bg.saveBackground(bg);
					dispose();
				}
				if(e.getActionCommand().equalsIgnoreCase("Blue")){
					if(new Record().getRecord().getWins() > 4 || u.loadUnlocks().isBlueUnlocked() == true){
						backgroundName = "\\BlueBack.png";
						bg.setPath(backgroundName);
						bg.setPicture(new ImageIcon("Constants.IMAGES_PATH" + backgroundName));
						bg.saveBackground(bg);
						u.setBlueUnlocked(true);
						u.saveUnlocks(u);
						dispose();
					}else{
						new MessageBox("You must have at least 5 total wins to unlock this background", "Requirements");
					}
				}
				if(e.getActionCommand().equalsIgnoreCase("Purple")){
					if(new Record().getRecord().getWins() > 9 || u.loadUnlocks().isPurpleUnlocked()){
						backgroundName = "\\PurpleBack.png";
						bg.setPath(backgroundName);
						bg.setPicture(new ImageIcon(Constants.IMAGES_PATH + backgroundName));
						bg.saveBackground(bg);
						u.setPurpleUnlocked(true);
						u.saveUnlocks(u);
						dispose();
					}else{
						new MessageBox("You must have at least 10 total wins to unlock this background", "Requirements");
					}
				}
			}
			
		};
		
		 circle.addActionListener(al);
		 square.addActionListener(al);
		 shape.addActionListener(al);
		 heart.addActionListener(al);
		 star.addActionListener(al); 
		 white.addActionListener(al);
		 black.addActionListener(al);
		 blue.addActionListener(al);
		 purple.addActionListener(al);
		 
		 buttonPanel.add(white);
		 buttonPanel.add(black);
		 buttonPanel.add(blue);
		 buttonPanel.add(purple);
		 buttonPanel.add(circle);
		 buttonPanel.add(heart);
		 buttonPanel.add(square);
		 buttonPanel.add(star);
		 buttonPanel.add(shape);
		 
		 add(bgLabel);
		 add(buttonPanel);
		 setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		 pack();
		 setResizable(false);
		 setVisible(true);
		 
		 
	}
	
	public String getBackgroundName(){
		return backgroundName;
	}
	
	public String getBackgroundTitle(){
		return bgTitle;
	}
	
	
}

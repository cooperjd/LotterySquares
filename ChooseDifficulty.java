import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ChooseDifficulty extends JFrame{

	private static final long serialVersionUID = 1L;
	private String mode;
	private Options options;
	private String bgName;
	private boolean optionsOpen = false;
	private ChooseDifficulty cd;
	
	public ChooseDifficulty(Dimension d){
		super("Choose Difficulty");
		setSize(d);
		
		cd = this;
		
		super.setLocationRelativeTo(null);
		setResizable(false);
		
		setIconImage(Constants.ICON.getImage());
		
		JButton easyButton = new JButton("Easy");
		JButton mediumButton = new JButton("Medium");
		JButton hardButton = new JButton("Hard");
		JButton optionsButton = new JButton("Background");
		JButton mainMenuButton = new JButton("Main Menu");
		JButton exitButton = new JButton("Exit");
		
		JPanel difficultyPanel = new JPanel();
		JPanel buttonPanel = new JPanel();
		
		difficultyPanel.setLayout(new GridLayout(3,1));
		
		ActionListener al = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(options != null){
					bgName = options.getBackgroundName();
				}
				
				if(e.getActionCommand().equalsIgnoreCase("Easy")){
					mode = "Easy";
					System.out.println("Easy Mode");
					dispose();
					bgName = new Background(false).loadBackground().getPath();
					new Game(mode, bgName);
					if(options != null)
						options.dispose();
					
					try {
						if(MusicController.playing){
							MusicController.stop();
							MusicController.play(1);
						}
					} catch (UnsupportedAudioFileException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					} catch (LineUnavailableException e1) {
						e1.printStackTrace();
					}
				}
					
				if(e.getActionCommand().equalsIgnoreCase("Medium")){
					mode = "Medium";
					System.out.println("Medium Mode");
					dispose();
					bgName = new Background(false).loadBackground().getPath();
					new Game(mode, bgName);
					if(options != null)
						options.dispose();
					
					try {
						if(MusicController.playing){
							MusicController.stop();
							MusicController.play(1);
						}
					} catch (UnsupportedAudioFileException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					} catch (LineUnavailableException e1) {
						e1.printStackTrace();
					}
				}
						
				if(e.getActionCommand().equalsIgnoreCase("Hard")){
					mode = "Hard";
					System.out.println("Hard Mode");
					dispose();
					bgName = new Background(false).loadBackground().getPath();
					new Game(mode, bgName);
					if(options != null)
						options.dispose();
					
					try {
						if(MusicController.playing){
							MusicController.stop();
							MusicController.play(1);
						}
					} catch (UnsupportedAudioFileException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					} catch (LineUnavailableException e1) {
						e1.printStackTrace();
					}
				}
				
				if(e.getActionCommand().equalsIgnoreCase("Main Menu")){
					System.out.println("Main Menu button pressed");
					dispose();
					bgName = new Background(false).loadBackground().getPath();
					new MainMenu();
				}
				
				if(e.getActionCommand().equalsIgnoreCase("Background")){
					System.out.println("Options button pressed");
					if(!optionsOpen){
						optionsOpen = true;
						options = new Options(cd);
					}
				}
				
				if(e.getActionCommand().equalsIgnoreCase("Exit")){
					System.out.println("Exit button pressed");
					System.exit(0);
				}
			}
		};
		
		easyButton.addActionListener(al);
		mediumButton.addActionListener(al);
		hardButton.addActionListener(al);
		mainMenuButton.addActionListener(al);
		exitButton.addActionListener(al);
		optionsButton.addActionListener(al);
		
		difficultyPanel.add(easyButton);
		difficultyPanel.add(mediumButton);
		difficultyPanel.add(hardButton);
		buttonPanel.add(mainMenuButton);
		buttonPanel.add(optionsButton);
		buttonPanel.add(exitButton);
		
		add(difficultyPanel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public String getBGName(){
		if(bgName != null){
			return bgName;
		}
		else
			return "WhiteBack.png";
	}
	
	public void setOptionsOpen(boolean b){
		optionsOpen = b;
	}
}

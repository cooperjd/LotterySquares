import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Game extends JFrame{

	private static final long serialVersionUID = 1L;
	private Gameboard gb;
	private String mode;
	private JLabel redLabel;
	private JLabel blueLabel;
	private JLabel greenLabel;
	private JLabel yellowLabel;
	private JPanel labelComp;
	private JPanel buttonPanel;
	public int squareWidth;
	public int squareHeight;
	
	public Game(final String mode, final String backGround){
		super("Lottery Squares - " + mode);
		super.setSize(800, 830);
		super.setLocationRelativeTo(null);
		setResizable(false);
		setIconImage(Constants.ICON.getImage());
		this.mode = mode;
		
		gb = new Gameboard(this, mode, backGround);
		
		labelComp = new JPanel();
		labelComp.setLayout(new FlowLayout());
		final JPanel gameboardPanel = gb;
		buttonPanel = new JPanel();
		JButton quitButton = new JButton("Quit");
		JButton exitButton = new JButton("Exit");
		
		ActionListener al = new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {				
				if(e.getActionCommand().equals("Quit")){
					System.out.println("Quit button pressed");
					MusicController.stop();
					dispose();
					new MainMenu();
				}
				
				if(e.getActionCommand().equals("Exit")){
					System.out.println("Exit button pressed");
					MusicController.stop();
					System.exit(0);
				}
			}
			
		};
		
		printScores(gb.getScoreKeeper());
		
		quitButton.addActionListener(al);
		exitButton.addActionListener(al);
			
		buttonPanel.add(quitButton);
		buttonPanel.add(labelComp);
		buttonPanel.add(exitButton);
		
		add(gameboardPanel);
		add(buttonPanel, BorderLayout.SOUTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void printScores(ScoreKeeper sk){		
		if(redLabel != null && yellowLabel != null && blueLabel != null && greenLabel != null){
			labelComp.remove(redLabel);
			labelComp.remove(yellowLabel);
			labelComp.remove(greenLabel);
			labelComp.remove(blueLabel);
		}
		
		JLabel newRed = new JLabel("     Red: " + sk.getRedCount() + " / " + sk.getRedLimit() + "     ");
		JLabel newYellow = new JLabel("Yellow: " + sk.getYellowCount() + " / " + sk.getYellowLimit() + "     ");
		JLabel newGreen= new JLabel("Green: " + sk.getGreenCount() + " / " + sk.getGreenLimit() + "     ");
		JLabel newBlue = new JLabel("Blue: " + sk.getBlueCount() + " / " + sk.getBlueLimit() + "     ");
		
		redLabel = newRed;
		yellowLabel = newYellow;
		greenLabel = newGreen;
		blueLabel = newBlue;
		
		labelComp.add(blueLabel);
		labelComp.add(redLabel);
		labelComp.add(yellowLabel);
		labelComp.add(greenLabel);
		
		labelComp.validate();
		buttonPanel.validate();
		validate();
		System.out.println("Changed Labels");
	}
	
	public String getMode(){
		return mode;
	}
}

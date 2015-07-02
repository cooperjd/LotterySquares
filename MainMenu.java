import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainMenu extends JFrame{

	private static final long serialVersionUID = 1L;
	private Record record;
	private JLabel recordLabel;
	private boolean myRecordOpen = false;
	private boolean htpOpen = false;
	private MainMenu mm;
	
	public MainMenu(){
		super("Lottery Squares");
		super.setSize(500, 500);
		super.setLocationRelativeTo(null);
		setResizable(false);
		
		mm = this;
		
		setIconImage(Constants.ICON.getImage());
		JButton playButton = new JButton("Play");
		JButton musicButton = new JButton("Music");
		JButton htpButton = new JButton("How To Play");
		JButton myRecord = new JButton("My Record");
		JButton exitButton = new JButton("Exit");
		final JButton resetRecordBut = new JButton("Reset");
		
		record = getRecord();
		
		recordLabel = new JLabel(record.toString());
		JLabel imageLabel = new JLabel(Constants.ICON);
		JPanel buttonPanel = new JPanel();
		JPanel labelPanel = new JPanel();
		final JPanel recordPanel = new JPanel();
		
		buttonPanel.setLayout(new FlowLayout());
		buttonPanel.add(playButton);
		buttonPanel.add(musicButton);
		buttonPanel.add(htpButton);
		buttonPanel.add(myRecord);
		buttonPanel.add(exitButton);
		
		KeyListener kl = new KeyListener(){

			@Override
			public void keyPressed(KeyEvent arg0) {
				System.out.println("Key pressed");
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_U){
					//THis is code for cassie to change the song. 
					System.out.println("U pressed");
				}
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		};
		
		ActionListener al = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("Play")){
					dispose();
					new ChooseDifficulty(getContentPane().getSize());
					System.out.println("Play Button Pressed.");
				}
				if(e.getActionCommand().equals("Music")){
					if(MusicController.playing){
						MusicController.stop();
					}else{
						try {
							MusicController.play(0);
						} catch (UnsupportedAudioFileException e1) {
							e1.printStackTrace();
						} catch (IOException e1) {
							e1.printStackTrace();
						} catch (LineUnavailableException e1) {
							e1.printStackTrace();
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					System.out.println("Music Button Pressed.");
				}
				if(e.getActionCommand().equalsIgnoreCase("How To Play")){
					System.out.println("HTP Button Pressed.");
					if(!htpOpen){
						htpOpen = true;
						new HowToPlay(mm);
					}
				}
				if(e.getActionCommand().equalsIgnoreCase("Exit")){
					System.out.println("Exit Button Pressed.");
					System.exit(0);
				}
				if(e.getActionCommand().equalsIgnoreCase("Reset")){
					System.out.println("Reset Button Pressed.");
					new Record().newRecord();
					new Unlocks().resetUnlocks();
					recordPanel.remove(recordLabel);
					recordPanel.remove(resetRecordBut);
					record = getRecord();
					recordLabel = new JLabel(record.toString());
					recordPanel.add(recordLabel);
					recordPanel.add(resetRecordBut);
					recordLabel.validate();
					recordPanel.validate();
					validate();
				}
				if(e.getActionCommand().equalsIgnoreCase("My Record")){
					System.out.println("My Record Button Pressed.");
					if(!myRecordOpen){
						myRecordOpen = true;
						new RecordPage(mm);
					}
				}
			}
		};
		
		playButton.addActionListener(al);
		musicButton.addActionListener(al);
		exitButton.addActionListener(al);
		htpButton.addActionListener(al);
		resetRecordBut.addActionListener(al);
		myRecord.addActionListener(al);
		
		labelPanel.add(imageLabel);
		recordPanel.add(recordLabel);
		recordPanel.add(resetRecordBut);
		
		addKeyListener(kl);
		add(recordPanel, BorderLayout.NORTH);
		add(labelPanel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
		try {
			MusicController.play(0);
		} catch (UnsupportedAudioFileException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (LineUnavailableException e1) {
			e1.printStackTrace();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	private Record getRecord(){
		return new Record().getRecord();
	}
	
	public void setMyRecordOpen(boolean b){
		myRecordOpen = b;
	}
	
	public void setHTPOpen(boolean b){
		htpOpen = b;
	}
}

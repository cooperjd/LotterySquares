import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class HowToPlay extends JFrame{
	
	private static final long serialVersionUID = 1L;

	public HowToPlay(final MainMenu mm){
		super("How To Play");
		setSize(500,500);
		super.setLocationRelativeTo(null);
		
		setIconImage(Constants.ICON.getImage());
		
		JButton back = new JButton("Back");
		JLabel blank = new JLabel("   ");
		JLabel title = new JLabel("HOW TO PLAY:");
		JLabel object = new JLabel("OBJECT OF THE GAME: Click the square with the picture of the little girl.");
		JLabel htp = new JLabel("PLAYING THE GAME: Click on a square to reveal its color.");
		JLabel rule1 = new JLabel("RULE #1: Theres a limit to how many times you can select each color.");
		JLabel rule1_2 = new JLabel("Indicated by the second number on the scoreboard.");
		JLabel rule2 = new JLabel("RULE #2: If you pick the little boy you lose immediately.");
		
		JPanel labelPanel = new JPanel();
		labelPanel.setLayout(new GridLayout(5,1));
		title.setFont (title.getFont ().deriveFont (20.0f));
		blank.setFont (blank.getFont ().deriveFont (20.0f));
		object.setFont (object.getFont ().deriveFont (20.0f));
		htp.setFont (htp.getFont ().deriveFont (20.0f));
		rule1.setFont (rule1.getFont ().deriveFont (20.0f));
		rule1_2.setFont (rule1_2.getFont ().deriveFont (20.0f));
		rule2.setFont (rule2.getFont ().deriveFont (20.0f));
		
		addWindowListener(new WindowListener() {

	        @Override
	        public void windowClosing(WindowEvent e) {
	        	
	        }

	        @Override 
	        public void windowOpened(WindowEvent e) {}

	        @Override 
	        public void windowClosed(WindowEvent e) {
	        	mm.setHTPOpen(false);;
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
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equalsIgnoreCase("Back")){
					dispose();
				}
			}
			
		};
		
		back.addActionListener(al);
		
		labelPanel.add(object);
		labelPanel.add(htp);
		labelPanel.add(rule1);
		labelPanel.add(rule1_2);
		labelPanel.add(rule2);
		
		add(title, BorderLayout.NORTH);
		add(labelPanel, BorderLayout.CENTER);
		add(back, BorderLayout.SOUTH);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		pack();
	}
}

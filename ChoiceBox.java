import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class ChoiceBox extends JFrame{	
	private static final long serialVersionUID = 1L;

	public ChoiceBox(String message, String header, int width, int height,final Installer installer){
		super(header);
		setSize(width,height);
		setLocationRelativeTo(null);
		setResizable(false);
		
		JLabel messageL = new JLabel(message);
		JLabel blankLabel = new JLabel("   ");
		
		JButton yesBtn = new JButton("Yes");
		JButton noBtn = new JButton("No");
		
		ActionListener al = new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equalsIgnoreCase("Yes")){
					installer.checkForFiles();
					dispose();
					new MessageBox("Successfully installed Lottery Squares.\nPlease restart the program.", "Install successful");
				}
				
				if(e.getActionCommand().equalsIgnoreCase("No")){
					new MessageBox("You cannot play if you do not install.", "Program Closing");
					System.exit(0);
				}
			}
			
		};
		
		yesBtn.addActionListener(al);
		noBtn.addActionListener(al);
		
		JPanel buttonPanel = new JPanel();
		
		buttonPanel.add(yesBtn);
		buttonPanel.add(blankLabel);
		buttonPanel.add(noBtn);
		
		add(messageL);
		add(buttonPanel, BorderLayout.SOUTH);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
	}
}

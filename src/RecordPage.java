import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class RecordPage extends JFrame{

	private static final long serialVersionUID = 1L;

	public RecordPage(final MainMenu mm){
		super("My Record");
		setSize(200, 200);
		super.setLocationRelativeTo(null);
		
		setIconImage(Constants.ICON.getImage());
		
		NumberFormat formatter = new DecimalFormat("#0.00");
		
		addWindowListener(new WindowListener() {

	        @Override
	        public void windowClosing(WindowEvent e) {
	        	
	        }

	        @Override 
	        public void windowOpened(WindowEvent e) {}

	        @Override 
	        public void windowClosed(WindowEvent e) {
	        	mm.setMyRecordOpen(false);
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
		
		JLabel winLabel = new JLabel("Wins: " + new Record().getRecord().getWins());
		JLabel lossLabel = new JLabel("Losses: " + new Record().getRecord().getLosses());
		JLabel ratioLabel = new JLabel("Ratio: " + formatter.format(new Record().getRecord().getRatio()));
		JLabel ewLabel = new JLabel("Easy Wins: " + new Record().getRecord().getEasyWins());
		JLabel mwLabel = new JLabel("Medium Wins: " + new Record().getRecord().getMediumWins());
		JLabel hwLabel = new JLabel("Hard Wins: " + new Record().getRecord().getHardWins());
		
		winLabel.setFont (winLabel.getFont ().deriveFont (20.0f));
		lossLabel.setFont (lossLabel.getFont ().deriveFont (20.0f));
		ratioLabel.setFont (ratioLabel.getFont ().deriveFont (20.0f));
		ewLabel.setFont (ewLabel.getFont ().deriveFont (20.0f));
		mwLabel.setFont (mwLabel.getFont ().deriveFont (20.0f));
		hwLabel.setFont (hwLabel.getFont ().deriveFont (20.0f));
		
		JPanel labelPanel = new JPanel();
		labelPanel.setLayout(new GridLayout(6,1));
				
		labelPanel.add(winLabel);
		labelPanel.add(lossLabel);
		labelPanel.add(ratioLabel);
		labelPanel.add(ewLabel);
		labelPanel.add(mwLabel);
		labelPanel.add(hwLabel);
		
		add(labelPanel, BorderLayout.CENTER);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		//pack();
	}
}

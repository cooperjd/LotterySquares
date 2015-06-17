import java.io.Serializable;

import javax.swing.JOptionPane;


public class MessageBox implements Serializable{
	
	private static final long serialVersionUID = 1L;

	public MessageBox(String infoMessage, String titleBar){
		 JOptionPane.showMessageDialog(null, infoMessage, titleBar, JOptionPane.INFORMATION_MESSAGE);
	}
}

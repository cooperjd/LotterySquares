import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SquareActionListener extends Square implements ActionListener{

	private static final long serialVersionUID = 1L;
	private Gameboard gb;
	
	public SquareActionListener(int locX, int locY, int indX, int indY, Gameboard gb) {
		super(locX, locY, indX, indY, gb);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Button at: " + getLocX() + " , " + getLocY() + " has been pushed.");
		new EasyScoreKeeper().checkSquares(gb.getSquares());
		if(!isBlack){
			setBackground(Color.BLACK);
			isBlack = true;
		}
		else{
			setBackground(color);
			isBlack = false;
			if(isWinner){
				setIcon(getWinPic());
				infoBox("You won!!! Congratulations!!!", "Winner!");
			}
		}
	}

}

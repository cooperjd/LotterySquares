import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;


public class Square extends JButton{

	private static final long serialVersionUID = 1L;

	private final int DIMENSION = 45;
	
	private ImageIcon winPic = new ImageIcon(Constants.IMAGES_PATH + "\\Cassie1.png");
	private ImageIcon losePic = new ImageIcon(Constants.IMAGES_PATH + "\\GP1.png");
	private int x, y, indX, indY;
	protected Color color;
	protected boolean isChecked = false;
	protected boolean isBlack;
	protected boolean isWinner = false;
	protected boolean isLoser = false;
	private Gameboard gb;
	
	private Color[] colorPallete = new Color[4];
	
	public Square(int locX, int locY, int indX, int indY, final Gameboard gb){
		Dimension d = new Dimension(DIMENSION, DIMENSION);
		this.gb = gb;
		setMinimumSize(d);
		setPreferredSize(d);
		setRandomColor();
		x = locX;
		y = locY;
		this.indX = indX;
		this.indY = indY;
		
		addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Button at: " + getLocX() + " , " + getLocY() + " has been pushed.");
				if(!isBlack){
					setIcon(new ImageIcon(Constants.IMAGES_PATH + gb.getBGName()));
					isBlack = true;
				}
				else{
					setIcon(null);
					setBackground(color);
					isBlack = false;
					gb.getScoreKeeper().checkSquares(gb.getSquares());
					gb.getGameWindow().printScores(gb.getScoreKeeper());
					isChecked = true;
					if(isWinner){
						gb.getLosingSquare().setIcon(losePic);
						setIcon(winPic);
						infoBox("You won!!! Congratulations!!!", "Winner!");
						new Record().setRecord(true, gb.getGameWindow().getMode());
						gb.getGameWindow().dispose();
						new Game(gb.getMode(), gb.getBGName());
						System.out.println("Game Reset");
					}
					else if(gb.getScoreKeeper().hasLost()){
						gb.getWinningSquare().setIcon(winPic);
						gb.getLosingSquare().setIcon(losePic);
						new MessageBox("You chose " + gb.getScoreKeeper().getLoseColor() + " too many times.  You Lose.", "Loser. :-(");
						new Record().setRecord(false, gb.getGameWindow().getMode());
						gb.getGameWindow().dispose();
						new Game(gb.getMode(), gb.getBGName());
						System.out.println("Game Reset");
					}
					else if(isLoser){
						gb.getWinningSquare().setIcon(winPic);
						setIcon(losePic);
						infoBox("You chose the little boy. You Lose.", "Loser. :-(");
						new Record().setRecord(false, gb.getGameWindow().getMode());
						gb.getGameWindow().dispose();
						new Game(gb.getMode(), gb.getBGName());
						System.out.println("Game Reset");
					}
				}
			}	
		}
		);
	}
	
	public ImageIcon getWinPic(){
		return winPic;
	}
	
	public int getLocX(){
		return x;
	}
	
	public int getLocY(){
		return y;
	}
	
	public int getIndX(){
		return indX;
	}
	
	public int getIndY(){
		return indY;
	}
	
	public int getDimensions(){
		return DIMENSION;
	}
	
	public Color getColor(){
		return color;
	}
	
	public static void infoBox(String infoMessage, String titleBar){
		 JOptionPane.showMessageDialog(null, infoMessage, titleBar, JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void setWinner(){
		color = Color.WHITE;
		isWinner = true;
	}
	
	public void setLoser(){
		color = Color.WHITE;
		isLoser = true;
	}
	
	public boolean isChecked(){
		return isChecked;
	}
	
	public boolean isBlack(){
		return isBlack;
	}
	
	public void setIsBlack(boolean b){
		isBlack = b;
	}
	
	private void setRandomColor(){
		colorPallete[0] = Color.RED;
		colorPallete[1] = Color.GREEN;
		colorPallete[2] = Color.YELLOW;
		colorPallete[3] = Color.BLUE;
		
		int colorIndex = probability();
		color = colorPallete[colorIndex];
		
		try{	
		setIcon(new ImageIcon(Constants.IMAGES_PATH + gb.getBGName()));
		}catch(Exception e){
			e.printStackTrace();
		}
		isBlack = true;
	}
	
	private int probability(){
		Random r = new Random();
		int returnInt = 0;
		boolean val1 = r.nextInt(4)==0;
		boolean val2 = r.nextInt(5)==0;
		boolean val3 = r.nextInt(10)==0;
		boolean val4 = r.nextInt(12)==0;
		boolean[] values = {val1, val2, val3, val4};
		for(int i=0; i<values.length; i++){
			if(values[i]){
				returnInt = i;
			}
			else{
				returnInt = r.nextInt(3);
			}
		}
		return returnInt;
	}
	
	@Override
	public String toString(){
		return "[Location= " + getLocX() + " , " + getLocY() + " :: Index= " + getIndY() + " , " + getIndX() + " :: " + color + "]";
	}
}

import java.awt.GridLayout;
import java.util.Random;

import javax.swing.JPanel;

public class Gameboard extends JPanel{

	private static final long serialVersionUID = 1L;
	Square[][] squares;
	Square winningSquare;
	Square losingSquare;
	boolean gameRunning = true;
	private ScoreKeeper sk;
	private Game gameWindow;
	private String backGround;
	private String mode;
	private int amount;
	
	public Gameboard(Game gameWindow, String mode, String backGround){
		this.gameWindow = gameWindow;
		this.backGround = backGround;
		this.mode = mode;
		
		
		System.out.println("Game Mode: " + mode);
		if(mode.equalsIgnoreCase("Easy")){
			amount = 8;
			sk = new EasyScoreKeeper();
			squares = new Square[8][8];
			setLayout(new GridLayout(8,8));
			setupSquares(8,8);
		}
		if(mode.equalsIgnoreCase("Medium")){
			amount = 9;
			sk = new MediumScoreKeeper();
			squares = new Square[9][9];
			setLayout(new GridLayout(9,9));
			setupSquares(9,9);
		}
		if(mode.equalsIgnoreCase("Hard")){
			amount = 10;
			sk = new HardScoreKeeper();
			squares = new Square[10][10];
			setupSquares(10,10);
			setLayout(new GridLayout(10,10));
		}
		setWinningSquare();
		
		
	}
	
	public void setupSquares(int iInd, int jInd){
		int x = 0; int y = 0;
		for(int i = 0; i < iInd; i++){
			if(x > 40*i)
				x =0;
			for(int j = 0; j < jInd; j++){
				if(y > 40*j)
					y = 0;
				squares[i][j] = new Square(x, y, i, j, this);
				add(squares[i][j]);
				squares[i][j].setVisible(true);
				y+=40;
			}
			x+=40;
		}
	}
	
	public Square getWinningSquare(){
		return winningSquare;
	}
	
	public Square getLosingSquare(){
		return losingSquare;
	}
	
	public String getMode(){
		return mode;
	}
	
	public Game getGameWindow(){
		return gameWindow;
	}
	
	public ScoreKeeper getScoreKeeper(){
		return sk;
	}
	
	public Square[][] getSquares(){
		return squares;
	}
	
	public String getBGName(){
		return backGround;
	}
	
	private void setWinningSquare(){
		int index1 = getRandomIndex();
		int index2 = getRandomIndex();
		squares[index1][index2].setWinner();
		winningSquare = squares[index1][index2];
		System.out.println("Winning Sqaure: " + winningSquare);
		
		setLosingSquare();
	}
	
	private void setLosingSquare(){
		int index3 = getRandomIndex();
		int index4 = getRandomIndex();
		if(!squares[index3][index4].isWinner){
			squares[index3][index4].setLoser();
			losingSquare = squares[index3][index4];
			System.out.println("Losing Square: " + losingSquare);
		}
		else{
			setLosingSquare();
		}
	}
	
	private int getRandomIndex(){	
		Random r = new Random();
		int index = r.nextInt(amount);
		return index;
	}
}

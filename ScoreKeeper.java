import java.awt.Color;

public interface ScoreKeeper {
	public void checkSquares(Square[][] squares);
	
	public void colorTest(Color c);
	
	public boolean hasLost();
	
	public void loseGame(String c);
	
	public String getLoseColor();
	
	public int getRedCount();
	
	public int getBlueCount();
	
	public int getGreenCount();
	
	public int getYellowCount();
	
	public int getRedLimit();
	
	public int getYellowLimit();
	
	public int getGreenLimit();
	
	public int getBlueLimit();
}

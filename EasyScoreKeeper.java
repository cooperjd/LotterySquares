import java.awt.Color;


public class EasyScoreKeeper implements ScoreKeeper{
	private int red = 0;
	private int green = 0;
	private int yellow = 0;
	private int blue = 0;
	
	private int BLUE_LIMIT = 10;
	private int RED_LIMIT = 15;
	private int YELLOW_LIMIT = 20;
	private int GREEN_LIMIT = 25;
	
	private boolean lost = false;
	private String loseColor;
	
	public void checkSquares(Square[][] squares){
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				if(!squares[i][j].isBlack() && !squares[i][j].isChecked()){
					colorTest(squares[i][j].getColor());
				}
			}
		}
	}
	
	public void colorTest(Color c){
		if(c.equals(Color.RED)){
			red++;
			if(red == RED_LIMIT)
				loseGame("Red");
		}
		if(c.equals(Color.BLUE)){
			blue++;
			if(blue == BLUE_LIMIT)
				loseGame("Blue");
		}
		if(c.equals(Color.YELLOW)){
			yellow++;
			if(yellow == YELLOW_LIMIT)
				loseGame("Yellow");
		}
		if(c.equals(Color.GREEN)){
			green++;
			if(green == GREEN_LIMIT)
				loseGame("Green");
		}
		
		System.out.println(red + " , " + blue + " , " + yellow + " , " + green);
	}
	
	public boolean hasLost(){
		return lost;
	}
	
	public void loseGame(String c){
		loseColor = c;
		lost = true;
	}
	
	public String getLoseColor(){
		return loseColor;
	}

	@Override
	public int getRedCount() {
		return red;
	}

	@Override
	public int getBlueCount() {
		return blue;
	}

	@Override
	public int getGreenCount() {
		return green;
	}

	@Override
	public int getYellowCount() {
		return yellow;
	}
	
	@Override
	public int getRedLimit() {
		// TODO Auto-generated method stub
		return RED_LIMIT;
	}

	@Override
	public int getYellowLimit() {
		// TODO Auto-generated method stub
		return YELLOW_LIMIT;
	}

	@Override
	public int getGreenLimit() {
		// TODO Auto-generated method stub
		return GREEN_LIMIT;
	}

	@Override
	public int getBlueLimit() {
		// TODO Auto-generated method stub
		return BLUE_LIMIT;
	}
}

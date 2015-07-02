import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;


public class Unlocks implements Serializable{
	private static final long serialVersionUID = -2545916310423392515L;
	private boolean circlesUnlocked = false;
	private boolean squaresUnlocked = false;
	private boolean blueUnlocked = false;
	private boolean shapesUnlocked = false;
	private boolean purpleUnlocked = false;
	private boolean starsUnlocked = false;
	private boolean heartsUnlocked = false;
	
	public boolean isCirclesUnlocked() {
		return circlesUnlocked;
	}

	public void setCirclesUnlocked(boolean circlesUnlocked) {
		this.circlesUnlocked = circlesUnlocked;
	}

	public boolean isSquaresUnlocked() {
		return squaresUnlocked;
	}

	public void setSquaresUnlocked(boolean squaresUnlocked) {
		this.squaresUnlocked = squaresUnlocked;
	}

	public boolean isBlueUnlocked() {
		return blueUnlocked;
	}

	public void setBlueUnlocked(boolean blueUnlocked) {
		this.blueUnlocked = blueUnlocked;
	}

	public boolean isShapesUnlocked() {
		return shapesUnlocked;
	}

	public void setShapesUnlocked(boolean shapesUnlocked) {
		this.shapesUnlocked = shapesUnlocked;
	}

	public boolean isPurpleUnlocked() {
		return purpleUnlocked;
	}

	public void setPurpleUnlocked(boolean purpleUnlocked) {
		this.purpleUnlocked = purpleUnlocked;
	}

	public boolean isStarsUnlocked() {
		return starsUnlocked;
	}

	public void setStarsUnlocked(boolean starsUnlocked) {
		this.starsUnlocked = starsUnlocked;
	}

	public boolean isHeartsUnlocked() {
		return heartsUnlocked;
	}

	public void setHeartsUnlocked(boolean heartsUnlocked) {
		this.heartsUnlocked = heartsUnlocked;
	}

	public void resetUnlocks(){		
		try{
			PrintWriter pw = new PrintWriter(Constants.UNLOCKS_FILE);
			pw.write(" ");
			pw.close();
			
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(Constants.UNLOCKS_FILE));
			oos.writeObject(new Unlocks());
			System.out.println("Unlocks Reset");
			oos.close();
		}catch(FileNotFoundException fnfe){
			fnfe.printStackTrace();
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
	}
	
	public void saveUnlocks(Unlocks u){
		try{
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(Constants.UNLOCKS_FILE));
			oos.writeObject(u);
			System.out.println("Unlocks Saved");
			oos.close();
		}catch(FileNotFoundException fnfe){
			fnfe.printStackTrace();
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
	}
	
	public Unlocks loadUnlocks(){
		Unlocks u = null;
		
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(Constants.UNLOCKS_FILE));
			u = (Unlocks) ois.readObject();
			ois.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return u;
	}
}

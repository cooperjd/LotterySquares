import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.NumberFormat;


public class Record implements Serializable{

	private static final long serialVersionUID = 1L;
	private int wins;
	private int losses;
	private int easyWins;
	private int mediumWins;
	private int hardWins;
	
	public Record(){
		wins = 0;
		losses = 0;
		easyWins = 0;
		mediumWins = 0;
		hardWins = 0;
	}
	
	private void won(String mode){
		wins++;
		if(mode.equalsIgnoreCase("Easy")){
			System.out.println("Easy Win");
			easyWins++;
		}
		if(mode.equalsIgnoreCase("Medium")){
			System.out.println("Medium Win");
			mediumWins++;
		}
		if(mode.equalsIgnoreCase("Hard")){
			System.out.println("Hard Win");
			hardWins++;
		}
	}
	
	private void lost(){
		losses++;
	}
	
	public int getWins(){
		return wins;
	}
	
	public int getEasyWins(){
		return easyWins;
	}
	
	public int getMediumWins(){
		return mediumWins;
	}
	
	public int getHardWins(){
		return hardWins;
	}
	
	public int getLosses(){
		return losses;
	}
	
	public double getRatio(){
		if(losses == 0)
			return wins;
		else{
			double ratio = (double) wins/(double) losses;
			return ratio;
		}
	}
	
	public String toString(){
		NumberFormat formatter = new DecimalFormat("#0.00");
		return "[Wins: " + wins + " - Losses: " + losses + " - Ratio: " + formatter.format(getRatio()) + "]";
		
	}
	
	public synchronized void newRecord(){
		try {
			PrintWriter pw = new PrintWriter(Constants.RECORD_FILE);
			pw.write(" ");
			pw.close();
			try{
				Record newRecord = new Record();
				FileOutputStream fout = new FileOutputStream(Constants.RECORD_FILE);
				ObjectOutputStream oos = new ObjectOutputStream(fout);   
				oos.writeObject(newRecord);
				oos.close();
				System.out.println("Record Saved");
			}
			catch(Exception e){
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void setRecord(boolean b, String mode){
		try{
			Record record = getRecord(); 
			if(b)
				record.won(mode);
			else
				record.lost();
			
			FileOutputStream fout = new FileOutputStream(Constants.RECORD_FILE);
			ObjectOutputStream oos = new ObjectOutputStream(fout);   
			oos.writeObject(record);
			oos.close();
			System.out.println("Record Saved");
	 
		   }catch(Exception ex){
			   ex.printStackTrace();
		   }
	}
	
	public Record getRecord(){
		 try{
			   FileInputStream fin = new FileInputStream(Constants.RECORD_FILE);
			   ObjectInputStream ois = new ObjectInputStream(fin);
			   Record myRecord = (Record) ois.readObject();
			   ois.close();
			   System.out.println("retrived record" + myRecord);
			   return myRecord;
	 
		   }catch(Exception ex){
			   ex.printStackTrace();
			   return null;
		   }
	}
}

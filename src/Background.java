import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.ImageIcon;


public class Background implements Serializable{

	private static final long serialVersionUID = 1L;
	private static String path;
	private static ImageIcon picture;
	
	public Background(boolean b){
		if(b){
			path = "WhiteBack.png";
			picture = new ImageIcon(Constants.MAIN_PATH + path);
		}
	}
	
	public String getPath() {
		return path;
	}

	public ImageIcon getPicture() {
		return picture;
	}
	
	public void setPath(String path) {
		Background.path = path;
	}

	public void setPicture(ImageIcon picture) {
		Background.picture = picture;
	}
	
	public String toString(){
		return "[Path: " + path + " - Picture: " + picture + "]";
	}
	
	public void saveBackground(Background bg){	
		try{
			FileOutputStream fos = new FileOutputStream(Constants.BACKGROUND_FILE);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(bg);
			oos.close();
		}catch(FileNotFoundException fnfe){
			fnfe.printStackTrace();
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
		
		System.out.println("Background Saved");
	}
	
	public Background loadBackground(){
		Background bg = null;
		try {
			FileInputStream fis = new FileInputStream(Constants.BACKGROUND_FILE);
			ObjectInputStream ois = new ObjectInputStream(fis);
			bg = (Background) ois.readObject();
			ois.close();
		} catch (FileNotFoundException e) {
			//new MessageBox("File Not Found Exception" , "Error");
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} catch (IOException e) {
			//new MessageBox("IO Exception" , "Error");
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			//new MessageBox("Class Not Found Exception" , "Error");
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		return bg;
	}
}

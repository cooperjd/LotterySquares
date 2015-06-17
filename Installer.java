import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;

import javax.imageio.stream.FileImageInputStream;
import javax.imageio.stream.FileImageOutputStream;
import javax.imageio.stream.ImageInputStream;
import javax.imageio.stream.ImageOutputStream;


public class Installer {
	public boolean filesChecked;
	
	public Installer(){
		filesChecked = false;
	}
	
	public void checkForFiles(){
		
		File[] files = {Constants.RECORD_FILE, Constants.BACKGROUND_FILE, Constants.UNLOCKS_FILE};

		try {
			Files.createDirectory(Constants.MAIN_PATH);
			Files.createDirectory(Constants.IMAGES_PATH);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String downloadedFilePath = System.getProperty("user.dir") + "\\Images";
		
		 File dir = new File(downloadedFilePath);
		  File[] directoryListing = dir.listFiles();
		  if (directoryListing != null) {
		    for (File child : directoryListing) {
		       try {
				copyFiles(downloadedFilePath + "\\" + child.getName(), child.getName());
			} catch (IOException e) {
				e.printStackTrace();
			}
		    }
		  } else {
		    new MessageBox("Some files are missing. Please download Lottery Squares again.","Error!");
		  }
		
		for(File file :  files){
			if(!file.exists() && !file.isDirectory()) { 
				file.getParentFile().mkdirs(); 
				try {
					file.createNewFile();
					if(file.equals(files[0])){
						new Record().newRecord();
					}
					if(file.equals(files[1])){
						Background bg = new Background(true);
						bg.saveBackground(bg);
					}
					if(file.equals(files[2])){
						new Unlocks().resetUnlocks();
					}
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		filesChecked = true;
	}
	
	private void copyFiles(String downloadedFilePath, String nameOfCopy) throws FileNotFoundException, IOException{
		
		File copy = new File(Constants.IMAGES_PATH + "\\" + nameOfCopy);
		File original = new File(downloadedFilePath);
				
		ImageInputStream in = new FileImageInputStream(original);
		ImageOutputStream out= new FileImageOutputStream(copy);


		// Transfer bytes from in to out
		byte[] buf = new byte[1024];
		int len;
		while ((len = in.read(buf)) > 0) {
		out.write(buf, 0, len);
		}
		in.close();
		out.close();
	}
}

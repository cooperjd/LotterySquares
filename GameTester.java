import java.nio.file.Files;

public class GameTester {
	
	public static void main(String[] args) { 
		
		Installer installer = new Installer();
		if(!Files.exists(Constants.MAIN_PATH)){
			new ChoiceBox("Do you want to install Lottery Squares on this computer?", "Install??", 350, 150, installer);
		}else
			installer.filesChecked = true;
		
		if(installer.filesChecked)
			new MainMenu();
	}
}

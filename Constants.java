import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.ImageIcon;


public class Constants {
	public static Path MAIN_PATH = Paths.get("C:\\Lottery Squares");
	public static Path IMAGES_PATH = Paths.get("C:\\Lottery Squares\\Images");
	public static Path SOUNDS_PATH = Paths.get("C:\\Lottery Squares\\sounds");
	public static File RECORD_FILE = new File("C:" + File.separator + "Lottery Squares" + File.separator + "data.bin");
	public static File BACKGROUND_FILE = new File("C:" + File.separator + "Lottery Squares" + File.separator + "background.bin");
	public static File UNLOCKS_FILE = new File("C:"+ File.separator + "Lottery Squares" + File.separator + "uls.bin");
	public static ImageIcon ICON = new ImageIcon("C:\\Lottery Squares\\Images\\SquaresImage.png");
}

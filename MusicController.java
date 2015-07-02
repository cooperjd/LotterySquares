import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


public class MusicController {
	public static Clip clip;
	public static boolean playing = true;
	private static String bgsong1 = "\\bgSong5.wav";
	private static String bgsong2 = "\\bgSong.wav";
	
	public static void play(int trackNumber) throws UnsupportedAudioFileException, IOException, LineUnavailableException{
		clip = AudioSystem.getClip();
		AudioInputStream inputStream;
		if(trackNumber == 1){
			inputStream = AudioSystem.getAudioInputStream(new BufferedInputStream(new FileInputStream(Constants.SOUNDS_PATH + bgsong2)));
		}else{
			inputStream = AudioSystem.getAudioInputStream(new BufferedInputStream(new FileInputStream(Constants.SOUNDS_PATH + bgsong1)));
		}
		clip.open(inputStream);
        clip.start();
        playing = true;
		System.out.println("Starting music...");
	}
	
	public static void stop(){
		clip.stop();
		playing = false;
	}
}

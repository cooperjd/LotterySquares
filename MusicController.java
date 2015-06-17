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
	
	public static void play() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
		clip = AudioSystem.getClip();
        AudioInputStream inputStream = AudioSystem.getAudioInputStream(new BufferedInputStream(new FileInputStream(Constants.SOUNDS_PATH + "\\bgSong.wav")));
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

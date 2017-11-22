package finalproject2;

import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class sound {
	private Clip clip;
	
	sound(File sound)
	{
		
		try
	    {
	        clip = AudioSystem.getClip();
	       	clip.open(AudioSystem.getAudioInputStream(sound));
	    }
	    catch (Exception exc)
	    {
	        exc.printStackTrace(System.out);
	    }
		startmusic();
	}
	
	public void startmusic(){
       	clip.start();
	}
	public void stopmusic(){
       	clip.stop();
	}
	
}


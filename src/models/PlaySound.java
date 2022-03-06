package models;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.BufferedInputStream;
import java.io.InputStream;

/**
 * This class is for creating the sound that generates when an enemy dies or a Tower shoots
 */
public class PlaySound {
    private Clip clip;
    private AudioInputStream inputStream;

    public PlaySound(){
        try{
            clip = AudioSystem.getClip();
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * This method is a help function for playing a sound
     */
    private void play(){
        try {
            clip.open(inputStream);
            clip.start();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * This method plays a shooting sound
     */
    public void playShot1(){
        try{
            InputStream stream = new BufferedInputStream(getClass().getResourceAsStream("/shot1.wav"));
            inputStream = AudioSystem.getAudioInputStream(stream);
            play();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * This method plays a dying sound
     */
    public void playDeath1(){
        try{
            InputStream stream = new BufferedInputStream(getClass().getResourceAsStream("/death1.wav"));
            inputStream = AudioSystem.getAudioInputStream(stream);
            play();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}

package models;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class PlaySound {
    Clip clip;
    AudioInputStream inputStream;

    public PlaySound(){
        try{
            clip = AudioSystem.getClip();


        } catch(Exception e){

        }
    }

    public void play(){
        try {
            clip.open(inputStream);
            clip.start();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void playShot1(){
        try{
            inputStream = AudioSystem.getAudioInputStream(getClass().getResourceAsStream("/shot1.wav"));
            play();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void playDeath1(){
        try{
            inputStream = AudioSystem.getAudioInputStream(getClass().getResourceAsStream("/death1.wav"));
            play();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

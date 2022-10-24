package com.halloween.view;

import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.FloatControl.Type;

public class PlayMusic {

  private Clip clip;
  private FloatControl musicVolume;

  public void play(String musicName) {
    try {

      // get the url path for our music
      URL url = getClass().getResource(musicName);

      if (url != null) {
        // NOTE: Audio input stream can take a URL, file, or string
        AudioInputStream audioInput = AudioSystem.getAudioInputStream(url);
        clip = AudioSystem.getClip();
        clip.open(audioInput);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
        // set the music volume
        musicVolume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        musicVolume.setValue(-20.0f);
        // start the music
        clip.start();

      } else {
        System.out.println("Can't find file");
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  public void stop() {
    clip.stop();
  }

  public void increaseVolume() {
    try {
      musicVolume.setValue(musicVolume.getValue() + 10.0f);
    } catch(IllegalArgumentException ex){
      ex.printStackTrace();
    }
  }

  public void decreaseVolume() {
    try {
      musicVolume.setValue(musicVolume.getValue() - 10.0f);
    } catch (IllegalArgumentException ex) {
      ex.printStackTrace();
    }
  }

}
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

      // String temp = url.getPath();
      // String music = temp.replace("%20", " ");
      //System.out.println(music);
      // File musicPath = new File(music);

      if (url != null) {
        // NOTE: Audio input stream can take a URL, file, or string
        AudioInputStream audioInput = AudioSystem.getAudioInputStream(url);
        clip = AudioSystem.getClip();
        clip.open(audioInput);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
        clip.start();

        // set the music volume
        musicVolume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        //System.out.println("Current volume: " + musicVolume.getValue());
        musicVolume.setValue(-20.0f);
        //System.out.println("Current volume: " + musicVolume.getValue());
        //System.out.println("Max volume: " + musicVolume.getMaximum());
        //System.out.println("Min volume: " + musicVolume.getMinimum());

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

//  public static void main(String[] args) {
//    PlayMusic playMusic = new PlayMusic();
//
//
//    // String musicName = "/main_combat.wav";
//    // String musicName = "/darkess.wav";
//    String musicName = "/losing-oneself.wav";
//
//    playMusic.play(musicName);
//
//
//    while (true) {
//      //System.out.println("hello");
//    }
//
//  }
}
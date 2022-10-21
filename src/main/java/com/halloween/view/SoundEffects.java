package com.halloween.view;

import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class SoundEffects {

  private static Clip clip;
  private static FloatControl soundVolume;

  public static void playSound(String soundName) {
    try {

      // get the url path for our sound effect
      URL url = SoundEffects.class.getResource(soundName);

      if (url != null) {

        // NOTE: Audio input stream can take a URL, file, or string
        AudioInputStream audioInput = AudioSystem.getAudioInputStream(url);
        clip = AudioSystem.getClip();
        clip.open(audioInput);
        clip.start();

        // set the sound volume
        soundVolume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        soundVolume.setValue(-10.0f);

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
      soundVolume.setValue(soundVolume.getValue() + 10.0f);
    } catch(IllegalArgumentException ex){
      ex.printStackTrace();
    }
  }

  public void decreaseVolume() {
    try {
      soundVolume.setValue(soundVolume.getValue() - 10.0f);
    } catch (IllegalArgumentException ex) {
      ex.printStackTrace();
    }
  }

  public static void main(String[] args) {
    PlayMusic playMusic = new PlayMusic();


    // String musicName = "/main_combat.wav";
    // String musicName = "/darkess.wav";
    // String musicName = "/losing-oneself.wav";
    String knock = "/door-knock.wav";
    String bubbles = "/bubbles.wav";
    String scream = "/scream.wav";
    String evil_shreik = "/evil-shreik.wav";
    String witch = "/witch.wav";
    String police = "/police-siren.wav";
    String girl_scream = "/girl_scream.wav";

    //playMusic.play(knock);
//    playSound(knock);
//    playSound(bubbles);
//    playSound(scream);
//    playSound(evil_shreik);
//    playSound(witch);
//    playSound(police);
//    playSound(girl_scream);

    playSound("/footsteps.wav");


    while (true) {
      //System.out.println("hello");
    }

  }
}
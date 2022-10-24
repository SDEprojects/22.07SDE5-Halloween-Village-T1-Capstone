package com.halloween.view;

import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class SoundEffects {

  private static Clip clip;
  private static FloatControl soundVolumeControl;
  private static float soundVolume = (-10.0f);
  private static float minSoundVolume = (-80.0f);

  public static void playSound(String soundName) {
    try {

      // get the url path for our sound effect
      URL url = SoundEffects.class.getResource(soundName);

      if (url != null) {

        // NOTE: Audio input stream can take a URL, file, or string
        AudioInputStream audioInput = AudioSystem.getAudioInputStream(url);
        clip = AudioSystem.getClip();
        clip.open(audioInput);

        // set the sound volume
        soundVolumeControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        soundVolumeControl.setValue(soundVolume);

        clip.start();

      } else {
        System.out.println("Can't find file");
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  public static void muteSoundEffects() {
    try {
      soundVolume = (-80.0f);
      soundVolumeControl.setValue(soundVolume);
    } catch (IllegalArgumentException ex) {
      ex.printStackTrace();
    }
  }

  public static void unmuteSoundEffects() {
    try {
      soundVolume = (-10.0f);
      soundVolumeControl.setValue(soundVolume);
    } catch (IllegalArgumentException ex) {
      ex.printStackTrace();
    }
  }

  public void increaseVolume() {
    try {
      soundVolumeControl.setValue(soundVolumeControl.getValue() + 10.0f);
    } catch(IllegalArgumentException ex){
      ex.printStackTrace();
    }
  }

  public void decreaseVolume() {
    try {
      soundVolumeControl.setValue(soundVolumeControl.getValue() - 10.0f);
    } catch (IllegalArgumentException ex) {
      ex.printStackTrace();
    }
  }
}
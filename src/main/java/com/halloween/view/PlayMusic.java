package com.halloween.view;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.lang.management.PlatformLoggingMXBean;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class PlayMusic {


  public void play(String musicName) {
    try {

      URL url = getClass().getResource(musicName);
      String temp = url.getPath();
      String music = temp.replace("%20", " ");
      System.out.println(music);
      File musicPath = new File(music);

      if (musicPath.exists()) {
        AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
        Clip clip = AudioSystem.getClip();
        clip.open(audioInput);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
        clip.start();
      } else {
        System.out.println("Can't find file");
      }
    } catch (Exception ex) {
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
//      System.out.println("hello");
//    }
//
//  }
}
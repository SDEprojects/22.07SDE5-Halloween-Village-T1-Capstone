package com.halloween.controller;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.halloween.model.Neighborhood;
import com.halloween.model.Player;
import com.halloween.model.State;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class StoreGame {
    private Gson gson = new Gson();

    public Game loadGame(){
        BufferedReader stateReader = new BufferedReader(
            new InputStreamReader(getClass().getClassLoader().getResourceAsStream("state.json")));
        State state = gson.fromJson(stateReader, State.class);
        BufferedReader playerReader = new BufferedReader(
            new InputStreamReader(getClass().getClassLoader().getResourceAsStream("player.json")));
        Player player = gson.fromJson(playerReader, Player.class);
        BufferedReader neighborhoodReader = new BufferedReader(
            new InputStreamReader(getClass().getClassLoader().getResourceAsStream("neighborhood.json")));
        Neighborhood neighborhood = gson.fromJson(neighborhoodReader, Neighborhood.class);
        return new Game(state, player, neighborhood);
    }

    public void saveGame(State state, Player player, Neighborhood neighborhood){
        writeFile(state, "state.json");
        writeFile(player, "player.json");
        writeFile(neighborhood, "neighborhood.json");
        System.out.println("Your game has been saved!");
    }

    private <T> void writeFile(T gameObject, String name) {
        try {
        String filepath = new File(name).getAbsolutePath();
        FileWriter writer = new FileWriter(filepath, false);
            gson.toJson(gameObject, writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JsonIOException e) {
            throw new RuntimeException();
        }
    }
}

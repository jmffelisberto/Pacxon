package com.l10gr10.pacxon;

import com.l10gr10.pacxon.gui.LanternaGUI;
import com.l10gr10.pacxon.model.menu.Menu;
import com.l10gr10.pacxon.states.MenuState;
import com.l10gr10.pacxon.states.State;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    private static Main gameInstance;
    private final LanternaGUI gui;
    private State state;

    private Main() throws IOException, URISyntaxException, FontFormatException {
        this.gui = new LanternaGUI(35, 35);
        this.state = new MenuState(new Menu());
    }

    public static Main getInstance() throws IOException, URISyntaxException, FontFormatException {
        if (gameInstance == null) {
            gameInstance = new Main();
        }
        return gameInstance;
    }

    public void setState(State state) {
        this.state = state;
    }

    public static void main(String[] args) {
        try {
            Main.getInstance().kickstart(); // Use getInstance to obtain the instance
        } catch (IOException | FontFormatException | URISyntaxException e) {
            e.printStackTrace();
        }
    }

    private void kickstart() throws IOException {
        int FPS = 10;
        int frameTime = 1000 / FPS;

        //for state changes...

        gui.close();
    }
}
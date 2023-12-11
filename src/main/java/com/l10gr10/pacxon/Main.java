package com.l10gr10.pacxon;

import com.l10gr10.pacxon.gui.LanternaGUI;
import com.l10gr10.pacxon.model.menu.Menu;
import com.l10gr10.pacxon.states.MenuState;
import com.l10gr10.pacxon.states.State;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Main {
    private static Main instance;
    private State currentState;
    private final LanternaGUI gui;

    private Main() throws IOException, URISyntaxException, FontFormatException {
        gui = new LanternaGUI(35, 35);
        currentState = new MenuState(new Menu());
    }

    public static Main getInstance() throws IOException, URISyntaxException, FontFormatException {
        if (instance == null) {
            instance = new Main();
        }
        return instance;
    }

    public void setState(State newState) {
        this.currentState = newState;
    }

    private void start() throws IOException {
        final int FPS = 60;
        final long frameTime = 1000 / FPS;

        while (this.currentState != null) {
            long startTime = System.currentTimeMillis();

            currentState.step(this, gui, startTime);

            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;

            try {
                if (sleepTime > 0) {
                    Thread.sleep(sleepTime);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }

        gui.close();
    }

    public static void main(String[] args) {
        try {
            getInstance().start();
        } catch (IOException | URISyntaxException | FontFormatException e) {
            e.printStackTrace();

        }
    }
}

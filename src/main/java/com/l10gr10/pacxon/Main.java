package com.l10gr10.pacxon;

import com.l10gr10.pacxon.controller.MenuController;
import com.l10gr10.pacxon.gui.GUI;
import com.l10gr10.pacxon.gui.LanternaGUI;
import com.l10gr10.pacxon.model.menu.Menu;
import com.l10gr10.pacxon.states.MenuState;
import com.l10gr10.pacxon.view.menu.MenuViewer;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Main {

    private final LanternaGUI gui;
    private MenuState menuState;

    public Main() throws IOException, URISyntaxException, FontFormatException {
        this.gui = new LanternaGUI(35, 35);
        Menu menu = new Menu();
        this.menuState = new MenuState(menu);
    }

    public void start() throws IOException {
        MenuViewer menuViewer = new MenuViewer(menuState.getModel());
        MenuController menuController = new MenuController(menuState.getModel());

        final int frameRate = 10;
        final long frameTime = 1000 / frameRate;

        while (true) {
            long startTime = System.currentTimeMillis();

            GUI.ACTION action = gui.getNextAction();
            menuController.handleInput(action);

            menuViewer.draw(gui);

            if (menuState.getModel().isExitSelected() && action == GUI.ACTION.SELECT) {
                break;
            }

            // Frame rate control
            long endTime = System.currentTimeMillis();
            long timeTaken = endTime - startTime;
            long timeLeft = frameTime - timeTaken;
            if (timeLeft > 0) {
                try {
                    Thread.sleep(timeLeft);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    e.printStackTrace();
                }
            }
        }

        gui.close();
    }



    public static void main(String[] args) {
        try {
            new Main().start();
        } catch (IOException | FontFormatException | URISyntaxException e) {
            e.printStackTrace();
        }
    }
}

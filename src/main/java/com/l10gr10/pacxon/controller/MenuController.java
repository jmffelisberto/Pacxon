package com.l10gr10.pacxon.controller;

import com.l10gr10.pacxon.gui.GUI;
import com.l10gr10.pacxon.model.menu.Menu;

public class MenuController {
    private Menu menu;

    public MenuController(Menu menu) {
        this.menu = menu;
    }

    public void handleInput(GUI.ACTION action) {
        switch (action) {
            case UP:
                menu.previousOption();
                break;
            case DOWN:
                menu.nextOption();
                break;
            case SELECT:
                executeSelectedOption();
                break;

        }
    }

    private void executeSelectedOption() {

        if (menu.isPlaySelected()) {

        } else if (menu.isExitSelected()) {
            System.out.println("Exit selected");
        }
    }
}

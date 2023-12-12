package com.l10gr10.pacxon.view.menu;

import com.l10gr10.pacxon.gui.GUI;
import com.l10gr10.pacxon.model.Position;
import com.l10gr10.pacxon.model.menu.GameOverMenu;
import com.l10gr10.pacxon.states.GameOverState;
import com.l10gr10.pacxon.view.Viewer;

import java.io.IOException;

public class GameOverViewer extends Viewer<GameOverMenu> {

    public GameOverViewer(GameOverMenu gameover) {
        super(gameover);
    }

    @Override
    protected void drawElements(GUI gui) throws IOException {
        gui.drawText(new Position(12, 3), "GAME OVER!", "Blue");


        gui.drawText(new Position(12, 7), "You lost!", "#FFFFFF");
        //gui.drawText(new Position(1, 9), "Choose if you want to go to the", "#FFFFFF");
        //gui.drawText(new Position(0, 10), "main menu or quit the game:", "#FFFFFF");

        for (int i = 0; i < getModel().getNumEntries(); i++) {
            String color = getModel().isSelected(i) ? "#FFD700" : "#FFFFFF";
            gui.drawText(new Position(10, 12 + i * 2), getModel().getEntryName(i), color);
        }
    }
}
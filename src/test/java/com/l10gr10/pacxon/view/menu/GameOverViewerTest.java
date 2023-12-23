package com.l10gr10.pacxon.view.menu;

import com.l10gr10.pacxon.gui.GUI;
import com.l10gr10.pacxon.model.Position;
import com.l10gr10.pacxon.model.menu.GameOverMenu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

class GameOverViewerTest {

    private GameOverViewer gameOverViewer;
    private GameOverMenu gameOverMenu;
    private GUI gui;

    @BeforeEach
    void setUp() {
        gameOverMenu = Mockito.mock(GameOverMenu.class);
        gameOverViewer = new GameOverViewer(gameOverMenu);
        gui = Mockito.mock(GUI.class);
    }

    @Test
    public void testDraw() throws IOException {
        gameOverViewer.draw(gui);

        // Verify that draw method calls drawText the correct number of times
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(12, 3), "GAME OVER!", "Blue");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(12, 7), "You lost!", "#FFFFFF");

        for (int i = 0; i < gameOverMenu.getNumEntries(); i++) {
            String color = gameOverMenu.isSelected(i) ? "#FFD700" : "#FFFFFF";
            Mockito.verify(gui, Mockito.times(1)).drawText(new Position(10, 12 + i * 2), gameOverMenu.getEntryName(i), color);
        }
    }




    @Test
    public void testDrawElements() throws IOException {
        gameOverViewer.drawElements(gui);

        // Update the expected number of invocations based on your actual drawElements implementation
        Mockito.verify(gui, Mockito.times(2)).drawText(Mockito.any(), Mockito.any(), Mockito.any());
    }
}

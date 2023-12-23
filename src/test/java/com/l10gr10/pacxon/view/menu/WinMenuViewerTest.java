package com.l10gr10.pacxon.view.menu;

import com.l10gr10.pacxon.gui.GUI;
import com.l10gr10.pacxon.model.Position;
import com.l10gr10.pacxon.model.menu.WinMenu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.Mockito.verify;

public class WinMenuViewerTest {

    private WinMenuViewer winMenuViewer;
    private GUI gui;
    private WinMenu winMenu;

    @BeforeEach
    void setUp() {
        winMenu = new WinMenu();
        gui = Mockito.mock(GUI.class);
        winMenuViewer = new WinMenuViewer(winMenu);
    }

    @Test
    public void drawElements() throws IOException {
        winMenuViewer.draw(gui);

        // Verify that the expected drawText calls are made with the correct arguments
        verify(gui).drawText(new Position(12, 3), "YOU WIN!", "Blue");
        verify(gui).drawText(new Position(8, 7), "Congratulations!", "#FFFFFF");

        for (int i = 0; i < winMenu.getNumEntries(); i++) {
            String color = winMenu.isSelected(i) ? "#FFD700" : "#FFFFFF";
            verify(gui).drawText(new Position(10, 12 + i * 2), winMenu.getEntryName(i), color);
        }
    }
}
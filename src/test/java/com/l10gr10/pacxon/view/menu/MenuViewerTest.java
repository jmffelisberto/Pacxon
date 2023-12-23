package com.l10gr10.pacxon.view.menu;

import com.l10gr10.pacxon.gui.GUI;
import com.l10gr10.pacxon.model.Position;
import com.l10gr10.pacxon.model.menu.Menu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.Mockito.verify;

class MenuViewerTest {

    private MenuViewer menuViewer;
    private GUI gui;
    private Menu menu;

    @BeforeEach
    void setUp() {
        menu = new Menu();
        menuViewer = new MenuViewer(menu);
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void testDrawElements() throws IOException {
        menuViewer.draw(gui);

        verify(gui).drawText(new Position(10, 5), "PAC-XON", "Blue");

        for (int i = 0; i < menuViewer.getModel().getNumEntries(); i++) {
            String color = menuViewer.getModel().isSelected(i) ? "#FFD700" : "#FFFFFF";
            verify(gui).drawText(new Position(10, 8 + i * 2), menuViewer.getModel().getEntryName(i), color);
        }
    }
}

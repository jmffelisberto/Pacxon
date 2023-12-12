package com.l10gr10.pacxon.view.menu;

import com.l10gr10.pacxon.gui.GUI;
import com.l10gr10.pacxon.model.Position;
import com.l10gr10.pacxon.model.menu.WinMenu;
import com.l10gr10.pacxon.view.Viewer;

import java.io.IOException;

public class WinMenuViewer extends Viewer<WinMenu> {
    public WinMenuViewer(WinMenu model) {
        super(model);
    }

    @Override
    protected void drawElements(GUI gui) throws IOException {
        gui.drawText(new Position(12, 3), "YOU WIN!", "Blue");


        gui.drawText(new Position(8, 7), "Congratulations!", "#FFFFFF");


        for (int i = 0; i < getModel().getNumEntries(); i++) {
            String color = getModel().isSelected(i) ? "#FFD700" : "#FFFFFF";
            gui.drawText(new Position(10, 12 + i * 2), getModel().getEntryName(i), color);
        }
    }
}

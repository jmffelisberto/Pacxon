package com.l10gr10.pacxon.view.menu;

import com.l10gr10.pacxon.gui.GUI;
import com.l10gr10.pacxon.model.Position;
import com.l10gr10.pacxon.model.menu.Menu;
import com.l10gr10.pacxon.view.Viewer;


public class MenuViewer extends Viewer<Menu> {
    public MenuViewer(Menu menu) {
        super(menu);
    }

    @Override
    protected void drawElements(GUI gui) {
        gui.drawText(new Position(10, 5), "PAC-XON", "Blue");
        for (int i = 0; i < getModel().getNumEntries(); i++) {
            String color = getModel().isSelected(i) ? "#FFD700" : "#FFFFFF";
            gui.drawText(new Position(10, 8 + i * 2), getModel().getEntryName(i), color);
        }
    }
}

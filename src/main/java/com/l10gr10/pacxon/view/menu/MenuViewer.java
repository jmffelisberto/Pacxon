package com.l10gr10.pacxon.view.menu;

import com.l10gr10.pacxon.gui.GUI;
import com.l10gr10.pacxon.model.Position;
import com.l10gr10.pacxon.model.menu.Menu;
import com.l10gr10.pacxon.view.Viewer;

public class MenuViewer extends Viewer<Menu> {
    public MenuViewer(Menu menu){
        super(menu);
    }

    @Override
    protected void drawElements(GUI gui) {
        gui.drawText(new Position(5, 5), "Menu", "#FFFFFF");

        for (int i = 0; i < getModel().getNumOfOptions(); i++)
            gui.drawText(
                    new Position(5, 7 + i),
                    getModel().getOption(i),
                    getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");
    }

}

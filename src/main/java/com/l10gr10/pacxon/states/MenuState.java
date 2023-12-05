package com.l10gr10.pacxon.states;

import com.l10gr10.pacxon.model.menu.Menu;
import com.l10gr10.pacxon.view.Viewer;
import com.l10gr10.pacxon.view.menu.MenuViewer;

public class MenuState extends State<Menu>{

    @Override
    protected Viewer<Menu> getViewer() {
        return new MenuViewer(getModel());
    }

    public MenuState(Menu menu) {
        super(menu);
    }


}

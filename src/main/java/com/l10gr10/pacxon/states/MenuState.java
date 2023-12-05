package com.l10gr10.pacxon.states;

import com.l10gr10.pacxon.controller.Controller;
import com.l10gr10.pacxon.controller.menu.MenuController;
import com.l10gr10.pacxon.model.menu.Menu;
import com.l10gr10.pacxon.view.menu.MenuViewer;
import com.l10gr10.pacxon.view.Viewer;

public class MenuState extends State<Menu> {
    public MenuState(Menu model) {
        super(model);
    }

    @Override
    protected Viewer<Menu> getViewer() {
        return new MenuViewer(getModel());
    }

    @Override
    protected Controller<Menu> getController() {
        return new MenuController(getModel());
    }
}

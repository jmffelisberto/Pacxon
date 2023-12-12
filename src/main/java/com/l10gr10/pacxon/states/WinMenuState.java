package com.l10gr10.pacxon.states;

import com.l10gr10.pacxon.controller.Controller;
import com.l10gr10.pacxon.controller.menu.WinMenuController;
import com.l10gr10.pacxon.model.menu.WinMenu;
import com.l10gr10.pacxon.view.Viewer;
import com.l10gr10.pacxon.view.menu.WinMenuViewer;

public class WinMenuState extends State<WinMenu>{
    public WinMenuState(WinMenu model) {
        super(model);
    }

    @Override
    protected Viewer<WinMenu> getViewer() {
        return new WinMenuViewer(getModel());
    }

    @Override
    protected Controller<WinMenu> getController() {
        return new WinMenuController(getModel());
    }
}

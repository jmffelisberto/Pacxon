package com.l10gr10.pacxon.controller.menu;

import com.l10gr10.pacxon.Main;
import com.l10gr10.pacxon.controller.Controller;
import com.l10gr10.pacxon.gui.GUI;
import com.l10gr10.pacxon.model.menu.Menu;
import com.l10gr10.pacxon.model.menu.WinMenu;
import com.l10gr10.pacxon.states.MenuState;
import com.l10gr10.pacxon.states.RulesState;

public class WinMenuController extends Controller<WinMenu> {
    public WinMenuController(WinMenu model) {
        super(model);
    }

    public void handleInput(Main main, GUI.ACTION action, long time) {
        switch (action) {
            case UP:
                getModel().previousEntry();
                break;
            case DOWN:
                getModel().nextEntry();
                break;
            case SELECT:
                if (getModel().isSelectedExit()) {
                    main.setState(null);
                } else if (getModel().isSelectedMenu()) {
                    Menu menu = new Menu();
                    main.setState(new MenuState(menu));
                } else if (getModel().isSelectedExit()) {
                    main.setState(new RulesState(null));
                }
                break;
            case QUIT:
                main.setState(null);
                break;

        }
    }
}

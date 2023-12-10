package com.l10gr10.pacxon.controller.menu;

import com.l10gr10.pacxon.Main;
import com.l10gr10.pacxon.controller.Controller;
import com.l10gr10.pacxon.gui.GUI;
import com.l10gr10.pacxon.model.menu.Menu;
import com.l10gr10.pacxon.model.rules.Rules;
import com.l10gr10.pacxon.states.GameState;
import com.l10gr10.pacxon.model.game.display.Display;
import com.l10gr10.pacxon.states.RulesState;

public class MenuController extends Controller<Menu> {
    public MenuController(Menu menu) {
        super(menu);
    }

    @Override
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
                } else if (getModel().isSelectedPlay()) {
                    Display display = new Display(35, 20);
                    main.setState(new GameState(display));
                } else if (getModel().isSelectedRules()) {
                    Rules rules = new Rules();
                    main.setState(new RulesState(rules));
                }
                break;
            case QUIT:
                main.setState(null);
                break;

        }
    }
}

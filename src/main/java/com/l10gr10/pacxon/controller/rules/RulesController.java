package com.l10gr10.pacxon.controller.rules;

import com.l10gr10.pacxon.Main;
import com.l10gr10.pacxon.controller.Controller;
import com.l10gr10.pacxon.gui.GUI;
import com.l10gr10.pacxon.model.game.display.Display;
import com.l10gr10.pacxon.model.menu.Menu;
import com.l10gr10.pacxon.model.rules.Rules;
import com.l10gr10.pacxon.states.GameState;
import com.l10gr10.pacxon.states.MenuState;

import java.util.Objects;

public class RulesController extends Controller<Rules> {

    public RulesController(Rules model) {
        super(model);
    }

    @Override
    public void handleInput(Main main, GUI.ACTION action, long time) {
        if (Objects.requireNonNull(action) == GUI.ACTION.SELECT) {
            if (getModel().isSelectedExit()) {
                Menu menu = new Menu();
                main.setState(new MenuState(menu));
            }
        }
    }
}
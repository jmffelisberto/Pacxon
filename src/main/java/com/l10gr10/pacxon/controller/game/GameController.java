package com.l10gr10.pacxon.controller.game;

import com.l10gr10.pacxon.Main;
import com.l10gr10.pacxon.controller.Controller;
import com.l10gr10.pacxon.gui.GUI;
import com.l10gr10.pacxon.model.game.display.Display;

public class GameController extends Controller<Display> {
    public GameController(Display display) {
        super(display);
    }

    @Override
    public void handleInput(Main main, GUI.ACTION action, long time) {
    }
}

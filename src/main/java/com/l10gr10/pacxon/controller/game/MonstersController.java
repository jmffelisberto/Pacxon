package com.l10gr10.pacxon.controller.game;

import com.l10gr10.pacxon.Main;
import com.l10gr10.pacxon.controller.Controller;
import com.l10gr10.pacxon.gui.GUI;
import com.l10gr10.pacxon.model.game.elements.nonstatic.Monster;

public class MonstersController extends Controller<Monster> {

    public MonstersController(Monster model) {
        super(model);
    }

    @Override
    public void handleInput(Main main, GUI.ACTION action, long time) {

    }
}

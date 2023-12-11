package com.l10gr10.pacxon.controller.game;

import com.l10gr10.pacxon.Main;
import com.l10gr10.pacxon.controller.Controller;
import com.l10gr10.pacxon.gui.GUI;
import com.l10gr10.pacxon.model.Position;
import com.l10gr10.pacxon.model.game.display.Display;
import com.l10gr10.pacxon.model.game.elements.nonstatic.Pacxon;

public class GameController extends Controller<Display> {

    private final PacxonController pacxonController;
    private final MonstersController monstersController;

    public GameController(Display display) {
        super(display);
        this.pacxonController = new PacxonController(display.getBoard());
        this.monstersController = new MonstersController(display.getBoard());

    }

    @Override
    public void handleInput(Main main, GUI.ACTION action, long time) {
        pacxonController.handleInput(main, action, time);
        monstersController.handleInput(main, action, time);
    }

}

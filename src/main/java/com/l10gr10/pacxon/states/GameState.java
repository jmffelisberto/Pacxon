package com.l10gr10.pacxon.states;

import com.l10gr10.pacxon.controller.Controller;
import com.l10gr10.pacxon.controller.game.GameController;
import com.l10gr10.pacxon.model.game.display.Display;
import com.l10gr10.pacxon.view.Viewer;
import com.l10gr10.pacxon.view.menu.GameViewer;

public class GameState extends State<Display> {
    public GameState(Display display) {
        super(display);
    }

    @Override
    protected Viewer<Display> getViewer() {
        return new GameViewer(getModel());
    }

    @Override
    protected Controller<Display> getController() {
        return new GameController(getModel());
    }

}
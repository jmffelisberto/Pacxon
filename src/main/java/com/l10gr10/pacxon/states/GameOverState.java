package com.l10gr10.pacxon.states;

import com.l10gr10.pacxon.controller.Controller;
import com.l10gr10.pacxon.controller.menu.GameOverController;
import com.l10gr10.pacxon.model.menu.GameOverMenu;
import com.l10gr10.pacxon.view.Viewer;
import com.l10gr10.pacxon.view.menu.GameOverViewer;

public class GameOverState extends State<GameOverMenu>{
    public GameOverState(GameOverMenu model) {
        super(model);
    }

    @Override
    protected Viewer<GameOverMenu> getViewer() {
        return new GameOverViewer(getModel());
    }

    @Override
    protected Controller<GameOverMenu> getController() {
        return new GameOverController(getModel());
    }
}
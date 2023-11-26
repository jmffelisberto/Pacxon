package com.l10gr10.pacxon.states;

import com.l10gr10.pacxon.gui.GUI;
import com.l10gr10.pacxon.model.menu.Menu;
import com.l10gr10.pacxon.view.Viewer;
import com.sun.tools.javac.Main;

import java.io.IOException;

public abstract class State<Model> {
    private final Model model;

    private final Viewer<Model> viewer;
    protected abstract Viewer<Model> getViewer();

    public State(Model model) {
        this.model = model;
        this.viewer = getViewer();
        //controller soon
    }

    public Model getModel() {
        return model;
    }

    //step for controller in Game Loop...
    public void step(Main game, GUI gui, long time) throws IOException {
        GUI.ACTION action = gui.getNextAction();
        //controller call...
        viewer.draw(gui);
    }

}

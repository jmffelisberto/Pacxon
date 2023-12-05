package com.l10gr10.pacxon.states;

import com.l10gr10.pacxon.Main;
import com.l10gr10.pacxon.controller.Controller;
import com.l10gr10.pacxon.gui.GUI;
import com.l10gr10.pacxon.view.Viewer;
import java.io.IOException;

public abstract class State<T> {
    protected final T model;

    public State(T model) {
        this.model = model;
    }

    protected abstract Viewer<T> getViewer();
    protected abstract Controller<T> getController();

    public T getModel() {
        return model;
    }

    public void step(Main main, GUI gui, long time) throws IOException {
        GUI.ACTION action = gui.getNextAction();
        getController().handleInput(main, action, time);
        getViewer().draw(gui);
    }
}

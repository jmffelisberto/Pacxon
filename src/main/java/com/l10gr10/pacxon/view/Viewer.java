package com.l10gr10.pacxon.view;

import com.l10gr10.pacxon.gui.GUI;

import java.io.IOException;

public abstract class Viewer<Model> {

    private final Model model;

    public Viewer(Model model){
        this.model = model;
    }

    public Model getModel() {
        return model;
    }

    protected abstract void drawElements(GUI gui);

    public void draw(GUI gui) throws IOException {
        gui.clear();
        drawElements(gui);
        gui.refresh();
    }

}

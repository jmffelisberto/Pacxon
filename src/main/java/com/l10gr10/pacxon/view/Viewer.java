package com.l10gr10.pacxon.view;

import com.l10gr10.pacxon.gui.GUI;
import java.io.IOException;

public abstract class Viewer<T> {
    protected final T model;

    public Viewer(T model) {
        this.model = model;
    }

    public T getModel() {
        return model;
    }

    public void draw(GUI gui) throws IOException {
        gui.clear();
        drawElements(gui);
        gui.refresh();
    }

    protected abstract void drawElements(GUI gui) throws IOException;
}

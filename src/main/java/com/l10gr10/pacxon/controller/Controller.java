package com.l10gr10.pacxon.controller;

import com.l10gr10.pacxon.Main;
import com.l10gr10.pacxon.gui.GUI;

public abstract class Controller<T> {
    protected final T model;

    public Controller(T model) {
        this.model = model;
    }

    public T getModel() {
        return model;
    }

    public abstract void handleInput(Main main, GUI.ACTION action, long time);
}

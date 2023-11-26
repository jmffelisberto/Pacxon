package com.l10gr10.pacxon.states;

import com.l10gr10.pacxon.model.menu.Menu;

public abstract class State<Model> {
    private final Model model;

    public State(Model model) {
        this.model = model;
        //getViewer on package viewer...
        //controller soon
    }

    public Model getModel() {
        return model;
    }

    //step for controller in Game Loop...
}

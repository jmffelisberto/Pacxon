package com.l10gr10.pacxon.states;

import com.l10gr10.pacxon.controller.Controller;
import com.l10gr10.pacxon.controller.rules.RulesController;
import com.l10gr10.pacxon.model.rules.Rules;
import com.l10gr10.pacxon.view.Viewer;
import com.l10gr10.pacxon.view.rules.RulesViewer;

public class RulesState extends State<Rules>{

    public RulesState(Rules model) {
        super(model);
    }

    @Override
    protected Viewer<Rules> getViewer() {
        return new RulesViewer(getModel());
    }

    @Override
    protected Controller<Rules> getController() {
        return new RulesController(getModel());
    }
}
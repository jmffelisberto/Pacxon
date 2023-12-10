package com.l10gr10.pacxon.view.rules;

import com.l10gr10.pacxon.gui.GUI;
import com.l10gr10.pacxon.model.Position;
import com.l10gr10.pacxon.model.rules.Rules;
import com.l10gr10.pacxon.view.Viewer;

import java.io.IOException;

public class RulesViewer extends Viewer<Rules> {
    public RulesViewer(Rules model) {
        super(model);
    }

    @Override
    protected void drawElements(GUI gui) throws IOException {
        gui.drawText(new Position(10, 5), "Rules", "Blue");
    }
}
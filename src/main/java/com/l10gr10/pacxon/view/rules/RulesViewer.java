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

        gui.drawText(new Position(2, 7), "P-PacXon, Under your control!", "#FFFFFF");
        gui.drawText(new Position(2, 9), "M-Monsters, They're chasing you!", "#FFFFFF");
        gui.drawText(new Position(2, 11), "B-Beers, Stop monsters for 5secs.", "#FFFFFF");
        gui.drawText(new Position(2, 13), "H-Hearts, 1UP to the PacXon!", "#FFFFFF");
    }

}
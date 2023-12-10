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
        gui.drawText(new Position(15, 3), "Rules", "Blue");


        gui.drawText(new Position(1, 7), "Conquer spaces, capture monsters!", "#FFFFFF");
        gui.drawText(new Position(1, 9), "They can't go through walls, but ", "#FFFFFF");
        gui.drawText(new Position(0, 10), "if they catch you, you lose 1 life.", "#FFFFFF");


        gui.drawText(new Position(1, 12), "As soon as you fill 80% of the ", "#FFFFFF");
        gui.drawText(new Position(0, 13), "board, you win!", "#FFFFFF");

        gui.drawText(new Position(2, 16), "P-PacXon, Under your control!", "#FFFFFF");
        gui.drawText(new Position(2, 18), "M-Monsters, They're chasing you!", "#FFFFFF");
        gui.drawText(new Position(2, 20), "B-Beers, Stop monsters for 5secs.", "#FFFFFF");
        gui.drawText(new Position(2, 22), "H-Hearts, 1UP to the PacXon!", "#FFFFFF");

        gui.drawText(new Position(7, 29), "Enter - Back to Menu", "#FFD700");
    }



}
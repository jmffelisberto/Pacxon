package com.l10gr10.pacxon.view.menu;

import com.l10gr10.pacxon.gui.GUI;
import com.l10gr10.pacxon.model.Position;
import com.l10gr10.pacxon.model.game.display.Display;
import com.l10gr10.pacxon.model.game.display.Stats;
import com.l10gr10.pacxon.model.game.elements.statik.Block;
import com.l10gr10.pacxon.view.Viewer;

import java.io.IOException;

public class GameViewer extends Viewer<Display> {
    public GameViewer(Display display) {
        super(display);
    }

    @Override
    protected void drawElements(GUI gui) throws IOException {
        int startY = 0;
        drawStats(gui, startY);
        drawBoard(gui);
    }


    private void drawBoard(GUI gui) {
        Block[][] blocks = getModel().getBoard().getBlocks();
        for (int y = 0; y < blocks.length; y++) {
            for (int x = 0; x < blocks[y].length; x++) {
                String color = blocks[y][x].isFilled() ? "#0000FF" : "#9D9DFF";
                gui.drawBlock(new Position(x, y + 4), color);
            }
        }
    }


    private void drawStats(GUI gui, int startY) throws IOException {
        int terminalWidth = gui.getScreenWidth();

        String livesText = "Lives: " + getModel().getStats().getLives();
        String scoreText = "Score: " + getModel().getStats().getScore();
        String progressText = "Progress: " + getModel().getStats().getProgressPercentage() + "/80%";

        int spacing = (terminalWidth - (livesText.length() + scoreText.length() + progressText.length())) / 2;

        gui.drawText(new Position(0, startY), livesText, "#FFD700");
        gui.drawText(new Position(livesText.length() + spacing, startY), scoreText, "#FFD700");
        gui.drawText(new Position(livesText.length() + scoreText.length() + spacing * 2, startY), progressText, "#FFD700");
    }
}

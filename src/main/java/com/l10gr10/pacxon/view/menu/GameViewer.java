package com.l10gr10.pacxon.view.menu;

import com.l10gr10.pacxon.gui.GUI;
import com.l10gr10.pacxon.model.Position;
import com.l10gr10.pacxon.model.game.display.Display;
import com.l10gr10.pacxon.model.game.display.Stats;
import com.l10gr10.pacxon.model.game.elements.nonstatic.Monster;
import com.l10gr10.pacxon.model.game.elements.statik.Beer;
import com.l10gr10.pacxon.model.game.elements.statik.Block;
import com.l10gr10.pacxon.model.game.elements.statik.Heart;
import com.l10gr10.pacxon.view.Viewer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.List;

public class GameViewer extends Viewer<Display> {
    public GameViewer(Display display) {
        super(display);
    }


    @Override
    protected void drawElements(GUI gui) throws IOException {
        int startY = 24;
        drawStats(gui, startY);
        drawBoard(gui);
        drawPacxon(gui);
        drawMonsters(gui);
        drawPowerUps(gui);
    }


    void drawBoard(GUI gui) {
        Block[][] blocks = getModel().getBoard().getBlocks();
        for (int y = 0; y < blocks.length; y++) {
            for (int x = 0; x < blocks[y].length; x++) {
                Block block = blocks[y][x];
                String color;
                if (block.isFilled()) {
                    color = "#002fff";  // Filled Block
                } else if (block.isTrail()) {
                    color = "#7583E2";  // Trail blocks
                } else {
                    color = "#000000";  // Unfilled blocks
                }
                gui.drawBlock(new Position(x, y + 4), color);
            }
        }
    }


    void drawStats(GUI gui, int startY) throws IOException {
        int terminalWidth = gui.getScreenWidth();

        String pacxonText = "PACXON";
        String quitGameText = "Press 'q' to quit";
        String livesText = "Lives: " + getModel().getStats().getLives();
        String scoreText = "Score: " + getModel().getStats().getScore();
        String progressText = "Progress: " + getModel().getStats().getProgressPercentage() + "/80%";

        int pacxonSpacing = (terminalWidth - pacxonText.length()) / 2;
        int progressSpacing = (terminalWidth - progressText.length()) / 2;

        // Draw "pacxon" at the top
        gui.drawText(new Position(pacxonSpacing, 1), pacxonText, "#FFD700");
        gui.drawText(new Position(8, 2), quitGameText, "#00FF00");

        // Draw the second line with progress centered
        gui.drawText(new Position(progressSpacing, startY), progressText, "#FFD700");

        // Draw the third line with lives on the left and score on the right
        gui.drawText(new Position(0, startY + 1), livesText, "#FFD700");
        gui.drawText(new Position(terminalWidth - scoreText.length(), startY + 1), scoreText, "#FFD700");
    }





    void drawPacxon(GUI gui) {
        Position pacxonPosition = getModel().getBoard().getPacxon().getPosition();
        String pacxonCharacter = "P";
        gui.drawText(new Position(pacxonPosition.getX(), pacxonPosition.getY() + 4), pacxonCharacter, "#FFFF00");
    }

    void drawMonsters(GUI gui){
        List<Monster> monsters = getModel().getBoard().getMonsters();
        String monsterCharacter = "M";
        for (Monster monster : monsters){
            Position helper = new Position(monster.getPosition().getX(), monster.getPosition().getY() + 4);
            gui.drawText(helper, monsterCharacter, "#FFFF00");
        }
    }

    void drawPowerUps(GUI gui){
        drawBeers(gui);
        drawHearts(gui);
    }

    private void drawHearts(GUI gui) {
        List<Heart> hearts = getModel().getBoard().getHearts();
        String heartCharacter = "H";
        for (Heart heart : hearts){
            Position helper = new Position(heart.getPosition().getX(), heart.getPosition().getY() + 4);
            gui.drawText(helper, heartCharacter, "#FFFF00");
        }
    }

    private void drawBeers(GUI gui) {
        List<Beer> beers = getModel().getBoard().getBeers();
        String beerCharacter = "B";
        for (Beer Beer : beers){
            Position helper = new Position(Beer.getPosition().getX(), Beer.getPosition().getY() + 4);
            gui.drawText(helper, beerCharacter, "#FFFF00");
        }
    }

}

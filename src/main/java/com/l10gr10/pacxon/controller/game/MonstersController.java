package com.l10gr10.pacxon.controller.game;

import com.l10gr10.pacxon.Main;
import com.l10gr10.pacxon.controller.Controller;
import com.l10gr10.pacxon.gui.GUI;
import com.l10gr10.pacxon.model.Position;
import com.l10gr10.pacxon.model.game.display.Board;
import com.l10gr10.pacxon.model.game.elements.nonstatic.Monster;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MonstersController extends Controller<Board> {

    public MonstersController(Board model) {
        super(model);
    }

    @Override
    public void handleInput(Main main, GUI.ACTION action, long time) {
        //doesnt really have input for now
        List<Monster> monsters = getModel().getMonsters();
        for (Monster monster : monsters) {
            moveRandomly(monster);
        }
    }

    private boolean isValidMove(Position newPosition) {
        int boardWidth = getModel().getWidth();
        int boardHeight = getModel().getHeight();
        return newPosition.getX() >= 0 && newPosition.getX() < boardWidth &&
                newPosition.getY() >= 0 && newPosition.getY() < boardHeight;
    }

    public void moveRandomly(Monster monster) {
        Position currentPos = monster.getPosition();
        Position direction = monster.getRandomDirection();
        Position newPosition = new Position(currentPos.getX() + direction.getX(), currentPos.getY() + direction.getY());

        if (isValidMove(newPosition)) {
            monster.setPosition(newPosition);
        }
    }

}

package com.l10gr10.pacxon.controller.game;

import com.l10gr10.pacxon.Main;
import com.l10gr10.pacxon.controller.Controller;
import com.l10gr10.pacxon.gui.GUI;
import com.l10gr10.pacxon.model.Position;
import com.l10gr10.pacxon.model.game.display.Board;
import com.l10gr10.pacxon.model.game.elements.nonstatic.Monster;
import com.l10gr10.pacxon.model.game.elements.statik.Block;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MonstersController extends Controller<Board> {

    private static final int MONSTER_MOVE_DELAY = 500;
    private long lastMoveTime;

    public MonstersController(Board model) {
        super(model);
        this.lastMoveTime = System.currentTimeMillis();
    }

    @Override
    public void handleInput(Main main, GUI.ACTION action, long time) {
        long currentTime = System.currentTimeMillis();
        long elapsedTime = currentTime - lastMoveTime;
        List<Monster> monsters = getModel().getMonsters();
        if (elapsedTime >= MONSTER_MOVE_DELAY) {
            for (Monster monster : monsters) {
                moveRandomly(monster);
                if (checkMonsterTrailCollision(monster)) {
                    getModel().resetTrail();
                    getModel().getStats().decreaseLife();
                    break;
                }
            }
            lastMoveTime = System.currentTimeMillis();
        }


    }

    private boolean isValidMove(Position newPosition) {
        int boardWidth = getModel().getWidth();
        int boardHeight = getModel().getHeight();
        boolean withinBounds = newPosition.getX() > 0 && newPosition.getX() < (boardWidth-1) &&
                newPosition.getY() > 0 && newPosition.getY() < (boardHeight-1);

        if (!withinBounds) {
            return false;
        }

        Block block = getModel().getBlockAt(newPosition);
        return !block.isFilled();
    }

    public void moveRandomly(Monster monster) {
        Position currentPos = monster.getPosition();
        Position direction = monster.getRandomDirection();
        Position newPosition = new Position(currentPos.getX() + direction.getX(), currentPos.getY() + direction.getY());

        if (isValidMove(newPosition)) {
            monster.setPosition(newPosition);
        }
    }

    private boolean checkMonsterTrailCollision(Monster monster) {
        List<Position> trailPositions = getModel().getTrailPositions();
        return trailPositions.contains(monster.getPosition());
    }

}

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

    private boolean isSlowedDown = false;

    private long slowDownEndTime;

    public MonstersController(Board model) {
        super(model);
        this.lastMoveTime = System.currentTimeMillis();
    }

    @Override
    public void handleInput(Main main, GUI.ACTION action, long time) {
        long currentTime = System.currentTimeMillis();

        long effectiveDelay = isSlowedDown && currentTime < slowDownEndTime
                ? 3 * MONSTER_MOVE_DELAY
                : MONSTER_MOVE_DELAY / 3;

        if (currentTime - lastMoveTime >= effectiveDelay) {
            for (Monster monster : getModel().getMonsters()) {
                moveRandomly(monster);
                if (checkMonsterTrailCollision(monster)) {
                    getModel().resetTrail();
                    getModel().getStats().decreaseLife();
                    break;
                }
            }
            lastMoveTime = currentTime;
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

    public void slowDownMonsters(long duration) {
        this.isSlowedDown = true;
        this.slowDownEndTime = System.currentTimeMillis() + duration;
    }
}

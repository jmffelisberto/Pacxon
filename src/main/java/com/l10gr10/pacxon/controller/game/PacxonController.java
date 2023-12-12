package com.l10gr10.pacxon.controller.game;

import com.l10gr10.pacxon.Main;
import com.l10gr10.pacxon.controller.Controller;
import com.l10gr10.pacxon.gui.GUI;
import com.l10gr10.pacxon.model.Position;
import com.l10gr10.pacxon.model.game.display.Board;
import com.l10gr10.pacxon.model.game.display.Stats;
import com.l10gr10.pacxon.model.game.elements.nonstatic.Monster;
import com.l10gr10.pacxon.model.game.elements.nonstatic.Pacxon;


public class PacxonController extends Controller<Board> {
    public PacxonController(Board board) {
        super(board);
    }

    @Override
    public void handleInput(Main main, GUI.ACTION action, long time) {
        Pacxon pacxon = getModel().getPacxon();
        Position oldPosition = pacxon.getPosition();
        pacxon.updateInvulnerability();
        Position newPosition = null;

        switch (action) {
            case UP:
                newPosition = new Position(pacxon.getPosition().getX(), pacxon.getPosition().getY() - 1);
                break;
            case DOWN:
                newPosition = new Position(pacxon.getPosition().getX(), pacxon.getPosition().getY() + 1);
                break;
            case LEFT:
                newPosition = new Position(pacxon.getPosition().getX() - 1, pacxon.getPosition().getY());
                break;
            case RIGHT:
                newPosition = new Position(pacxon.getPosition().getX() + 1, pacxon.getPosition().getY());
                break;
        }

        if (checkPacxonMonsterCollision()) {
            Board board = getModel();
            board.getStats().decreaseLife();
            if (board.getStats().getLives() <= 0) {
                //TO IMPLEMENT -> GAME OVER
            }
        }

        if (newPosition != null && isValidMove(newPosition)) {
            pacxon.setPosition(newPosition);
            if (isStartingFill(oldPosition, newPosition) || getModel().getBlockAt(oldPosition).isTrail()) {
                getModel().addToTrail(newPosition);
            }
            if (isCompletingFill(oldPosition, newPosition)) {
                getModel().completeFill();
            }
        }


    }


    private boolean isValidMove(Position position) {
        int boardWidth = getModel().getWidth();
        int boardHeight = getModel().getHeight();
        return position.getX() >= 0 && position.getX() < boardWidth &&
                position.getY() >= 0 && position.getY() < boardHeight;
    }

    //check is pacXon goes from fill to unfill blocl
    private boolean isStartingFill(Position oldPosition, Position newPosition) {
        return getModel().getBlockAt(oldPosition).isFilled() &&
                !getModel().getBlockAt(newPosition).isFilled();
    }

    //check if pacXon goes from unfill to fill block
    private boolean isCompletingFill(Position oldPosition, Position newPosition) {
        return !getModel().getBlockAt(oldPosition).isFilled() &&
                getModel().getBlockAt(newPosition).isFilled();
    }


    private boolean checkPacxonMonsterCollision() {
        Pacxon pacxon = getModel().getPacxon();
        if (!getModel().getPacxon().isInvulnerable()) {
            Position pacxonPosition = getModel().getPacxon().getPosition();
            for (Monster monster : getModel().getMonsters()) {
                if (pacxonPosition.equals(monster.getPosition())) {
                    pacxon.makeInvulnerable(2000);
                    return true;
                }
            }
        }
        return false;
    }
}

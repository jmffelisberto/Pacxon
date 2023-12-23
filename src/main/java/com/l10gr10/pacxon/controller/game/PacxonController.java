package com.l10gr10.pacxon.controller.game;

import com.l10gr10.pacxon.Main;
import com.l10gr10.pacxon.controller.Controller;
import com.l10gr10.pacxon.gui.GUI;
import com.l10gr10.pacxon.model.Position;
import com.l10gr10.pacxon.model.game.display.Board;
import com.l10gr10.pacxon.model.game.display.Stats;
import com.l10gr10.pacxon.model.game.elements.nonstatic.Monster;
import com.l10gr10.pacxon.model.game.elements.nonstatic.Pacxon;
import com.l10gr10.pacxon.model.menu.GameOverMenu;
import com.l10gr10.pacxon.model.menu.WinMenu;
import com.l10gr10.pacxon.states.GameOverState;
import com.l10gr10.pacxon.states.WinMenuState;


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
            case QUIT:
                main.setState(new GameOverState(new GameOverMenu()));
                break;
        }

        if (checkPacxonMonsterCollision()) {
            Board board = getModel();
            board.getStats().decreaseLife();
            if (board.getStats().getLives() < 1) {
                main.setState(new GameOverState(new GameOverMenu()));
            }
        }



        if (newPosition != null && isValidMove(newPosition)) {
            getModel().getPacxon().setPosition(newPosition);
            if (isStartingFill(oldPosition, newPosition) || getModel().getBlockAt(oldPosition).isTrail()) {
                getModel().addToTrail(newPosition);
            }
            if (isCompletingFill(oldPosition, newPosition)) {
                getModel().completeFill();
            }
        }

        if(getModel().getStats().getProgressPercentage() >= 80)
            main.setState(new WinMenuState(new WinMenu()));


    }


    boolean isValidMove(Position position) {
        int boardWidth = getModel().getWidth();
        int boardHeight = getModel().getHeight();
        return position.getX() >= 0 && position.getX() < boardWidth &&
                position.getY() >= 0 && position.getY() < boardHeight;
    }

    //check is pacXon goes from fill to unfill block
    boolean isStartingFill(Position oldPosition, Position newPosition) {
        return getModel().getBlockAt(oldPosition).isFilled() &&
                !getModel().getBlockAt(newPosition).isFilled();
    }

    //check if pacXon goes from unfill to fill block
    boolean isCompletingFill(Position oldPosition, Position newPosition) {
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

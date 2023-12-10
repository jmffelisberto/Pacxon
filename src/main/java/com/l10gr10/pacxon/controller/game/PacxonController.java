package com.l10gr10.pacxon.controller.game;

import com.l10gr10.pacxon.Main;
import com.l10gr10.pacxon.controller.Controller;
import com.l10gr10.pacxon.gui.GUI;
import com.l10gr10.pacxon.model.Position;
import com.l10gr10.pacxon.model.game.display.Board;
import com.l10gr10.pacxon.model.game.elements.nonstatic.Pacxon;

public class PacxonController extends Controller<Board> {
    public PacxonController(Board board) {
        super(board);
    }

    @Override
    public void handleInput(Main main, GUI.ACTION action, long time) {
        Pacxon pacxon = getModel().getPacxon();
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

        if (newPosition != null && isValidMove(newPosition)) {
            pacxon.setPosition(newPosition);
        }
    }


    private boolean isValidMove(Position position) {
        int boardWidth = getModel().getWidth();
        int boardHeight = getModel().getHeight();
        return position.getX() >= 0 && position.getX() < boardWidth &&
                position.getY() >= 0 && position.getY() < boardHeight;
    }
}

package com.l10gr10.pacxon.model.game.elements.nonstatic;

import com.l10gr10.pacxon.model.Position;
import com.l10gr10.pacxon.model.game.display.Board;
import com.l10gr10.pacxon.model.game.elements.Element;

import java.util.Random;

public class Monster extends Element {
    public Monster(Position position) {
        super(position);
    }

    private static final Random random = new Random();

    public Position getRandomDirection() {
        int randomDirection = random.nextInt(4); // 0: UP, 1: DOWN, 2: LEFT, 3: RIGHT

        return switch (randomDirection) {
            case 0 -> new Position(0, -1); // UP
            case 1 -> new Position(0, 1);  // DOWN
            case 2 -> new Position(-1, 0); // LEFT
            case 3 -> new Position(1, 0);  // RIGHT
            default -> new Position(0, 0);  // No movement (should not happen)
        };
    }

    @Override
    public Position getPosition() {
        return super.getPosition();
    }

}

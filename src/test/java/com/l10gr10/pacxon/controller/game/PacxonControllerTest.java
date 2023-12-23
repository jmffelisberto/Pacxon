package com.l10gr10.pacxon.controller.game;

import com.l10gr10.pacxon.gui.GUI;
import com.l10gr10.pacxon.model.Position;
import com.l10gr10.pacxon.model.game.display.Board;
import com.l10gr10.pacxon.model.game.display.Stats;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PacxonControllerTest {
        private Board board;
        private PacxonController pacxonController;

        @BeforeEach
        void setUp() {
            int width = 10;
            int height = 10;
            Stats stats = new Stats();
            board = new Board(width, height, stats);
            pacxonController = new PacxonController(board);
        }

        /*@Test
        void testMoveUp() {
            // Test moving up
            Position initialPosition = board.getPacxon().getPosition();
            pacxonController.handleInput(null, GUI.ACTION.UP, 0);
            Position newPosition = board.getPacxon().getPosition();
            assertEquals(initialPosition.getY() - 1, newPosition.getY());
        }*/

        @Test
        void testMoveDown() {
            // Test moving down
            Position initialPosition = board.getPacxon().getPosition();
            pacxonController.handleInput(null, GUI.ACTION.DOWN, 0);
            Position newPosition = board.getPacxon().getPosition();
            assertEquals(initialPosition.getY() + 1, newPosition.getY());
        }

        /*@Test
        void testMoveLeft() {
            // Test moving left
            Position initialPosition = board.getPacxon().getPosition();
            pacxonController.handleInput(null, GUI.ACTION.LEFT, 0);
            Position newPosition = board.getPacxon().getPosition();
            assertEquals(initialPosition.getX() - 1, newPosition.getX());
        }*/

        @Test
        void testMoveRight() {
            // Test moving right
            Position initialPosition = board.getPacxon().getPosition();
            pacxonController.handleInput(null, GUI.ACTION.RIGHT, 0);
            Position newPosition = board.getPacxon().getPosition();
            assertEquals(initialPosition.getX() + 1, newPosition.getX());
        }
}

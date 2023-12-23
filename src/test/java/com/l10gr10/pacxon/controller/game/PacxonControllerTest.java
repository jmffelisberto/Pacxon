package com.l10gr10.pacxon.controller.game;

import com.l10gr10.pacxon.Main;
import com.l10gr10.pacxon.gui.GUI;
import com.l10gr10.pacxon.model.Position;
import com.l10gr10.pacxon.model.game.display.Board;
import com.l10gr10.pacxon.model.game.display.Stats;
import com.l10gr10.pacxon.model.game.elements.nonstatic.Pacxon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;


class PacxonControllerTest {


    private Board board;
    private Pacxon pacxon;
    private PacxonController pacxonController;

    private Main main;

    @BeforeEach
    public void setUp() throws IOException, URISyntaxException, FontFormatException {
        // Set up the board and PacxonController for each test
        main = Main.getInstance();
        Stats stats = new Stats();
        board = new Board(5, 5, stats);
        pacxon = new Pacxon(new Position(2, 2), 3);
        board.getPacxon().setPosition(pacxon.getPosition());
        pacxonController = new PacxonController(board);
    }

    @Test
    public void testHandleInputMoveUp() throws IOException, URISyntaxException, FontFormatException {

        // When
        try {
            pacxonController.handleInput(Main.getInstance(), GUI.ACTION.UP, 0);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (FontFormatException e) {
            throw new RuntimeException(e);
        }

        // Then
        Position expectedPosition = new Position(2, 1);
        Position actualPosition = board.getPacxon().getPosition();

        assertEquals(expectedPosition, actualPosition);
    }

    // Add more tests for other directions and edge cases

    @Test
    public void testHandleInputInvalidMove() {
        // Given an initial position
        Position initialPosition = pacxon.getPosition();

        // When trying to move to an invalid position (outside the board)
        pacxonController.handleInput(main, GUI.ACTION.UP, 0);

        // Then the position should remain unchanged
        assertEquals(initialPosition, pacxon.getPosition());
    }

    @Test
    public void testIsStartingFill() {
        // Given a filled block at the old position and an unfilled block at the new position
        board.getBlockAt(new Position(1, 2)).setFilled(true);
        board.getBlockAt(new Position(2, 2)).setFilled(false);

        // When checking if it's starting to fill
        boolean result = pacxonController.isStartingFill(new Position(1, 2), new Position(2, 2));

        // Then the result should be true
        assertTrue(result);
    }

    @Test
    public void testIsNotStartingFill() {
        // Given an unfilled block at the old position and a filled block at the new position
        board.getBlockAt(new Position(1, 2)).setFilled(false);
        board.getBlockAt(new Position(2, 2)).setFilled(true);

        // When checking if it's starting to fill
        boolean result = pacxonController.isStartingFill(new Position(1, 2), new Position(2, 2));

        // Then the result should be false
        assertFalse(result);
    }

    @Test
    public void testIsCompletingFill() {
        // Given an unfilled block at the old position and a filled block at the new position
        board.getBlockAt(new Position(1, 2)).setFilled(false);
        board.getBlockAt(new Position(2, 2)).setFilled(true);

        // When checking if it's completing the fill
        boolean result = pacxonController.isCompletingFill(new Position(1, 2), new Position(2, 2));

        // Then the result should be true
        assertTrue(result);
    }

    @Test
    public void testIsNotCompletingFill() {
        // Given a filled block at the old position and an unfilled block at the new position
        board.getBlockAt(new Position(1, 2)).setFilled(true);
        board.getBlockAt(new Position(2, 2)).setFilled(false);

        // When checking if it's completing the fill
        boolean result = pacxonController.isCompletingFill(new Position(1, 2), new Position(2, 2));

        // Then the result should be false
        assertFalse(result);
    }


    // Add more tests based on the requirements and behavior of your PacxonController

    private void assertTrue(boolean condition) {
        if (!condition) {
            throw new AssertionError("Assertion failed: Expected true, but got false.");
        }
    }

    private void assertFalse(boolean condition) {
        if (condition) {
            throw new AssertionError("Assertion failed: Expected false, but got true.");
        }
    }
}
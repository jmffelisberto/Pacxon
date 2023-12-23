package com.l10gr10.pacxon.model.game.display;

import com.l10gr10.pacxon.model.Position;
import com.l10gr10.pacxon.model.game.elements.statik.Block;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class BoardTest {

    private Board board;

    @BeforeEach
    void setUp() {
        // Initialize a new Board with a dummy Stats object
        Stats stats = new Stats();
        board = new Board(5, 5, stats);
    }

    @Test
    void testGetWidth() {
        // Ensure that the width is correctly set during initialization
        assertEquals(5, board.getWidth());
    }

    @Test
    void testGetHeight() {
        // Ensure that the height is correctly set during initialization
        assertEquals(5, board.getHeight());
    }

    @Test
    void testGetBlocks() {
        // Ensure that the blocks array is initialized and not null
        assert board.getBlocks() != null;
    }

    @Test
    void testGetPacxon() {
        assert board.getPacxon() != null;
    }

    @Test
    void testGetMonsters() {
        assert board.getMonsters() != null;
    }

    @Test
    void testGetBlockAt() {
        // Test getting a block at a specific position
        Position position = new Position(1, 1);
        Block block = board.getBlockAt(position);

        // Ensure that the returned block is not null and has the correct position
        assert block != null;
        assertEquals(position, block.getPosition());
    }
}
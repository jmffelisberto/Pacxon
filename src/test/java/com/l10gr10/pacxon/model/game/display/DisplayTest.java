package com.l10gr10.pacxon.model.game.display;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DisplayTest {

    private Display display;

    @BeforeEach
    void setUp() {
        // Initialize a new Display with a dummy Stats object
        display = new Display(5, 5);
    }

    @Test
    void testGetBoard() {
        // Ensure that the board is not null
        assert display.getBoard() != null;
    }

    @Test
    void testGetStats() {
        // Ensure that the stats object is not null
        assert display.getStats() != null;
    }
}
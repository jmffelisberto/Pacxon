package com.l10gr10.pacxon.model.game.display;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DisplayTest {

    private Display display;

    @BeforeEach
    void setUp() {
        display = new Display(5, 5);
    }

    @Test
    void testGetBoard() {
        assert display.getBoard() != null;
    }

    @Test
    void testGetStats() {
        assert display.getStats() != null;
    }
}
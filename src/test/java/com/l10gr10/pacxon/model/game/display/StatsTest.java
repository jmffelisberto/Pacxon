package com.l10gr10.pacxon.model.game.display;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class StatsTest {

    private Stats stats;

    @BeforeEach
    void setUp() {
        stats = new Stats();
    }

    @Test
    void testDefaultConstructor() {
        // Ensure that the default constructor initializes lives to 3, score to 0, and progressPercentage to 0
        assertEquals(3, stats.getLives());
        assertEquals(0, stats.getScore());
        assertEquals(0, stats.getProgressPercentage());
    }

    @Test
    void testAddScore() {
        // Test adding points to the score
        stats.addScore(50);

        // Ensure that the score is updated correctly
        assertEquals(50, stats.getScore());
    }

    @Test
    void testUpdateProgress() {
        // Test updating progress based on filled blocks and total blocks
        stats.updateProgress(5, 20);

        // Ensure that the progressPercentage is updated correctly
        assertEquals(25, stats.getProgressPercentage());
    }
}
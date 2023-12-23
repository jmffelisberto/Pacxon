package com.l10gr10.pacxon.model.menu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameOverMenuTest {

    private GameOverMenu gameOverMenu;

    @BeforeEach
    void setUp() {
        gameOverMenu = new GameOverMenu();
    }

    @Test
    void getCurrentEntry() {
        assertEquals(0, gameOverMenu.getCurrentEntry());
    }

    @Test
    void isSelected() {
        assertTrue(gameOverMenu.isSelected(0));
        assertFalse(gameOverMenu.isSelected(1));
    }

    @Test
    void isSelectedMenu() {
        assertTrue(gameOverMenu.isSelectedMenu());
        assertFalse(gameOverMenu.isSelectedExit());
    }

    @Test
    void isSelectedExit() {
        assertFalse(gameOverMenu.isSelectedExit());
    }

    @Test
    void getNumEntries() {
        assertEquals(2, gameOverMenu.getNumEntries());
    }

    @Test
    void nextEntry() {
        gameOverMenu.nextEntry();
        assertEquals(1, gameOverMenu.getCurrentEntry());
        gameOverMenu.nextEntry();
        assertEquals(0, gameOverMenu.getCurrentEntry());
    }

    @Test
    void previousEntry() {
        gameOverMenu.previousEntry();
        assertEquals(1, gameOverMenu.getCurrentEntry());
        gameOverMenu.previousEntry();
        assertEquals(0, gameOverMenu.getCurrentEntry());
    }

    @Test
    void getEntryName() {
        assertEquals("Back to menu", gameOverMenu.getEntryName(0));
        assertEquals("Quit game", gameOverMenu.getEntryName(1));
    }
}
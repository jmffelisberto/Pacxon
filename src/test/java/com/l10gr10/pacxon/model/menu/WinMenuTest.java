package com.l10gr10.pacxon.model.menu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WinMenuTest {

    private WinMenu winMenu;

    @BeforeEach
    void setUp() {
        winMenu = new WinMenu();
    }

    @Test
    void getCurrentEntry() {
        assertEquals(0, winMenu.getCurrentEntry());
    }

    @Test
    void isSelected() {
        assertTrue(winMenu.isSelected(0));
        assertFalse(winMenu.isSelected(1));
    }

    @Test
    void isSelectedMenu() {
        assertTrue(winMenu.isSelectedMenu());
        assertFalse(winMenu.isSelectedExit());
    }

    @Test
    void isSelectedExit() {
        assertFalse(winMenu.isSelectedExit());
    }

    @Test
    void getNumEntries() {
        assertEquals(2, winMenu.getNumEntries());
    }

    @Test
    void nextEntry() {
        winMenu.nextEntry();
        assertEquals(1, winMenu.getCurrentEntry());
        winMenu.nextEntry();
        assertEquals(0, winMenu.getCurrentEntry());
    }

    @Test
    void previousEntry() {
        winMenu.previousEntry();
        assertEquals(1, winMenu.getCurrentEntry());
        winMenu.previousEntry();
        assertEquals(0, winMenu.getCurrentEntry());
    }

    @Test
    void getEntryName() {
        assertEquals("Back to menu", winMenu.getEntryName(0));
        assertEquals("Quit game", winMenu.getEntryName(1));
    }
}
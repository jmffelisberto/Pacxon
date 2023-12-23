package com.l10gr10.pacxon.model.menu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MenuTest {

    private Menu menu;

    @BeforeEach
    void setUp() {
        menu = new Menu();
    }

    @Test
    void getCurrentEntry() {
        assertEquals(0, menu.getCurrentEntry());
    }

    @Test
    void isSelected() {
        assertTrue(menu.isSelected(0));
        assertFalse(menu.isSelected(1));
    }

    @Test
    void isSelectedPlay() {
        assertTrue(menu.isSelectedPlay());
        assertFalse(menu.isSelectedRules());
        assertFalse(menu.isSelectedExit());
    }

    @Test
    void isSelectedRules() {
        assertFalse(menu.isSelectedRules());
    }

    @Test
    void isSelectedExit() {
        assertFalse(menu.isSelectedExit());
    }

    @Test
    void getNumEntries() {
        assertEquals(3, menu.getNumEntries());
    }

    @Test
    void nextEntry() {
        menu.nextEntry();
        assertEquals(1, menu.getCurrentEntry());
        menu.nextEntry();
        assertEquals(2, menu.getCurrentEntry());
        menu.nextEntry();
        assertEquals(0, menu.getCurrentEntry());
    }

    @Test
    void previousEntry() {
        menu.previousEntry();
        assertEquals(2, menu.getCurrentEntry());
        menu.previousEntry();
        assertEquals(1, menu.getCurrentEntry());
        menu.previousEntry();
        assertEquals(0, menu.getCurrentEntry());
    }

    @Test
    void getEntryName() {
        assertEquals("Play", menu.getEntryName(0));
        assertEquals("Rules", menu.getEntryName(1));
        assertEquals("Exit", menu.getEntryName(2));
    }
}
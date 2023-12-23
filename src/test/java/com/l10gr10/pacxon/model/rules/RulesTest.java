package com.l10gr10.pacxon.model.rules;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RulesTest {

    private Rules rules;

    @BeforeEach
    void setUp() {
        rules = new Rules();
    }

    @Test
    void getCurrentEntry() {
        assertEquals(0, rules.getCurrentEntry());
    }

    @Test
    void isSelected() {
        assertTrue(rules.isSelected(0));
    }

    @Test
    void isSelectedExit() {
        assertTrue(rules.isSelectedExit());
    }

    @Test
    void getNumEntries() {
        assertEquals(1, rules.getNumEntries());
    }

    @Test
    void nextEntry() {
        rules.nextEntry();
        assertEquals(0, rules.getCurrentEntry());
    }

    @Test
    void previousEntry() {
        rules.previousEntry();
        assertEquals(0, rules.getCurrentEntry());
    }

    @Test
    void getEntryName() {
        assertEquals("Back to menu", rules.getEntryName(0));
    }

}
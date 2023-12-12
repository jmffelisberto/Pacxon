package com.l10gr10.pacxon.model.menu;

import java.util.Arrays;
import java.util.List;

public class GameOverMenu{
    private final List<String> entries;
    private int currentEntry = 0;

    public GameOverMenu() {
        this.entries = Arrays.asList("Back to menu", "Quit game");
    }


    public int getCurrentEntry() {
        return currentEntry;
    }

    public boolean isSelected(int index) {
        return index == getCurrentEntry();
    }

    public boolean isSelectedMenu() {
        return isSelected(0);
    }

    public boolean isSelectedExit() {
        return isSelected(1);
    }

    public int getNumEntries() {
        return entries.size();
    }

    public void nextEntry() {
        currentEntry = (currentEntry + 1) % getNumEntries();
    }

    public void previousEntry() {
        currentEntry = (currentEntry - 1 + getNumEntries()) % getNumEntries();
    }

    public String getEntryName(int index) {
        return entries.get(index);
    }
}
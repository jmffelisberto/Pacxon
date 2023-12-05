package com.l10gr10.pacxon.model.menu;

import java.util.Arrays;
import java.util.List;

public class Menu {

    private final List<String> options;
    private int currentOption = 0;

    public Menu() {
        // Adding more options like "Rules" or "Settings"
        this.options = Arrays.asList("Play", "Rules", "Exit");
    }

    public int getNumOfOptions() {
        return this.options.size();
    }

    public void nextOption() {
        currentOption = (currentOption + 1) % getNumOfOptions();
    }

    public void previousOption() {
        currentOption = (currentOption - 1 + getNumOfOptions()) % getNumOfOptions();
    }

    public boolean isSelected(int index) {
        return currentOption == index;
    }

    public String getOption(int index) {
        return options.get(index);
    }

    // Utility methods for specific options, for readability
    public boolean isPlaySelected() {
        return isSelected(0);
    }

    public boolean isRulesSelected() {
        return isSelected(1);
    }

    public boolean isExitSelected() {
        return isSelected(2);
    }
}

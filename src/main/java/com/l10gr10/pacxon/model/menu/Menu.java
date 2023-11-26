package com.l10gr10.pacxon.model.menu;

import java.util.Arrays;
import java.util.List;

public class Menu {

    private final List<String> options;
    private int currentOption = 0; //first option

    public Menu(){
        this.options = Arrays.asList("Play", "Rules", "Exit");
    }

    //logic for menu

    public int getNumOfOptions() {
        return this.options.size();
    }

    public void nextOption() {
         currentOption++;
         if (currentOption > getNumOfOptions() - 1)
             currentOption = 0;
    }

    public void previousOption() {
        currentOption--;
        if (currentOption < 0)
            currentOption = getNumOfOptions() - 1;
    }
    public boolean isSelected(int i) {
        return currentOption == i;
    }

    public boolean isStartSelected() {
        return isSelected(0);
    }

    public boolean isExitSelected() {
        return isSelected(1);
    }

    public boolean isRulesSelected() {
        return isSelected(2);
    }

    public String getOption(int i) {
        return options.get(i);
    }
}

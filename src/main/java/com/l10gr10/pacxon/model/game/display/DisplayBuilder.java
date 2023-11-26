package com.l10gr10.pacxon.model.game.display;

import com.l10gr10.pacxon.model.game.elements.notstatic.Monster;
import com.l10gr10.pacxon.model.game.elements.notstatic.Pacxon;

import java.util.List;

public abstract class DisplayBuilder {

    protected abstract int getWidth();
    protected abstract int getHeight();

    //protected abstract List<Wall> createWalls();

    protected abstract List<Monster> createMonsters();

    protected abstract Pacxon createPacxon();

    public Display generateDisplay(){
        Display display = new Display(getWidth(), getHeight());

        displ
    }



}

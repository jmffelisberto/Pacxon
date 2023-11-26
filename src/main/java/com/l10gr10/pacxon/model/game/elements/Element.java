package com.l10gr10.pacxon.model.game.elements;

import com.l10gr10.pacxon.model.Position;

public class Element {

    private Position position;

    public Element(int x, int y){
        this.position = new Position(x, y);
    }

    public Position getPosition() {
        return position;
    }
    public void setPosition(Position position) {
        this.position = position;
    }

}

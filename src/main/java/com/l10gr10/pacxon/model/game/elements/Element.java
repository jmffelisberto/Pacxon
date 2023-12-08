package com.l10gr10.pacxon.model.game.elements;

import com.l10gr10.pacxon.model.Position;

public class Element {

    private Position position;

    public Element(Position position){
        this.position = new Position(position.getX(), position.getY());
    }

    public Position getPosition() {
        return position;
    }
    public void setPosition(Position position) {
        this.position = position;
    }

}

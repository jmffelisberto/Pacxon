package com.l10gr10.pacxon.model.game.elements.statik;

import com.l10gr10.pacxon.model.Position;
import com.l10gr10.pacxon.model.game.elements.Element;

public class Block extends Element {
    private boolean isFilled;

    public Block(Position position, boolean isFilled) {
        super(position);
        this.isFilled = isFilled;
    }

    public boolean isFilled() {
        return isFilled;
    }

    public void setFilled(boolean filled) {
        isFilled = filled;
    }

}
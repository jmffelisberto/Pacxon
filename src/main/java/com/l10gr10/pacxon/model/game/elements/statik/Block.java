package com.l10gr10.pacxon.model.game.elements.statik;

import com.l10gr10.pacxon.model.Position;
import com.l10gr10.pacxon.model.game.elements.Element;

public class Block extends Element {
    private boolean isFilled;
    private boolean isTrail;

    private boolean isVisited;

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

    public boolean isTrail() {
        return isTrail;
    }

    public void setTrail(boolean trail) {
        isTrail = trail;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

}
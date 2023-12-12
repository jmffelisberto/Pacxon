package com.l10gr10.pacxon.model.game.elements.nonstatic;

import com.l10gr10.pacxon.model.Position;
import com.l10gr10.pacxon.model.game.elements.Element;

public class Pacxon extends Element {
    private int lives;

    private boolean isInvulnerable;
    private long invulnerableTime;

    public Pacxon(Position position, int lives) {
        super(position);
        this.lives = lives;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public void makeInvulnerable(long duration) {
        this.isInvulnerable = true;
        this.invulnerableTime = System.currentTimeMillis() + duration;
    }

    public void updateInvulnerability() {
        if (System.currentTimeMillis() > invulnerableTime) {
            this.isInvulnerable = false;
        }
    }

    public boolean isInvulnerable() {
        return isInvulnerable;
    }

}

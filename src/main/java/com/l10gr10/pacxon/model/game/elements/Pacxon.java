package com.l10gr10.pacxon.model.game.elements;

public class Pacxon extends Element{

    private int health;

    public Pacxon(int x, int y){
        super(x, y);
        this.health = 3;
    }

    public void increaseHP() {
        this.health++;
    }
    public void decreaseHP() {
        this.health--;
    }

    public int getHealth() {
        return health;
    }
}

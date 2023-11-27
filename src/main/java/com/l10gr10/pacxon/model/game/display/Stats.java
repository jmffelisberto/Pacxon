package com.l10gr10.pacxon.model.game.display;

public class Stats {

    private final int score;
    private final int percentage;

    public Stats(int score, int percentage) {
        this.score = score;
        this.percentage = percentage;
    }

    public int getScore() {
        return score;
    }

    public int getPercentage() {
        return percentage;
    }
}

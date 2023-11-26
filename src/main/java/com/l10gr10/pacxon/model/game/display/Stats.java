package com.l10gr10.pacxon.model.game.display;

public class Stats {

    private final int score;
    private final int percentage;

    public Stats(int score, int percentage) {
        this.score = score;
        this.percentage = percentage;
        // Initialize the states based on the provided width and height
    }

    public int getScore() {
        return score;
    }

    public int getPercentage() {
        return percentage;
    }

    // Other methods related to the stats
}

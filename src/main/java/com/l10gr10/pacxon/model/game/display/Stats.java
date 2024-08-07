package com.l10gr10.pacxon.model.game.display;

public class Stats {
    private int lives;
    private int score;
    private int progressPercentage;

    public Stats() {
        this.lives = 3;
        this.score = 0;
        this.progressPercentage = 0;
    }

    public int getScore() {
        return score;
    }
    public int getLives() {
        return lives;
    }

    public int getProgressPercentage() {
        return progressPercentage;
    }

    public void addScore(int points) {
        this.score += points;
    }

    public void updateProgress(int filledBlocks, int totalBlocks) {
        this.progressPercentage = (int)(((double) filledBlocks / totalBlocks) * 100);
    }


    public void decreaseLife() {
        this.lives--;
    }

    public void increaseLife() {
        this.lives++;
    }
}


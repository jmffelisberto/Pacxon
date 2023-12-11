package com.l10gr10.pacxon.model.game.display;

public class Display {

    private Board board;
    private Stats stats;

    public Display(int width, int height) {
        this.stats = new Stats();
        this.board = new Board(width, height, this.stats);
    }

    public Board getBoard() {
        return board;
    }

    public Stats getStats() {
        return stats;
    }


}

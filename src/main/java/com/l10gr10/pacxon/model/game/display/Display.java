package com.l10gr10.pacxon.model.game.display;

public class Display {

    private Board board;
    private Stats stats;

    public Display(int width, int height, , ) {
        this.board = new Board(width, height);
        this.stats = new Stats();
    }

    public Board getBoard() {
        return board;
    }
    public void setBoard(Board board) {
        this.board = board;
    }

    public Stats getStats() {
        return stats;
    }
    public void setStats(Stats stats) {
        this.stats = stats;
    }

}

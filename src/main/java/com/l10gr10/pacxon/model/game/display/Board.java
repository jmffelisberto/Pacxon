package com.l10gr10.pacxon.model.game.display;

import com.l10gr10.pacxon.model.Position;
import com.l10gr10.pacxon.model.game.elements.nonstatic.Monster;
import com.l10gr10.pacxon.model.game.elements.nonstatic.Pacxon;
import com.l10gr10.pacxon.model.game.elements.statik.Beer;
import com.l10gr10.pacxon.model.game.elements.statik.Block;
import com.l10gr10.pacxon.model.game.elements.statik.Heart;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final int width;
    private final int height;
    private Block[][] blocks;
    private Pacxon pacxon;
    private List<Monster> monsters;
    private List<Beer> beers;
    private List<Heart> hearts;
    private List<Position> trailPositions = new ArrayList<>();


    public Board(int width, int height) {
        this.width = width;
        this.height = height;
        this.blocks = new Block[height][width];
        this.beers = new ArrayList<Beer>();
        this.monsters = new ArrayList<Monster>();
        initializeBoard();
    }

    private void initializeBoard() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                boolean isPerimeter = x == 0 || y == 0 || x == width - 1 || y == height - 1;
                Position position = new Position(x, y);
                blocks[y][x] = new Block(position, isPerimeter);
            }
        }

        pacxon = new Pacxon(new Position(0, 0), 3);
        monsters.add(new Monster(new Position(3, 7)));
        monsters.add(new Monster(new Position(6, 20)));
        monsters.add(new Monster(new Position(12, 2)));
        monsters.add(new Monster(new Position(30, 15)));
    }

    public Block[][] getBlocks() {
        return blocks;
    }

    public Pacxon getPacxon() {
        return pacxon;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public List<Monster> getMonsters() {
        return monsters;
    }

    public void startFill(Position startPosition) {
        trailPositions.clear();
        addToTrail(startPosition);
    }

    public void completeFill() {
        for (Position pos : trailPositions) {
            getBlockAt(pos).setFilled(true);
            getBlockAt(pos).setTrail(false);
        }
        trailPositions.clear();
    }

    public void addToTrail(Position position) {
        if (!getBlockAt(position).isTrail()) {
            trailPositions.add(position);
            getBlockAt(position).setTrail(true);
        }
    }

    public Block getBlockAt(Position position) {
        return blocks[position.getY()][position.getX()];
    }

}
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


    public Board(int width, int height) {
        this.width = width;
        this.height = height;
        this.blocks = new Block[height][width];
        this.beers = new ArrayList<>();
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

}
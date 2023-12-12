package com.l10gr10.pacxon.controller.game;

import com.l10gr10.pacxon.Main;
import com.l10gr10.pacxon.controller.Controller;
import com.l10gr10.pacxon.gui.GUI;
import com.l10gr10.pacxon.model.Position;
import com.l10gr10.pacxon.model.game.display.Board;
import com.l10gr10.pacxon.model.game.elements.nonstatic.Pacxon;
import com.l10gr10.pacxon.model.game.elements.statik.Heart;
import com.l10gr10.pacxon.model.game.elements.statik.Beer;

import java.util.List;
import java.util.Random;

public class PowerUpsController extends Controller<Board> {
    private long lastPowerUpTime = 0;
    private static final long POWER_UP_INTERVAL = 15000; // 15 for each powerUp pop-up

    @Override
    public void handleInput(Main main, GUI.ACTION action, long time) {
    }

    public PowerUpsController(Board board) {
        super(board);
    }

    public void update(long time) {
        if (time - lastPowerUpTime > POWER_UP_INTERVAL) {
            lastPowerUpTime = time;
            addRandomPowerUp();
        }
        checkPowerUpCollisions();
    }

    private void addRandomPowerUp() {
        Position randomPosition = getRandomPosition();
        if (Math.random() < 0.5) {
            getModel().getHearts().add(new Heart(randomPosition));
        } else {
            getModel().getBeers().add(new Beer(randomPosition));
        }
    }

    private Position getRandomPosition() {
        Random random = new Random();
        int x, y;
        do {
            x = random.nextInt(getModel().getWidth());
            y = random.nextInt(getModel().getHeight());
        } while (getModel().getBlockAt(new Position(x, y)).isFilled());
        return new Position(x, y);
    }

    private void checkPowerUpCollisions() {
        Pacxon pacxon = getModel().getPacxon();
        List<Heart> hearts = getModel().getHearts();
        List<Beer> beers = getModel().getBeers();

        hearts.removeIf(heart -> {
            if (heart.getPosition().equals(pacxon.getPosition())) {
                getModel().getStats().increaseLife();
                return true;
            }
            return false;
        });
        beers.removeIf(beer -> {
            if (beer.getPosition().equals(pacxon.getPosition())) {
                getModel().getMonstersController().slowDownMonsters(5000);
                return true;
            }
            return false;
        });
    }
}
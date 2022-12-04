package com.javarush.games.spaceinvaders.gameobjects;

import com.javarush.engine.cell.Game;
import com.javarush.games.spaceinvaders.Direction;
import com.javarush.games.spaceinvaders.ShapeMatrix;
import com.javarush.games.spaceinvaders.SpaceInvadersGame;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EnemyFleet {
    private static final int ROWS_COUNT = 3;
    private static final int COLUMNS_COUNT = 10;
    private static final int STEP = ShapeMatrix.ENEMY.length + 1;
    private List<EnemyShip> ships;
    private Direction direction = Direction.RIGHT;

    public EnemyFleet() {
        createShips();
    }

    private void createShips() {
        ships = new ArrayList<>();
        for (int y = 0; y < ROWS_COUNT; y++) {
            for (int x = 0; x < COLUMNS_COUNT; x++) {
                ships.add(new EnemyShip(x * STEP, y * STEP + 12));
            }
        }
        ships.add(new Boss(STEP * COLUMNS_COUNT / 2 - ShapeMatrix.BOSS_ANIMATION_FIRST.length / 2 - 1, 5));
    }

    public void draw(Game game) {
        ships.forEach(enemyShip -> enemyShip.draw(game));
    }

    private double getLeftBorder() {
        return ships.stream()
                .map(enemyShip -> enemyShip.x)
                .min(Double::compareTo)
                .get();
                //.min((o1, o2) -> (int) (o1.x - o2.x)).get().x;
    }

    private double getRightBorder() {
        return ships.stream()
                .map(enemyShip -> enemyShip.x + enemyShip.width)
                .max(Double::compareTo)
                .get();
        /*double maxX = 0;
        for (EnemyShip enemyShip : ships) {
            if (maxX < (enemyShip.x + enemyShip.width)) maxX = enemyShip.x + enemyShip.width;
        }
        return maxX;*/
        //return ships.stream().max(Comparator.comparing(enemyShip -> enemyShip.x + enemyShip.width));
        //)//(o1, o2) -> (int) ((o1.x + o1.width) - (o2.x + o2.width))).get().x;
    }

    public double getBottomBorder() {
        return ships.stream()
                .map(enemyShip -> enemyShip.y + enemyShip.height)
                .max(Double::compareTo)
                .get();
        /*double maxY = 0;
        for (EnemyShip enemyShip : ships){
            if (maxY < (enemyShip.y + enemyShip.height)){
                maxY = enemyShip.y + enemyShip.height;
            }
        }
        return maxY;*/
    }
    public int getShipsCount(){
        return ships.size();
    }

    private double getSpeed() {
        return Math.min(2.0, 3.0 / ships.size());
    }

    public void move() {
        if (!ships.isEmpty()) {
            if (direction == Direction.LEFT && getLeftBorder() < 0) {
                direction = Direction.RIGHT;
                ships.forEach(enemyShip -> enemyShip.move(Direction.DOWN, getSpeed()));
            } else if (direction == Direction.RIGHT && getRightBorder() > SpaceInvadersGame.WIDTH) {
                direction = Direction.LEFT;
                ships.forEach(enemyShip -> enemyShip.move(Direction.DOWN, getSpeed()));
            } else {
                ships.forEach(enemyShip -> enemyShip.move(direction, getSpeed()));
            }
        }
    }

    public Bullet fire(Game game) {
        if (!ships.isEmpty()) {
            if (game.getRandomNumber(100 / SpaceInvadersGame.COMPLEXITY) <= 0) {
                return ships.get(game.getRandomNumber(ships.size())).fire();
            }
        }
        return null;
    }

    public int verifyHit(List<Bullet> bullets) {
        if (bullets.isEmpty()) {
            return 0;
        }

        int score = 0;
        for (Bullet bullet : bullets) {
            for (EnemyShip ship : ships) {
                if (ship.isAlive && bullet.isAlive && ship.isCollision(bullet)) {
                    ship.kill();
                    bullet.kill();
                    score += ship.score;
                }
            }
        }
        return score;
    }

    public void deleteHiddenShips() {
        ships.removeIf(enemyShip -> !enemyShip.isVisible());
    }
}

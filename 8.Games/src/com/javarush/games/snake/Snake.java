package com.javarush.games.snake;

import com.javarush.engine.cell.*;

import java.util.ArrayList;
import java.util.List;

public class Snake {
    private List<GameObject> snakeParts = new ArrayList<>();
    private static final String HEAD_SIGN = "\uD83D\uDC7E";
    private static final String BODY_SIGN = "\u26AB";
    private Direction direction = Direction.LEFT;
    public boolean isAlive = true;

    public Snake(int x, int y) {
        snakeParts.add(new GameObject(x, y));
        snakeParts.add(new GameObject(x + 1, y));
        snakeParts.add(new GameObject(x + 2, y));
    }

    public void setDirection(Direction direction) {
        if ((this.direction == Direction.LEFT ||
                this.direction == Direction.RIGHT) && snakeParts.get(0).x == snakeParts.get(1).x) {
            return;
        }
        if ((this.direction == Direction.UP ||
                this.direction == Direction.DOWN) && snakeParts.get(0).y == snakeParts.get(1).y) {
            return;
        }
        if (direction == Direction.LEFT && this.direction == Direction.RIGHT) return;
        else if (direction == Direction.RIGHT && this.direction == Direction.LEFT) return;
        else if (direction == Direction.UP && this.direction == Direction.DOWN) return;
        else if (direction == Direction.DOWN && this.direction == Direction.UP) return;
        this.direction = direction;
    }

    public void draw(Game game) {
        Color snakeColor = isAlive ? Color.BLACK : Color.RED;
        for (int i = 0; i < snakeParts.size(); i++) {
            if (i == 0)
                game.setCellValueEx(snakeParts.get(i).x, snakeParts.get(i).y, Color.NONE, HEAD_SIGN, snakeColor, 75);
            else game.setCellValueEx(snakeParts.get(i).x, snakeParts.get(i).y, Color.NONE, BODY_SIGN, snakeColor, 75);
        }
    }

    public GameObject createNewHead() {
        GameObject head = snakeParts.get(0);
        int headX = head.x;
        int headY = head.y;
        if (direction == Direction.LEFT) headX--;
        else if (direction == Direction.RIGHT) headX++;
        else if (direction == Direction.UP) headY--;
        else headY++;
        return new GameObject(headX, headY);
    }

    public void removeTail() {
        snakeParts.remove(snakeParts.size() - 1);
    }

    public void move(Apple apple) {
        GameObject newHead = createNewHead();
        if (newHead.x < 0 || newHead.x >= SnakeGame.WIDTH ||
                newHead.y < 0 || newHead.y >= SnakeGame.HEIGHT) {
            isAlive = false;
            return;
        }
        if (checkCollision(newHead)) {
            isAlive = false;
            return;
        }
        snakeParts.add(0, newHead);
        if (newHead.x == apple.x && newHead.y == apple.y) apple.isAlive = false;
        else removeTail();
    }

    public boolean checkCollision(GameObject gameObject) {
        for (GameObject part : snakeParts) {
            if (part.x == gameObject.x && part.y == gameObject.y) return true;
        }
        return false;
    }

    public int getLength() {
        return snakeParts.size();
    }
}


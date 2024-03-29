package com.javarush.games.racer;

import com.javarush.engine.cell.*;
import com.javarush.games.racer.road.RoadManager;

public class RacerGame extends Game {
    public static final int WIDTH = 64;
    public static final int HEIGHT = 64;
    public static final int CENTER_X = WIDTH / 2;
    public static final int ROADSIDE_WIDTH = 14;
    private static final int RACE_GOAL_CARS_COUNT = 40;
    private int score;
    private boolean isGameStopped;
    private RoadMarking roadMarking;
    private PlayerCar player;
    private RoadManager roadManager;
    private FinishLine finishLine;
    private ProgressBar progressBar;

    @Override
    public void initialize() {
        showGrid(false);
        setScreenSize(WIDTH, HEIGHT);
        createGame();
    }

    @Override
    public void setCellColor(int x, int y, Color color) {
        if (x >= 0 && x < WIDTH && y >= 0 && y < HEIGHT) {
            super.setCellColor(x, y, color);
        }
    }

    @Override
    public void onTurn(int step) {
        if (roadManager.checkCrush(player)) {
            gameOver();
            drawScene();
            return;
        }
        if (roadManager.getPassedCarsCount() >= RACE_GOAL_CARS_COUNT){
            finishLine.show();
        }
        if (finishLine.isCrossed(player)){
            win();
            drawScene();
            return;
        }
        roadManager.generateNewRoadObjects(this);
        moveAll();
        score -= 5;
        setScore(score);
        drawScene();
    }

    @Override
    public void onKeyPress(Key key) {
        if (key == Key.RIGHT) player.setDirection(Direction.RIGHT);
        else if (key == Key.LEFT) player.setDirection(Direction.LEFT);
        else if (key == Key.UP) player.speed = 2;
        else if (key == Key.SPACE && isGameStopped) createGame();
    }

    @Override
    public void onKeyReleased(Key key) {
        if (key == Key.RIGHT && player.getDirection() == Direction.RIGHT ||
                key == Key.LEFT && player.getDirection() == Direction.LEFT) player.setDirection(Direction.NONE);
        else if (key == Key.UP) player.speed = 1;
    }

    private void createGame() {
        score = 3500;
        isGameStopped = false;
        roadMarking = new RoadMarking();
        player = new PlayerCar();
        roadManager = new RoadManager();
        finishLine = new FinishLine();
        progressBar = new ProgressBar(RACE_GOAL_CARS_COUNT);
        drawScene();
        setTurnTimer(40);
    }

    private void drawScene() {
        drawField();
        roadMarking.draw(this);
        player.draw(this);
        roadManager.draw(this);
        finishLine.draw(this);
        progressBar.draw(this);
    }

    private void drawField() {
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                //В методе drawField() для ячеек игрового поля, у которых x равен
                // CENTER_X, необходимо вызвать метод setCellColor(int, int, Color)
                // с параметрами: CENTER_X, y, и любой цвет (например, Color.WHITE).
                if (x == CENTER_X) {
                    setCellColor(CENTER_X, y, Color.WHITE);
                } //В методе drawField() для ячеек игрового поля, у которых x больше
                // либо равно ROADSIDE_WIDTH и x меньше (WIDTH - ROADSIDE_WIDTH),
                // необходимо вызвать метод setCellColor(int, int, Color) с параметрами:
                // координаты x и y, и любой цвет (например, Color.-DIMGREY).
                else if (x >= ROADSIDE_WIDTH && x < (WIDTH - ROADSIDE_WIDTH)) {
                    setCellColor(x, y, Color.DIMGREY);
                }// В методе drawField() для всех остальных ячеек игрового поля,
                // необходимо вызвать метод setCellColor(int, int, Color) с параметрами:
                // координаты x и y, и цвет, и любой цвет (например, Color.GREEN).
                else {
                    setCellColor(x, y, Color.GREEN);
                }
            }
        }
    }

    private void moveAll() {
        roadMarking.move(player.speed);
        roadManager.move(player.speed);
        finishLine.move(player.speed);
        progressBar.move(roadManager.getPassedCarsCount());
        player.move();
    }

    private void gameOver() {
        isGameStopped = true;
        showMessageDialog(Color.RED, "Game Over!", Color.BLACK, 75);
        stopTurnTimer();
        player.stop();
    }
    private void win(){
        isGameStopped = true;
        showMessageDialog(Color.GREEN, "You Win!", Color.BLACK, 75);
        stopTurnTimer();
    }
}

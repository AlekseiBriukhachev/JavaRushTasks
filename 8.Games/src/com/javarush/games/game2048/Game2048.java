package com.javarush.games.game2048;

import com.javarush.games.*;

public class Game2048 extends Game {
    private static final int SIDE = 4;
    private int score;
    private boolean isGameStopped = false;
    private int[][] gameField = new int[SIDE][SIDE];
    @Override
    public void initialize() {
        setScreenSize(SIDE, SIDE);
        createGame();
        drawScene();
    }

    @Override
    public void onKeyPress(Key key) {
        if (!isGameStopped) {
            if (canUserMove()) {
                switch (key) {
                    case UP:
                        moveUp();
                        drawScene();
                        break;
                    case DOWN:
                        moveDown();
                        drawScene();
                        break;
                    case RIGHT:
                        moveRight();
                        drawScene();
                        break;
                    case LEFT:
                        moveLeft();
                        drawScene();
                        break;
                }
            }
            else gameOver();
        }
        else if (key == Key.SPACE){
            isGameStopped = false;
            createGame();
            score = 0;
            setScore(score);
            drawScene();

        }
    }

    private void moveLeft() {
        boolean action = false;
        for (int[] row : gameField){
            boolean compressed = compressRow(row);
            boolean merged = mergeRow(row);
            if (merged) compressRow(row);
            if (compressed || merged) action = true;
        }
        if (action) createNewNumber();
    }

    private void moveRight() {
        rotateClockwise();
        rotateClockwise();
        moveLeft();
        rotateClockwise();
        rotateClockwise();

    }

    private void moveDown() {
        rotateClockwise();
        moveLeft();
        rotateClockwise();
        rotateClockwise();
        rotateClockwise();

    }

    private void moveUp() {
        rotateClockwise();
        rotateClockwise();
        rotateClockwise();
        moveLeft();
        rotateClockwise();

    }

    private void createGame(){
        gameField = new int[SIDE][SIDE];
        createNewNumber();
        createNewNumber();
    }
    private void drawScene(){
        for (int y = 0; y < SIDE; y++) {
            for (int x = 0; x < SIDE; x++) {
                setCellColoredNumber(x, y, gameField[y][x]);
            }
        }
    }
    private void createNewNumber(){
        int x, y;
        do{
            x = getRandomNumber(SIDE);
            y = getRandomNumber(SIDE);
        }while (gameField[x][y] != 0);
        if (getRandomNumber(10) == 9){
            gameField[x][y] = 4;
        }
        else {
            gameField[x][y] = 2;
        }
        if (getMaxTileValue() == 2048) win();
    }
    private Color getColorByValue(int value){
        switch (value){
            case 0:
                return Color.WHITE;
            case 2:
                return Color.PURPLE;
            case 4:
                return Color.BLUEVIOLET;
            case 8:
                return Color.BLUE;
            case 16:
                return Color.CYAN;
            case 32:
                return Color.DARKSEAGREEN;
            case 64:
                return Color.FORESTGREEN;
            case 128:
                return Color.ORANGE;
            case 256:
                return Color.MISTYROSE;
            case 512:
                return Color.CORAL;
            case 1024:
                return Color.PINK;
            case 2048:
                return Color.DARKVIOLET;
            default:
                return Color.NONE;
        }
    }
    private void setCellColoredNumber(int x, int y, int value){
        String str = value > 0 ? "" + value : "";
        setCellValueEx(x, y, getColorByValue(value), str);
    }
    private boolean compressRow(int[] row){
        boolean rowShifted = false;
        int tempPosition = 0;
        for (int i = 0; i < SIDE; i++) {
            if (row[i] != 0){
                if (i != tempPosition){
                    row[tempPosition] = row[i];
                    row[i] = 0;
                    rowShifted = true;
                }
                tempPosition++;
            }
        }
        return rowShifted;
    }
    private boolean mergeRow(int[] row) {
        boolean rowMerged = false;
        for (int i = 0; i < row.length - 1; i++) {
            if (row[i] != 0 && row[i] == row[i + 1]) {
                row[i] *= 2;
                score += row[i];
                row[i + 1] = 0;
                rowMerged = true;
                setScore(score);
            }
        }
        return rowMerged;
    }
    private void rotateClockwise(){
        int[][] rotatedMatrix = new int[SIDE][SIDE];
        for (int x = 0; x < SIDE; x++) {
            for (int y = 0; y < SIDE; y++) {
                rotatedMatrix[x][y] = gameField[gameField.length - y - 1][x];
            }
        }
        gameField = rotatedMatrix;
    }
    private int getMaxTileValue(){
        int maxTileValue = 0;
        for (int x = 0; x < gameField.length; x++) {
            for (int y = 0; y < gameField.length; y++) {
                if (maxTileValue < gameField[x][y]) maxTileValue = gameField[x][y];
            }
        }
        return maxTileValue;
    }
    private void win(){
        isGameStopped = true;
        showMessageDialog(Color.GREEN, "YOU WIN!", Color.BLACK, 75);
    }
    private void gameOver(){
        isGameStopped = true;
        showMessageDialog(Color.RED, "Game Over", Color.BLACK, 75);
    }
    private boolean canUserMove(){
        for (int x = 0; x < gameField.length; x++) {
            for (int y = 0; y < gameField.length; y++) {
                if (gameField[x][y] == 0) return true;
                else if (x < SIDE - 1 && gameField[x][y] == gameField[x + 1][y]) return true;
                else if (y < SIDE - 1 && gameField[x][y] == gameField[x][y + 1]) return true;
            }
        }
        return false;
    }
}

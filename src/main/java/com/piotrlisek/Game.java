package com.piotrlisek;

import java.util.Arrays;

public class Game {
    private String[] board;
    private String currentPlayerMark;
    private int turnNumber;
    private boolean gameWon;

    Game() {
        board = new String[9];
        for (int i = 0; i < 9; i++) {
            board[i] = String.valueOf(i + 1);
        }
        turnNumber = 0;
        currentPlayerMark = "O";
        gameWon = false;
    }

    public int getTurnNumber() { return turnNumber; }

    public boolean isGameWon() {
        return gameWon;
    }

    public void makeMove(String input) {
        if (input.matches("[1-9]")) {
            int index = Integer.parseInt(input);
            if (!(board[index - 1].equals("X") || board[index - 1].equals("O"))) {
                System.out.println();
                board[index - 1] = currentPlayerMark;
                turnNumber++;
            } else {
                System.out.println("\nThe place have to be empty. Player " + currentPlayerMark + ", enter an unselected slot with number from 1 to 9");
            }
        } else if (input.equals("exit")) {
            System.out.println("You exited the game");
        }
    }

    public void changePlayer() {
        if (turnNumber % 2 != 0) {
            currentPlayerMark = "O";
        } else {
            currentPlayerMark = "X";
        }
        System.out.println("Player " + currentPlayerMark + ", enter an unselected slot with number from 1 to 9:");
    }

    public boolean checkWinner() {
        for (int i = 0; i < 8; i++) {
            String line = null;
            switch (i) {
                case 0:
                    line = board[0] + board[1] + board[2];
                    break;
                case 1:
                    line = board[3] + board[4] + board[5];
                    break;
                case 2:
                    line = board[6] + board[7] + board[8];
                    break;
                case 3:
                    line = board[0] + board[3] + board[6];
                    break;
                case 4:
                    line = board[1] + board[4] + board[7];
                    break;
                case 5:
                    line = board[2] + board[5] + board[8];
                    break;
                case 6:
                    line = board[0] + board[4] + board[8];
                    break;
                case 7:
                    line = board[2] + board[4] + board[6];
                    break;
            }
            if (line.equals("XXX")) {
                return gameWon = true;
            } else if (line.equals("OOO")) {
                return gameWon = true;
            }
        }
        //checking if there is draw
        for (int i = 0; i < 9; i++) {
            if (Arrays.asList(board).contains(String.valueOf(i + 1))) {
                break;
            } else if (i == 8) return gameWon = false;
        }
        return false;
    }

    public void showBoard() {
        System.out.println(board[0] + " | " + board[1] + " | " + board[2]);
        System.out.println("--------");
        System.out.println(board[3] + " | " + board[4] + " | " + board[5]);
        System.out.println("--------");
        System.out.println(board[6] + " | " + board[7] + " | " + board[8]);
    }

    public void printStatus() {
        if (gameWon) {
            if (turnNumber % 2 != 0) {
                System.out.println("Player " + currentPlayerMark + " won the game");
            } else {
                System.out.println("Player " + currentPlayerMark + " won the game");
            }
        } else {
            System.out.println("It's a draw");
        }
    }
}

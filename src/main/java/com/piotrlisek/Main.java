package com.piotrlisek;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        Scanner scanner = new Scanner(System.in);

        System.out.println("TicTacToe Game");
        System.out.println("---------\n");

        game.showBoard();
        while (game.getTurnNumber() < 9 && !game.isGameWon()) {
            game.changePlayer();
            String input = scanner.nextLine();
            game.makeMove(input);
            game.showBoard();
            game.checkWinner();
        }
        game.printStatus();
    }
}

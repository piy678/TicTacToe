package main.java.org.example;

import org.example.Player;
import org.example.Board;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class TicTacToe {
    Player player1;
    Player player2;
    Player currentPlayer;
    Board board;

    public TicTacToe() {
        player1 = new Player('X');
        player2 = new Player('O');
        currentPlayer = player1;
        board = new Board();
    }

    public void switchCurrentPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    public boolean hasWinner() {
        char[][] cells = board.cells;


        for (int i = 0; i < 3; i++) {
            if ((cells[i][0] == cells[i][1] && cells[i][1] == cells[i][2] && cells[i][0] != ' ') ||
                    (cells[0][i] == cells[1][i] && cells[1][i] == cells[2][i] && cells[0][i] != ' ')) {
                return true;
            }
        }
        if ((cells[0][0] == cells[1][1] && cells[1][1] == cells[2][2] && cells[0][0] != ' ') ||
                (cells[0][2] == cells[1][1] && cells[1][1] == cells[2][0] && cells[0][2] != ' ')) {
            return true;
        }

        return false;
    }
}
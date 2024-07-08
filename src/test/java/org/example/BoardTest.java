package org.example;

import org.example.Board;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTest {
    @Test
    public void testBoardIsCellEmpty() {
        Board board = new Board();
        Assertions.assertTrue(board.isCellEmpty(0, 0));
        board.place(0, 0, 'X');
        Assertions.assertFalse(board.isCellEmpty(0, 0));
    }



    @Test
    public void testBoardPlace() {
        Board board = new Board();
        board.place(0, 0, 'X');
        Assertions.assertFalse(board.isCellEmpty(0, 0));
        assertEquals('X', board.cells[0][0]);
    }



    @Test
    public void testBoardIsFull() {
        Board board = new Board();
        Assertions.assertFalse(board.isFull());
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board.place(i, j, 'X');
            }
        }
        Assertions.assertTrue(board.isFull());
    }



    @Test
    public void testBoardClear() {
        Board board = new Board();
        board.place(0, 0, 'X');
        board.clear();
        Assertions.assertTrue(board.isCellEmpty(0, 0));
    }


    @Test
    public void testBoardPrint() {
        Board board = new Board();
        board.place(0, 0, 'X');
        board.place(1, 1, 'O');

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
        board.print();
        System.setOut(originalOut);


        String expectedOutput = "X| | \n-----\n |O| \n-----\n | | \n";
        String actualOutput = outputStream.toString().replaceAll("\\s", "");
        Assertions.assertEquals(expectedOutput.replaceAll("\\s", ""), actualOutput);
    }
   
}
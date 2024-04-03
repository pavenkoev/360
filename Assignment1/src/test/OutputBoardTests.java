package test;

import assignment.InputBoard;
import assignment.OutputBoard;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

public class OutputBoardTests {
    private static OutputBoard createBoard(final String theInput) {
        final InputBoard inputBoard = InputBoard.readBoard(new Scanner(theInput));
        return OutputBoard.createFromInputBoard(inputBoard);
    }

    @Test
    public void hints1x1Mine() {
        final OutputBoard board = createBoard("1 1\n*");

        Assertions.assertEquals("*\n", board.toString());
    }

    @Test
    public void hints1x1NoMine() {
        final OutputBoard board = createBoard("1 1\n.");

        Assertions.assertEquals("0\n", board.toString());
    }

    @Test
    public void hints2x2() {
        final OutputBoard board = createBoard("2 2\n.*\n*.");

        Assertions.assertEquals("2*\n*2\n", board.toString());
    }

    @Test
    public void hints2x2NoMines() {
        final OutputBoard board = createBoard("2 2\n..\n..");

        Assertions.assertEquals("00\n00\n", board.toString());
    }

    @Test
    public void hints4x4() {
        final OutputBoard board = createBoard("4 4\n*...\n....\n.*..\n....");

        Assertions.assertEquals("*100\n2210\n1*10\n1110\n", board.toString());
    }
}

package test;

import assignment.BoardCell;
import assignment.InputBoard;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

public class InputBoardTests {
    @Test
    public void constructor() {
        final InputBoard board = new InputBoard(1, 1,
                new BoardCell[][] {new BoardCell[] {BoardCell.Mine}});

        Assertions.assertEquals(1, board.getLines());
        Assertions.assertEquals(1, board.getColumns());
        Assertions.assertTrue(board.isMine(0, 0));
    }

    @Test
    public void readBoard1x1() {
        final String input = "1 1\n*";
        final InputBoard board = InputBoard.readBoard(new Scanner(input));

        Assertions.assertNotNull(board);
        Assertions.assertEquals(1, board.getLines());
        Assertions.assertEquals(1, board.getColumns());

        Assertions.assertTrue(board.isMine(0, 0));
    }

    @Test
    public void readBoard2x2() {
        final String input = "2 2\n*.\n..";
        final InputBoard board = InputBoard.readBoard(new Scanner(input));

        Assertions.assertNotNull(board);
        Assertions.assertEquals(2, board.getLines());
        Assertions.assertEquals(2, board.getColumns());

        Assertions.assertTrue(board.isMine(0, 0));
        Assertions.assertFalse(board.isMine(0, 1));
        Assertions.assertFalse(board.isMine(1, 0));
        Assertions.assertFalse(board.isMine(1, 1));
    }

    @Test
    public void readBoard3x1() {
        final String input = "3 1\n*\n.\n*";
        final InputBoard board = InputBoard.readBoard(new Scanner(input));

        Assertions.assertNotNull(board);
        Assertions.assertEquals(3, board.getLines());
        Assertions.assertEquals(1, board.getColumns());

        Assertions.assertTrue(board.isMine(0, 0));
        Assertions.assertFalse(board.isMine(1, 0));
        Assertions.assertTrue(board.isMine(2, 0));
    }

    @Test
    public void readBoardNull() {
        final String input = "";
        final InputBoard board = InputBoard.readBoard(new Scanner(input));

        Assertions.assertNull(board);
    }

    @Test
    public void readBoardInvalidFormat() {
        final String input = "lines 2 columns 2\n*.\n..";
        final InputBoard board = InputBoard.readBoard(new Scanner(input));

        Assertions.assertNull(board);
    }

    @Test
    public void readBoardInvalidCharacters() {
        final String input = "2 2\n*-\n?+";
        final InputBoard board = InputBoard.readBoard(new Scanner(input));

        Assertions.assertNull(board);
    }

    @Test
    public void readBoardZeroSize() {
        final String input = "0 0\n*";
        final InputBoard board = InputBoard.readBoard(new Scanner(input));

        Assertions.assertNull(board);
    }

    private static InputBoard createBoard(final String theInput) {
        return InputBoard.readBoard(new Scanner(theInput));
    }

    @Test
    public void calculateMinesAround1x1() {
        final InputBoard board = createBoard("1 1\n*");

        Assertions.assertEquals(0, board.calculateMineCountAroundCell(0, 0));
    }

    @Test
    public void calculateMinesAround1x2() {
        final InputBoard board = createBoard("1 2\n.*");

        Assertions.assertEquals(1, board.calculateMineCountAroundCell(0, 0));
    }

    @Test
    public void calculateMinesAround2x2() {
        final InputBoard board = createBoard("2 2\n.*\n*.");

        Assertions.assertEquals(2, board.calculateMineCountAroundCell(1, 1));
    }
}

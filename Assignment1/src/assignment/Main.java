/*
 * Group Assignment 1
 * Elle Pavenko
 */

package assignment;

import java.util.Scanner;

/**
 * The {@code Main} class serves as the entry point for application.
 * @author Elle Pavenko
 * @version 1.0
 */
public final class Main {
    /**
     * Private constructor to prevent instantiation of this utility class.
     */
    private Main() {

    }

    /**
     * The main method of the application. Reads board configurations from standard input,
     * generates and displays output boards with hints for each input board. The method
     * continues reading and processing input boards until no more boards are provided.
     *
     * @param theArgs Command-line arguments passed to the program.
     */
    public static void main(final String[] theArgs) {
        final Scanner scanner = new Scanner(System.in);

        InputBoard inputBoard = null;
        int boardNumber = 1;

        while ((inputBoard = InputBoard.readBoard(scanner)) != null) {
            final OutputBoard outputBoard = OutputBoard.createFromInputBoard(inputBoard);
            System.out.println("Field #" + boardNumber++ + ":");
            System.out.println(outputBoard);
        }
    }
}
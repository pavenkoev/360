/*
 * Group Assignment 1
 * Elle Pavenko
 */

import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;

/**
 * The {@code InputGenerator} class generates input for a minefield game application.
 * It reads configuration settings from standard input and produces a random game board
 * based on specified dimensions and mine probability.
 * @author Elle Pavenko
 * @version 1.0
 */
public final class InputGenerator {
    /**
     * Private constructor to prevent instantiation of this utility class.
     */
    private InputGenerator() {

    }

    /**
     * The main method that serves as the entry point for the input generator.
     * It prompts the user to enter the dimensions of the game board and the probability
     * of mines being placed in each cell. The method continuously listens for input until
     * the user decides to exit by entering 'exit'.
     *
     * @param theArgs Command-line arguments passed to the program.
     */
    public static void main(final String[] theArgs) {
        final Scanner scanner = new Scanner(System.in);
        final Random random = new Random();

        System.out.println("Input example: \n10 10 0.3");
        System.out.println("'random' to generate boards with random parameters");
        System.out.println("'exit' to exit");
        System.out.println();

        while (true) {
            try {
                System.out.print("Enter number of lines, columns, mine probability "
                        + "(or 'exit' or 'random'): ");
                String input = scanner.nextLine();
                input = input.trim();

                if ("exit".equalsIgnoreCase(input)) {
                    break;
                } else if ("random".equalsIgnoreCase(input)) {
                    System.out.print("How many? ");

                    final int number = scanner.nextInt();
                    scanner.nextLine();

                    generateRandomBoards(random, number);
                } else {
                    run(input, random);
                }

            } catch (final NoSuchElementException e) {
                System.err.println("Incorrect input.");
            }
        }
    }

    /**
     * Processes the user's input, extracting the dimensions of the board
     * and the mine probability, then invokes the board
     * generation process with these parameters.
     *
     * @param theInput The user's input string containing
     *                 board dimensions and mine probability.
     * @param theRandom An instance of {@code Random} to generate
     *                  random values for mine placement.
     * @throws NoSuchElementException If the input does not contain enough data
     * or is in an incorrect format.
     */
    private static void run(final String theInput, final Random theRandom)
            throws NoSuchElementException {
        final Scanner scanner = new Scanner(theInput);
        final int lines = scanner.nextInt();
        final int columns = scanner.nextInt();
        final double mineProbability = scanner.nextDouble();

        generateBoard(theRandom, lines, columns, mineProbability);
    }

    /**
     * Generates and prints a specified number of random boards to standard output.
     * Board dimensions and mine probabilities are randomly determined.
     *
     * @param theRandom Random instance for determining board specs.
     * @param theNumber Number of boards to generate.
     */
    private static void generateRandomBoards(final Random theRandom, final int theNumber) {
        for (int i = 0; i < theNumber; i++) {
            final int lines = theRandom.nextInt(1, 100 + 1);
            final int columns = theRandom.nextInt(1, 100 + 1);
            final double mineProbability = theRandom.nextDouble();

            System.out.println(lines + " " + columns);
            generateBoard(theRandom, lines, columns, mineProbability);
        }
    }

    /**
     * Generates a game board with the specified dimensions and mine probability.
     * The board is printed to standard output, with '*' representing a mine and '.'
     * representing an empty space.
     *
     * @param theRandom An instance of {@code Random} used to determine mine placement.
     * @param theLines The number of lines (rows) for the game board.
     * @param theColumns The number of columns for the game board.
     * @param theMineProbability The probability of a cell containing a mine.
     */
    private static void generateBoard(final Random theRandom,
                                      final int theLines, final int theColumns,
                                      final double theMineProbability) {
        for (int i = 0; i < theLines; i++) {
            for (int j = 0; j < theColumns; j++) {
                if (theRandom.nextDouble() <= theMineProbability) {
                    System.out.print("*");
                } else {
                    System.out.print(".");
                }
            }

            System.out.println();
        }
    }
}

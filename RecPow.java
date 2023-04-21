import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This program uses recursion to calculate
 * a power to a number.
 *
 * @author Sarah Andrew
 * @version 1.0
 *
 * @since 2023-04-13
 */
public final class RecPow {

    /**
     * This is a private constructor used to satisfy the
     * style checker.
     *
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
     */
    private RecPow() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * This is the main method.
     *
     * @param args Unused.
     */
    public static void main(String[] args) {
        // Pass path to file as parameter.
        final File file = new File("input.txt");
        final File fileOut = new File("output.txt");

        // Usage of try catch to detect error.
        try {
            // Create FileWriter object to write to file.
            final FileWriter fW = new FileWriter(fileOut);
            // Create Scanner object to read from file.
            final Scanner sc = new Scanner(file);

            // Create PrintWriter object to write to file.
            final PrintWriter write = new PrintWriter(fW);

            // Create an ArrayList to hold the input values.
            final ArrayList<String> inputList =
                new ArrayList<String>();

            // Read in all values from input file.
            while (sc.hasNextLine()) {
                final String line = sc.nextLine();
                inputList.add(line);
            }

            // Iterate through the input list.
            for (String input : inputList) {
                try {
                    // Split the input string into the base and exponent.
                    final String[] inputParts = input.split(" ");

                    // Parse the base and exponent as integers,
                    // accessing it at index.
                    final int base = Integer.parseInt(inputParts[0]);
                    final int exp = Integer.parseInt(inputParts[1]);

                    // If statement to determine negative inputs.
                    if (base >= 1 && exp >= 0) {
                        // Call function.
                        final int recPower = recPow(base, exp);

                        // Display results.
                        System.out.print("The number " + base);
                        System.out.print("^" + exp);
                        System.out.println(" is = " + recPower);

                        // Write to output file.
                        write.print("The number " + base);
                        write.print("^" + exp);
                        write.println(" is = " + recPower);
                    } else {
                        // Displays error to user.
                        System.out.println("Please enter a positive number.");
                        write.println("Please enter a positive number.");
                    }

                } catch (NumberFormatException E) {
                    // Write error to output file &
                    // displays to user.
                    System.out.println("Invalid input: " + input);
                    write.println("Error: Invalid input - " + input);
                }
            }
            // Close scanners.
            sc.close();
            write.close();

        } catch (IOException error) {
            // Displays error to user.
            System.out.println("An error occurred: "
                    + error.getMessage());
        }
    }

    /**
     * This function uses recursion to
     * a power to a number.
     *
     * @param base passed
     * @param exp passed.
     * @return recPow.
     */
    public static int recPow(int base, int exp) {
        // Calculates power of a number.
        // Define base cases.
        if (exp == 0) {
            // Returns 1.
            return 1;
        } else {
            // Calls function recursively.
            return base * recPow(base, exp - 1);
        }
    }
}

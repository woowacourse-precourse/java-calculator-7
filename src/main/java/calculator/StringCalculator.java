package calculator;

import java.util.ArrayList;
import java.util.List;

/**
 * This class parses the input string and calculates the sum of a list of integers.
 */
public class StringCalculator {

    /**
     * This method returns default separators
     * @return default separators
     */
    private ArrayList<String> getDefaultSeparator() {
        return new ArrayList<String>(List.of(",", ":"));
    }

    /**
     * This method return custom separators
     * @param input The string to get custom separator
     * @return A list of default separators + custom separator
     */
    private ArrayList<String> getCustomSeparator(String input) {
        ArrayList<String> separators = getDefaultSeparator();

        String custom_separator = input.split("\\\\n")[0];
        custom_separator = custom_separator.substring(2);
        separators.add(custom_separator);

        return separators;
    }

    /**
     * This method return numbers separated by separators
     * @param input The string to get numbers
     * @param separators The string to split numbers
     * @return A list of numbers
     */
    private ArrayList<Integer> getNumbers(String input, ArrayList<String> separators) {
        ArrayList<Integer> numbers = new ArrayList<Integer>();

        String number_string = input.split("\\n")[1];
        System.out.println("number_string: " + number_string);

        String separator = String.join("|", separators);

        for (String num : number_string.split(separator)) {
            numbers.add(Integer.parseInt(num));
        }

        return numbers;
    }
}

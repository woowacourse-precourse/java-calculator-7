package calculator;

import java.util.List;

/**
 * Interface for parsing input string to numbers. Implementations should provide a way to parse input string to
 * numbers.
 *
 * @see SimpleParser
 * @see calculator.myParser.MyParser
 */
public interface Parser {
    /**
     * Parse input string to numbers.
     *
     * @param input input string to parse
     * @return list of numbers parsed from input string
     * @throws IllegalArgumentException if the input string is invalid
     */
    List<Double> parse(String input);
}

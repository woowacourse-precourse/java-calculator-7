package calculator;

import java.util.List;

/**
 * Interface for parsing input string to numbers. Implementations should provide a way to parse input string to
 * numbers.
 *
 * @see SimpleParser
 */
public interface Parser {
    /**
     * Parse input string to numbers. Throw an <code>IllegalArgumentException</code> if the input string is invalid.
     *
     * @param input input string to parse
     * @return list of numbers parsed from input string
     */
    List<Integer> parse(String input);
}

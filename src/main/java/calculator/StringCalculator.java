package calculator;

import java.util.ArrayList;
import java.util.List;

/**
 * This class parses the input string and calculates the sum of a list of integers.
 */
public class StringCalculator {

    /**
     * This method returns default seperators
     * @return default seperators
     */
    private ArrayList<String> getDefaultSeperator() {
        return new ArrayList<String>(List.of(",", ":"));
    }

}

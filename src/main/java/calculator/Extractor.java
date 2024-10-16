package calculator;

import java.util.Arrays;

public class Extractor {

    public int[] extractorNumbers(String delimitedNumbers) {
        String delimiter = "[,:]";

        String[] splitNumbers = delimitedNumbers.split(delimiter);

        return Arrays.stream(splitNumbers).mapToInt(Integer::parseInt).toArray();
    }
}

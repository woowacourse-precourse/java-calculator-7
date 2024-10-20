package calculator;

import java.math.BigInteger;

public class Calculator {

    BigInteger sumFromString(String inputString) {
        if (inputString.isEmpty()) {
            return BigInteger.ZERO;
        }

        NumberExtractor extractor = new NumberExtractor(inputString);
        String[] numberStrings = extractor.extractDelimitedNumbers();

        Numbers numbers = new Numbers(numberStrings);

        return numbers.sum();
    }
}
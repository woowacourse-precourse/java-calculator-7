package calculatorAddTest;

import java.math.BigInteger;

public class Calculator {

    BigInteger sumFromString(String inputString) {
        if (inputString.isEmpty()) {
            return BigInteger.ZERO;
        }

        Delimiter delimiter = new Delimiter(inputString);
        String[] delimitedNumbers = delimiter.getDelimitedNumbers();

        NumberValidator validator = new NumberValidator();
        validator.positiveNumberCheck(delimitedNumbers);

        return addingNumbers(delimitedNumbers);
    }

    private BigInteger addingNumbers(String[] delimitedNumbers) {
        BigInteger result = BigInteger.ZERO;
        for (String delimitedNumber : delimitedNumbers) {
            result = result.add(new BigInteger(delimitedNumber));
        }
        return result;
    }
}
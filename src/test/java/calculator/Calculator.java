package calculator;

import java.math.BigInteger;

public class Calculator {

    BigInteger sumFromString(String inputString) {
        if (inputString.isEmpty()) {
            return BigInteger.ZERO;
        } //공백 처리

        Delimiter delimiter = new Delimiter(inputString);
        String[] delimitedNumbers = delimiter.extractDelimitedNumbers();//구분자로 문자열 -> 숫자 처리

        NumberValidator validator = new NumberValidator();
        validator.validateNumbers(delimitedNumbers);//잘못된 값 예외 처리

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
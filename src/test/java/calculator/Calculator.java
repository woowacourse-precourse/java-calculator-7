package calculator;

import java.math.BigInteger;

public class Calculator {

    BigInteger sumFromString(String inputString) {
        if (inputString.isEmpty()) {
            return BigInteger.ZERO;
        } //공백 처리

        NumberExtractor Extractor = new NumberExtractor(inputString);
        String[] numbers = Extractor.extractDelimitedNumbers();//구분자로 문자열 -> 숫자 처리

        NumberValidator validator = new NumberValidator();
        validator.validateNumbers(numbers);//잘못된 값 예외 처리

        return sumNumbers(numbers);
    }

    private BigInteger sumNumbers(String[] numbers) {
        BigInteger sum = BigInteger.ZERO;
        for (String number : numbers) {
            sum = sum.add(new BigInteger(number));
        }
        return sum;
    }
}
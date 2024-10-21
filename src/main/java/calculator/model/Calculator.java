package calculator.model;

import static calculator.validate.Validator.validateNumber;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Calculator {

    private BigDecimal result = new BigDecimal(BigInteger.ZERO);
    private final Parser parser = new Parser();

    public void calculateSum(String delimiter, String numberContent) {
        String[] numbers = splitNumber(delimiter, numberContent);
        for (String number : numbers) {
            validateNumber(number);
            result = result.add(parser.parseToBigDecimal(number));
        }
    }

    private String[] splitNumber(String delimiter, String numberContent) {
        return numberContent.split(delimiter);
    }

    public BigDecimal getResult() {
        return result;
    }
}
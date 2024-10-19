package calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void calculate() {
        Delimiter delimiter = new Delimiter();
        DelimiterParser dp = new DelimiterParser();

        String input = "//@\\n1,2,3//,\\n4:5:6//!\\n7!8!9//_\\n";
        String customDelimiter = dp.findCustomDelimiter(input);

        delimiter.addCustomDelimiter(customDelimiter);
        input = dp.removeCustomDelimiterRegistrant(input);

        System.out.println("input = " + input);

        Calculator calculator = new Calculator(delimiter, input);
        long result = calculator.calculate();

        System.out.println("result = " + result);
    }
}
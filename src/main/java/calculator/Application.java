package calculator;

import java.math.BigInteger;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        String input = IoHandler.getUserInput();
        List<BigInteger> numbers = StringParser.extractNumbers(input);
        IoHandler.print("결과 : " + Calculator.add(numbers));
    }
}
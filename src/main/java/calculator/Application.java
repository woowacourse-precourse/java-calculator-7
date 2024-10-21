package calculator;

import calculator.plusCalculator.PlusCalculator;
import calculator.plusCalculator.PlusCalculatorInterface;
import calculator.view.Request;
import calculator.view.Response;
import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        PlusCalculatorInterface plusCalculator = new PlusCalculator(Arrays.asList(",", ":"));

        String input = Request.inputPlusCalculator();

        int result = plusCalculator.run(input);

        Response.outputPlusCalculator(result);
    }
}

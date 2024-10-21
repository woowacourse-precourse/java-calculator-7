package calculator;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        String input = InOutput.getInput();
        List<String> numbers = CalculatorParser.parser(input);
        int sum = CalculatorLogic.calculateSum(numbers);
        InOutput.printResult(sum);
    }
}
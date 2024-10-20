package calculator;

public class CalculatorService {
    public int calculator(String input) {
        String replacedInput = input.replace("\\n", "\n");

        DelimiterSplitter splitter = new DelimiterSplitter(replacedInput);
        AddCalculator addCalculator = new AddCalculator(splitter.split());
        return addCalculator.add();
    }
}

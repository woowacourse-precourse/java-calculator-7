package calculator;

import static calculator.InputView.inputString;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        StringInput input = new StringInput(inputString(ResultView::printInputString));

        StringSplitter stringSplitter = new StringSplitter();
        String[] stringNumbers = stringSplitter.split(input.getInput());

        StringConverter converter = new StringConverter();
        List<Integer> numbers = converter.convertToNumbers(stringNumbers);

        StringAddCalculator calculator = new StringAddCalculator();
        int result = calculator.sumNumList(numbers);

        ResultView.printResult(result);
    }
}

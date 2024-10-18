package calculator.controller;

import calculator.Delimiter;
import calculator.Number;
import calculator.UserInputString;
import calculator.view.InputView;
import calculator.view.OutputView;
import java.util.List;

public class CalculatorController {

    public void run() {
        OutputView.printStartMessage();
        String inputStringForAddition = InputView.readInputString();

        UserInputString userInput = new UserInputString(inputStringForAddition);
        if (userInput.isInputEmpty()) {
            OutputView.printResult("0");
            return;
        }

        Delimiter delimiter = new Delimiter(userInput.getInput());
        String delimiterRegex = delimiter.getDelimiterRegex();

        List<String> parser = userInput.parser(delimiterRegex);
        List<Long> inputNumbers = parser.stream().map(token -> {
            Number number = new Number(token);
            return number.getInputNumbers();
        }).toList();

        if (inputNumbers.size() > 10) {
            throw new IllegalArgumentException("10개 이상의 숫자를 더할 수 없습니다.");
        }

        Long result = inputNumbers.stream().mapToLong(Long::longValue).sum();

    }
}

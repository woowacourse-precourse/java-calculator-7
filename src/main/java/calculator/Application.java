package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        DelimiterParser dp = new DelimiterParser();
        Delimiter dm = new Delimiter();

        String input = inputView.getInput();
        String customDelimiter = dp.findCustomDelimiter(input);
        dm.addCustomDelimiter(customDelimiter);

        String removeInput = dp.removeCustomDelimiterRegistrant(input);
        Calculator calculator = new Calculator(dm, removeInput);


        long result = calculator.calculate();

        OutputView outputView = new OutputView();
        outputView.print(result);
    }
}

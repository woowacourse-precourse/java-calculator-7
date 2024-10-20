package calculator.calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

import calculator.delimiter.DelimiterService;
import calculator.util.InputUtil;
import calculator.view.ViewService;

public class Calculator {

    private DelimiterService delimiterService;
    private CalculateService calculateService;
    private int result;

    public Calculator() {
        this.delimiterService = new DelimiterService();
        this.calculateService = new CalculateService();
        this.result = 0;
    }

    public void run() {
        ViewService.viewInput();
        String input = readLine();
        InputUtil.checkInputDigit(input);

        if (!InputUtil.checkEmptyInput(input)) {
            String[] input_array = delimiterService.generateString(input);
            InputUtil.checkArrayNumber(input_array);
            result = calculateService.calculate(input_array);
        }
        ViewService.viewOutput(result);
    }
}

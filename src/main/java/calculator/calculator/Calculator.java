package calculator.calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

import calculator.delimiter.DelimiterService;
import calculator.util.InputUtil;
import calculator.view.ViewService;

public class Calculator {

    private DelimiterService delimiterService;
    private CalculateService calculateService;

    public Calculator() {
        this.delimiterService = new DelimiterService();
        this.calculateService = new CalculateService();
    }

    public void run() {
        ViewService.viewInput();
        String input = readLine();
        InputUtil.checkInputDigit(input);

        String[] input_array = delimiterService.generateString(input);
        InputUtil.checkArrayNumber(input_array);

        int result = calculateService.calculate(input_array);
        ViewService.viewOutput(result);
    }
}

package calculator;

import camp.nextstep.edu.missionutils.Console;

public class CalculatorView {

    CalculatorService calculatorService = new CalculatorService();

    public String getUserInput() {
        System.out.println(Constants.USER_INPUT_REQUEST_STRING);
        return Console.readLine();
    }

    public void outputCalculatorResults(int result) {
        System.out.println(Constants.CALCULATOR_RESULTS_OUTPUT_MESSAGE + result);
    }
}

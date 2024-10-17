package calculator.domain;

import calculator.global.ui.InputView;
import calculator.global.ui.OutView;
import camp.nextstep.edu.missionutils.Console;

public class Calculator {

    InputView inputView = new InputView();
    OutView outView = new OutView();

    public Calculator() {
    }

    public void run() {
        outView.startMessage();
        outView.resultMessage(sum(inputView.splitNumbers(Console.readLine())));
    }

    private int sum(String[] numbers) {

        int sum = 0;
        for (String number : numbers) {
            try {
                negativeNumberException(number);
                sum += Integer.parseInt(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            }
        }
        return sum;
    }

    private void negativeNumberException(String number) {
        if (Integer.parseInt(number) < 0) {
            throw new IllegalArgumentException();
        }
    }
}

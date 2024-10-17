package calculator.domain;

import calculator.global.ui.InputView;
import calculator.global.ui.OutView;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Calculator {

    InputView inputView = new InputView();
    OutView outView = new OutView();

    public void run() {
        outView.startMessage();
        outView.resultMessage(sum(inputView.parseIntNumbers(Console.readLine())));
    }

    private int sum(List<Integer> numbers) {
        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        return sum;
    }
}

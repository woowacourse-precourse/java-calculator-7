package calculator.ui;

import calculator.common.Request;
import calculator.common.Response;
import calculator.processor.Processor;
import camp.nextstep.edu.missionutils.Console;

public class Calculator {

    private final Processor processor;

    public Calculator(Processor processor) {
        this.processor = processor;
    }

    public void run() {
        Response response = processor.process(getNumbers());
        displayResult(response);
    }

    private Request getNumbers() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return new Request(Console.readLine());
    }

    private void displayResult(Response result) {
        System.out.println("결과 : " + result.body());
    }
}

package calculator.ui;

import calculator.common.Request;
import calculator.common.RequestType;
import calculator.common.Response;
import calculator.processor.Processor;
import camp.nextstep.edu.missionutils.Console;

public class Calculator {

    private final Processor processor;

    public Calculator(Processor processor) {
        this.processor = processor;
    }

    public void command(RequestType type) {
        Response response = processor.process(new Request(type, getNumbers()));
        displayResult(response);
    }

    private String getNumbers() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }

    private void displayResult(Response result) {
        System.out.println("결과 : " + result.body());
    }
}

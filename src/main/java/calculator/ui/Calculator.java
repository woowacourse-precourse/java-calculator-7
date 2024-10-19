package calculator.ui;

import calculator.common.Request;
import calculator.common.Response;
import camp.nextstep.edu.missionutils.Console;

public class Calculator {

    /**
     * TODO : 계산 요청을 처리하는 Processor 구현
     */
    public void run() {
        getNumbers();
    }

    private Request getNumbers() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return new Request(Console.readLine());
    }
}

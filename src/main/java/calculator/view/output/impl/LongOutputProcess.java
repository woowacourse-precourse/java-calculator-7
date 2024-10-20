package calculator.view.output.impl;

import calculator.view.output.InfoService;
import calculator.view.output.ResultService;

public class LongOutputProcess implements InfoService, ResultService {

    @Override
    public void info() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
    }

    @Override
    public void result(Number number) {
        System.out.printf("결과 : %,d", number.longValue());
    }
}

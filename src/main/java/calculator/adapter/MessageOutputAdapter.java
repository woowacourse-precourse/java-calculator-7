package calculator.adapter;

import calculator.domain.Number;

public final class MessageOutputAdapter {

    public void printInputMessage() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
    }

    public void printResult(final Number result) {
        System.out.println("결과 : " + result.value());
    }
}
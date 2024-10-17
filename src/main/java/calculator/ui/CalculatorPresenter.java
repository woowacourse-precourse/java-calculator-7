package calculator.ui;

import camp.nextstep.edu.missionutils.Console;

public class CalculatorPresenter {

    private final StringBuilder stringBuilder;

    public CalculatorPresenter(StringBuilder stringBuilder) {
        this.stringBuilder = stringBuilder;
    }

    public String splitAndSumInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }

    public void splitAndSumOutput(int result) {
        stringBuilder.append("결과 : ").append(result).append('\n');
        System.out.println(stringBuilder);
        bufferClear();
    }

    private void bufferClear() {
        stringBuilder.setLength(0);
    }

}

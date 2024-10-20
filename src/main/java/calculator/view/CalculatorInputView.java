package calculator.view;

import calculator.domain.CalcTarget;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class CalculatorInputView {
    private static final String INPUT_EXPRESSION = "덧셈할 문자열을 입력해 주세요.";

    public CalcTarget printInputView() {
        System.out.println(INPUT_EXPRESSION);
        try {
            return CalcTarget.input(readLine());
        } catch (Exception e) {
            throw new IllegalArgumentException("잘못된 입력값입니다.");
        }
    }
}

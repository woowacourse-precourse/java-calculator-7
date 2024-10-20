package calculator.view;

import calculator.domain.CalcTarget;

import java.util.NoSuchElementException;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class CalculatorInputView {
    private static final String INPUT_EXPRESSION = "덧셈할 문자열을 입력해 주세요.";

    public CalcTarget printInputView() {
        System.out.println(INPUT_EXPRESSION);
        String inputVal = "";
        try {
            inputVal = readLine();
            if (inputVal.isEmpty()) {
                inputVal = "0";
            }
            return CalcTarget.input(inputVal);

        } catch (NoSuchElementException e) {
            inputVal = "0";
            return CalcTarget.input(inputVal);
        }
    }
}

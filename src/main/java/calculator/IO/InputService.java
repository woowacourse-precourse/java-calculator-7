package calculator.IO;

import camp.nextstep.edu.missionutils.Console;


public class InputService {
    private String formula;

    public void readFormula() {
        // 문자열 입력 받기
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        formula = (Console.readLine());
    }

    public void checkValidFormula() {
        // 문자열에 아무 값도 입력되지 않은 경우
        if (isBlankFormula())
            formula = "0";
    }

    public Boolean isBlankFormula() {
        return formula.isBlank();
    }
}

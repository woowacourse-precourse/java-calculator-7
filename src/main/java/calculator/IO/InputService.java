package calculator.IO;

import camp.nextstep.edu.missionutils.Console;


public class InputService {
    private String formula;

    public void readFormula() {
        // 문자열 입력 받기
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        formula = (Console.readLine());
    }
}

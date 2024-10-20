package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Console {
    public String readCalcLine() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return readLine();
    }

    public void writeCalcResult(int result) {
        System.out.println("결과 : " + result);
    }
}

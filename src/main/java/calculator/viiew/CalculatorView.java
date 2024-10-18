package calculator.viiew;

import camp.nextstep.edu.missionutils.Console;

public class CalculatorView {

    /**
     * 계산할 문자열을 작성합니다.
     *
     * @return 작성한 문자열
     */
    public String input() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }

    /**
     * 계산기의 입력한 숫자를 더한 최종 값을 출력합니다.
     */
    public void resultOutput(int result) {
        System.out.println("결과 : " + result);
    }
}

package calculator;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    // 사용자로부터 문자열 입력 받기
    public String getInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }

    // 결과 출력
    public void printResult(int result) {
        System.out.println("결과 : " + result);
    }
}

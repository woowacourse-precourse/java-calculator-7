package calculator.view;

import camp.nextstep.edu.missionutils.Console;


public class CalculateView {

    // 사용자로부터 문자열 입력
    public String getInputString() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String inputString = Console.readLine();
        Console.close();
        return inputString;
    }

    // 최종 결과값 출력
    public void printResult(int result) {
        System.out.println("결과: " + result);
    }

}

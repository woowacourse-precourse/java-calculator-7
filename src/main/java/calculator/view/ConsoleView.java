package calculator.view;

import camp.nextstep.edu.missionutils.Console;

// 콘솔에서 사용자 입력을 처리하는 클래스
public class ConsoleView {

    // 사용자로부터 문자열 입력을 받는 메서드
    public String getInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }

    // 계산 결과를 콘솔에 출력하는 메서드
    public void printResult(int result) {
        System.out.println("결과 : " +  result);
    }

}
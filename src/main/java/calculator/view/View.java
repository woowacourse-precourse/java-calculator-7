package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class View {

    // View의 기본 생성자
    public View() {
    }

    // 사용자로부터 덧셈할 문자열 입력을 받는 메서드
    public String getInput() {
        // 사용자에게 입력을 요청하는 메시지 출력
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        // MissionUtils 라이브러리의 Console을 사용하여 사용자 입력을 읽음
        return Console.readLine();
    }

    // 계산 결과를 출력하는 메서드
    public void printResult(int result) {
        // 결과값을 출력하는 메시지
        System.out.println("결과 : " + result);
    }

    // 오류 메시지를 출력하는 메서드
    public void printError(String message) {
        // 발생한 예외 메시지를 출력
        System.out.println("잘못된 입력입니다: " + message);
    }
}

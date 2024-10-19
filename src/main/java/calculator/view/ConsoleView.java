package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleView {

    //사용자로부터 문자열 입력 받기
    public String getInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }

    //계산 결과를 콘솔에 출력: 예) '결과 : 6'
    public void printResult(int result) {
        System.out.println("결과 : " +  result);
    }

    //오류 발생시 오류 메시지 출력
    public void printErrorMessage(String message) {
        System.out.println("오류 발생 : " + message);
    }




}
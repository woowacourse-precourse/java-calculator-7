package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.print("덧셈할 문자열을 입력해주세요 : ");
        String input = Console.readLine(); // 사용자의 값을 입력받음

        StringCalculator calculator = new StringCalculator();

        // 숫자 추출 테스트
        System.out.println("입력된 문자열에서 추출된 숫자: " + calculator.extractNumToString(input));


    }
}

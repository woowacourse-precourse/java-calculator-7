package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // 사용자에게 입력 요청
        System.out.print("문자열 입력: ");

        // 콘솔에서 입력받은 값을 input에 저장
        String input = Console.readLine();

        // 입력받은 값을 출력
        System.out.println("입력한 문자열: " + input);
    }
}

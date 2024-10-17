package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // x를 눌러 종료

//      while문으로 돌리는건 폐기, Console의 메모리 처리방식 미흡

        System.out.println("숫자를 입력해 주세요.\n(H : 도움말 | 기본 구분자 : ',' 또는 ':')");
        String inputString = Console.readLine().trim();

        // h를 눌러 도움말 호출
        if (inputString.equalsIgnoreCase("H")) {
            new Helper();
        } else if (inputString.isEmpty()) {
            System.out.println("결과 : 0");
        } else {
            new Calculator(inputString);
        }
    }
}

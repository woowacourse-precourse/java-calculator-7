package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        // 사용자에게 `덧셈할 문자열을 입력해 주세요.` 라고 `콘솔`을 통해 질의한다.
        System.out.println("덧셈할 문자열을 입력해 주세요.");

        // `Scanner` 를 연다.
        // `쉼표(,)`와 `콜론(:)` 같은 구분자와 `양수`로 구성된 `문자열`을 입력 받는다. (예시: "1,2:3")
        String input = Console.readLine();
    }
}

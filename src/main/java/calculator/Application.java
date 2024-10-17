package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        try {
            System.out.println("덧셈할 문자열을 입력해 주세요.\n" +
                    "구분자는 쉼표(,) 또는 콜론(:)을 사용할 수 있습니다.\n" +
                    "예를 들어 '1,2:3'은 1 + 2 + 3 = 6과 같습니다.\n\n" +
                    "커스텀 구분자를 사용하고 싶다면 //(사용할 구분자)\\n(덧셈할 문자열)을 입력해 주세요.\n" +
                    "예를 들어 커스텀 구분자로 세미콜론(;)을 지정한다면 '//;\\n1;2;3'을 입력하면 됩니다.");
            String input = Console.readLine();
            // 계산기
            System.out.println(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

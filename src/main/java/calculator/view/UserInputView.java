package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class UserInputView {

    public static String inputExpression() {

        System.out.println("덧셈할 문자열을 입력해 주세요.\n");

        return Console.readLine(); // 입력받은 문자열을 반환한다.
    }
}

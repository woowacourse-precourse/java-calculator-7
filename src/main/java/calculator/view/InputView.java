package calculator.view;

// InputView.java
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    // 사용자로부터 문자열을 입력받음
    public static String getInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }
}

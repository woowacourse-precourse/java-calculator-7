package calculator;
import camp.nextstep.edu.missionutils.Console;

public class Input {
    public static String makeInput() {
        Output.print("덧셈할 문자열을 입력해 주세요");
        return Console.readLine();
    }
}

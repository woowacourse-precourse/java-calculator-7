package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {
    public List<String> read() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Arrays.asList(Console.readLine().split(","));
    }
}

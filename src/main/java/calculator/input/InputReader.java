package calculator.input;

import camp.nextstep.edu.missionutils.Console;

public class InputReader {

    public String readLine() throws IllegalArgumentException {
        String inputView = "덧셈할 문자열을 입력해 주세요.";
        System.out.println(inputView);
        return Console.readLine();
    }

    public void close() {
        Console.close();
    }

}

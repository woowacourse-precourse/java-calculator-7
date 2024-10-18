package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static final String inputMessage = "덧셈할 문자열을 입력해 주세요.";
    public static void main(String[] args) {
        System.out.println(inputMessage);
        String input = readLine();
    }
}

package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    private static final String inputPhrase = "덧셈할 문자열을 입력해 주세요.";

    public static void main(String[] args) {
        System.out.println("inputPhrase = " + inputPhrase);
        String userInput = readLine();
    }
}

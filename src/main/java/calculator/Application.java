package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    private static final String inputPhrase = "덧셈할 문자열을 입력해 주세요.";
    private static final String outputPhrase = "결과 : ";
    private static final String startCustomPattern = "//";
    private static final String endCustomPattern = "\n";

    public static void main(String[] args) {
        System.out.println(inputPhrase);
        String userInput = readLine();
    }

    private static boolean isCustomDelimiter(String userInput) {
        return userInput.startsWith(startCustomPattern) && userInput.contains(endCustomPattern);
    }

}

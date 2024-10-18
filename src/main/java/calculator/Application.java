package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    private static final String GUIDE_MESSAGE = "덧셈할 문자열을 입력해 주세요.";
    private static final String RESULT_MESSAGE = "결과 : ";

    public static void main(String[] args) {
        printGuideMessage();
        String input = Console.readLine();

        StringCalculator stringCalculator = new StringCalculator(new DelimiterParser());
        int result = stringCalculator.add(input);

        printResultMessage(result);
    }

    private static void printGuideMessage() {
        System.out.println(GUIDE_MESSAGE);
    }

    private static void printResultMessage(int result) {
        System.out.println(RESULT_MESSAGE + result);
    }
}

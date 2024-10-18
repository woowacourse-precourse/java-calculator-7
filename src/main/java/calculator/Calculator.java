package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Calculator {

    private final static String START_COMMENT = "덧셈할 문자열을 입력해 주세요.";
    private final static String RESULT_COMMENT = "결과 : ";

    public static void run() {
        System.out.println(START_COMMENT);

        String words = Console.readLine();

        if (words.isEmpty()) {
            System.out.println(RESULT_COMMENT + 0);
            return;
        }

        String[] delimiterArray = Delimiter.getDelimiter(words);

        int result = sum(delimiterArray);
        System.out.println(RESULT_COMMENT + result);
    }

    public static int sum(String[] delimiterArray) {
        int result = 0;

        for (String number : delimiterArray) {
            int parsedNumber = Integer.parseInt(number);
            result += parsedNumber;
        }

        return result;
    }

}

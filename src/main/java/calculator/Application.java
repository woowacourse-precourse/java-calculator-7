package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;

public class Application {

    private static final String INPUT_GUIDE_MESSAGE = "덧셈할 문자열을 입력해 주세요.";
    private static final String DEFAULT_DELIMITER = "[,:]";

    public static void main(String[] args) {

        String inputString = getInputString();
        int[] extractedNumbers = extractNumbers(inputString, DEFAULT_DELIMITER);
        System.out.println(Arrays.toString(extractedNumbers));
    }

    private static String getInputString() {

        System.out.println(INPUT_GUIDE_MESSAGE);
        return Console.readLine();
    }

    private static int[] extractNumbers(String inputString, String delim) {

        String[] extractedStringNumbers = inputString.split(delim);
        return Arrays.stream(extractedStringNumbers).mapToInt(Integer::parseInt).toArray();
    }
}

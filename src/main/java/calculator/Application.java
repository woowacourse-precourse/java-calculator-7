package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Application {

    private static final String INPUT_GUIDE_MESSAGE = "덧셈할 문자열을 입력해 주세요.";
    private static final String DEFAULT_DELIMITER = ",:";

    public static void main(String[] args) {

        String inputString = getInputString();
        ArrayList<Integer> extractedNumbers = extractNumbers(inputString, DEFAULT_DELIMITER);
        System.out.println(extractedNumbers);
    }

    private static String getInputString() {

        System.out.println(INPUT_GUIDE_MESSAGE);
        return Console.readLine();
    }

    private static ArrayList<Integer> extractNumbers(String inputString, String delim) {

        ArrayList<Integer> numbersToSum = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(inputString, delim);

        while (tokenizer.hasMoreTokens()) {
            numbersToSum.add(Integer.valueOf(tokenizer.nextToken()));
        }

        return numbersToSum;
    }
}

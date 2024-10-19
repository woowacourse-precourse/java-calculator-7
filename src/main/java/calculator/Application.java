package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {

    static String customDelemiter;
    public static void main(String[] args) {

        String numsInput;
        String[] input = Console.readLine().split("\\\\n");

        System.out.println(Arrays.toString(input));
        if (input.length > 1) {
            String prefix = input[0];
            numsInput = input[1];

            if (prefix != null && !prefix.isEmpty()) {
                customDelemiter = getCustomDelimiter(prefix);
                System.out.println("커스텀 구분자: " + customDelemiter);
            }
        } else {
            numsInput = input[0];
        }

        String[] delimiters = getDelimiters();
        String delimiter = String.join("|", delimiters);

        String[] nums = numsInput.split(delimiter);
        System.out.println(Arrays.toString(nums));

        Console.close();
    }

    private static String[] getDelimiters() {
        String[] delimiters;
        if (customDelemiter == null) {
            delimiters = new String[] {",", ":"};
            return delimiters;
        }
        delimiters = new String[] {",", ":", customDelemiter};
        return delimiters;
    }

    private static String getCustomDelimiter(String input) {

        if (!input.startsWith("//")) return null;   // 형식 예외처리 필요

        String delimiter = input.substring(2);
        if (delimiter.length() > 1) return null;    // 구분자 길이 예외처리 필요

        return delimiter;
    }

}

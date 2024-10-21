package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;

public class Application {

    static String customDelemiter;
    public static void main(String[] args) {

        System.out.println("덧셈할 문자열을 입력해 주세요.");

        String numsInput;
        String[] input = Console.readLine().split("\\\\n");

        System.out.println(Arrays.toString(input));
        if (input.length > 1) {
            String prefix = input[0];
            numsInput = input[1];

            if (prefix != null && !prefix.isEmpty()) {
                customDelemiter = getCustomDelimiter(prefix);
            }
        } else {
            numsInput = input[0];
        }

        String[] delimiters = getDelimiters();
        String delimiter = String.join("|", delimiters);

        String[] nums = numsInput.split(delimiter);
        int result = 0;
        if (isAllNumbers(nums)) {
            for (String num : nums) {
                result += Integer.parseInt(num);
            }
        }

        System.out.println("결과 : " + result);
        Console.close();
    }

    private static boolean isAllNumbers(String[] nums) {
        for (String num : nums) {
            if (!num.matches("\\d+")) {
                throw new IllegalArgumentException("덧셈할 숫자는 양수만 입력 가능합니다.");
            };
        }
        return true;
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

        if (!input.startsWith("//")) {
            throw new IllegalArgumentException("구분자 입력형식이 올바르지 않습니다.");
        };

        String delimiter = input.substring(2);
        if (delimiter.length() > 1) {
            throw new IllegalArgumentException("구분자는 한글자여야 합니다.");
        };

        return delimiter;
    }

}

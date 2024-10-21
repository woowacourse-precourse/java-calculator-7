package calculator;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    static List<String> delimiters = new ArrayList<>(Arrays.asList(",", ":"));

    public static void main(String[] args) {

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String str = Console.readLine();

        long answer = 0;

        if ((str.startsWith("//") && str.contains("\\n"))) {
            delimiters = checkDelimiter(str);
        }

        String[] nums = splitNum(str, delimiters);

        checkError(nums);
        // 나눠진 문자열 이용해 합계 계산

        System.out.println("결과 : " + answer);

    }

    private static List<String> checkDelimiter(String str) {
        String tmp = str.substring(2, str.indexOf("\\n"));
        delimiters.add(tmp);
        return delimiters;
    }

    private static String[] splitNum(String str, List<String> delimiter) {
        String input = str.substring(str.indexOf("\\n") + 2);
        String lastDeli = String.join("|", delimiters);
        return input.split(lastDeli);
    }

    private static void checkError(String[] nums) {
        for (String num : nums) {
            int tmp = Integer.parseInt(num);
            if (tmp < 0) {
                throw new IllegalArgumentException (
                        "음수가 포함되어 있습니다."
                );
            }
        }

        if (nums.length == 0) {
            throw new IllegalArgumentException(
                    "덧셈을 수행할 숫자가 없습니다."
            );
        }
    }

}


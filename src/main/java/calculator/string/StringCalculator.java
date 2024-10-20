package calculator.string;

import java.util.Arrays;

public class StringCalculator {

    /** 기본 구분자로 계산
     * @param str 계산될 문자열
     * @return 구분자들로 구분된 문자열들의 합
     */
    public int calculate(String str, String regex) {

        if (str.isEmpty() || regex == null) return 0;

        int result;
        String[] nums = str.split(regex);

        result = Arrays.stream(nums)
                .mapToInt(this::customParseToInt)
                .sum();

        return result;
    }

    private int customParseToInt(String str) {
        int num;
        try {
            num = Integer.parseInt(str);
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        if (num < 0) {
            throw new IllegalArgumentException();
        }
        return num;
    }
}
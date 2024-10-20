package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

public class Application {

    public static void main(String[] args) {

        try {
            System.out.println("덧셈할 문자열을 입력해 주세요.");

            String inputString = Console.readLine();
            double result = processInput(inputString);

            System.out.println("결과 : " + result);
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }

    }

    /**
     * 구분자와 양수로 구성된 문자열에서 숫자의 합을 계산합니다.
     *
     * @param s 합을 계산할 문자열
     * @return 합계
     */
    static double processInput(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        String customDelimiter = getCustomDelimiter(s);
        String delimiters = getDelimiters(customDelimiter);
        String refinedString = refineInput(s);

        String[] tokens = refinedString.split(delimiters);
        return addNumbers(tokens);
    }

    /**
     * 구분자와 양수로 구성된 문자열에서 커스텀 구분자를 추출합니다.
     *
     * @param s 구분자와 양수로 구성된 문자열
     * @return 커스텀 구분자 또는 null
     */
    static String getCustomDelimiter(String s) {
        if (s.startsWith("//")) {
            int endOfDelimiter = s.indexOf("\\n");

            return s.substring(2, endOfDelimiter);
        }

        return null;
    }

    /**
     * 기본 구분자와 커스텀 구분자를 포함한 모든 구분자들을 반환합니다.
     *
     * @param customDelimiter 커스텀 구분자
     * @return 구분자들
     */
    static String getDelimiters(String customDelimiter) {
        String defaultDelimiters = ",|:";

        if (customDelimiter != null) {
            return defaultDelimiters + "|" + Pattern.quote(customDelimiter);
        }

        return defaultDelimiters;
    }

    /**
     * 커스텀 구분자를 제외한 나머지 문자열을 정제합니다.
     *
     * @param s 커스텀 구분자
     * @return 정제된 문자열
     */
    static String refineInput(String s) {
        if (s.startsWith("//")) {
            int startOfNumbers = s.indexOf("\\n") + 2;
            return s.substring(startOfNumbers);
        }

        return s;
    }

    /**
     * 문자열 배열에 담긴 숫자들을 더합니다.
     *
     * @param strArr 문자열 배열
     * @return 합계
     */
    static double addNumbers(String[] strArr) {

        double sumResult = 0;

        for (String strToken : strArr) {
            double doubleToken = Double.parseDouble(strToken);

            if (doubleToken <= 0) {
                throw new IllegalArgumentException("양수가 아닙니다.");
            }

            sumResult += doubleToken;
        }

        return sumResult;

    }

}

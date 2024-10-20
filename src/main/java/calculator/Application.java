package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;


public class Application {

    /**
     * 구분자와 양수로 구성된 문자열에서 숫자의 합을 계산합니다.
     *
     * @param s 합을 계산할 문자열
     * @return 합계
     */
    static int calculate(String s) {
        if (s.equals("")) {
            return 0;
        }


        String refinedString = s;
        String listOfDelimiters = ",|:";

        // 커스텀 구분자 처리
        if (s.startsWith("//")) {
            int endOfDelimiter = s.indexOf("\\n");

            String customDelimiter = s.substring(2, endOfDelimiter);
            listOfDelimiters += "|" + Pattern.quote(customDelimiter);

            int startOfNumbers = endOfDelimiter + 2;
            refinedString = s.substring(startOfNumbers);
        }


        String[] tokens = refinedString.split(listOfDelimiters);
        int sumResult = 0;

        for (String stringToken : tokens) {
            int integerToken = Integer.parseInt(stringToken);

            if (integerToken <= 0) {
                throw new IllegalArgumentException("양수가 아닙니다.");
            }

            sumResult += integerToken;
        }

        return sumResult;

    }

    public static void main(String[] args) {

        System.out.println("덧셈할 문자열을 입력해 주세요.");

        String inputString = Console.readLine();

        int result = calculate(inputString);
        System.out.println("결과 : " + result);

    }
}

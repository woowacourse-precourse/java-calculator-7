package calculator;

import calculator.string.RegexUtil;
import calculator.string.StringCalculator;
import camp.nextstep.edu.missionutils.Console;


public class Application {

    private static final String DEFAULT_REGEX_ELEMENT1 = ",";
    private static final String DEFAULT_REGEX_ELEMENT2 = ":";

    public static void main(String[] args) {
        /* 기본 구분자 + 커스텀 구분자 까지 기능 구현
        * */

        StringCalculator stringCalculator = new StringCalculator();
        RegexUtil regexUtil = new RegexUtil();


        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String inputStr = Console.readLine();
        String customDelim = regexUtil.parseCustomDelimiter(inputStr);

        String regex;
        if (customDelim == null) {
            regex = regexUtil.createRegex(DEFAULT_REGEX_ELEMENT1, DEFAULT_REGEX_ELEMENT2);
        } else {
            regex = regexUtil.createRegex(DEFAULT_REGEX_ELEMENT1, DEFAULT_REGEX_ELEMENT2, customDelim);
            inputStr = regexUtil.removeCustomDelimiter(inputStr);
        }

        try {
            int result = stringCalculator.calculate(inputStr, regex);
            System.out.println("결과 : " + result);

        } catch (IllegalArgumentException ex) {
            System.err.println(ex.getMessage());

        }

    }
}
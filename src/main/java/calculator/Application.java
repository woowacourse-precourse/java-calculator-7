package calculator;

import calculator.string.RegexUtil;
import calculator.string.StringCalculator;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    private static final String DEFAULT_REGEX_ELEMENT1 = ",";
    private static final String DEFAULT_REGEX_ELEMENT2 = ":";

    public static void main(String[] args) {
        /* 기본 구분자에 대한 기능 구현
        * */

        StringCalculator stringCalculator = new StringCalculator();
        RegexUtil regexUtil = new RegexUtil();

        //todo: 커스텀 추가시 입력 이후로 이동
        String regex = regexUtil.createRegex(DEFAULT_REGEX_ELEMENT1, DEFAULT_REGEX_ELEMENT2);

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String inputStr = Console.readLine();

        try {
            int result = stringCalculator.calculate(inputStr, regex);
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException ex) {
            System.err.println(ex.getMessage());
        }

    }
}
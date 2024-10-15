package calculator;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    static boolean iscustomDelimiter = false;    // 기본 구분자, 커스텀 구분자 인지

    // 덧셈 구하는 함수
    private static int sum(String delimiter, String numberFormula) {
        if (numberFormula.isEmpty()) {return 0;}
        int result = 0;
        String[] numberArray = numberFormula.split(delimiter);
        for (String number : numberArray) {
            result += Integer.parseInt(number);
        }
        return result;
    }

    // 기본 구분자 or 커스텀 구분자 구별하는 함수
    private static void distinctionDelimiter(String formula) {
        if (formula.startsWith("//")) {
            iscustomDelimiter = true;
        }
    }

    private static String input() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }

    public static void run() {
        String formula = input();   // 사용자 입력
        distinctionDelimiter(formula);    // 기본 구분자, 커스텀 구분자 구분하기
        String[] refineFormula = InputValidation.validateDelimiter(iscustomDelimiter, formula);
        int result = sum(refineFormula[0], refineFormula[1]);   // 덧셈 구하는 함수
        System.out.println("결과 : " + result);
    }
}

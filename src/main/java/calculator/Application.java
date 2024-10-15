package calculator;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        calStart();
    }

    private static void calStart() {
        String[] digits = getDigits();
        System.out.println(Arrays.toString(digits));
        getResult(digits);
    }

    private static String input() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine(); //한 줄 입력 받음
    }

    private static String[] getDigits() {
        String input = input();
        String separator = ",:";

        //커스텀 구분자
        int startIndex = input.indexOf("//"); //정규표현식도 고려해볼 것
        int endIndex = input.indexOf("\\n");
        if (startIndex != -1 && endIndex != -1 && startIndex < endIndex) {
            separator += input.substring(startIndex + 2, endIndex);
            input = input.substring(endIndex + 2);
        }

        return input.split("[" + separator + "]");
    }


    private static void getResult(String[] digits) {
        int result = 0;
        for (String val : digits) {
            int intVal;
            if (val.isEmpty()) {
                intVal = 0;
            } else {
                intVal = exception(val);
            }
            result += intVal;
        }
        System.out.println("결과 : " + result);
    }

    private static int exception(String val) {
        int intVal;
        try {
            intVal = Integer.parseInt(val);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }

        if (Integer.parseInt(val) < 0) {
            throw new IllegalArgumentException("음수 사용 불가");
        }
        return intVal;
    }
}

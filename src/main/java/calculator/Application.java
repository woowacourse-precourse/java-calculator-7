package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    static String delimeter = ",|:";
    static String inputExpression;

    static int hasCustom(String str) {
        int start = str.indexOf("//");
        return start;
    }

    static void registerCustom(String str) {

    }

    public static void main(String[] args) {
        // 입력
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        inputExpression = Console.readLine();

        // 구분자 등록
        if (hasCustom(inputExpression) != -1) {
            registerCustom(inputExpression);
        }

        // 구분자로 문자열 자르기

        // 추출된 숫자들의 합 구하기

        // 결과 출력
    }
}


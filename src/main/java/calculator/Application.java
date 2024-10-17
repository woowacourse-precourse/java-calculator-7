package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<String> separators = new ArrayList<>();

        String input = Console.readLine();
        Console.close();

        checkBeginAndEndOfValue(input);

        
    }

    //문자열의 시작과 끝 확인
    private static void checkBeginAndEndOfValue(String value) {
        //문자열의 시작 확인
        if (!value.startsWith("//") && !isNum(value.charAt(0))) {
            throw new IllegalArgumentException("문자열의 시작은 커스텀 구분자 선언 또는 양수여야 합니다");
        }

        //문자열의 끝 확인
        if (!value.endsWith("\n")|| !isNum(value.charAt(value.length() - 1))) {
            throw new IllegalArgumentException("문자열의 끝은 커스텀 구분자 선언 종료 또는 양수여야 합니다.");
        }
    }


    //char값이 1 ~ 9 사이의 양수인지 확인
    private static boolean isNum(char c) {
        return c >= 1 && c <= 9;
    }




}

package calculator.service;

/*
계산기
- 문자열 분리하기
  - 분리한 문자열을 정수로 변환해 Numbers 생성
- 숫자 리스트의 합 구하기
*/

import java.util.List;

public class CalculateDefault {

    private static final String COLON = ":";
    private static final String COMMA = ",";
    private static final String OR = "|";

    //문자열 분리 - 콜론 판단
    public static boolean checkContainColon(String userInput) {
        return userInput.contains(COLON);
    }

    //문자열 분리 - 쉼표 판단
    public static boolean checkContainComma(String userInput) {
        return userInput.contains(COMMA);
    }

    //문자열 분리 - 콜론
    public static List<String> splitWithColon(String userInput) {
        return List.of(userInput.split(COLON));
    }

    //문자열 분리 - 쉼표
    public static List<String> splitWithComma(String userInput) {
        return List.of(userInput.split(COMMA));
    }

    public static boolean checkContainCommaAndColon(String userInput) {
        return checkContainColon(userInput) && checkContainComma(userInput);
    }

    public static List<String> splitWithCommaAndColon(String userInput) {
        return List.of(userInput.split(COMMA + OR + COLON));
    }
}

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
    public boolean checkContainCOLON(String userInput) {
        return userInput.contains(COLON);
    }

    //문자열 분리 - 쉼표 판단
    public boolean checkContainCOMMA(String userInput) {
        return userInput.contains(COMMA);
    }

    //문자열 분리 - 콜론
    public List<String> splitWithCOLON(String userInput) {
        return List.of(userInput.split(COLON));
    }

    //문자열 분리 - 쉼표
    public List<String> splitWithCOMMA(String userInput) {
        return List.of(userInput.split(COMMA));
    }

    public boolean checkContainCOMMAAndCOLON(String userInput) {
        return checkContainCOLON(userInput) && checkContainCOMMA(userInput);
    }

    public List<String> splitWithCOMMAAndCOLON(String userInput) {
        return List.of(userInput.split(COMMA + OR + COLON));
    }
}

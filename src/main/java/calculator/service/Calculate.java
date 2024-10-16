package calculator.service;

/*
계산기
- 문자열 분리하기
  - 분리한 문자열을 정수로 변환해 Numbers 생성
- 숫자 리스트의 합 구하기
*/

public class Calculate {

    private static final String COLON = ":";
    private static final String COMMA = ",";

    //문자열 분리 - 콜론 판단
    public boolean checkContainCOLON(String userInput) {
        return userInput.contains(COLON);
    }
}

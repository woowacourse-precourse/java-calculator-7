package calculator.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputProcessor {
    private String input;
    private String delimiter = ",:";
    //## 기능(흐름)
    //2. 입력받은 문자열 검증(아래 예외처리 참고)
    //3. 구분자 관리: 사용자 정의 구분자 설정가능, default는 쉼표나 콜론
    //4. 숫자와 구분자 분리하기

    public InputProcessor(String input) {
        this.input = input;
        checkCustomDelimiter();
        validateInput();
    }

    //1. 구분자와 양수로 이뤄진 문자열인가(숫자인지, 음수가 아닌지)
    //2. 문자열이 비어있을 경우
    //3. 입력받은 구분자가 사용자 정의 구분 기호 형식과 다를 경우
    //4. 설정도된 구분자가 두개 연속으로 입력된 경우
    //=> `IllegalArgumentException` 발생

    private void checkCustomDelimiter() {
        if (input.startsWith("//")) {
            customDelimiter();
        }
    }

    private void customDelimiter(){
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (matcher.find()) {
            delimiter = matcher.group(1);
            input = matcher.group(2);
        }
    }

    private void validateInput() {

    }
}

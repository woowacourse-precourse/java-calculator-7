package calculator.validator;

import java.util.Arrays;

public class CalculatorValidator {

    /**
     * 숫자가 아닌 문자열이 있는지 확인한다. 만약 있다면 IllegalArgumentException 으로 처리한다.
     *
     * @param separatedStringArr 숫자 외의 문자가 있는지 확인하고 싶은 문자열을 입력한다.
     */
    public void hasNaN(String[] separatedStringArr) {
        if (Arrays.stream(separatedStringArr)
                .flatMapToInt(String::chars)
                .anyMatch(it -> it < '0' || it > '9')) {
            throw new IllegalArgumentException("입력한 문자열에 구분자, 숫자 외의 문자가 존재합니다.");
        }
    }
}

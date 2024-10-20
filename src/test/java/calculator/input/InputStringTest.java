package calculator.input;

import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputStringTest {

    @Test
    @DisplayName("입력 문자열 개별 문자로 분리")
    void splitInputString() {
        // 입력 문자열과 클래스명이 혼동될 수 있음
        // 더 좋은 변수명 찾기
        String inputStr = "264//-1";

        InputString inputString = new InputString();
        ArrayList inputChars = inputString.splitInputString(inputStr);

        for (Object s : inputChars) {
            System.out.print(s + ", ");
            System.out.println(s.getClass().getName());
        }
    }

}
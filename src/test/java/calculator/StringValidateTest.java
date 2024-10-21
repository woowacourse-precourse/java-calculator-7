package calculator;

import calculator.domain.InputtedString;
import calculator.domain.delimiters.DelimitersFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringValidateTest {

    DelimitersFactory delimitersFactory = new DelimitersFactory();
    
    @DisplayName("커스텀 구분자 없는 옳은 문자열 테스트")
    @Test
    void correctLineWithOutCustomDelimiter() {
        List<String> correctLines = new ArrayList<>();
        correctLines.add("1,2,3");
        correctLines.add("1:2:3");
        correctLines.add("1,2:3");
        correctLines.add("1:2,3");
        correctLines.add("");
        for (String correctLine : correctLines) {
            InputtedString inputtedString = new InputtedString(correctLine);
            assertDoesNotThrow(() -> delimitersFactory.getFromStringAfterValidate(inputtedString));
        }
    }

    @DisplayName("커스텀 구분자 있는 옳은 문자열 테스트")
    @Test
    void correctLineWithCustomDelimiter() {
        String correctLine1 = "//s\\n1s2,3";
        assertDoesNotThrow(() ->
                delimitersFactory.getFromStringAfterValidate(new InputtedString(correctLine1)));

        String correctLine2 = "//s\\ns1s2,3";
        assertDoesNotThrow(() ->
                delimitersFactory.getFromStringAfterValidate(new InputtedString(correctLine2)));

        String correctLine3 = "//**\\n1:2**3";
        assertDoesNotThrow(() ->
                delimitersFactory.getFromStringAfterValidate(new InputtedString(correctLine3)));

        String correctLine4 = "// \\n1 2 3";
        assertDoesNotThrow(() ->
                delimitersFactory.getFromStringAfterValidate(new InputtedString(correctLine4)));

        String correctLine5 = "// # \\n1 # 2 # 3";
        assertDoesNotThrow(() ->
                delimitersFactory.getFromStringAfterValidate(new InputtedString(correctLine5)));

    }

    @DisplayName("커스텀 구분자 없는 틀린 문자열 테스트")
    @Test
    void wrongLineWithOutCustomDelimiter() {
        List<String> wrongLines = new ArrayList<>();
        wrongLines.add("1x2");
        wrongLines.add("1 2");
        wrongLines.add("1-2");
        wrongLines.add("-");
        wrongLines.add(" ");
        wrongLines.add("a");
        wrongLines.add("-1,2");

        for (String wrongLine : wrongLines) {
            assertThrows(IllegalArgumentException.class, () ->
                    delimitersFactory.getFromStringAfterValidate(new InputtedString(wrongLine)));
        }
    }

    @DisplayName("커스텀 구분자가 중간에 있는 문자열 테스트")
    @Test
    void wrongLineWithCustomDelimiter1() {
        List<String> wrongLines = new ArrayList<>();
        wrongLines.add("1@2//@\\n");
        wrongLines.add("1*2//*\\n*3");
        wrongLines.add("1*2//*3");
        wrongLines.add("1*2*3\\n");

        for (String wrongLine : wrongLines) {
            assertThrows(IllegalArgumentException.class, () ->
                    delimitersFactory.getFromStringAfterValidate(new InputtedString(wrongLine)));
        }
    }

    @DisplayName("커스텀 구분자 지정이 틀린 문자열 테스트")
    @Test
    void wrongLineWithCustomDelimiter2() {
        String wrongLine1 = "//@1,2@3"; // 커스텀 구분자 지정자 꼬리가 없는 경우
        String wrongLine2 = "@\\n1,2@3"; // 커스텀 구분자 지정자 머리가 없는 경우

        assertThrows(IllegalArgumentException.class, () ->
                delimitersFactory.getFromStringAfterValidate(new InputtedString(wrongLine1)));
        assertThrows(IllegalArgumentException.class, () ->
                delimitersFactory.getFromStringAfterValidate(new InputtedString(wrongLine2)));
    }

    @DisplayName("커스텀 구분자 이외에 문자가 있는 경우")
    @Test
    void wrongLineWithCustomDelimiter3() {
        String wrongLine1 = "//#\\n1#-2,3";
        String wrongLine2 = "//##\\n1#2#3";
        String wrongLine3 = "//#!\\n1 #!2#!3";

        assertThrows(IllegalArgumentException.class, () ->
                delimitersFactory.getFromStringAfterValidate(new InputtedString(wrongLine1)));
        assertThrows(IllegalArgumentException.class, () ->
                delimitersFactory.getFromStringAfterValidate(new InputtedString(wrongLine2)));
        assertThrows(IllegalArgumentException.class, () ->
                delimitersFactory.getFromStringAfterValidate(new InputtedString(wrongLine3)));

    }

    @DisplayName("커스텀 구분자에 지정자가 쓰인 옳은 경우")
    @Test
    void correctLineCustomDelimiterSpecifier() {
        String correctLine = "////\\n1//2//3";

        assertDoesNotThrow(() ->
                delimitersFactory.getFromStringAfterValidate(new InputtedString(correctLine)));
    }

    @DisplayName("커스텀 구분자에 지정자가 쓰인 틀린 경우")
    @Test
    void wrongLineCustomDelimiterSpecifier() {
        String wrongLine1 = "//#//\\n\\n1#//\\n\\n3#4";
        String wrongLine2 = "////\\n1/2//3";
        String wrongLine3 = "//\\n\\n1\\n2\n3";

        assertThrows(IllegalArgumentException.class, () ->
                delimitersFactory.getFromStringAfterValidate(new InputtedString(wrongLine1)));
        assertThrows(IllegalArgumentException.class, () ->
                delimitersFactory.getFromStringAfterValidate(new InputtedString(wrongLine2)));
        assertThrows(IllegalArgumentException.class, () ->
                delimitersFactory.getFromStringAfterValidate(new InputtedString(wrongLine3)));
    }

}

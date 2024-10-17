package calculator.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StringParserTest {

    private StringParser stringParser = new StringParser();


    @Test
    void 공백문자_입력시_0을_포함한_리스트_반환() {
        List<Integer> result = stringParser.extractNumbers("");
        assertEquals(Collections.singletonList(0), result);
    }

    @Test
    void 정수_입력시_올바른_숫자_반환() {
        List<Integer> result = stringParser.extractNumbers("1,2:3");
        assertEquals(Arrays.asList(1, 2, 3), result);
    }

    @Test
    void 커스텀_구분자_입력시_올바른_숫자_반환() {
        List<Integer> result = stringParser.extractNumbers("//;\\n1;2;3");
        assertEquals(Arrays.asList(1, 2, 3), result);
    }

    @Test
    void 잘못된_커스텀_구분자_입력시_예외_발생() {
        String input = "//;1;2;3";
        assertThrows(IllegalArgumentException.class, () -> {
            stringParser.extractCustomSeparator(input);
        });
    }

    @Test
    void 혼합_구분자_입력시_올바른_숫자_반환() {
        List<Integer> result = stringParser.extractNumbers("//;\\n1,2:3;4");
        assertEquals(Arrays.asList(1, 2, 3, 4), result);
    }

    @Test
    void 유효하지_않은_숫자_입력시_예외_발생() {
        assertThrows(IllegalArgumentException.class, () -> {
            stringParser.extractNumbers("1,2,a");
        });
    }

    @Test
    void 음수_입력시_올바른_숫자_반환() {
        List<Integer> result = stringParser.extractNumbers("-1,2,-3");
        assertEquals(Arrays.asList(-1, 2, -3), result);
    }

    @Test
    void 큰_숫자_입력시_올바른_숫자_반환() {
        List<Integer> result = stringParser.extractNumbers("1000,2000,3000");
        assertEquals(Arrays.asList(1000, 2000, 3000), result);
    }

    @Test
    void 여러_자리_커스텀_구분자_입력시_올바른_숫자_반환() {
        List<Integer> result = stringParser.extractNumbers("//***\\n1***2***3");
        assertEquals(Arrays.asList(1, 2, 3), result);
    }

    @Test
    void 유효하지_않은_여러_자리_커스텀_구분자_입력시_예외_발생() {
        assertThrows(IllegalArgumentException.class, () -> {
            stringParser.extractNumbers("//*%*\n1***2***3");
        });
    }

    @Test
    void 중복된_구분자_입력시_올바른_숫자_반환() {
        List<Integer> result = stringParser.extractNumbers("1,,2,:3");
        assertEquals(Arrays.asList(1, 2, 3), result);
    }

    @Test
    void 유효하지_않은_숫자_문자열_변환시_예외_발생() {
        assertThrows(IllegalArgumentException.class, () -> {
            stringParser.extractNumbers("1,2,abc");
        });
    }

    @Test
    void 공백문자가_아닐시_false를_반환하다() {
        boolean expectedFalse = false;
        String notBlank = "Not Blank";

        boolean actual = stringParser.isBlank(notBlank);

        assertEquals(expectedFalse, actual);
    }

    @Test
    void 공백문자일시_true를_반환하다() {
        boolean expectedTrue = true;
        String blank = "";

        boolean actual = stringParser.isBlank(blank);

        assertEquals(expectedTrue, actual);
    }

    @Test
    void 커스텀_구분자_추출_성공() {
        String input = "//;\\n1;2;3";
        String customSeparator = stringParser.extractCustomSeparator(input);
        assertEquals(";", customSeparator);
    }

    @Test
    void 커스텀_구분자가_없을_때_null_반환() {
        String input = "1,2,3";
        String customSeparator = stringParser.extractCustomSeparator(input);
        assertNull(customSeparator);
    }

    @Test
    void 잘못된_커스텀_구분자_형식_예외_발생() {
        String input = "//;n1;2;3";
        assertThrows(IllegalArgumentException.class, () -> {
            stringParser.extractCustomSeparator(input);
        });
    }

    @Test
    void 커스텀_구분자_정의_제거_성공() {
        String input = "//;\\n1;2;3";
        String result = stringParser.removeCustomSeparatorDefinition(input);
        assertEquals("1;2;3", result);
    }

    @Test
    void 커스텀_구분자가_없을_때_원본_문자열_반환() {
        String input = "1,2,3";
        String result = stringParser.removeCustomSeparatorDefinition(input);
        assertEquals(input, result);
    }
}

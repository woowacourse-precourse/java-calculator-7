package util;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import calculator.util.SplitStringUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SplitStringUtilTest {

    @Test
    @DisplayName("커스텀 구분자 문자열 / 숫자 문자열 나누는지")
    public void testSplitInputWithCustomSeparator() {
        String input = "//;\n1;2;3";
        String[] result = SplitStringUtil.splitInputString(input);

        String[] expected = {"//;\n", "1;2;3"};
        assertArrayEquals(expected, result);
    }

    @Test
    @DisplayName("이상한 커스텀 구분자 문자열 / 숫자 문자열 나누는지")
    public void testSplitInputWithStrangeCustomSeparator() {
        String input = "strangecustomseparator1,2,3";
        String[] result = SplitStringUtil.splitInputString(input);

        String[] expected = {"strangecustomseparator", "1,2,3"};
        assertArrayEquals(expected, result);
    }

    @Test
    @DisplayName("숫자문자열이없어도 커스텀 구분자 문자열 / 숫자 문자열 나누는지")
    public void testSplitInputWithNoNumbers() {
        String input = "//;\n";
        String[] result = SplitStringUtil.splitInputString(input);

        String[] expected = {"//;\n", ""};
        assertArrayEquals(expected, result);
    }
    
    @Test
    @DisplayName("커스텀 구분자 문자열이 없어도 커스텀 구분자 문자열 / 숫자문자열 나누는지")
    public void testSplitInputWithoutCustomSeparator() {
        String input = "1,2:3";
        String[] result = SplitStringUtil.splitInputString(input);

        String[] expected = {"", "1,2:3"};
        assertArrayEquals(expected, result);
    }

}

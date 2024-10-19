package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringDividerTest {
    @DisplayName("구분자를 이용하여 String 으로 구성된 숫자 배열을 리턴하기 (커스텀 문자열이 주어지지 않을 경우)")
    @Test
    void test4() {
        String givenString = "1:2,3";
        String[] expected = new String[]{"1", "2", "3"};
        StringDivider stringDivider = new StringDivider(givenString);

        String[] result = stringDivider.divideStringBy();
        assertArrayEquals(expected, result);
    }

    @DisplayName("구분자를 이용하여 String 으로 구성된 숫자 배열을 리턴하기 (커스텀 문자열이 주어질 경우 )")
    @Test
    void test5() {
        String givenString = "1;2:3,4;5";
        String givenCustomSeparator = ";";
        String[] expected = new String[]{"1", "2", "3", "4", "5"};
        StringDivider stringDivider = new StringDivider(givenCustomSeparator,givenString);

        String[] result = stringDivider.divideStringBy();
        assertArrayEquals(expected, result);
    }

    @DisplayName("구분자를 이용하여 String 으로 구성된 숫자 배열을 리턴하기 (커스텀 문자열이 주어질 경우 )")
    @Test
    void test5_1() {
        String givenString = "1;;;;2:3,4;;;;5";
        String givenCustomSeparator = ";;;;";
        String[] expected = new String[]{"1", "2", "3", "4", "5"};
        StringDivider stringDivider = new StringDivider(givenCustomSeparator,givenString);

        String[] result = stringDivider.divideStringBy();
        assertArrayEquals(expected, result);
    }

}

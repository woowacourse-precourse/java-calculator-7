package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MethodTest {

    @Test
    @DisplayName("입력값이 정상적으로 들어오게 되는지")
    void test() {
        String given = "1:2:3";
        String expected = "1:2:3";

        System.setIn(new ByteArrayInputStream(given.getBytes()));
        String result = Application.getInput();

        assertEquals(expected, result);
    }

    @DisplayName("시작에 커스텀 구분자(//\n)를 지정할경우 해당 커스텀 구분자를 존재여부 파악(존재할 경우)")
    @Test
    void test1() {
        String given = "//;\n1;2;3";
        boolean expected = true;

        boolean result = Application.isCustomSeparatorExist(given);

        assertEquals(expected, result);
    }

    @DisplayName("시작에 커스텀 구분자(//\n)를 지정할경우 해당 커스텀 구분자를 존재여부 파악(존재하지 않을 경우)")
    @Test
    void test2() {
        String given = "1:2:3";
        boolean expected = false;

        boolean result = Application.isCustomSeparatorExist(given);

        assertEquals(expected, result);
    }

    @DisplayName("시작에 커스텀 구분자(//\n)를 지정할경우 해당 커스텀 구분자를 리턴하기")
    @Test
    void test3() {
        String given = "//ㅋ\n1;2;3";
        String expected = "ㅋ";

        String result = Application.getCustomSeparator(given);

        assertEquals(expected, result);
    }

    @DisplayName("구분자를 이용하여 String 으로 구성된 숫자 배열을 리턴하기 (커스텀 문자열이 주어지지 않을 경우)")
    @Test
    void test4() {
        String givenString = "1:2,3";

        String[] expected = new String[]{"1", "2", "3"};

        String[] result = Application.divideStringBy(givenString);
        assertArrayEquals(expected, result);
    }

    @DisplayName("구분자를 이용하여 String 으로 구성된 숫자 배열을 리턴하기 (커스텀 문자열이 주어질 경우 )")
    @Test
    void test5() {
        String givenString = "//;\n1;2:3,4;5";
        String givenCustomSeparator = ";";
        String[] expected = new String[]{"1", "2", "3", "4", "5"};

        String[] result = Application.divideStringBy(givenString, givenCustomSeparator);
        assertArrayEquals(expected, result);
    }
}

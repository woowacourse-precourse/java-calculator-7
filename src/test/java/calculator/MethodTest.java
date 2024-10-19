package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MethodTest {
    @DisplayName("문자열로 구성된 숫자의 합을 구한다.")
    @Test
    void test6() {
        String[] givenArr = new String[]{"1", "2", "3", "4", "5", "6"};
        int expected = 21;

        int result = Application.sum(givenArr);

        assertEquals(expected, result);
    }
}

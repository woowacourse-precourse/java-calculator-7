package calculator;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class CalculatorServiceTest {
    private int answer;
    private CalculatorService cal = new CalculatorService();

    @Test
    void 빈_문자열_처리() {
        String input = "";
        answer = cal.returnAnswer(input);
        assertEquals(0, answer);
    }

    @Test
    void 기본_구분자_처리() {
        String input = "1,2,3";
        int[] expected = {1, 2, 3};
        int[] actual = cal.convertIntArray(cal.splitByDefaultDelimiter(input));
        assertArrayEquals(expected, actual);

        String input2 = "1:2,3";
        int[] expected2 = {1, 2, 3};
        int[] actual2 = cal.convertIntArray(cal.splitByDefaultDelimiter(input2));
        assertArrayEquals(expected2, actual2);
    }

    @Test
    void 커스텁_구분자_처리() {
        String input = "//a\n1a2a3a";
        int[] expected = {1, 2, 3};
        int[] actual = cal.convertIntArray(cal.splitByCustomDelimiter(input));
        assertArrayEquals(expected, actual);

        String input2 = "//ab\n1ab2ab3ab4";
        int[] expected2 = {1, 2, 3, 4};
        int[] actual2 = cal.convertIntArray(cal.splitByCustomDelimiter(input2));
        assertArrayEquals(expected2, actual2);
    }

    @Test
    void 숫자_합산() {
        int[] input = {1, 2, 3};
        int actual = cal.plus(input);
        assertEquals(6, actual);
    }

    @Test
    void 구분자_존재_X() {
        String input = "12345";
        String input2 = "//a\n12345";
        assertThrows(IllegalArgumentException.class,
                () -> {
                    cal.ensureValidInput(input);
                    cal.ensureValidInput(input2);
                });
    }

    @Test
    void 잘못된_커스텀_구분자_사용() {
        String input = "//a//1a2a3a";
        String input2 = "\na//1a2a3a";
        assertThrows(IllegalArgumentException.class,
                () -> {
                    cal.ensureValidInput(input);
                    cal.ensureValidInput(input2);
                });
    }

    @Test
    void 첫시작이_잘못된_문자의_걍우() {
        String input = ",1,2,3,4";
        assertThrows(IllegalArgumentException.class,
                () -> {
                    cal.ensureValidInput(input);
                });
    }

    @Test
    void 중간에_다른_구분자_사용() {
        String input = "1,2.3:4";
        assertThrows(IllegalArgumentException.class,
                () -> {
                    cal.ensureValidInput(input);
                });
    }

}

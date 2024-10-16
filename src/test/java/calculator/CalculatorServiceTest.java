package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class CalculatorServiceTest {
    private int answer;
    private CalculatorService cal = new CalculatorService();

    @Test
    void 빈_문자열_처리() {
        String input = "";
        answer = cal.ensureValidInput(input);
        assertEquals(0, answer);
        String input2 = "//a\\n";
        assertEquals(cal.ensureValidInput(input2), 0);
    }

    @Test
    void 기본_구분자_처리() {
        String input = "1,2,3";
        int expected = cal.ensureValidInput(input);
        assertEquals(expected, 6);

        String input2 = "1";
        int expected2 = cal.ensureValidInput(input);
        assertEquals(expected2, 6);
    }

    @Test
    void 커스텁_구분자_처리() {
        String input = "//;\\n1";
        int expected = cal.ensureValidInput(input);
        assertEquals(expected, 1);

        String input111 = "//a\\n1a2a3a";
        int expected00 = cal.ensureValidInput(input111);
        assertEquals(expected00, 6);
    }

    @Test
    void 숫자_합산() {
        int[] input = {1, 2, 3};
        int actual = cal.plus(input);
        assertEquals(6, actual);
    }

    @Test
    void 구분자_존재_X() {
        String input1 = "12345";
        String input2 = "//a\\n12345";
        assertThrows(IllegalArgumentException.class,
                () -> {
                    cal.ensureValidInput(input1);
                });

        assertThrows(IllegalArgumentException.class,
                () -> {
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
                });
        assertThrows(IllegalArgumentException.class,
                () -> {
                    cal.ensureValidInput(input2);
                });

    }

    @Test
    void 첫시작이_잘못된_문자의_경우() {
        String input = ",1,2,3,4";
        assertThrows(IllegalArgumentException.class,
                () -> {
                    cal.ensureValidInput(input);
                });
    }


    @Test
    void 중간에_다른_구분자_사용() {
        String input = "1,2.3:4";
        String input2 = "1a2b,3,4";
        assertThrows(IllegalArgumentException.class,
                () -> {
                    cal.ensureValidInput(input);
                });
        assertThrows(IllegalArgumentException.class,
                () -> {
                    cal.ensureValidInput(input2);
                });

    }

    @Test
    void 최종_테스트() {
        String defaultInput = "1,2,3,4,10";
        String defaultInput2 = "1,2:30:42";
        int expected1 = cal.ensureValidInput(defaultInput);
        int expected2 = cal.ensureValidInput(defaultInput2);
        assertEquals(expected1, 20);
        assertEquals(expected2, 75);

        String customInput = "//a\\n1a2a3a";
        String customInput2 = "//qwe\\n1qwe2qwe3qwe4qwe5";
        int expected3 = cal.ensureValidInput(customInput);
        int expected4 = cal.ensureValidInput(customInput2);
        assertEquals(expected3, 6);
        assertEquals(expected4, 15);

        String wrongInput1 = "-1,2,3";
        String wrongInput2 = "/a\\n1a2a3a";
        String wrongInput3 = "//x\\n1xx2x4xc5";
        assertThrows(IllegalArgumentException.class,
                () -> {
                    cal.ensureValidInput(wrongInput1);
                });
        assertThrows(IllegalArgumentException.class,
                () -> {
                    cal.ensureValidInput(wrongInput2);
                });
        assertThrows(IllegalArgumentException.class,
                () -> {
                    cal.ensureValidInput(wrongInput3);
                });


    }

}

package calculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ApplicationTest {

    private final calculator.Calculator calculator = new calculator.Calculator();

    @Test
    void 커스텀_구분자_사용() {
        String input = "//;\n1;2";
        int result = calculator.add(input);
        assertEquals(3, result); // 결과가 3이어야 함
    }

    @Test
    void 음수_입력_예외_테스트() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.add("-1,2");
        });
        assertEquals("잘못된 입력입니다: 입력값에 음수가 포함되어 있습니다: -1 ", exception.getMessage());
    }

    @Test
    void 빈_입력_테스트() {
        assertEquals(0, calculator.add("")); // 빈 입력은 0이어야 함
    }

    @Test
    void 여러_구분자_사용() {
        String input = "//;\n1;2;3;4";
        int result = calculator.add(input);
        assertEquals(10, result); // 결과가 10이어야 함
    }
}

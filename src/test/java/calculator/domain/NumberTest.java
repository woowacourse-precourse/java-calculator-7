package calculator.domain;

import static org.assertj.core.api.Fail.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class NumberTest {

    @Test
    void 숫자_읽기() {
        Number n = new Number(5);
        assertEquals(5, n.getNumber());
    }

    @Test
    void 숫자_양수인지_유효성_검사() {
        try {
            Number n = new Number(-5);
            fail("테스트에 실패하였습니다.");
        } catch (IllegalArgumentException e) {
            assertEquals("[ERROR] 양수를 입력해야 합니다.", e.getMessage());
        }
    }
}

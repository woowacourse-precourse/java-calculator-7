package calculator.validator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ValidatorTest{
    private final Validator validator = new Validator();

    @Test
    void 빈문자열_입력_검증() {
        assertTrue(validator.inputValidate(""));
    }

    @Test
    void null_입력_검증() {
        assertTrue(validator.inputValidate(null));
    }

    @Test
    void 숫자가아닌문자열_입력_검증() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            validator.numberValidate("abc");
        });
        assertEquals("숫자가 아닌 문자열은 허용되지 않습니다.",thrown.getMessage());
    }

    @Test
    void 음수_입력_검증() {
        // 음수를 입력했을 때
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            validator.numberValidate("-1");
        });
        assertEquals("음수는 허용되지 않습니다.", thrown.getMessage());
    }
}

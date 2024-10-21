package util;

import static org.junit.jupiter.api.Assertions.assertThrows;

import calculator.util.SeparatorValidationUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SeparatorValidationUtilTest {

    @Test
    @DisplayName("틀린 커스텀 구분자 1.형식이 틀림 2.없음 3.숫자가 들어감 ")
    public void testInvalidSeparatorStringFormat() {
        assertThrows(IllegalArgumentException.class, () ->
                SeparatorValidationUtil.validateSeparatorStringFormat("/;\\n")
        );

        assertThrows(IllegalArgumentException.class, () ->
                SeparatorValidationUtil.validateSeparatorStringFormat("//\\n")
        );

        assertThrows(IllegalArgumentException.class, () ->
                SeparatorValidationUtil.validateSeparatorStringFormat("//1\\n")
        );

    }

    @Test
    @DisplayName("올바른 커스텀 구분자 띄어쓰기도 가능 ")
    public void testValidSeparatorStringFormat() {
        SeparatorValidationUtil.validateSeparatorStringFormat("//\\\n");
        SeparatorValidationUtil.validateSeparatorStringFormat("//;\\n");
        SeparatorValidationUtil.validateSeparatorStringFormat("// \\n");
    }
}

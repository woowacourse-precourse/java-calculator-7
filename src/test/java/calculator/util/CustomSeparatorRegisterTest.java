package calculator.util;

import calculator.domain.CalcTarget;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomSeparatorRegisterTest {

    @Test
    @DisplayName("커스텀 구분자 등록")
    void registerCustomSeparator() {
        // given
        String input = "//;\\n1";
        CalcTarget calcTarget = CalcTarget.input(input);
        // when
        CustomSeparatorRegister.registerCustomSeparator(calcTarget);
        // then
        assertEquals(";", calcTarget.getCustomSeparator());
        assertEquals("1", calcTarget.getValue());
    }

}
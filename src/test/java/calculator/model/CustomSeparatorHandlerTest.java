package calculator.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;


class CustomSeparatorHandlerTest {
    private CustomSeparatorHandler handler = new CustomSeparatorHandler();

    @Test
    void 커스텀_구분자_추출_성공() {
        String input = "//;\\n1;2;3";
        String customSeparator = handler.extractCustomSeparator(input);

        assertEquals(";", customSeparator);
    }

    @Test
    void 커스텀_구분자가_없을_때_null_반환() {
        String input = "1,2,3";
        String customSeparator = handler.extractCustomSeparator(input);

        assertNull(customSeparator);
    }

    @Test
    void 잘못된_커스텀_구분자_형식_예외_발생() {
        String input = "//;n1;2;3";

        assertThrows(IllegalArgumentException.class, () -> {
            handler.extractCustomSeparator(input);
        });
    }

    @Test
    void 커스텀_구분자_정의_제거_성공() {
        String input = "//;\\n1;2;3";
        String result = handler.removeCustomSeparatorDefinition(input);
        assertEquals("1;2;3", result);
    }

    @Test
    void 커스텀_구분자가_없을_때_원본_문자열_반환() {
        String input = "1,2,3";
        String result = handler.removeCustomSeparatorDefinition(input);
        assertEquals(input, result);
    }

    @Test
    void 여러_자리_커스텀_구분자_추출_성공() {
        String input = "//*%*\\n1*%*2*%*3";
        String customSeparator = handler.extractCustomSeparator(input);
        assertEquals("*%*", customSeparator);
    }
}
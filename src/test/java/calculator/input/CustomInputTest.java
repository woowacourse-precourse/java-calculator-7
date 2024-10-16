package calculator.input;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CustomInputTest {

    @Test
    void 상속_객체_테스트() {
        // given & when
        Input customInput = Input.of("//;\\n1;2;3");
        // then
        assertInstanceOf(CustomInput.class, customInput);
        assertNotNull(customInput);
    }

    @Test
    void 커스텀_구분자가_주어진_경우() {
        // given
        char separator = ';';
        String inputStr = "//" + separator + "\\n1;2;3";
        // when
        CustomInput customInput = (CustomInput) Input.of(inputStr);
        // then
        assertInstanceOf(CustomInput.class, customInput);
        assertTrue(customInput.isSeparatorEqual(separator));
    }
}
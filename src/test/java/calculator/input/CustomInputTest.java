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
        assertEquals(separator, customInput.getSeparator());
    }


    @Test
    void 커스텀_구분자_형식_예외_prefix_없음() {
        // given
        String inputStr = ";\\" + "n1;2;3";
        // when & then
        assertThrows(IllegalArgumentException.class, () -> Input.of(inputStr));
    }

    @Test
    void 커스텀_구분자_형식_예외_suffix_없음() {
        // given
        String inputStr = "//;" + "1;2;3";
        // when & then
        assertThrows(IllegalArgumentException.class, () -> Input.of(inputStr));
    }

    @Test
    void 커스텀_구분자_형식_오류_구분자_없음() {
        // given
        String inputStr = "//\\n" + "1;2;3";
        // when & then
        assertThrows(IllegalArgumentException.class, () -> Input.of(inputStr));
    }

    @Test
    void 문자열_형식_오류_숫자로_시작_안_함() {
        // given
        String inputStr = "//;\\n" + ";2;3";
        // when & then
        assertThrows(IllegalArgumentException.class, () -> Input.of(inputStr));
    }
}
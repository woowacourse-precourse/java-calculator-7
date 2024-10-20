package calculator.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class CustomDelimiterTest {

    @Test
    void 커스텀_구분자_추출() {
        // given
        String input = "//;\\n1;2;3";

        // when
        CustomDelimiter customDelimiter = CustomDelimiter.extractCustomDelimiter(input);

        // then
        assertEquals(customDelimiter.get(), ";");
    }

    @Test
    void 입력_문자열_추출() {
        // given
        String input = "//;\\n1;2;3";

        /// when
        input = CustomDelimiter.extractInput(input);

        // then
        assertEquals("1;2;3", input);
    }

    @Test
    void 기본_구분자와_같은_커스텀_구분자_입력시_예외_발생() {
        // given
        String input = "//,\\n1;2;3";

        // when & then
        assertThrows(IllegalArgumentException.class, () -> CustomDelimiter.extractCustomDelimiter(input));
    }

    @Test
    void 공백_커스텀_구분자_입력시_예외_발생() {
        // given
        String input = "// \\n1 2 3";

        // when
        assertThrows(IllegalArgumentException.class, () -> CustomDelimiter.extractCustomDelimiter(input));
    }

    // 특정 문자열: \n
    @Test
    void 커스텀_구분자가_특정_문자열로_끝나지_않는_입력시_예외_발생() {
        // given
        String input = "//,1;2;3";

        // when & then
        assertThrows(IllegalArgumentException.class, () -> CustomDelimiter.extractCustomDelimiter(input));
    }

    @Test
    void 두개_이상의_커스텀_구분자_입력시_예외_발생() {
        // given
        String input = "//a\\n//b\\n1a2b3";

        // when & then
        assertThrows(IllegalArgumentException.class, () -> CustomDelimiter.extractCustomDelimiter(input));
    }

    @Test
    void 커스텀_구분자가_없는_경우_null_반환() {
        // given
        String input = "1,2,3";

        // when
        CustomDelimiter customDelimiter = CustomDelimiter.extractCustomDelimiter(input);

        // then
        assertNull(customDelimiter);
    }
}

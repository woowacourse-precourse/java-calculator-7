package calculator.input;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class CustomInputTest {

    @Test
    void 상속_객체_테스트() {
        // given & when
        Input customInput = Input.from("//;\\n1;2;3");
        // then
        assertInstanceOf(CustomInput.class, customInput);
        assertNotNull(customInput);
    }

    @Test
    void 커스텀_구분자가_주어진_경우() {
        // given
        String separator = ";";
        String inputStr = "//" + separator + "\\n1;2;3";
        // when
        CustomInput customInput = (CustomInput) Input.from(inputStr);
        // then
        assertInstanceOf(CustomInput.class, customInput);
        assertTrue(customInput.matchesSeparator(separator));
    }

    @Test
    void 숫자_배열_테스트() {
        // given
        Input input = Input.from("//;\\n1;2;3");
        // when
        List<Long> longList = input.toLongList();
        // then
        assertEquals(1, longList.get(0));
        assertEquals(2, longList.get(1));
        assertEquals(3, longList.get(2));
    }

    @Test
    void 숫자배열_예외_구분자_다름() {
        // given
        Input input = Input.from("//;\\n1?2");
        // when & then
        assertThrows(IllegalArgumentException.class, input::toLongList);
    }

    @Test
    void escape_커스텀_구분자가_주어진_경우_온점() {
        String escapes = ".^$*+?()[]{}|\\";
        for (int i = 0; i < escapes.length(); i++) {
            // given
            String separator = String.valueOf(escapes.charAt(i));
            String inputStr = "//" + separator + "\\n1" + separator + 2 + separator + 3;
            // when
            CustomInput customInput = (CustomInput) Input.from(inputStr);
            // then
            assertTrue(customInput.matchesSeparator("\\" + separator));
        }
    }

    @Test
    void 커스텀_숫자_변환_예외_숫자로_시작_안_함() {
        // given
        Input input = Input.from("//;\\n;2;3");
        // when & then
        assertThrows(IllegalArgumentException.class, input::toLongList);
    }

    @Test
    void 커스텀_숫자_변환_예외_구분자_없음() {
        // given
        Input input = Input.from("//\\n1;2;3");
        // when & then
        assertFalse(input instanceof CustomInput);
        assertThrows(IllegalArgumentException.class, input::toLongList);
    }

    @Test
    void 커스텀_숫자_변환_예외_prefix_없음() {
        // given
        Input input = Input.from(";\\n1;2;3");
        // when & then
        assertFalse(input instanceof CustomInput);
        assertThrows(IllegalArgumentException.class, input::toLongList);
    }

    @Test
    void 커스텀_객체_변환_예외_suffix_없음() {
        // given
        Input input = Input.from("//;1;2;3");
        // when & then
        assertFalse(input instanceof CustomInput);
        assertThrows(IllegalArgumentException.class, input::toLongList);
    }
}
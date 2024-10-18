package calculator.input;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class CustomInputTest {

    @Test
    void 커스텀_객체_생성() {
        // given & when
        Input customInput = Input.from("//;\\n1;2;3");
        // then
        assertInstanceOf(CustomInput.class, customInput);
        assertNotNull(customInput);
    }

    @Test
    void 커스텀_구분자_확인() {
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
    void 정수_리스트_요소_확인() {
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
    void escape_커스텀_구분자가_주어진_경우_구분자_확인() {
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
    void 정수_리스트_예외__커스텀과_다른_구분자() {
        // given
        Input input = Input.from("//;\\n1?2");
        // when & then
        assertThrows(IllegalArgumentException.class, input::toLongList);
    }

    @Test
    void 정수_리스트_예외__구분자_앞에_정수_없음() {
        // TODO : 구분자 뒤에 정수가 없는 경우 허용하는지 확인 후 처리 예정 ex) //;\n1;2;;;
        // given
        Input input = Input.from("//;\\n;2;3");
        // when & then
        assertThrows(IllegalArgumentException.class, input::toLongList);
    }

    @Test
    void 객체_생성_예외__구분자_없음() {
        // given
        Input input = Input.from("//\\n1;2;3");
        // when & then
        assertThrows(IllegalArgumentException.class, input::toLongList);
    }

    @Test
    void 객체_생성_예외__prefix_없음() {
        // given
        Input input = Input.from(";\\n1;2;3");
        // when & then
        assertThrows(IllegalArgumentException.class, input::toLongList);
    }

    @Test
    void 객체_생성_예외__suffix_없음() {
        // given
        Input input = Input.from("//;1;2;3");
        // when & then
        assertThrows(IllegalArgumentException.class, input::toLongList);
    }
}
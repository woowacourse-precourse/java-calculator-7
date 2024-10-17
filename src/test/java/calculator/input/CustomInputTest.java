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
        char separator = ';';
        String inputStr = "//" + separator + "\\n1;2;3";
        // when
        CustomInput customInput = (CustomInput) Input.from(inputStr);
        // then
        assertInstanceOf(CustomInput.class, customInput);
        assertTrue(customInput.matchesSeparator(separator));
    }

    @Test
    void 정수배열_테스트() {
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
    void 정수배열_예외_구분자_다름() {
        // given
        Input input = Input.from("//;\\n1?2");
        // when & then
        assertThrows(IllegalArgumentException.class, input::toLongList);
    }
}
package calculator.input;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class InputTest {

    @Test
    void 객체_생성() {
        // given & when
        Input input = Input.from("1;2;3");
        // then
        assertFalse(input instanceof CustomInput);
        assertNotNull(input);
    }

    @Test
    void 기본_구분자_확인() {
        // given & when
        Input input = Input.from("1,2:3");
        // then
        assertTrue(input.matchesSeparator(","));
        assertTrue(input.matchesSeparator(":"));
    }

    @Test
    void 정수_리스트_변환_콜론() {
        // given
        Input input = Input.from("1:2:3");
        // when
        List<Long> longList = input.toLongList();
        // then
        assertEquals(1, longList.get(0));
        assertEquals(2, longList.get(1));
        assertEquals(3, longList.get(2));
    }

    @Test
    void 정수_리스트_변환_콤마() {
        // given
        Input input = Input.from("1,3");
        // when
        List<Long> longList = input.toLongList();
        // then
        assertEquals(1, longList.get(0));
        assertEquals(3, longList.get(1));
    }

    @Test
    void 정수_리스트_예외__기본_구분자와_다름() {
        // given
        Input input = Input.from("1,3?2");
        // when & then
        assertThrows(IllegalArgumentException.class, input::toLongList);
    }
}
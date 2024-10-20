package calculator.input;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputTest {

    @DisplayName("[정상] 기본 객체 생성")
    @Test
    void instance() {
        // given & when
        Input input = Input.from("1;2;3");
        // then
        assertFalse(input instanceof CustomInput);
        assertNotNull(input);
    }

    @DisplayName("[정상] 기본 구분자 (,) (:) 확인")
    @Test
    void defaultInputSeparator() {
        // given & when
        Input input = Input.from("1,2:3");
        // then
        assertTrue(input.matchesSeparator(","));
        assertTrue(input.matchesSeparator(":"));
    }

    @DisplayName("[정상] 콜론으로 리스트 변환")
    @Test
    void parseLongListWithColon() {
        // given
        Input input = Input.from("1:2:3");
        // when
        List<Long> longList = input.toLongList();
        // then
        assertEquals(1, longList.get(0));
        assertEquals(2, longList.get(1));
        assertEquals(3, longList.get(2));
    }

    @DisplayName("[정상] 콜론으로 리스트 변환")
    @Test
    void parseLongListWithComma() {
        // given
        Input input = Input.from("1,3");
        // when
        List<Long> longList = input.toLongList();
        // then
        assertEquals(1, longList.get(0));
        assertEquals(3, longList.get(1));
    }

    @DisplayName("[리스트 변환 예외] 기본 구분자와 다른 경우")
    @Test
    void invalidSeparator() {
        // given
        Input input = Input.from("1,3?2");
        // when & then
        assertThrows(IllegalArgumentException.class, input::toLongList);
    }
}
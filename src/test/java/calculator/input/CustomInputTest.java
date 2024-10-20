package calculator.input;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CustomInputTest {

    @DisplayName("[정상] 커스텀 객체 생성")
    @Test
    void instance() {
        // given & when
        Input customInput = Input.from("//;\\n1;2;3");
        // then
        assertInstanceOf(CustomInput.class, customInput);
        assertNotNull(customInput);
    }

    @DisplayName("[정상] 커스텀 구분자 매칭")
    @Test
    void customSeparatorMatch() {
        // given
        String separator = ";";
        String inputStr = "//" + separator + "\\n1;2;3";
        // when
        CustomInput customInput = (CustomInput) Input.from(inputStr);
        // then
        assertInstanceOf(CustomInput.class, customInput);
        assertTrue(customInput.matchesSeparator(separator));
    }

    @DisplayName("[정상] 리스트 변환 요소 확인")
    @Test
    void parseLongList() {
        // given
        Input input = Input.from("//;\\n1;2;3");
        // when
        List<Long> longList = input.toLongList();
        // then
        assertEquals(1, longList.get(0));
        assertEquals(2, longList.get(1));
        assertEquals(3, longList.get(2));
    }

    @DisplayName("[정상] escape 커스텀 구분자 입력한 경우 구분자 매칭")
    @Test
    void escapeCustomSeparator() {
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

    @DisplayName("[리스트 변환 예외] 커스텀 구분자와 다른 문자가 포함된 경우")
    @Test
    void invalidSeparator() {
        // given
        Input input = Input.from("//;\\n1?2");
        // when & then
        assertThrows(IllegalArgumentException.class, input::toLongList);
    }

    @DisplayName("[리스트 변환 예외] 정수가 아닌 경우")
    @Test
    void invalidNumFormat() {
        // given
        Input input = Input.from("//;\\n;2;3");
        // when & then
        assertThrows(IllegalArgumentException.class, input::toLongList);
    }

    @DisplayName("[리스트 변환 예외] 주어진 구분자가 없는 경우")
    @Test
    void invalidCustomFormat() {
        // given
        Input input = Input.from("//\\n1;2;3");
        // when & then
        assertThrows(IllegalArgumentException.class, input::toLongList);
    }

    @DisplayName("[리스트 변환 예외] 커스텀 문자열의 접두사가 없는 경우")
    @Test
    void notFoundCustomPrefix() {
        // given
        Input input = Input.from(";\\n1;2;3");
        // when & then
        assertThrows(IllegalArgumentException.class, input::toLongList);
    }

    @DisplayName("[리스트 변환 예외] 커스텀 문자열의 접미사가 없는 경우")
    @Test
    void notFoundCustomSuffix() {
        // given
        Input input = Input.from("//;1;2;3");
        // when & then
        assertThrows(IllegalArgumentException.class, input::toLongList);
    }
}
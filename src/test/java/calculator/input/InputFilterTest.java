package calculator.input;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputFilterTest {

    @DisplayName("[정상] 기본 객체 생성")
    @Test
    void defaultInputInstance() {
        // given
        String defaultInput = "1,2:3";
        // when
        Input defaultInputInstance = InputFilter.parseInput(defaultInput);
        // then
        assertInstanceOf(Input.class, defaultInputInstance);
        assertFalse(defaultInputInstance instanceof CustomInput);
    }

    @DisplayName("[정상] 커스텀 객체 생성 (다형성)")
    @Test
    void customInputInstance() {
        // given
        String customInput = "//;\\n1;2;3";
        // when & then
        assertInstanceOf(CustomInput.class, InputFilter.parseInput(customInput));
    }

    @DisplayName("[커스텀 객체 생성 실패] 커스텀 문자열의 구분자가 없는 경우")
    @Test
    void notFoundSeparator() {
        // given
        Input input = Input.from("//\\n1;2;3");
        // when & then
        assertFalse(input instanceof CustomInput);
    }

    @DisplayName("[커스텀 객체 생성 실패] 커스텀 문자열의 접두사가 없는 경우")
    @Test
    void notFoundCustomPrefix() {
        // given
        Input input = Input.from(";\\n1;2;3");
        // when & then
        assertFalse(input instanceof CustomInput);
    }

    @DisplayName("[커스텀 객체 생성 실패] 커스텀 문자열의 접미사가 없는 경우")
    @Test
    void notFoundCustomSuffix() {
        // given
        Input input = Input.from("//;1;2;3");
        // when & then
        assertFalse(input instanceof CustomInput);
    }
}
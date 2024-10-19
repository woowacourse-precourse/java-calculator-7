package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidatorTest {
    @Test
    @DisplayName("기본구분자를 활용하는 문자열 포맷 검증 성공테스트")
    void checkDefaultDelimterFormatSuccessTest() {
        //given
        String[] inputString = {"1:2:3", "123,2:3", "12:333,44"};
        //when
        for (String input : inputString){
            boolean result = Validator.checkDefaultDelimterFormat(input);
            //then
            assertThat(result).isTrue();
        }
    }
    @Test
    @DisplayName("기본구분자를 활용하는 문자열 포맷 검증 실패테스트")
    void checkDefaultDelimterFormatFailTest() {
        //given
        String[] inputStrings = {"1:2:", ":1:2","","a:2:3,","#:3,4","   :  3:43"};
        //when
        for (String input : inputStrings){
            boolean result = Validator.checkDefaultDelimterFormat(input);
            //then
            assertThat(result).isFalse();
        }
    }

    @Test
    @DisplayName("커스텀 구분자를 활용하는 문자열 포맷 검증 성공테스트")
    void checkCustomDelimiterFormatSuccessTest() {
        //given
        String[] inputStrings = {"//;\\n", "//;\\n1;2;3", "//;\\nabc", "//;\\n1;2;31f4b."};
        //when
        for (String input : inputStrings){
            boolean result = Validator.checkCustomDelimiterFormat(input);
            //then
            assertThat(result).isTrue();
        }
    }
    @Test
    @DisplayName("커스텀 구분자를 활용하는 문자열 포맷 검증 실패테스트")
    void checkCustomDelimiterFormatFailTest() {
        //given
        String[] inputStrings = {"/;\\n", ";\\n1;2;3", "//;\nabc", "//;\\1;2;31f4b."};
        //when
        for (String input : inputStrings){
            boolean result = Validator.checkCustomDelimiterFormat(input);
            //then
            assertThat(result).isFalse();
        }
    }
    @Test
    @DisplayName("커스텀 구분자를 지정하는 문자열 뒤로 나오는 본 문자열 포맷 검증 성공테스트")
    void checkRemainStringFormatSuccessTest() {
        //given
        String[] inputStrings = {"1#2#3", "123#2#43"};
        //when
        for (String input : inputStrings){
            boolean result = Validator.checkRemainStringFormat(input, "#");
            //then
            assertThat(result).isTrue();
        }
    }
    @Test
    @DisplayName("커스텀 구분자를 지정하는 문자열 뒤로 나오는 본 문자열 포맷 검증 실패테스트")
    void checkRemainStringFormatFailTest() {
        //given
        String[] inputStrings = {"  ", "1;2;", "1;;2;", "abc", "1;2;31f4b."};
        //when
        for (String input : inputStrings){
            boolean result = Validator.checkRemainStringFormat(input, ";");
            //then
            assertThat(result).isFalse();
        }
    }
}
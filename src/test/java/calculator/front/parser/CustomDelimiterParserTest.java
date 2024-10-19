package calculator.front.parser;

import static org.junit.jupiter.api.Assertions.*;

import calculator.front.input.CustomDelimiterParsedInput;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CustomDelimiterParserTest {
    @Test
    @DisplayName("빈 문자열이 들어갔을 때, CustomDelimiterParsedInput의 필드는 null이면 안 됨")
    void 커스텀_구분자_추출_테스트1() {
        //given
        String rawInput = "";
        //when
        CustomDelimiterParsedInput customDelimiterParsedInput = CustomDelimiterParser.parse(rawInput);
        //then
        // 빈 문자열과 커스텀 구분자가 존재하지 않는 리스트 반환, null이면 안 됨.
        assertNotNull(customDelimiterParsedInput.delimiters());
        assertNotNull(customDelimiterParsedInput.inputWithDelimiter());
    }

    @Test
    @DisplayName("커스텀 구분자와 파싱해야할 문자열 두 가지로 파싱하여 CustomDelimiterParsedInput 객체 반환")
    void 커스텀_구분자_추출_테스트2() {
        //given
        String rawInput = "//;\\n1,2,3";
        String inputWithDelimiters = "1,2,3";
        List<Character> delimiters = new ArrayList<>();
        delimiters.add(';');
        //when
        CustomDelimiterParsedInput customDelimiterParsedInput = CustomDelimiterParser.parse(rawInput);
        //then
        assertEquals(customDelimiterParsedInput.delimiters(), delimiters);
        assertEquals(customDelimiterParsedInput.inputWithDelimiter(), inputWithDelimiters);
    }
}
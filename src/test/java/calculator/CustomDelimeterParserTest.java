package calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomDelimeterParserTest {
    @Test
    void 커스텀_구분자_파싱_성공() {
        //given
        String inputStr = "//;\n1;2;3";
        String delimiter = ",|:";

        //when
        String[] result = CustomDelimeterParser.parse(inputStr, delimiter);

        //then
        assertEquals("1;2;3", result[0]);
        assertEquals(",|:|;", result[1]);
    }

    @Test
    void 기본구분자만_있는경우_성공() {
        //given
        String inputStr = "1,2:3";
        String delimiter = ",|:";

        //when
        String[] result = CustomDelimeterParser.parse(inputStr, delimiter);

        //then
        assertEquals("1,2:3", result[0]);  // 입력 문자열 그대로
        assertEquals(",|:", result[1]);    // 기본 구분자 그대로
    }

    @Test
    void 커스텀구분자_올바르지않은_종료_예외() {
        //given
        String inputStr = "//;1;2;3";
        String delimiter = ",|:";

        //when
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            CustomDelimeterParser.parse(inputStr, delimiter);
        });

        //then
        assertEquals("커스텀 구분자는 //와 \\n사이에 존재해야 합니다.", exception.getMessage());
    }
}
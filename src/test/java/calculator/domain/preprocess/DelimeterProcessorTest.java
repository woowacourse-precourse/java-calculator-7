package calculator.domain.preprocess;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DelimeterProcessorTest {

    DelimeterProcessor delimeterProcessor = new DelimeterProcessor();

    @Test
    @DisplayName("커스텀 구분자 요구사항 인식")
    void custom_delimeter_o() {
        boolean result = delimeterProcessor.checkCustomDelimeterRequest("//;\n2,3,4");
        assertEquals(result, true);
    }

    @Test
    @DisplayName("커스텀 구분자 미입력 예외 발생")
    void no_custom_delimeter(){
       IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
               ()->delimeterProcessor.validateCutomDelimeterRequest("//\n2,3,4"));
       assertEquals(e.getMessage(),"구분자로 사용할 문자 미입력");
    }

    @Test
    @DisplayName("두 글자 이상의 구분자 지정시 예외 발생")
    void long_custom_delimeter(){
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                ()->delimeterProcessor.validateCutomDelimeterRequest("//;;;\n2,3,4"));
        assertEquals(e.getMessage(),"구분자로 사용할 문자가 두 글자 이상");
    }

    @Test
    @DisplayName("한 글자의 경우 예외 없음")
    void right_custom_delimeter(){
        assertDoesNotThrow(
                ()->delimeterProcessor.validateCutomDelimeterRequest("//;\n2,3,4"));
    }

    @Test
    @DisplayName("구분자 추출 테스트")
    void extract_custom_delimeter(){
        String delimeter = delimeterProcessor.extractCustomDelimeter("//;\n");
        assertEquals(delimeter,";");
    }
}
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

}
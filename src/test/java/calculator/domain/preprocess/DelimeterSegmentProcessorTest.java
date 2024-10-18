package calculator.domain.preprocess;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DelimeterSegmentProcessorTest {

    DelimeterSegmentProcessor delimeterSegmentProcessor = new DelimeterSegmentProcessor();

    @Test
    @DisplayName("커스텀 구분자 요구사항 인식")
    void custom_delimeter_o() {
        boolean result = delimeterSegmentProcessor.checkCustomDelimeterRequest("//;\n2,3,4");
        assertEquals(result, true);
    }



    @Test
    @DisplayName("구분자 추출 테스트")
    void extract_custom_delimeter() {
        String delimeter = delimeterSegmentProcessor.extractCustomDelimeter("//;\n");
        assertEquals(delimeter, ";");
    }

    @Test
    @DisplayName("구분자 요청 제외 String 반환 테스트")
    void discard_custom_delimeter_request() {
        String newInput = delimeterSegmentProcessor.extractCalculationSegment("//;\n1,2,3");
        assertEquals(newInput, "1,2,3");
    }

    @Test
    @DisplayName("구분자 리스트 생성 테스트")
    void make_delimter_list(){
        List<String> delimeterList = delimeterSegmentProcessor.makeDelimeterList(">");
        List<String> expectedList = new ArrayList<>(Arrays.asList(",",":",">"));
        assertEquals(delimeterList.size(),3);
        assertTrue(delimeterList.containsAll(expectedList));
    }
}
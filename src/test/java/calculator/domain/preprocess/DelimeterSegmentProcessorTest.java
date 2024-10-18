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
    @DisplayName("checkCustomDelimeterRequest 기능 테스트")
    void custom_delimeter_o() {
        boolean result = delimeterSegmentProcessor.checkCustomDelimeterRequest("//;\n2,3,4");
        assertTrue(result);
    }


    @Test
    @DisplayName("CalculationSegment 반환 테스트")
    void discard_custom_delimeter_request() {
        String newInput = delimeterSegmentProcessor.extractCalculationSegment("//;\n1,2,3");
        assertEquals(newInput, "1,2,3");
    }

    @Test
    @DisplayName("구분자 리스트 생성 테스트")
    void make_delimter_list(){
        List<String> delimeterList = delimeterSegmentProcessor.extractDelimeterList(">");
        List<String> expectedList = new ArrayList<>(Arrays.asList(",",":",">"));
        assertEquals(delimeterList.size(),3);
        assertTrue(delimeterList.containsAll(expectedList));
    }
}
package calculator.domain.preprocess;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DelimiterSegmentProcessorTest {

    DelimiterSegmentProcessor delimiterSegmentProcessor = new DelimiterSegmentProcessor();

    @Test
    @DisplayName("checkCustomDelimiterRequest 기능 테스트")
    void custom_delimiter_o() {
        boolean result = delimiterSegmentProcessor.checkCustomDelimiterRequest("//;\n2,3,4");
        assertTrue(result);
    }


    @Test
    @DisplayName("CalculationSegment 반환 테스트")
    void discard_custom_delimiter_request() {
        String newInput = delimiterSegmentProcessor.extractCalculationSegment("//;\n1,2,3");
        assertEquals(newInput, "1,2,3");
    }

    @Test
    @DisplayName("구분자 리스트 생성 테스트")
    void make_delimiter_list(){
        List<String> delimiterList = delimiterSegmentProcessor.extractDelimiterList(">");
        List<String> expectedList = new ArrayList<>(Arrays.asList(",",":",">"));
        assertEquals(delimiterList.size(),3);
        assertTrue(delimiterList.containsAll(expectedList));
    }
}
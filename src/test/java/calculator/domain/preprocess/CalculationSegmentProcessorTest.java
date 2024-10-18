package calculator.domain.preprocess;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static calculator.utils.Util.isInteger;
import static org.junit.jupiter.api.Assertions.*;

class CalculationSegmentProcessorTest {

    CalculationSegmentProcessor calculationSegmentProcessor = new CalculationSegmentProcessor();

    @Test
    @DisplayName("isInteger 기능 테스트")
    void isInteger_test() {
        assertTrue(isInteger("3"));
        assertFalse(isInteger("z"));
    }


    @Test
    @DisplayName("findNoneDelimeterString 기능 테스트")
    void findNoneDelimeterString_o(){
        assertDoesNotThrow(()->
                calculationSegmentProcessor.findNoneDelimeterString(Arrays.asList(",",":"),"1,2,3,4:5:6:7"));
    }

    @Test
    @DisplayName("findNoneDelimeterString 예외 테스트")
    void findNoneDelimeterString_x(){
        IllegalArgumentException e= assertThrows(IllegalArgumentException.class,()->
                calculationSegmentProcessor.findNoneDelimeterString(Arrays.asList(",",":"),"1,2>3,4:5:6:7"));

        assertEquals(e.getMessage(),"구분자 이외의 문자가 있습니다.");
    }

    @Test
    @DisplayName("extractNumbers 빈칸 제거까지 있는 기능 테스트")
    void extractNumbers_withblank() {
        List<String> delimeterList = new ArrayList<>(Arrays.asList(",", ":", "<"));

        List<String> result = calculationSegmentProcessor.extractNumbers(delimeterList, "2,3:4<");
        List<String> expected = new ArrayList<>(Arrays.asList("2", "3", "4"));

        assertTrue(expected.containsAll(result));
    }

    @Test
    @DisplayName("extractNumbers 빈칸 발생 없는 기능 테스트")
    void extractNumbers_withoutblank() {
        List<String> delimeterList = new ArrayList<>(Arrays.asList(",", ":", "<"));

        List<String> result = calculationSegmentProcessor.extractNumbers(delimeterList, "2,3:4<5");
        List<String> expected = new ArrayList<>(Arrays.asList("2", "3", "4", "5"));

        assertTrue(expected.containsAll(result));
    }
}
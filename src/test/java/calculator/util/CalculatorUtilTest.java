package calculator.util;

import static org.junit.jupiter.api.Assertions.*;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CalculatorUtilTest {
    @Test
    void extractDelimiter() {
        // when
        List<String> delimiterResult = CalculatorUtil.extractDelimiter("1:2,2");
        List<String> customDelimiterResult = CalculatorUtil.extractDelimiter("//+\n1+2:2");

        // then
        assertTrue(delimiterResult.contains(","));
        assertTrue(delimiterResult.contains(":"));
        assertEquals(2, customDelimiterResult.size());

        assertTrue(customDelimiterResult.contains("+"));
        assertTrue(customDelimiterResult.contains(":"));
        assertEquals(2, customDelimiterResult.size());
    }
}
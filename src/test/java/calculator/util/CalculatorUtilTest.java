package calculator.util;

import static org.junit.jupiter.api.Assertions.*;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
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

    @Test
    void splitByDelimiters() {

        // given
        List<String> delimiters = new ArrayList<>();
        delimiters.add(",");
        delimiters.add(":");
        delimiters.add("+");
        delimiters.add("|");

        // when
        List<Integer> result = CalculatorUtil.splitByDelimiters(delimiters, "1:2:3,4|5|6");

        // then
        assertEquals(6, result.size());
    }
}
package calculator.util;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
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

    @Test
    @DisplayName("커스텀 문자 정규식에 일치하는 부분을 삭제하고 반환합니다.")
    void formattingString() {
        String resultA = CalculatorUtil.formattingString("1:2:3,4|5|6");
        String resultB = CalculatorUtil.formattingString("//:\n1:2:3,4|5|6");

        assertThat(resultA).isEqualTo("1:2:3,4|5|6");
        assertThat(resultB).isEqualTo("1:2:3,4|5|6");
    }

    @Test
    @DisplayName("커스텀 구분자 선언부가 1개인지 확인합니다.")
    void isOnlyOneCustomDeclare() {
        // when
        Boolean resultOneDeclare = CalculatorUtil.isOnlyOneCustomDeclare("//:\n1:2:3,4|5|6");
        Boolean resulTwiceDeclare2 = CalculatorUtil.isOnlyOneCustomDeclare("//:\n//:\n1:2:3,4|5|//:\n6");
        Boolean resultNoneDeclare = CalculatorUtil.isOnlyOneCustomDeclare("1:2:3,4|5|6");

        // then
        assertTrue(resultOneDeclare);
        assertFalse(resulTwiceDeclare2);
        assertTrue(resultNoneDeclare);
    }
}
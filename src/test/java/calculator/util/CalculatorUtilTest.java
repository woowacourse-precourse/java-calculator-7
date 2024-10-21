package calculator.util;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import calculator.common.util.CalculatorUtil;
import calculator.service.InputValidator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorUtilTest {
    @Test
    void extractDelimiter() {
        // when
        List<String> delimiterResult = CalculatorUtil.extractDelimiter("1:2,2");
        List<String> customDelimiterResult = CalculatorUtil.extractDelimiter("//|\\n1:2|2");

        // then
        assertTrue(delimiterResult.contains(","));
        assertTrue(delimiterResult.contains(":"));
        assertEquals(2, delimiterResult.size());

        assertTrue(customDelimiterResult.contains(":"));
        assertTrue(customDelimiterResult.contains("|"));
        assertEquals(2, customDelimiterResult.size());
    }

    @Test
    @DisplayName("구분자를 기준으로 숫자를 추출합니다.")
    void splitByDelimiters_o() {

        // given
        String[] delimiters = {",", "|", ":"};
        List<String> delimiterList = new ArrayList<>(Arrays.asList(delimiters));
        String inputValue = "1:2:3,4|5|6";

        // when
        List<Integer> result = CalculatorUtil.splitByDelimiters(delimiterList, inputValue);

        // then
        assertEquals(6, result.size());
    }

    @Test
    @DisplayName("숫자 구분시, 잘못된 입력이 존재하는 경우 오류를 발생합니다.")
    void splitByDelimiters_x() {
        // given
        String[] delimiters = {",", "|", "+", ":"};
        List<String> delimiterList = new ArrayList<>(Arrays.asList(delimiters));
        String inputValue = "1::2:3,4|5|6";

        // when, then
        assertThrows(IllegalArgumentException.class,
                () -> {CalculatorUtil.splitByDelimiters(delimiterList, inputValue);
        });
    }

    @Test
    @DisplayName("커스텀 문자 정규식에 일치하는 부분을 삭제하고 반환합니다.")
    void formattingString() {
        String resultA = CalculatorUtil.formattingString("1:2:3,4|5|6");
        String resultB = CalculatorUtil.formattingString("//:\\n1:2:3,4|5|6");

        assertThat(resultA).isEqualTo("1:2:3,4|5|6");
        assertThat(resultB).isEqualTo("1:2:3,4|5|6");
    }

    @Test
    @DisplayName("커스텀 구분자 선언부가 1개인지 확인합니다.")
    void isOnlyOneCustomDeclare() {

        // given
        InputValidator inputValidator = new InputValidator();

        // when
        Boolean resultOneDeclare = inputValidator.isOnlyOneCustomDeclare("//:\\n1:2:3,4|5|6");
        Boolean resulTwiceDeclare2 = inputValidator.isOnlyOneCustomDeclare("//:\\n//:\\n1:2:3,4|5|//:\\n6");
        Boolean resultNoneDeclare = inputValidator.isOnlyOneCustomDeclare("1:2:3,4|5|6");

        // then
        assertTrue(resultOneDeclare);
        assertFalse(resulTwiceDeclare2);
        assertTrue(resultNoneDeclare);
    }

    @Test
    @DisplayName("추출한 delimiter 외 다른 '문자' 또는 '공백을 포함하는 지 확인합니다.")
    void isContainInvalidChar() {
        // given
        InputValidator inputValidator = new InputValidator();

        // when
        Boolean invalidDeclare = inputValidator.isContainInvalidChar("//:\\n//:\\n1:2:3,4|5|//:\\n6");
        Boolean containSpace = inputValidator.isContainInvalidChar("//-\\n1 2:3-4:5,6");
        Boolean validResult1 = inputValidator.isContainInvalidChar("1:2:3,4:5:6");
        Boolean validResult2 = inputValidator.isContainInvalidChar("//-\\n1-2:3-4:5,6");

        // then
        assertTrue(invalidDeclare);
        assertTrue(containSpace);

        assertFalse(validResult1);
        assertFalse(validResult2);
    }
}
package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringAddCalculatorTest {

    private StringAddCalculator stringAddCalculator = new StringAddCalculator();

    @DisplayName("기본 구분자를 이용해 문자열 파싱 후 숫자 합 출력 확인 테스트")
    @Test
    void calculateDefaultDelimiterAddTest() {
        String input = "1,2:3";
        int expectedSum = 6;
        assertThat(stringAddCalculator.add(input)).isEqualTo(expectedSum);
    }

    @DisplayName("커스텀 구분자를 이용해 문자열 파싱 후 숫자 합 출력 확인 테스트")
    @Test
    void calculateCustomDelimiterAddTest() {
        String input = "//;\n1;2;3";
        int expectedSum = 6;
        assertThat(stringAddCalculator.add(input)).isEqualTo(expectedSum);
    }
}

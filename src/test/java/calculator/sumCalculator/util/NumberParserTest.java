package calculator.sumCalculator.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;


class NumberParserTest {

    private NumberParser numberParser;

    @BeforeEach
    void setUp() {
        numberParser = new NumberParser();
    }

    @Test
    @DisplayName("커스텀 구분자를 사용한 사용자 입력에서 숫자를 추출한다.")
    void extractNumbersContainCustomDelimiter() {
        String expression = "1^^2^^3";
        List<Integer> result = numberParser.extractNumbers(expression, true, "^^");
        assertThat(List.of(1,2,3)).isEqualTo(result);
    }

    @Test
    @DisplayName("기본 구분자를 사용한 사용자 입력에서 숫자를 추출한다.")
    void extractNumbersContainDefaultDelimiter() {
        String input = "1,2;3";
        List<Integer> result = numberParser.extractNumbers(input, false, "");
        assertThat(List.of(1,2,3)).isEqualTo(result);
    }

    @Test
    @DisplayName("예외 테스트 - 기본 구분자를 사용한 연산식에 올바르지 않은 숫자를 입력하면 추출 실패한다.")
    void failExtractNumbersContainInvalidNumber() {
        String input = "1,2;a";
        assertThatThrownBy(() -> numberParser.extractNumbers(input, false, ""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("연산식에 유효하지 않은 숫자가 포함되어 있습니다.");
    }

    @Test
    @DisplayName("예외 테스트 - 커스텀 구분자를 사용한 연산식에 올바르지 않은 숫자를 입력하면 추출 실패한다.")
    void failExtractNumbersContainInvalidNumberUsedCustomDelimiter() {
        String input = "1#2#a";
        assertThatThrownBy(() -> numberParser.extractNumbers(input, true, "#"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("연산식에 유효하지 않은 숫자가 포함되어 있습니다.");
    }

}
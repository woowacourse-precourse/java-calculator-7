package calculator.application;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import calculator.application.impl.PositiveNumberExtractService;
import calculator.domain.CalculatorPrompt;
import java.util.List;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ExtractServiceUnitTest {

    ExtractService extractService = new PositiveNumberExtractService();

    @Test
    @DisplayName("한자리 이상의 숫자로 구성된 문자열 리스트를 정수로 추출한다.")
    void givenDigitList_whenExtractNumbers_thenReturnNumberList() {
        // given
        List<String> numberStrings = List.of("1", "12", "123");

        // when
        List<Integer> result = extractService.extractNumbers(numberStrings);

        // then
        List<Integer> expected = List.of(1, 12, 123);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("한개의 리스트 정보가 주어질 시, 하나의 추출된 정보를 반환한다.")
    void givenHasOneNumberList_whenExtractNumbers_thenReturnListSizeIsOne() {
        // given
        List<String> numberStrings = List.of("1");

        // when
        List<Integer> result = extractService.extractNumbers(numberStrings);

        // then
        assertThat(result.size()).isOne();
    }

    @Test
    @DisplayName("빈 리스트 정보가 주어질 시, 빈 리스트 정보를 반환한다.")
    void givenEmptyList_whenExtractNumbers_thenReturnListSizeZero() {
        // given
        List<String> numberStrings = List.of();

        // when
        List<Integer> result = extractService.extractNumbers(numberStrings);

        // then
        assertThat(result.size()).isZero();
    }

    @Test
    @DisplayName("숫자 이외에 문자가 포함된 문자열 추출 시, 예외가 발생한다")
    void givenHasNotNumberList_whenExtractNumbers_thenReturnError() {
        // given
        List<String> numberStrings = List.of(",", "1", "2");

        // when, then
        assertThatThrownBy(() -> extractService.extractNumbers(numberStrings))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("음수가 포함된 문자열 추출 시, 예외가 발생한다")
    void givenHasNegativeNumberList_whenExtractNumbers_thenReturnError() {
        // given
        List<String> numberStrings = List.of("-1", "1", "2");

        // when, then
        assertThatThrownBy(() -> extractService.extractNumbers(numberStrings))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
package calculator.util;

import calculator.exception.util.NumberExtractorErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumberExtractorTest {
    @Test
    @DisplayName("정상적으로 숫자 및 구분자가 포함된 문자열 (커스텀 구분자 x)")
    void 정상적인_숫자가_포함된_문자열_커스텀_구분자_x() {
        // given
        String input = "1,2:3";
        String[] delimiters = {",", ":"};

        // when
        int[] result = NumberExtractor.extract(input, delimiters);

        // then
        assertThat(result).containsExactly(1, 2, 3);
    }

    @Test
    @DisplayName("정상적으로 숫자 및 구분자가 포함된 문자열 (커스텀 구분자 o)")
    void 정상적인_숫자가_포함된_문자열_커스텀_구분자_o() {
        // given
        String input = "1&2:6";
        String[] delimiters = {",", ":", "&"};

        // when
        int[] result = NumberExtractor.extract(input, delimiters);

        // then
        assertThat(result).containsExactly(1, 2, 6);
    }

    @Test
    @DisplayName("기본 구분자 또는 커스텀 구분자가 아닌 구분자가 포함된 경우 예외 처리")
    void 지정된_구분자가_아닌_문자열() {
        // given
        String input = "3?4";
        String[] delimiters = {",", ":", "&"};

        // when & then
        assertThatThrownBy(() -> NumberExtractor.extract(input, delimiters))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NumberExtractorErrorMessage.INVALID_DELIMITER.getMessage());
    }

    @Test
    @DisplayName("0 또는 음수를 포함된 경우 예외 처리")
    void 음수_또는_0이_포함된_문자열() {
        // given
        String input = "4:-3";
        String[] delimiters = {",", ":", "&"};

        // when & then
        assertThatThrownBy(() -> NumberExtractor.extract(input, delimiters))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NumberExtractorErrorMessage.NEGATIVE_OR_ZERO_NUMBER.getMessage());
    }

    @Test
    @DisplayName("유효하지 않은 문자가 포함된 경우 예외 처리")
    void 유효하지_않은_문자가_포함된_문자열() {
        // given
        String input = "4:2,abc";
        String[] delimiters = {",", ":", "&"};

        // when & then
        assertThatThrownBy(() -> NumberExtractor.extract(input, delimiters))
                .isInstanceOf(IllegalArgumentException.class)
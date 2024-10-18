package calculator.domain;

import calculator.domain.collection.Delimiters;
import calculator.domain.value.Delimiter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class DelimiterTest {

    @Test
    @DisplayName("올바른 커스텀 구분자를 생성한다.")
    void 올바른_커스텀_구분자_생성() {
        // Given
        String input = "//;\\n1;2;3";

        // When
        Delimiters delimiters = Delimiters.of(input);
        String processedInput = delimiters.removeDelimiterDefinition(input);
        String[] result = delimiters.split(processedInput);

        // Then
        assertThat(result).containsExactly("1", "2", "3");
    }

    @Test
    @DisplayName("커스텀 구분자에 숫자가 포함될 경우 예외를 발생시킨다.")
    void 숫자_구분자_예외_발생() {
        // Given
        String invalidDelimiter = "1";

        // When, Then
        assertThatThrownBy(() -> new Delimiter(invalidDelimiter))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("커스텀 구분자에 숫자가 포함될 수 없습니다.");
    }

    @Test
    @DisplayName("잘못된 구분자를 사용한 경우 예외를 발생시킨다.")
    void 잘못된_구분자_사용_예외_발생() {
        // Given
        String input = "//!\\1!2!3";

        // When, Then
        assertThatThrownBy(() -> Delimiters.of(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("커스텀 구분자가 올바르게 입력되지 않았습니다.");
    }

    @Test
    @DisplayName("커스텀 구분자가 두 글자 이상인 경우 예외를 발생시킨다.")
    void 커스텀_구분자_두_글자_이상_예외_발생() {
        // Given
        String input = "//!!\\n1!!2!!3";

        // When, Then
        assertThatThrownBy(() -> Delimiters.of(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("커스텀 구분자는 한 글자여야 합니다.");
    }

    @Test
    @DisplayName("커스텀 구분자가 특수문자인 경우에도 동작한다.")
    void 커스텀_구분자_특수문자_사용() {
        // Given
        String customDelimiter = ".";

        // When
        Delimiter delimiter = new Delimiter(customDelimiter);

        // Then
        assertThat(delimiter.toRegex()).isEqualTo("\\.");
    }

    @Test
    @DisplayName("비어있는 커스텀 구분자를 사용한 경우 예외를 발생시킨다.")
    void 비어있는_커스텀_구분자_예외_발생() {
        // Given
        String emptyDelimiter = "//\\n1";

        // When, Then
        assertThatThrownBy(() -> Delimiters.of(emptyDelimiter))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("커스텀 구분자는 비어 있을 수 없습니다.");
    }
}

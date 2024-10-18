package calculator.domain.prompt;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class DelimiterTest {

    @ParameterizedTest
    @ValueSource(chars = {',', ':'})
    @DisplayName("Delimiter 생성 시 기본 구분자들이 포함되어있다.")
    void givenDefaultDelimitersAndConstructed_whenIsIn_thenTrue(char defaultDelimiter) {
        // given
        Delimiter delimiter = new Delimiter();

        // when
        boolean result = delimiter.isIn(defaultDelimiter);

        // then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Delimiter에 커스텀 구분자를 추가할 수 있다.")
    void givenCustomDelimiterAndConstructed_whenAdd_thenCustomDelimiterInDelimiter() {
        // given
        Delimiter delimiter = new Delimiter();
        char customDelimiter = '+';

        // when
        delimiter.add(customDelimiter);

        // then
        assertThat(delimiter.isIn(customDelimiter)).isTrue();
    }

    @Test
    @DisplayName("Delimiter에 존재하지 않는 구분자를 확인할 수 있다.")
    void givenCustomDelimiterAndConstructed_whenAdd_thenOtherDelimiterNotInDelimiter() {
        // given
        Delimiter delimiter = new Delimiter();
        char customDelimiter = '+';

        // when
        delimiter.add(customDelimiter);

        // then
        assertThat(delimiter.isIn('.')).isFalse();
    }

    @Test
    @DisplayName("Delimiter는 3개 이상 구분자를 추가할 경우 예외가 발생한다.")
    void givenCustomDelimiterAndConstructedAndAdd_whenAdd_thenReturnError() {
        // given
        Delimiter delimiter = new Delimiter();
        char customDelimiter = '+';
        delimiter.add(customDelimiter);

        // when, then
        assertThatThrownBy(() -> delimiter.add(customDelimiter))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
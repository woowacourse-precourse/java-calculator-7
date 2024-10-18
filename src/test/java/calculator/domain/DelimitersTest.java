package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class DelimitersTest {

    @Test
    @DisplayName("기본 구분자로 쉼표와 콜론이 주어진다.")
    void createDefault() {
        // given
        Delimiters delimiters = new Delimiters();

        // then
        assertThat(delimiters.getElements()).hasSize(2);
        assertThat(delimiters.getElements()).contains(",");
        assertThat(delimiters.getElements()).contains(":");
    }

    @Test
    @DisplayName("구분자를 추가한다.")
    void addDelimiter() {
        // given
        Delimiters delimiters = new Delimiters();
        String customDelimiter = ";";

        // when
        delimiters.addDelimiter(customDelimiter);

        // then
        assertThat(delimiters.getElements()).hasSize(3);
        assertThat(delimiters.getElements()).contains(customDelimiter);
    }

    @Test
    @DisplayName("구분자에 숫자가 추가될 경우 예외가 발생한다.")
    void throwExceptionWhenNumberInput() {
        // given
        Delimiters delimiters = new Delimiters();
        String customDelimiter = "1";

        // when, then
        assertThatThrownBy(() -> delimiters.addDelimiter(customDelimiter))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
package calculator.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static calculator.util.Const.*;
import static org.assertj.core.api.Assertions.*;
import java.util.List;

class DelimiterSetTest {

    private DelimiterSet delimiterSet;

    @BeforeEach
    void setUp() {
        delimiterSet = new DelimiterSet();
    }

    @Test
    @DisplayName("기본 구분자는 콤마와 콜론을 포함하고 있어야 한다.")
    void defaultDelimitersArePresent() {
        assertThat(delimiterSet.hasCustom())
                .as("기본 구분자만 있을 때 커스텀 구분자가 없어야 합니다.")
                .isFalse();

        assertThat(delimiterSet.getSplitForm())
                .contains(",", ":");
    }

    @Test
    @DisplayName("숫자 구분자는 예외를 발생시켜야 한다.")
    void addNumericDelimiterShouldThrowException() {
        assertThatThrownBy(() -> delimiterSet.addAll(List.of("123")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NUMERIC_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("문자 구분자는 예외를 발생시켜야 한다.")
    void addStringDelimiterShouldThrowException() {
        assertThatThrownBy(() -> delimiterSet.addAll(List.of("abc")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(STRING_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("커스텀 구분자가 추가되면 hasCustom이 true를 반환해야 한다.")
    void customDelimitersShouldBeAdded() {
        delimiterSet.addAll(List.of("#", ";"));
        assertThat(delimiterSet.hasCustom())
                .isTrue();

        assertThat(delimiterSet.getSplitForm())
                .contains("#", ";");
    }
}

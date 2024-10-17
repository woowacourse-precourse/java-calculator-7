package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DelimiterTest {
    static final String ERROR_MESSAGE = "잘못된 구분자 형식입니다.";

    @Test
    @DisplayName("커스텀 구분자를 포함하여 문자를 분리한다")
    void testCustomDelimiter() {
        //given
        Delimiter delimiter = new Delimiter();
        String token = "//;\\n1;2;3;4,5:6";
        String[] expectedValue = {"1", "2", "3", "4", "5", "6"};
        //when
        String[] numbers = delimiter.split(token);
        //then
        assertThat(numbers).hasSize(expectedValue.length);
        assertThat(numbers).contains(expectedValue);
    }

    @Test
    @DisplayName("기본 구분자가 포함된 문자를 분리한다")
    void testDefaultDelimiter() {
        //given
        Delimiter delimiter = new Delimiter();
        String token = "1:2,3,4,5:6";
        String[] expectedValue = {"1", "2", "3", "4", "5", "6"};
        //when
        String[] numbers = delimiter.split(token);
        //then
        assertThat(numbers).hasSize(expectedValue.length);
        assertThat(numbers).contains(expectedValue);
    }

    @Test
    @DisplayName("완벽하지 않은 커스텀 구분자에 대해서는 예외가 발생하지 않는다")
    void testIncompleteCustomSeparator() {
        //given
        Delimiter delimiter = new Delimiter();
        String token = "1:2;3,4,5:6";
        String[] expectedValue = {"1", "2;3", "4", "5", "6"};
        //when
        String[] numbers = delimiter.split(token);
        //then
        assertThat(numbers).hasSize(expectedValue.length);
        assertThat(numbers).contains(expectedValue);
    }

    @Test
    @DisplayName("커스텀 구분자 표현식안에 2개이상의 구분자가 있으면 예외가 발생한다")
    void failInvalidCustomDelimiterFormat() {
        //given
        Delimiter delimiter = new Delimiter();
        String invalidCustomDelimiterFormat = "//;{\\n";
        String token = invalidCustomDelimiterFormat + "1;2;3;4,5:6";
        //when
        //then
        Assertions.assertThatThrownBy(() -> {
                    delimiter.split(token);
                }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_MESSAGE);
    }
}
package calculator.domain.vo.delimiter;

import static calculator.infrastructure.exception.ErrorCode.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("Delimiters 테스트")
class DelimitersTest {

    @Test
    void 기본_Delimiters가_정상적으로_생성() {
        // given
        String input = "1,2,3";

        // when
        Delimiters delimiters = Delimiters.from(input);

        // then
        assertThat(delimiters.getDelimiterRegex()).isEqualTo("\\Q,\\E|\\Q:\\E");
    }

    @ParameterizedTest
    @ValueSource(strings = {"//;\\n1;2;3", "//#\\n1#2#3", "//*\\n1*2*3"})
    void Custom_Delimiter가_정상적으로_파싱(String input) {

        // given & when
        Delimiters delimiters = Delimiters.from(input);

        // then
        assertThat(delimiters.getDelimiterRegex()).containsAnyOf(";", "#", "*");
    }

    @ParameterizedTest
    @ValueSource(strings = {"//;;\\n1;2;3", "//##\\n1#2#3", "//**\\n1*2*3"})
    void 유효하지않은_Custom_Delimiter_시_예외를_발생(String input) {
        // given & when
        assertThatThrownBy(() -> Delimiters.from(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(INVALID_DELIMITER.getMessage());
    }
}
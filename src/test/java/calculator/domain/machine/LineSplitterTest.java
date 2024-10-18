package calculator.domain.machine;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class LineSplitterTest {

    LineSplitter lineSplitter = new LineSplitter(new DelimiterExtractor());

    @ParameterizedTest
    @ValueSource(strings = {"2,3,4", "2:3,4", "2:3:4"})
    @DisplayName("기본 구분자 성공")
    void basicDelimiterSuccess(String input) {
        // when
        List<Long> operands = lineSplitter.getOperands(input);
        assertArrayEquals(new Long[]{2L, 3L, 4L}, operands.toArray());
    }

    @Test
    @DisplayName("커스텀 구분자 성공")
    void basicDelimiterFailure() {
        // given
        String line = "//@\\n2@3@4";

        // when
        List<Long> operands = lineSplitter.getOperands(line);

        // then
        assertArrayEquals(new Long[]{2L, 3L, 4L}, operands.toArray());
    }

    @Test
    @DisplayName("커스텀 구분자가 공백일 때")
    void blankCustomDelimiter() {
        // given
        String line = "//\\n234";

        // when
        // then
        assertThatIllegalArgumentException().isThrownBy(() -> lineSplitter.getOperands(line));
    }
}
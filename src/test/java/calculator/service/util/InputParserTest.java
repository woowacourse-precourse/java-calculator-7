package calculator.service.util;

import calculator.domain.exception.CalculatorException;
import calculator.domain.exception.ErrorMessage;
import calculator.domain.model.ExtractedInput;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class InputParserTest {

    @Test
    @DisplayName("문자열 입력을 구분자로 분리하여 숫자 리스트로 변환 테스트")
    void parseValidInputReturnsListOfIntegers() {
        ExtractedInput input = ExtractedInput.of(",|:", "1,2,3,4");

        List<Integer> result = InputParser.parseByDelimiters(input);

        assertThat(result)
                .hasSize(4)
                .containsExactly(1, 2, 3, 4);
    }

    @Test
    @DisplayName("구분자로 숫자를 잘못된 값이 포함된 경우 예외 발생 테스트")
    void parseInvalidNumberThrowsCalculatorException() {
        ExtractedInput input = ExtractedInput.of(",|:", "1,2,a,4");

        assertThatThrownBy(() -> InputParser.parseByDelimiters(input))
                .isInstanceOf(CalculatorException.class)
                .hasMessage(ErrorMessage.NOT_NUMBER_ERROR.getMessage());
    }

    @Test
    @DisplayName("빈 문자열 입력 시 빈 리스트 반환 테스트")
    void parseEmptyInputReturnsEmptyList() {
        ExtractedInput input = ExtractedInput.of(",|:", "");

        List<Integer> result = InputParser.parseByDelimiters(input);

        assertThat(result)
                .isEmpty();
    }
}

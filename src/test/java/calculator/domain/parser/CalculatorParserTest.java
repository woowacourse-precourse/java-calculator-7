package calculator.domain.parser;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import calculator.domain.dto.InputRequest;
import java.util.List;
import java.util.regex.Pattern;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorParserTest {

    private static final String DEFAULT_DELIMITER = ",|:";

    @Test
    @DisplayName("정상 입력: 1,2")
    public void testValidInputWithCommaAndColonDelimiters() {
        InputRequest inputRequest = InputRequest.of(DEFAULT_DELIMITER, "1,2");
        List<Integer> list = CalculatorParser.parseForDelimiters(inputRequest);

        assertThat(list)
                .hasSize(2)
                .containsExactly(1, 2);
    }

    @Test
    @DisplayName("예외 테스트: 불필요한 구분자")
    public void testInvalidInputWithUnnecessaryDelimiters() {
        InputRequest inputRequest = InputRequest.of(DEFAULT_DELIMITER, "1::::");

        assertThrows(IllegalArgumentException.class, () ->
                CalculatorParser.parseForDelimiters(inputRequest));
    }

    @Test
    @DisplayName("예외 테스트: 커스텀 구분자와 다른 구분자를 사용")
    public void testInvalidInputWithIncorrectCustomDelimiters() {
        String customDelimiters = DEFAULT_DELIMITER + "|" + Pattern.quote(";;");
        InputRequest inputRequest = InputRequest.of(customDelimiters, "1;2");

        assertThrows(IllegalArgumentException.class, () ->
                CalculatorParser.parseForDelimiters(inputRequest));
    }

    @Test
    @DisplayName("예외 테스트: 사용자가 입력한 값이 양수가 아닌 경우")
    public void testInvalidInputWithNonPositiveValues() {
        InputRequest inputRequest = InputRequest.of(DEFAULT_DELIMITER, "1:-2:-2");
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () ->
                CalculatorParser.parseForDelimiters(inputRequest));
        assertEquals(e.getMessage(), "양수가 아니거나 계산 범위를 초과하였습니다.");
    }
    
}
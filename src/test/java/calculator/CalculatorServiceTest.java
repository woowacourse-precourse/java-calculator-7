package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import calculator.service.CalculatorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorServiceTest {
    CalculatorService calculatorService;

    @BeforeEach
    void setUp() {
        calculatorService = CalculatorService.getInstance();
    }

    @DisplayName("문자열에 기본 구분자들(쉼표(,)와 콜론(:))을 구분자가 포함되어 있는지 체크")
    @Test
    void isContainsDefaultDelimiters() {
        // give
        String userInput = "1,2:3";
        // when
        Boolean isContainsDefaultDelimiters = calculatorService.containsDefaultDelimiters((userInput));
        // then
        assertThat(isContainsDefaultDelimiters).isEqualTo(true);
    }

    @DisplayName("문자열에 커스텀 구분자(\"//\"와 \"\\n\" 사이에 위치하는 문자)가 포함되어 있는지 체크하는 메소드")
    @Test
    void isContainsCustomDelimiters() {
        // give
        String userInput = "//;\n1;2;3";
        // when
        String customDelimiters = calculatorService.extractCustomDelimiter((userInput));
        // then
        assertThat(customDelimiters).isEqualTo(";");
    }

}

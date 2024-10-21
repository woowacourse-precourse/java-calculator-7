package calculator;

import static calculator.service.CalculatorService.containsDefaultDelimiters;
import static org.assertj.core.api.Assertions.assertThat;

import calculator.service.CalculatorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class calculatorServiceTest {
    CalculatorService calculatorService;

    @BeforeEach
    void setUp() {
        calculatorService = CalculatorService.getInstance();
    }

    @DisplayName("문자열에 기본 구분자들(쉼표(,)와 콜론(:))을 구분자가 포함되어 있는지 체크")
    @Test
    void iscontainsDefaultDelimiters() {
        // give
        String userInput = "1,2:3";
        // when
        Boolean isContainsDefaultDelimiters = calculatorService.containsDefaultDelimiters((userInput));
        // then
        assertThat(isContainsDefaultDelimiters).isEqualTo(true);
    }
}

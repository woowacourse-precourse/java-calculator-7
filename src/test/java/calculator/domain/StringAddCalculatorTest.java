package calculator.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class StringAddCalculatorTest {
    private StringAddCalculator calculator;

    @BeforeEach
    void setUp() {
        Splitter splitter = new Splitter(new Validator());
        NumberParser parser = new NumberParser(new Validator());
        calculator = new StringAddCalculator(splitter, parser);
    }

    @Test
    void 문자열_계산_기본_구분자() {
        String input = "1,2:3";
        int result = calculator.calculate(input);
        assertThat(result).isEqualTo(6);
    }

    @Test
    void 문자열_계산_커스텀_구분자() {
        String input = "//;\n1;2;3";
        int result = calculator.calculate(input);
        assertThat(result).isEqualTo(6);
    }

}

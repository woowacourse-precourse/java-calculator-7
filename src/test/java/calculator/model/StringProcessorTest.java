package calculator.model;

import static org.junit.jupiter.api.Assertions.assertTrue;

import calculator.model.vo.Number;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StringProcessorTest {
    private StringProcessor processor;

    @BeforeEach
    void setUp() {
        processor = new StringProcessor();
    }

    @Test
    void 기본_구분자를_기준으로_문자열을_처리할_수_있다() {
        String expression = "1,2:3";

        List<Number> result = processor.interpret(expression);

        assertTrue(result.stream()
                .anyMatch(number -> number.equals(Number.of("1"))));
    }
}

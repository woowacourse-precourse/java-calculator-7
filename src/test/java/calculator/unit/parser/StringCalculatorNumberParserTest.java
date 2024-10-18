package calculator.unit.parser;

import calculator.parser.StringCalculatorNumberParser;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringCalculatorNumberParserTest {


    @Test
    @DisplayName("파서 그냥 실행 테스트")
    void test() {
        List<String> numbers = List.of("1", "2", "3");
        StringCalculatorNumberParser parser = new StringCalculatorNumberParser();
        List<Integer> intNumbers = parser.parseNumbers(numbers);
        Assertions.assertEquals(intNumbers.get(0), 1);
        Assertions.assertEquals(intNumbers.get(1), 2);
        Assertions.assertEquals(intNumbers.get(2), 3);


    }
}
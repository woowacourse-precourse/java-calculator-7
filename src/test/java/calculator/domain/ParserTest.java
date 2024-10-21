package calculator.domain;

import calculator.domain.model.PreprocessedInput;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {

    @Test
    @DisplayName("정상적인 문자열과 구분자가 주어졌을 때 숫자 List로 잘 변환됨")
    void parse() {
        // givben
        String string = "1,2:3#4";
        List<Character> delimiters = List.of(',', ':', '#');
        PreprocessedInput preprocessedInput = new PreprocessedInput(string, delimiters);
        Parser parser = new Parser(preprocessedInput);

        // when
        List<Integer> result = parser.parse();

        // then
        assertEquals(List.of(1, 2, 3, 4), result);
    }

    @Test
    @DisplayName("구분자 목록에 없는 문자가 숫자 중간에 끼여있을 경우 IlligalArgumentException 발생")
    void parseWithIllegalArgument() {
        // given
        String string = "1,2:3#4";
        List<Character> delimiters = List.of(',', ':');
        PreprocessedInput preprocessedInput = new PreprocessedInput(string, delimiters);
        Parser parser = new Parser(preprocessedInput);

        // when
        // then
        assertThrows(IllegalArgumentException.class, parser::parse);
    }

    @Test
    @DisplayName("음수 들어오는 경우 IllegalArgumentException 발생")
    void validateNegativeNumber() {
        // given
        String string = "-1,2:3";
        List<Character> delimiters = List.of(',', ':');
        PreprocessedInput preprocessedInput = new PreprocessedInput(string, delimiters);
        Parser parser = new Parser(preprocessedInput);

        // when
        // then
        assertThrows(IllegalArgumentException.class, parser::parse);
    }
}

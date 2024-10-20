package calculator.parser;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputParserTest {
    private InputParser parser;

    @BeforeEach
    void setUp() {
        parser = new InputParser();
    }

    @Test
    void 널_입력_테스트() {
        String nullInput = null;

        assertSimpleTest(() ->
                assertThatThrownBy(() -> parser.validateInput(nullInput))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 문자열_2개이상_테스트() {
        String invalidInput = "\"1,2,3\" \"4,5,6\"";

        assertSimpleTest(() ->
                assertThatThrownBy(() -> parser.validateInput(invalidInput))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 공백처리_테스트() {
        String hasSpacesInput = "  1,2,3   ";
        String expectedString = "1,2,3";

        assertEquals(expectedString, parser.processSpace(hasSpacesInput), "두 문자열이 같지 않습니다.");
    }

    @Test
    void 빈문자열_테스트() {
        String emptyInput = "";
        List<Integer> numbers = parser.parse(emptyInput);
        List<Integer> expectedNumbers = List.of(0);

        assertEquals(expectedNumbers, numbers, "두 리스트가 같지 않습니다.");
    }

    @Test
    void 구분자_처리_테스트() {
        String seperatedInput = "1,2:3,4:";
        List<Integer> numbers = parser.parse(seperatedInput);
        List<Integer> expectedNumbers = List.of(1, 2, 3, 4);

        assertEquals(expectedNumbers, numbers, "두 리스트가 같지 않습니다.");
    }
}

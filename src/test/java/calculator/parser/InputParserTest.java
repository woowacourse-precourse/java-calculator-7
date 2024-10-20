package calculator.parser;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
}

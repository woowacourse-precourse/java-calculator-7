package calculator.view;

import calculator.domain.Number;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class InputHandlerTest {
    private InputHandler inputHandler;

    @BeforeEach
    void setUp() {
        inputHandler = new InputHandler();
    }

    @ParameterizedTest
    @CsvSource(value = {"//;\\n1;2;3, 5", "1:2:3, 0"})
    void 커스텀_구분자가_있는지_확인(String input, int expected) {
        //given
        //setUp 메서드에서 제공

        //when
        int length = inputHandler.isCustomDelimiter(input);

        //then
        Assertions.assertThat(length).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"'1,2,3'", "1:2:3", "'1,2:3'"})
    void 숫자를_추출하기(String input) {
        //given
        List<String> result = new ArrayList<>();

        //when
        List<Number> numbers = inputHandler.parseNumbers(input);
        for (Number number : numbers) {
            result.add(number.getValue().toString());
        }

        //then
        Assertions.assertThat(result).isEqualTo(Arrays.asList("1", "2", "3"));
    }
}
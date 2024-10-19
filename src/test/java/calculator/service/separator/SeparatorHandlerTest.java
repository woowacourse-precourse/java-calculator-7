package calculator.service.separator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import calculator.domain.number.Number;
import calculator.domain.number.Numbers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class SeparatorHandlerTest {

    SeparatorHandler separatorHandler;

    @BeforeEach
    void init() {
        separatorHandler = new SeparatorHandler(new SeparatorService());
    }

    @ParameterizedTest
    @ValueSource(strings = {"//;\\n1;2;3", "1,2:3", "1.2,2.3:3.4", "//;\\n1.2;2.3;3.4"})
    void 정상작동(String input) {
        Numbers numbers = separatorHandler.process(input);

        assertThat(numbers.getNumbers().size()).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "//;\\n"})
    void 빈문자열(String input) {
        Numbers numbers = separatorHandler.process(input);
        Number number = numbers.getNumbers().getFirst();

        assertThat(numbers.getNumbers().size()).isEqualTo(1);
        assertThat(number.getValue()).isEqualTo(0);
    }

}
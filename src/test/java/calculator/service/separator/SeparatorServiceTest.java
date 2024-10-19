package calculator.service.separator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import calculator.domain.number.Number;
import calculator.domain.number.Numbers;
import calculator.domain.separator.BasicSeparator;
import calculator.domain.separator.CustomSeparator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class SeparatorServiceTest {

    SeparatorService service;

    @BeforeEach
    void init() {
        service = new SeparatorService();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2:3", "1,2,3", "1:2:3"})
    void 기본구분자_정상작동(String input) {
        Numbers numbers = service.separate(new BasicSeparator(), input);

        assertThat(numbers.getNumbers().size()).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(strings = "")
    void 커스텀구분자_정상작동(String input) {
        Numbers numbers = service.separate(new CustomSeparator(";"), input);
        Number number = numbers.getNumbers().getFirst();

        assertThat(numbers.getNumbers().size()).isEqualTo(1);
        assertThat(number.getValue()).isEqualTo(0);
    }
}
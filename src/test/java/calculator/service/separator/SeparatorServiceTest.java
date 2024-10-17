package calculator.service.separator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import calculator.domain.number.Numbers;
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
    @ValueSource(strings = "\\n;//1;2;3")
    void 커스텀구분자예외(String input) {
        assertThatThrownBy(() -> service.separate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2:3", "//;\\n1;2;3", "1,2,3", "1:2:3"})
    void 정상작동(String input) {
        Numbers numbers = service.separate(input);

        assertThat(numbers.getNumbers().size()).isEqualTo(3);
    }
}
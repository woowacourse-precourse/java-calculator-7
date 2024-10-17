package calculator.domain.separator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import calculator.domain.number.Number;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CustomSeparatorTest {

    CustomSeparator customSeparator;

    @BeforeEach
    void init() {
        customSeparator = new CustomSeparator(";");
    }

    @ParameterizedTest
    @ValueSource(strings = "//;\\n1;2;3")
    void 커스텀구분자(String value) {
        List<Number> numbers = customSeparator.separate(value);

        assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(strings = {"//;\\n;1;2", "//;\\n1;2;", "//;\\n;1;"})
    void 양사이드구분자예외(String value) {
        assertThatThrownBy(() -> customSeparator.separate(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"//;\\n1;;2", "//;\\n;;1", "//;\\n1;;"})
    void 연속커스텀구분자예외(String value) {
        assertThatThrownBy(() -> customSeparator.separate(value))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
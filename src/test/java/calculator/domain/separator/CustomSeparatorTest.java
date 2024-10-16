package calculator.domain.separator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
    @ValueSource(strings = "1;2;3")
    void 커스텀구분자(String value) {
        List<String> separate = customSeparator.separate(value);

        assertEquals(List.of("1", "2", "3"), separate);
    }

    @ParameterizedTest
    @ValueSource(strings = {";1;2", "1;2;", ";1;"})
    void 양사이드구분자예외(String value) {
        assertThatThrownBy(() -> customSeparator.separate(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1;;2", ";;1", "1;;"})
    void 연속커스텀구분자예외(String value) {
        assertThatThrownBy(() -> customSeparator.separate(value))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
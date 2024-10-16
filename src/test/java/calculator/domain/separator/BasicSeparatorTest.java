package calculator.domain.separator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BasicSeparatorTest {

    BasicSeparator basicSeparator;

    @BeforeEach
    void init() {
        basicSeparator = new BasicSeparator();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "1:2:3", "1,2:3"})
    void 문자열구분하기(String value) {

        List<String> separate = basicSeparator.separate(value);

        assertEquals(List.of("1", "2", "3"), separate);
    }

    @ParameterizedTest
    @ValueSource(strings = {",2,3", "1,2,", ",2,"})
    void 양사이드구분자오는예외(String value) {
        assertThatThrownBy(() -> basicSeparator.separate(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,,2", "3,,", ",,1"})
    void 연속구분자예외(String value) {
        assertThatThrownBy(() -> basicSeparator.separate(value))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

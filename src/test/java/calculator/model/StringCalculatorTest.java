package calculator.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {

    private StringCalculator stringCalculator;

    @BeforeEach
    public void setUp() {
        stringCalculator = new StringCalculator();
    }

    @Test
    @DisplayName("숫자 필터링 기능 테스트")
    public void filterNumberTest() {
        // given
        String input1 = "1,2:3";
        String input2 = "13:27:3";
        String input3 = "139,20:3576";

        // when
        List<Long> numbers1 = stringCalculator.filter(input1);
        List<Long> numbers2 = stringCalculator.filter(input2);
        List<Long> numbers3 = stringCalculator.filter(input3);

        // then
        assertThat(numbers1).containsExactly(1L, 2L, 3L);
        assertThat(numbers2).containsExactly(13L, 27L, 3L);
        assertThat(numbers3).containsExactly(139L, 20L, 3576L);
    }
}

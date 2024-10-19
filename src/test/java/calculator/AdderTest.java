package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class AdderTest {

    @ParameterizedTest
    @CsvSource({
            "1,2,3,6", "2,3,4,9", "3,4,5,12",
    })
    void 숫자열이_주어지는_경우_덧셈을_수행할_수_있다(int first, int second, int last, int expected) {
        // given

        List<Integer> numbers = List.of(1, 2, 3);
        Adder adder = new Adder();

        // when
        int result = adder.add(numbers);

        // then
        assertThat(result).isEqualTo(6);
    }

    @Test
    void 리스트에_0만_존재하는_경우_0을_반환한다() {
        // given
        List<Integer> numbers = List.of(0);
        Adder adder = new Adder();

        // when
        int result = adder.add(numbers);

        // then
        assertThat(result).isZero();
    }

}

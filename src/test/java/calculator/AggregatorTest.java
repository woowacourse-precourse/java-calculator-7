package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AggregatorTest {

    @Test
    public void 성공적으로_처리하는_경우() {
        // given
        List<Integer> input = List.of(0, 123, 634, 1264753, 645);

        // when
        int answer = Aggregator.add(input);
        int expected = 1266155;

        // then
        Assertions.assertThat(answer).isEqualTo(expected);
    }

    @Test
    public void 오버플로우가_발생하는_경우() {
        // given
        String[] input = new String[]{"146798364592386492183467", "24234234"};

        // when
        // then
        assertSimpleTest(() ->
                assertThatThrownBy(() -> Converter.convert(input))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

}

package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class ListCalculatorTest {

    private ListCalculator listCalculator = new ListCalculator();

    @Test
    @DisplayName("list를 입력으로 받으면 합을 계산한다")
    void 리스트를_합으로_변환한다() {
        List<Long> list = new ArrayList<>();
        list.add(1L);
        list.add(2L);
        list.add(3L);
        list.add(4L);
        Assertions.assertThat(listCalculator.calculate(list)).isEqualTo(10);
    }

    @Test
    @DisplayName("길이가 100000인 list를 입력으로 받으면 합을 계산한다")
    void 긴_리스트를_합으로_변환한다() {
        List<Long> list = new ArrayList<>();
        for(int i = 0; i < 100000; i++) {
            list.add(5L);
        }
        Assertions.assertThat(listCalculator.calculate(list)).isEqualTo(5 * 100000);
    }


    @Test
    @DisplayName("인자가 10억 이상인 list를 입력으로 받으면 합을 계산한다")
    void 큰인자의_리스트를_합으로_변환한다() {
        List<Long> list = new ArrayList<>();
        for(int i = 0; i < 100000; i++) {
            list.add((long) Integer.MAX_VALUE);
        }
        Assertions.assertThat(listCalculator.calculate(list)).isEqualTo(Integer.MAX_VALUE * 100000L);
    }
}
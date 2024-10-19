package calculator.util;

import calculator.InputString;
import calculator.splitor.BasicSplitor;
import calculator.splitor.Splitor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class IntegerConverterTest {
    @DisplayName("문자열 리스트를 숫자 리스트로 변환한다.")
    @Test
    void test1() {
        assertSimpleTest(() -> {
            // given
            List<String> stringList = List.of("1", "3", "4", "23");

            // when
            List<Integer> integerList = IntegerConverter.convertToIntegerList(stringList);

            // then
            assertThat(integerList).isEqualTo(List.of(1, 3, 4, 23));
        });
    }
}
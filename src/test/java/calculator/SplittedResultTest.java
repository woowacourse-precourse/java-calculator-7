package calculator;

import calculator.splitor.BasicSplitor;
import calculator.splitor.Splitor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SplittedResultTest {

    @DisplayName("문자열 리스트에 저장된 수의 합을 계산한다.")
    @Test
    void test1() {
        assertSimpleTest(() -> {
            // given
            SplittedResult splittedResult = new SplittedResult(List.of("3", "5", "10"));

            // when
            int sum = splittedResult.sum();

            // then
            assertThat(sum).isEqualTo(18);
        });
    }

}
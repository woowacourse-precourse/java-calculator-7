package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ApplicationTest extends NsTest {
    /**
     * split 관련 테스트
     */
    @Test
    void 기본구분자_처리() {
        StringCalculator sc = new StringCalculator();
        assertSimpleTest(() -> {
            String[] splitedNumbers = sc.splitTest("1");

            assertArrayEquals(splitedNumbers, new String[] {"1"});
        });
    }

//    @Test
//    void 커스텀_구분자_사용() {
//        assertSimpleTest(() -> {
//            run("//;\\n1");
//            assertThat(output()).contains("결과 : 1");
//        });
//    }
//
//    @Test
//    void 예외_테스트() {
//        assertSimpleTest(() ->
//            assertThatThrownBy(() -> runException("-1,2,3"))
//                .isInstanceOf(IllegalArgumentException.class)
//        );
//    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
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
    void 쉼표로_구분된_문자열_분리() {
        assertSimpleTest(() -> {
            run("1,2");
            assertThat(output()).contains("결과 : 3");
        });

        assertSimpleTest(() -> {
            run("1,2,3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 콜론으로_구분된_문자열_분리() {
        assertSimpleTest(() -> {
            run("1:2");
            assertThat(output()).contains("결과 : 3");
        });

        assertSimpleTest(() -> {
            run("1:2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 쉼표와콜론이_함께_있는_문자열_분리() {
        assertSimpleTest(() -> {
            run("1,2:3");
            assertThat(output()).contains("결과 : 6");
        });

        assertSimpleTest(() -> {
            run("1:2,3");
            assertThat(output()).contains("결과 : 6");
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


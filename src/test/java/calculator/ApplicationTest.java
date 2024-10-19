
package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 커스텀_구분자_사용_2() {
        assertSimpleTest(() -> {
            run("2;//;\\n37:3,7");
            assertThat(output()).contains("결과 : 49");
        });
    }

    @Test
    void 입력_x() {
        assertSimpleTest(() -> {
            run("\n");
            assertThat(output()).contains("결과 : 0");
        });
    }
    @Test
    void 입력_실수구분_성공1() {
        assertSimpleTest(() -> {
            run("38.2:27.3:30.4");
            assertThat(output()).contains("결과 : 95.9");
        });
    }

    @Test
    void 입력_실수구분_성공2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("38..2:27.3:30.4"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

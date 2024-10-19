package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    // 구분자 관련 테스트 케이스
    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }
    @Test
    void 구분자_전체사용() {
        assertSimpleTest(() -> {
            run("//;\\n1;2:3,4;5");
            assertThat(output()).contains("결과 : 15");
        });
    }

    // 예외 테스트 케이스
    @Test
    void 양수외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }    @Test
    void 양수외_테스트2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("0,1,2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    void 양수외_테스트3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("Hello,java,backend"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 공백_테스트() {
        assertSimpleTest(() -> {
            run();
            assertThat(output()).contains("결과 : 0");
        });
    }



    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

public class ApplicationCustomTest extends NsTest {

    @Test
    void 커스텀_구분자_여러개_사용() {
        assertSimpleTest(() -> {
            run("//;\\n//?\\n1;2?3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 예외_구분자_사용() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("////\\n1//2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 숫자_구분자_사용() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//123\\n41235"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 맨_앞_구분자() {
        assertSimpleTest(() -> {
            run(",1,2,3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 맨_뒤_구분자() {
        assertSimpleTest(() -> {
            run("1,2,3,");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 공백_커스텀_구분자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//\\n12"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 연속_구분자() {
        assertSimpleTest(() -> {
            run("//,,\\n1,,2,,3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

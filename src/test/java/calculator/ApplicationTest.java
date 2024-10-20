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
            run("//;\\n1;2;3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자_다수_사용() {
        assertSimpleTest(() -> {
            run("//;;\\n1;;2;;3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 숫자만_사용() {
        assertSimpleTest(() -> {
            run("123");
            assertThat(output()).contains("결과 : 123");
        });
    }

    @Test
    void 일반_구분자_사용() {
        assertSimpleTest(() -> {
            run("12,4:3");
            assertThat(output()).contains("결과 : 19");
        });
    }

    /*
    @Test
    void 입력_없음_테스트() {
        assertSimpleTest(() -> {
            run(" ");
            assertThat(output()).contains("결과 : 0");
        });
    }
    */

    @Test
    void 예외_테스트_음수() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_다른_문자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2&3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_다른_문자_커스텀() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\\n-1,2&3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

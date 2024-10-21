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
    void 구분자_없는_입력_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("123"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 소수점_입력_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1.5,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 너무_큰_숫자_입력_예외() {
        String largeNumber = String.valueOf(Long.MAX_VALUE);
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(largeNumber + ",1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 유효하지_않은_숫자_형식_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,a,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 합계_초과_예외() {
        String maxInt = String.valueOf(Integer.MAX_VALUE);
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(maxInt + "," + maxInt))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

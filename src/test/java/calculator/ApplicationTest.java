package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {
    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 커스텀_구분자_형식만_있는_문자열() {
        assertSimpleTest(() -> {
            run("//\\n");
            assertThat(output().contains("결과 : 0"));
        });
    }

    @Test
    void only_delimeter_input() {
        assertSimpleTest(() -> {
            run(",,,,");
            assertThat(output().contains("결과 : 0"));
        });
    }

    @Test
    void using_whiteSpace_custom_delimeter() {
        assertSimpleTest(() -> {
            run("// \\n 1 2 3");
            assertThat(output().contains("결과 : 6"));
        });
    }

    @Test
    void zero_before_digit() {
        assertSimpleTest(() -> {
            run("123:001");
            assertThat(output().contains("결과 : 124"));
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
    void Exception_Test_more_than_one_custom_delimeter() {

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//!@#\\n1,2"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void Exception_Test_digit_custom_delimeter() {

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//0\\n1,2"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

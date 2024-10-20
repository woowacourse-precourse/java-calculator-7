package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

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

    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");

            run("//;\\n1,2:3");
            assertThat(output()).contains("결과 : 6");

            run("//;\\n1;2");
            assertThat(output()).contains("결과 : 3");
        });
    }

    /**
     * 예외처리 관련 테스트
     */
    @Test
    void 예외_빈_문자열() {
        StringCalculator sc = new StringCalculator();
        assertThatThrownBy(() -> sc.add(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 예외_잘못된_문자열() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,,2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1;2;"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_구분자_지정형식오류() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//\n1;2;3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//1;2;3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_잘못된_구분자_사용() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\n1*2:3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_공백_사용() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1 2;3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_음수_사용() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}


package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {

    @Nested
    class DelimiterTest {
        @Test
        void 성공_기본구분자() {
            assertSimpleTest(() -> {
                run("1,2:3");
                assertThat(output()).contains("결과 : 6");
            });
        }

        @Test
        void 성공_커스텀구분자() {
            assertSimpleTest(() -> {
                run("//;\\n1");
                assertThat(output()).contains("결과 : 1");
            });
        }

        @Test
        void 성공_커스텀구분자_여러개의구분자() {
            assertSimpleTest(() -> {
                run("//;\\n//!\\n1;2!3");
                assertThat(output()).contains("결과 : 6");
            });
        }

        @Test
        void 성공_커스텀구분자_여러글자로이루어진구분자() {
            assertSimpleTest(() -> {
                run("//!5!\\n1!5!2");
                assertThat(output()).contains("결과 : 3");
            });
        }

        @Test
        void 실패_커스텀구분자_숫자로만이루어진구분자() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("//5\\n15253"))
                            .isExactlyInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        void 실패_커스텀구분자_기본구분자가포함된구분자() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("//,!\\n1,!22,!23"))
                            .isExactlyInstanceOf(IllegalArgumentException.class)
            );
        }
    }

    @Nested
    class NumberTest {
        @Test
        void 실패_음수() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("-1,2,3"))
                            .isExactlyInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        void 실패_소수() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("//(\\n1(2.2,23"))
                            .isExactlyInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        void 실패_범위를넘어가는수() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException((long) Math.pow(2, 32) + ",2,3"))
                            .isExactlyInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        void 실패_숫자로변환되지않은문자() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("a,2,3"))
                            .isExactlyInstanceOf(IllegalArgumentException.class)
            );
        }
    }

    @Nested
    class LogicTest {
        @Test
        void 실패_결과값오버플로우() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException((int) (Math.pow(2, 31) - 1) + ",2,3"))
                            .isExactlyInstanceOf(IllegalStateException.class)
            );
        }
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

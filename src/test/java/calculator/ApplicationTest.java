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
    void 일반_구분자_사용_ZERO() {
        assertSimpleTest(() -> {
            run("0,0:0:0,0,0:0:0");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 일반_구분자_사용_INT() {
        assertSimpleTest(() -> {
            run("1,2,3,4:5:6:7,8,9:10");
            assertThat(output()).contains("결과 : 55");
        });
    }

    @Test
    void 일반_구분자_사용_INT_MAX() {
        // int -2,147,483,648 ~ 2,147,483,647
        assertSimpleTest(() -> {
            run("2147483646,1");
            assertThat(output()).contains("결과 : 2147483647");
        });
    }

    @Test
    void 일반_구분자_사용_INT_MAX_OVER() {
        // int -2,147,483,648 ~ 2,147,483,647
        assertSimpleTest(() -> {
            run("2147483647,1");
            assertThat(output()).contains("결과 : 2147483648");
        });
    }

    @Test
    void 일반_구분자_사용_LONG_MAX() {
        // 9,223,372,036,854,775,842
        // -9,223,372,036,854,775,808 ~ 9,223,372,036,854,775,807
        assertSimpleTest(() -> {
            run("10:9223372036854775797");
            assertThat(output()).contains("결과 : 9223372036854775807");
        });
    }

    @Test
    void 일반_구분자_사용_BIGINTEGER() {
        assertSimpleTest(() -> {
            run("9223372036854775797,9223372036854775797,9223372036854775797,922337203685477579792939");
            assertThat(output()).contains("결과 : 922364873801588144120330");
        });

        assertSimpleTest(() -> {
            run("9223372036854775797,9000000000000");
            assertThat(output()).contains("결과 : 9223381036854775797");
        });
    }

    @Test
    void 예외_테스트_음수포함() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_다른문자입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("+1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,\"2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,2,#3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

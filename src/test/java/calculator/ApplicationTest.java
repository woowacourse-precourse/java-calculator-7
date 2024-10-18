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
    void 형식에서_벗어남_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("/a\n12"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자만_추가() {
        assertSimpleTest(() -> {
            run("//;\\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 숫자_구분자외_시작_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("k1,23"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 기본_구분자만_사용() {
        assertSimpleTest(() -> {
            run("1,2,3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 구분자_한글자_초과_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//ak\n1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 여러_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1;2:3,4");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    void 숫자가_큰_경우() {
        assertSimpleTest(() -> {
            run("9223372036854775808");
            assertThat(output()).contains("결과 : 9223372036854775808");
        });
    }

    @Test
    void 숫자_커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//2\n123");
            assertThat(output()).contains("결과 : 4");
        });
    }

    @Test
    void 여러_커스텀_구분자() {
        assertSimpleTest(() -> {
            run("//2\n//4\n12345");
            assertThat(output()).contains("결과 : 9");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

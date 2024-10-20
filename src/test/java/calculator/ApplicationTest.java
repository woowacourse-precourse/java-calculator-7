package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    @DisplayName("올바른 입력에 커스텀 구분자 사용")
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }
    @Test
    @DisplayName("올바른 입력에 기본 구분자 사용")
    void 기본_구분자_사용() {
        assertSimpleTest(() -> {
            run("1:20,307");
            assertThat(output()).contains("결과 : 328");
        });
    }

    @Test
    @DisplayName("빈 문자열에 기본 구분자 사용")
    void 기본_구분자_사용_빈_문자열() {
        assertSimpleTest(() -> {
            run("");
            assertThat(output()).contains("결과 : 0");
        });
    }
    @Test
    @DisplayName("빈 문자열에 커스텀 구분자 사용")
    void 커스텀_구분자_사용_빈_문자열() {
        assertSimpleTest(() -> {
            run("//$\\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    @DisplayName("정수값 범위를 넘어서 커스텀 구분자 사용")
    void 커스텀_구분자_사용_큰_정수값() {
        assertSimpleTest(() -> {
            run("//;\\n2100000000;210000000");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    @DisplayName("정수값 범위를 넘어서 기본 구분자 사용")
    void 기본_구분자_사용_큰_정수값() {
        assertSimpleTest(() -> {
            run("2100000000:210000000");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 예외_테스트() {
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

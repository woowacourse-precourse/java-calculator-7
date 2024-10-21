package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    @Test
    void 구분자_미사용_숫자만() {
        assertSimpleTest(() -> {
            run("3");
            assertThat(output()).contains("결과 : 3");
        });
    }

    @Test
    void 구분자_미사용_문자포함() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("3("))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구분자를 지정해 주세요")
        );
    }

    @Test
    void 기본_구분자_사용() {
        assertSimpleTest(() -> {
            run("1,2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 기본_구분자_사용_단일_구분자() {
        assertSimpleTest(() -> {
            run("1,2,3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 기본_구분자_사용_문자포함() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("1,2,3o"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("정확한 숫자들을 입력해 주세요")
        );
    }

    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 커스텀_구분자_사용_여러_양수의_합() {
        assertSimpleTest(() -> {
            run("//;\\n1;5;7");
            assertThat(output()).contains("결과 : 13");
        });
    }

    @Test
    void 커스텀_구분자_위치오류() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("1//;\\n1;7"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("커스텀 구분자는 제일 앞에 설정해 주세요")
        );
    }

    @Test
    void 빈_문자열_사용() {
        assertSimpleTest(() -> {
            run("\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("양수로 구성된 숫자를 입력해 주세요.")
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

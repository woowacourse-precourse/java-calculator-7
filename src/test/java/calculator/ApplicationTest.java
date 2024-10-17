package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

/**
 * packageName    : calculator
 * fileName       : ApplicationTest
 * author         : ehgur062300
 * date           : 2024-10-18
 * description    : 테스트 코드 작성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-10-18      ehgur062300         ver 1.0
 */

class ApplicationTest extends NsTest {

    @Test
    void 빈_값_입력() {
        assertSimpleTest(() -> {
            run("");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 기본_구분자_사용() {
        assertSimpleTest(() -> {
            run("1,2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자_사용1() {
        assertSimpleTest(() -> {
            run("//;,:\n1;,:2".replace("\n","\\n"));
            assertThat(output()).contains("결과 : 3");
        });
    }

    @Test
    void 커스텀_구분자_사용2() {
        assertSimpleTest(() -> {
            run("//-\n-1-2-3".replace("\n","\\n"));
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 구분자_하이픈_예외_테스트() {
        assertSimpleTest(() -> {
            run("//-\n-1--2-3".replace("\n","\\n"));
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 구분자_외_다른_문자열_포함_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,2//3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 음수_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자_지정_형식_위치_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,2//3\n".replace("\n","\\n")))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
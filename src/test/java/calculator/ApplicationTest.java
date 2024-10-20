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

    // 성공 케이스 추가
    @Test
    void 입력값_공백시() {
        assertSimpleTest(() -> {
            run("\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 커스텀_구분자_공백_사용() {
        assertSimpleTest(() -> {
            run("// \\n1 2 3 4 5");
            assertThat(output()).contains("결과 : 15");
        });
    }

    @Test
    void 커스텀_구분자_역슬래쉬() {
        assertSimpleTest(() -> {
            run("//\\\\n1\\2\\3\\4\\5");
            assertThat(output()).contains("결과 : 15");
        });
    }

    @Test
    void 큰_양수_값_계산() {
        assertSimpleTest(() -> {
            run("9223372036854775807,9223372036854775807");
            assertThat(output()).contains("결과 : 18446744073709551614");
        });
    }

    // 예외 케이스 추가
    @Test
    void 커스텀_포맷_불일치_끝_문자_예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("//-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_포맷_불일치_시작_문자예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("\\n-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_포맷_불일치_문자_여러개_예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("//,,\\n-1,,2,,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

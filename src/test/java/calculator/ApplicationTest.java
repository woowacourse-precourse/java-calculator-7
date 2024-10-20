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
    void 예외_테스트_문자만_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("aaaaa"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("ERROR : 계산할 수 없는 입력입니다.")
        );
    }

    @Test
    void 예외_테스트_문자_구분자_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("a:a:a:a:a"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("ERROR : 계산할 수 없는 입력입니다.")
        );
    }

    @Test
    void 예외_테스트_숫자만_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("11111"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("ERROR : 구분자가 없는 문자입니다.")
        );
    }

    @Test
    void 공백입력_처리() {
        assertSimpleTest(() -> {
            run(" ");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 커스텀_구분자_사용_메타문자() {
        assertSimpleTest(() -> {
            run("//?\\n1?2?3");
            assertThat(output()).contains("결과 : 6");
        });
    }



    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

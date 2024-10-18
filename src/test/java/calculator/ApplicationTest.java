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
    void 커스텀_구분자_긴_배열() {
        assertSimpleTest(() -> {
            run("//;\\n1;3;56;6;78;3;1;");
            assertThat(output()).contains("결과 : 148");
        });
    }
    @Test
    void 커스텀_구분자_복잡한_형태() {
        assertSimpleTest(() -> {
            run("//*@#$%@#$&%@#$%\\n4*@#$%@#$&%@#$%4*@#$%@#$&%@#$%5");
            assertThat(output().contains("결과 : 13"));
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
    void 예외_테스트_잘못된_구분자_입력_형식() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("//*@#$%@#$&%@#$%\\4*@#$%@#$&%@#$%4*@#$%@#$&%@#$%5"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

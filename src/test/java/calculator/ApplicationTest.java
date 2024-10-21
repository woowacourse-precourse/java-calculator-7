package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    @Test
    public void 잘못된_입력_테스트() {
        // 잘못된 입력 'a,2,3'에 대해 NumberFormatException을 기대
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("a,2,3"))
                    .isInstanceOf(IllegalArgumentException.class);
        });

        // 잘못된 입력 '1,,2'에 대해 NumberFormatException을 기대
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("1,,2"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    public void null_또는_빈문자() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException(""))
                    .isInstanceOf(IllegalArgumentException.class);
        });

        // 빈 문자열 입력 테스트
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException(null))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    public void 숫자하나() throws Exception {
        assertSimpleTest(() -> {
            run("1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    public void 쉼표구분자() throws Exception {
        assertSimpleTest(() -> {
            run("1,2,3,4");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\n1:2;3");
            assertThat(output()).contains("결과 : 6");
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

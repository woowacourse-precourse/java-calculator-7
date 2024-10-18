package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    @Test
    void 기본_구분자_사용() {
        assertSimpleTest(() -> {
            run("1,2,3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 기본_구분자_혼용_사용() {
        assertSimpleTest(() -> {
            run("1,2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1;2;3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 여러_글자_커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//=&=\\n1=&=2=&=3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 빈_문자열_입력() {
        assertSimpleTest(() -> {
            run("\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 음수_입력시_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,-2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("0과 음수는 입력할 수 없습니다.")
        );
    }

    @Test
    void 숫자_0_입력_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,0,3"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("0과 음수는 입력할 수 없습니다.")
        );
    }

    @Test
    void 문자_포함_입력_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,q,3"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("숫자 외의 값은 입력할 수 없습니다.")
        );
    }

    @Test
    void 초과된_범위_입력_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("99999999999999,2"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("입력된 숫자의 길이가 허용 범위를 초과하였습니다.")
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

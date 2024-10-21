package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

public class CustomTest extends NsTest {

    @Test
    void 커스텀_구분자_및_공백_처리() {
        assertSimpleTest(() -> {
            run("//; \\n1 ; 2 ; 3 ");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 연속된_구분자_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,,2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 숫자가_아닌_값_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,a,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void null_입력_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(null))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 빈_문자열_처리() {
        assertSimpleTest(() -> {
            run("");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

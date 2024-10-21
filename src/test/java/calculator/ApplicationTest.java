package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    @Test
    void 커스텀_구분자_없이_계산() {
        assertSimpleTest(() -> {
            run("1,2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }
    
    @Test
    void 커스텀_구분자_1개_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1;2");
            assertThat(output()).contains("결과 : 3");
        });
    }

    @Test
    void 커스텀_구분자_복수개_사용() {
        assertSimpleTest(() -> {
            run("//#$%\\n1#2$3%4");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    void 커스텀_구분자_입력을_종료하지_않는_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//*1,2:3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 구분자에_해당하지_않는_문자가_문자열에_포함() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1*2:3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 문자열에_숫자가_포함X() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("::"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 문자열에_포함된_숫자가_연산하기에_너무_큰_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,99999999999999999999"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

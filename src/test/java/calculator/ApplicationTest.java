package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {

    @Test
    void 기본구분자로_합을_구한다() {
        assertSimpleTest(() -> {
            run("1:2,3:4");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    void 두자리_이상의_숫자를_처리한다() {
        assertSimpleTest(() -> {
            run("1:10,123");
            assertThat(output()).contains("결과 : 134");
        });
    }

    @Test
    void 커스텀구분자_없이_기본구분자_외에_다른_문자가_있으면_예외가_발생한다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1:2^3:4"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 구분자로_시작하면_예외가_발생한다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(":2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 구분자로_끝나면_예외가_발생한다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1:2,"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 구분자가_두개_이상_연속되면_예외가_발생한다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1:2,:3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 음수가_처음에_입력되면_예외가_발생한다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1:2:3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 음수가_중간에_입력되면_예외가_발생한다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1:-2:3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀구분자를_사용한다() {
        assertSimpleTest(() -> {
            run("//;\\n1:2;3,4");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    void 커스텀구분자를_사용할때_두자리_이상의_숫자를_사용한다() {
        assertSimpleTest(() -> {
            run("//;\\n1:2;3,10");
            assertThat(output()).contains("결과 : 16");
        });
    }

    @Test
    void 여러개의_커스텀구분자를_사용한다() {
        assertSimpleTest(() -> {
            run("//;^\\n1:2;3,4^5");
            assertThat(output()).contains("결과 : 15");
        });
    }

    @Test
    void 여러개의_커스텀구분자를_사용할때_두자리_이상의_숫자를_사용한다() {
        assertSimpleTest(() -> {
            run("//;^\\n1:2;3,4^10");
            assertThat(output()).contains("결과 : 20");
        });
    }

    @Test
    void 커스텀구분자_문법에서_슬래쉬가_하나면_예외가_발생한다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("/;^\\n1:2;3,4^5"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀구분자_문법에서_슬래쉬가_없으면_예외가_발생한다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(";^\\n1:2;3,4^5"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀구분자_문법에서_역슬래쉬가_없으면_예외가_발생한다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;^n1:2;3,4^5"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀구분자_문법에서_n이_없으면_예외가_발생한다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;^\\1:2;3,4^5"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀구분자_문법에서_역슬래쉬와_n이_없으면_예외가_발생한다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;^1:2;3,4^5"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀구분자를_사용할때_음수로_시작하면_예외가_발생한다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\\n-1:2;3,4"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀구분자를_사용할때_음수가_중간에_있으면_예외가_발생한다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\\n1:2-;3,4"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

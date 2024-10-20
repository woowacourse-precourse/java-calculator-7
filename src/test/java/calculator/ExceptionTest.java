package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ExceptionTest extends NsTest {

    @Test
    @DisplayName("디폴트 구분자도, 커스텀 구분자도 아닌 문자열의 입력이 들어왔을 경우")
    void 디폴트_구분자도_커스텀_구분자도_아닌_문자열의_입력이_들어왔을_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1;2;3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("커스텀 문자를 지정하지 않은 다른 기호를 구분자로 사용했을떄")
    void 커스텀_문자를_지정하지_않은_다른_기호를_구분자로_사용했을떄() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\\n1;2\\3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("음수를 입력한 경우")
    void 음수를_입력한_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,-3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Test
    @DisplayName("숫자와 구분자 외의 공백이 있는 경우")
    void 숫자와_구분자_외의_공백이_있는_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1, 2, 3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("숫자가 없고 디폴트 구분자만 있는 경우")
    void 숫자가_없고_디폴트_구분자만_있는_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(":::"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("숫자가 없고 커스텀 구분자만 있는 경우")
    void 숫자가_없고_커스텀_구분자만_있는_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//[\\n"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("랜덤한 문자열인 경우")
    void 랜덤한_문자열인_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("hi hello"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("커스텀 구분자를 지정하려고 했으나 실제 구분자가 없는 경우")
    void 커스텀_구분자를_지정하려고_했으나_실제_구분자가_없는_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//\\n1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("커스텀 구분자의 - 를 썼을때와 음수가 섞여있는 경우")
    void 커스텀_구분자의_데쉬를_썼을때와_음수가_섞여있는_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//-\\n1--2-3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("정수형이 아닌 자료형을 입력한 경우")
    void 정수형이_아닌_자료형을_입력한_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1.5,2,3.7"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

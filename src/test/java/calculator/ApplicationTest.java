package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.Test;

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
    void 커스텀_구분자_형식_중간에_사이에_1개가_아니면_예외가_발생한다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;{\\n1;2,3:4"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("잘못된 구분자 형식입니다.")
        );
    }

    @Test
    void 숫자형식_변환중_잘못된_형식이면_예외가_발생한다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1q,2,3:4"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("잘못된 숫자 입니다.")
        );
    }

    @Test
    void 공백만_포함된_입력값이_들어오면_파싱부문에서_예외가_발생한다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("    "))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("잘못된 숫자 입니다.")
        );
    }

    @Test
    void 빈_입력값이_들어오면_프리코스에서_주어진_라이브러리에서의_Scanner의_nextLine에서_예외가_발생한다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> run(""))
                        .isInstanceOf(NoSuchElementException.class));

    }

    @Test
    void 계행문자만_있는_입력값이_들어오면_파싱_부문에서_예외가_발생한다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("\n"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("잘못된 숫자 입니다.")
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

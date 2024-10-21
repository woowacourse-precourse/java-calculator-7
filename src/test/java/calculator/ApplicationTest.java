package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
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
    void 공백_커스텀_구분자가_주어졌을_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//\\n1;2;3"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("// \\n 사이 문자가 존재하지 않습니다. 커스텀 구분자를 넣어주세요."));
    }

    @Test
    void 커스텀_구분자로_문자열이_주어졌을_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//!!\\n1!!2!!3"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("// \\n 사이 구분자는 문자이어야 합니다. 문자열이 아닌 문자를 넣어주세요."));
    }

    @Test
    void 커스텀_구분자가_무엇인지_명시하지_않은_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//2;3;4"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("\\n을 사용하여 어떤 문자가 커스텀 구분자인지 구분해주세요."));
    }

    @Test
    void 기본구분자_숫자외에_다른문자가_왔을경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,2,3!4"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("기본 구분자, 숫자로만 이루어진 문자열을 작성해주세요."));
    }

    @Test
    void 커스텀구분자_숫자외에_다른문자가_왔을경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\\n1,2,3,4"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("커스텀 구분자, 숫자로만 이루어진 문자열을 작성해주세요."));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

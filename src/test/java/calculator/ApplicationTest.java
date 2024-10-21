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
    void 줄바꿈구분자가_없으면_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//\1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("\\n을 찾을 수 없습니다")
        );
    }

    @Test
    void 커스텀구분자가_없으면_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//\\n1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("커스텀문자가 없습니다.")
        );
    }

    @Test
    void 커스텀구분자길이가_문자열이면_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//aa\\n1aa2aa3"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("단일 문자만 입력할 수 있습니다.")
        );
    }

    @Test
    void 커스텀구분자가_숫자이면_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//1\\n11213"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("구분자에 숫자는 포함될 수 없습니다.")
        );
    }

    @Test
    void 오버플로우_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("2,1232132142142142222222221412,313213"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("정수 표현범위를 넘어섰습니다.")
        );
    }

    @Test
    void 합이_오버플로우로_음수가_될때_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,9223372036854775807"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("더하는 과정에서 정수 표현범위를 넘어섰습니다.")
        );
    }

    @Test
        //입력이 "1,2,"일떄  String[] numbers = input.split(",")하면 ["1", "2"]  // 마지막 빈 문자열이 무시됨
    void 마지막이_구분자로_끝날때_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\\n1;2,"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("구분자와 숫자 매치가 맞지 않습니다.")
        );
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

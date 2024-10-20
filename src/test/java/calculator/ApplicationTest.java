package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
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
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("구분자가 없을 경우 예외를 발생한다.")
    void meetsAllStringByNumber_Then_Exception() {
        // given
        String input = "123456789";
        // when & then
        assertThatThrownBy(() -> runException(input))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("구분자 뒤에 숫자가 없을 경우 예외를 발생한다.")
    void meetsAllStringByOperator_Then_Exception() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("1,2,3,"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("커스텀 구분자를 등록했음에도, 구분자 뒤에 숫자가 없을 경우 예외를 발생한다.")
    void meetsAllStringByCustomSeparator_Then_Exception() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("//;\\n1;2,3;"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("잘못된 구분자가 숫자앞에 올 경우 예외를 발생한다.")
    void meetsWrongSeparator_Then_Exception() {
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

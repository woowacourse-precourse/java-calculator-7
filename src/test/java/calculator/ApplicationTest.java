package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    @Test
    @DisplayName("빈 문자열 입력시 결과가 0으로 출력된다")
    void 빈_문자열_입력_테스트() {
        assertSimpleTest(() -> {
            run("");
            assertThat(output()).contains("결과: 0");
        });
    }

    @Test
    @DisplayName("공백 문자열 입력시 결과가 0으로 출력된다")
    void 공백_문자열_입력_테스트() {
        assertSimpleTest(() -> {
            run("    ");
            assertThat(output()).contains("결과: 0");
        });
    }

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

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

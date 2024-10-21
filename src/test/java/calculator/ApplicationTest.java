package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
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
    void 공백_입력() {
        assertSimpleTest(() -> {
            // 공백 입력을 처리할 수 있도록 run 메서드를 실행
            run(" "); // 공백 입력
            // 출력 결과를 확인하는 방법
            assertThat(output()).contains("결과 : 0"); // 결과 출력에서 0이 포함되는지 확인
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

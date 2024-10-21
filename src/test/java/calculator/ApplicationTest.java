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
    void 공백_입력_테스트() {
        // Given
        String input = "\"\""; // 입력값으로 공백 문자열

        // When
        assertSimpleTest(() -> {
            run(input); // run 메서드에 공백 문자열을 전달
            // Then
            assertThat(output()).contains("결과 : 0"); // 출력 결과가 "결과 : 0"인지 확인
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;

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
    void 빈_문자열_처리() {
        assertSimpleTest(() -> {
            run("");  // NsTest의 run 메서드 사용
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 큰_숫자_계산() {
        assertSimpleTest(() -> {
            run("1000,2000,3000");
            assertThat(output()).contains("결과 : 6000");
        });
    }

    @Test
    void 기본_구분자_사용() {
        assertSimpleTest(() -> {
            String input = "1,2:3";
            System.setIn(new ByteArrayInputStream(input.getBytes()));

            runMain();
            assertThat(output()).contains("결과 : 6"); // 1 + 2 + 3 = 6
        });
    }

    @Test
    void 공백_포함_입력() {
        assertSimpleTest(() -> {
            String input = "1, 2 : 3";
            System.setIn(new ByteArrayInputStream(input.getBytes()));

            runMain();
            assertThat(output()).contains("결과 : 6"); // 공백을 무시하고 1 + 2 + 3 = 6
        });
    }

    @Test
    void 잘못된_형식_입력_예외() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> {
                String input = "1,A,3";
                System.setIn(new ByteArrayInputStream(input.getBytes()));

                runMain();
            }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자로 변환할 수 없는 값이 포함되어 있습니다")
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}

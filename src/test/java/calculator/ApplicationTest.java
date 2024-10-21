package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void 구분자_사이가_비어있을_경우() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> Application.calculateProcess("1,,2"))
                .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("잘못된 값을 입력하였습니다.")
        );
    }

    @Test
    void 생성하지_않은_커스텀_구분자를_사용한_경우() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> Application.calculateProcess("//;\\n1;2~3"))
                .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("잘못된 값을 입력하였습니다.")
        );
    }

    @Test
    void 커스텀_구분자가_숫자인_경우() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> Application.calculateProcess("//1\\n11213"))
                .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("숫자로 커스텀 구분자를 만들 수 없습니다.")
        );
    }

    @Test
    void 커스텀_구분자와_기본_구분자_혼합_덧셈() {
        assertSimpleTest(() -> {
            run("//;\\n1;2,3:4");
            assertThat(output().contains("결과 : 10"));
        });
    }

    @Test
    void 기본_구분자_덧셈() {
        assertSimpleTest(() -> {
           run("1,2:3");
           assertThat(output().contains("결과 : 6"));
        });
    }

    @Test
    void 숫자만_입력했을_경우() {
        assertSimpleTest(() -> {
            run("123");
            assertThat(output().contains("결과 : 123"));
        });
    }

    @Test
    void 음수_입력() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> Application.calculateProcess("1,-2,3"))
                .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("잘못된 값을 입력하였습니다.")
        );
    }

    @Test
    void 빈_문자열_입력() {
        assertSimpleTest(() -> {
            // 아무것도 입력하지 않고 enter키를 누르면 빈 줄이 입력되기 때문에
            // 빈 줄을 입력으로 전달합니다.
            run("\n");
            assertThat(output()).contains("결과 : 0");
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

package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    // 단위 테스트 ----
    Application app = new Application();

    @Test
    public void 기본_구분자_파싱() {
        String input = "1,2:3";
        String[] result = app.splitInput(input);
        assertThat(result[0]).contains("[,:]");
        assertThat(result[1]).contains("1,2:3");
    }

    @Test
    public void 커스텀_구분자_파싱() {
        String[] result = app.splitInput("//;\\n1;2;3");
        assertThat(result[0]).contains("[,:;]");
        assertThat(result[1]).contains("1;2;3");
    }


    @Test
    public void 합계_계산() {
        Integer result = app.getSum(new String[]{"[,:;]", "1;2;3"});
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void 합계_계산_음수포함() {
        String[] splitInput = new String[]{"[,;]", "1;-2;3"};
        assertThatThrownBy(() -> app.getSum(splitInput))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 문자_숫자_변환() {
        assertThat(app.convertToNum("1")).isEqualTo(1);
    }

    @Test
    public void 문자_숫자_변환_0입력() {
        assertThatThrownBy(() -> app.convertToNum("0"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 문자_숫자_변환_음수입력() {
        assertThatThrownBy(() -> app.convertToNum("-1"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 문자_숫자_변환_문자입력() {
        assertThatThrownBy(() -> app.convertToNum("a"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    // 통합 테스트 ----
    @Test
    void 기본_구분자_사용() {
        assertSimpleTest(() -> {
            run("1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 기본_구분자_사용2() {
        assertSimpleTest(() -> {
            run("1,2:3");
            assertThat(output()).contains("결과 : 6");
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
    void 커스텀_구분자_사용2() {
        assertSimpleTest(() -> {
            run("//;\\n1;2;3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 혼합_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1,2:3;4");
            assertThat(output()).contains("결과 : 10");
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
    void 예외_테스트_문자포함() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("a,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

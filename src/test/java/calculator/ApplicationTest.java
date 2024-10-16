package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import calculator.app.StringChecker;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {
    static StringChecker stringChecker = new StringChecker();

    @Test
    void 커스텀_구분자_식별함수_단위테스트() {
        assertSimpleTest(() -> {
            assertThat(stringChecker.checkCustomSeparator("//;\\n1").contains(";"));
        });
    }

    @Test
    void 커스텀_구분자_식별함수_단위테스트_공백() {
        assertSimpleTest(() -> {
            StringChecker stringChecker = new StringChecker();
            assertThat(stringChecker.checkCustomSeparator("// \\n1").contains(" "));
        });
    }

    @Test
    void 커스텀_구분자_식별함수_단위테스트_숫자() {
        assertSimpleTest(() -> {
            assertThat(stringChecker.checkCustomSeparator("//5\\n1").contains("5"));
        });
    }

    @Test
    void 커스텀_구분자_식별함수_단위테스트_기본() {
        assertSimpleTest(() -> {
            assertThat(stringChecker.checkCustomSeparator("//n1") == List.of(':', ','));
        });
    }

    @Test
    void 커스텀_구분자_식별함수_단위테스트_추가() {
        assertSimpleTest(() -> {
            assertThat(stringChecker.checkCustomSeparator("//n\\n") == List.of(':', ',', 'n'));
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

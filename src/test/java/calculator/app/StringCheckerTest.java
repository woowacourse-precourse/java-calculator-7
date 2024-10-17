package calculator.app;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import calculator.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Test;

class StringCheckerTest extends NsTest {
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

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
    void 유효성_검증_함수_유효한경우() {
        assertSimpleTest(() -> {
            assertThat(stringChecker.checkExpressionValidation("1,2,3", List.of(':', ',', 'n')));
        });
    }

    @Test
    void 유효성_검증_함수_유효하지않음() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> stringChecker.checkExpressionValidation("1,2.3", List.of(':', ',', 'n'))
        );
        assertThat(exception).isInstanceOf(IllegalArgumentException.class);
    }

}
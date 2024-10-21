package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ApplicationTest extends NsTest {

    @Test
    void 단일_숫자_입력() {
        assertSimpleTest(() -> {
            run("5");
            assertThat(output()).contains("결과 : 5");
        });
    }

    @Test
    void 여러_자리_숫자() {
        assertSimpleTest(() -> {
            run("34");
            assertThat(output()).contains("결과 : 34");
        });
    }

    @Test
    void 기본과_커스텀_구분자_혼합() {
        assertSimpleTest(() -> {
            run("//;\\n2,3:4;5");
            assertThat(output()).contains("결과 : 14");
        });
    }

    @Test
    void 구분자가_양끝에_있는_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(",2,3,"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

    }

    @Test
    void 빈_입력() {
        assertSimpleTest(() -> {
            run("\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//#\\n5#6");
            assertThat(output()).contains("결과 : 11");
        });
    }

    @Test
    void 기본_구분자_사용() {
        assertSimpleTest(() -> {
            run("2,3:4");
            assertThat(output()).contains("결과 : 9");
        });
    }

    @Test
    void 큰_숫자() {
        assertSimpleTest(() -> {
            run("9999999999,1");
            assertThat(output()).contains("결과 : 10000000000");
        });
    }


    @Test
    void 숫자를_커스텀_구분자로() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//2\n323"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 점을_커스텀_구분자로() {
        assertSimpleTest(() -> {
            run("//.\\n4.5,3");
            assertThat(output()).contains("결과 : 12");
        });
    }

    @Test
    void 연속된_구분자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("3::4"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 앞에_0이_있는_숫자() {
        assertSimpleTest(() -> {
            run("07");
            assertThat(output()).contains("결과 : 7");
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"`", "~", "*", "!", "@", "#", "$", "%", "^", "&", "_", "=", "+", "?", "/", "\\", ":", "-", ",", "(", "[", "{", "|", "~"})
    void 커스텀_구분자_테스트(String delimiter) {
        assertSimpleTest(() -> {
            String input = String.format("//%s\\n1%s2%s3", delimiter, delimiter, delimiter);
            run(input);
            assertThat(output()).contains("결과 : 6");
        });
    }
    
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

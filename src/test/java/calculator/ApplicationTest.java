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
    @DisplayName("커스텀, 기본 구분자 혼합 사용시 정상 반환")
    void success_mix() {
        assertSimpleTest(() -> {
            run("//;\\n1;1,1:1");
            assertThat(output()).contains("결과 : 4");
        });
    }

    @Test
    @DisplayName("커스텀, 기본 구분자 혼합 사용시 예외 - 숫자로 치환할 수 없음")
    void fail_mix2() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("//;\\na;1,1:1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName(" \"\"입력 시 0반환 ")
    void success_blank() {
        assertSimpleTest(() -> {
            run("\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    @DisplayName(" \"\"입력 시 0반환 ")
    void success_manyBlank() {
        assertSimpleTest(() -> {
            run("        ");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    @DisplayName("커스텀(' '), 기본 구분자 혼합 사용시 정상 반환")
    void success_spaceDelimiter() {
        assertSimpleTest(() -> {
            run("// \\n1 1 1:1");
            assertThat(output()).contains("결과 : 4");
        });
    }

    @Test
    @DisplayName("양쪽에 공백이 있는 커스텀(' '), 기본 구분자 혼합 사용시 정상 반환")
    void success_spaceDelimiterAndSideBlank() {
        assertSimpleTest(() -> {
            run("    // \\n1 1 1:1  ");
            assertThat(output()).contains("결과 : 4");
        });
    }

    @Test
    @DisplayName("소숫점자리 정상 출력")
    void success_print_decimal() {
        assertSimpleTest(() -> {
            run("1,1,1.1");
            assertThat(output()).contains("결과 : 3.1");
        });
    }

    @Test
    @DisplayName("소숫점자리 정상 출력")
    void success_print() {
        assertSimpleTest(() -> {
            run("1.5,1.3,1.2");
            assertThat(output()).contains("결과 : 4");
        });
    }

    @Test
    @DisplayName("empty 커스텀 구분자 사용시 예외처리")
    void fail_emptyCustomDelimiter() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("//\\n1,1:1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

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
        assertSimpleTest(
                () -> assertThatThrownBy(() -> runException("-1,2,3")).isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 다수_입력_테스트() {
        assertSimpleTest(() -> {
            run("1:2:3:4");
            assertThat(output().contains("결과 : 10"));
        });
    }

    @Test
    void 큰수_입력_테스트() {
        assertSimpleTest(() -> {
            run("123456789876543212345678987654321,123456789876543212345678987654321,123456789876543212345678987654321");
            assertThat(output().contains("결과 : 370370369629629637037036962962963"));
        });
    }

    @Test
    void 커스텀_구분자_다수() {
        assertSimpleTest(() -> {
            run("//+\\n1+2+3+4");
            assertThat(output().contains("결과 : 10"));
        });
    }

    @Test
    void 구분자_앞_공백() {
        assertSimpleTest(
                () -> assertThatThrownBy(() -> runException(",2,3")).isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("양수,구분자,양수의 입력 형식을 지켜주세요. 현재 구분자로 시작하고 있습니다."));
    }

    @Test
    void 구분자_뒤_공백() {
        assertSimpleTest(
                () -> assertThatThrownBy(() -> runException("1,2,3,")).isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("양수,구분자,양수의 입력 형식을 지켜주세요. 현재 구분자로 끝나고 있습니다."));
    }

    @Test
    void 커스텀_구분자_앞_공백() {
        assertSimpleTest(
                () -> assertThatThrownBy(() -> runException("//?\\n?2?3")).isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("양수,구분자,양수의 입력 형식을 지켜주세요. 현재 구분자로 시작하고 있습니다."));
    }

    @Test
    void 커스텀_구분자_뒤_공백() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException("//?\\n1?2?3?")).isInstanceOf(
                IllegalArgumentException.class).hasMessage("양수,구분자,양수의 입력 형식을 지켜주세요. 현재 구분자로 끝나고 있습니다."));
    }

    @Test
    void 커스텀_구분자_혼합_테스트() {
        assertSimpleTest(() -> {
            run("//+\\n1+2,3:4");
            assertThat(output().contains("결과 : 10"));
        });
    }

    @Test
    void 커스텀_구분자_형식() {
        assertSimpleTest(
                () -> assertThatThrownBy(() -> runException("//?2?3")).isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("커스텀 구분자 형식(//커스텀구분자\\n)을 준수해주세요."));
    }

    @Test
    void 커스텀_구분자_숫자_테스트() {
        assertSimpleTest(
                () -> assertThatThrownBy(() -> runException("//1\\n213")).isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 빈_문자열_입력_테스트() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException("\n")).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력이 이루어지지 않았습니다."));
    }

    @Test
    void 공백_입력_테스트() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException(" ")).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력이 이루어지지 않았습니다."));
    }

    @Test
    void 구분자_단일_입력() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException(",")).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("양수,구분자,양수의 입력 형식을 지켜주세요. 현재 구분자로 끝나고 있습니다."));
    }

    @Test
    void 커스텀_구분자_단일_입력() {
        assertSimpleTest(
                () -> assertThatThrownBy(() -> runException("//~\\n~")).isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("양수,구분자,양수의 입력 형식을 지켜주세요. 현재 구분자로 끝나고 있습니다."));
    }

    @Test
    void 숫자_단일_입력() {
        assertSimpleTest(() -> {
            run("123");
            assertThat(output().contains("결과 : 123"));
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

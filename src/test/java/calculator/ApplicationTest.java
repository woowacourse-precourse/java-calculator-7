package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    //입력 테스트

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
    void 기본_구분자_사용() {
        assertSimpleTest(() -> {
            run("1,2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 빈_문자열_입력() {
        assertSimpleTest(() -> {
            run("");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 공백_만_있는_입력() {
        assertSimpleTest(() -> {
            run("   ");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 쉼표_로만_구분된_입력() {
        assertSimpleTest(() -> {
            run("1,2,");
            assertThat(output()).contains("결과 : 3");
        });
    }

    @Test
    void 콜론_로만_구분된_입력() {
        assertSimpleTest(() -> {
            run("1:2:");
            assertThat(output()).contains("결과 : 3");
        });
    }

    @Test
    void 공백이_포함된_입력() {
        assertSimpleTest(() -> {
            run(" 1 , 2 : 3 ");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 숫자가_없는_입력() {
        assertSimpleTest(() -> {
            run(",,,::");
            assertThat(output()).contains("결과 : 0");
        });
    }


    @Test
    void 매우_긴_입력() {
        assertSimpleTest(() -> {
            run("1,2:3,4:5,6:7,8:9,10");
            assertThat(output()).contains("결과 : 55");
        });
    }

    @Test
    void 커스텀_구분자와_기본_구분자_혼용() {
        assertSimpleTest(() -> {
            run("//;\\n1;2,3:4");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    void 커스텀_구분자에_여러_특수문자_포함() {
        assertSimpleTest(() -> {
            run("//;*#\\n1;*#2;*#3;*#4");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    void 구분자가_전혀_없는_입력() {
        assertSimpleTest(() -> {
            run("123");
            assertThat(output()).contains("결과 : 123");
        });
    }


    //예외 테스트

    @Test
    void 기본_구분자가_연속으로_있는_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,,2::3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Test
    void 커스텀_구분자_형식_오류() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;1;2;3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자_비정상입력_오류() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\n1;;2;3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 음수_입력_오류() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 숫자가_아닌_입력_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,2,a"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자에_여러_특수문자_포함_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;*#\\n1;#2;*#3;*#4"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

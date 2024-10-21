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
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 정상적인_입력_값() {
        assertSimpleTest(() -> {
            run("1,2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 빈_입력_후_정상적인_입력_테스트() {
        assertSimpleTest(() -> {
            run("", "1,2,3");
            assertThat(output()).contains("결과 : 0", "결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자가_가장_뒤에_선언되어_있으며_연산할_문자열에_커스텀_구분자_미사용_기본_구분자_사용() {
        assertSimpleTest(() -> {
            run("123,45//;\\n");
            assertThat(output()).contains("결과 : 168");
        });
    }

    @Test
    void 커스텀_구분자가_가장_뒤에_선언되어_있으며_연산할_문자열에_커스텀_구분자_미사용_기본_구분자_미사용() {
        assertSimpleTest(() -> {
            run("12345//;\\n");
            assertThat(output()).contains("결과 : 12345");
        });
    }

    @Test
    void 커스텀_구분자가_가장_뒤에_선언되어_있으며_연산할_문자열에_커스텀_구분자_사용_기본_구분자_사용() {
        assertSimpleTest(() -> {
            run("1,23;45//;\\n");
            assertThat(output()).contains("결과 : 69");
        });
    }

    @Test
    void 커스텀_구분자가_가장_뒤에_선언되어_있으며_연산할_문자열에_커스텀_구분자_사용_기본_구분자_미사용() {
        assertSimpleTest(() -> {
            run("1231;2;3//;\\n");
            assertThat(output()).contains("결과 : 1236");
        });
    }

    @Test
    void 커스텀_구분자가_가장_앞에_선언되어_있으며_연산할_문자열에_커스텀_구분자_미사용_기본_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1,2,3:4:5,6");
            assertThat(output()).contains("결과 : 21");
        });
    }

    @Test
    void 커스텀_구분자가_가장_앞에_선언되어_있으며_연산할_문자열에_커스텀_구분자_미사용_기본_구분자_미사용() {
        assertSimpleTest(() -> {
            run("//;\\n12345");
            assertThat(output()).contains("결과 : 12345");
        });
    }

    @Test
    void 커스텀_구분자가_가장_앞에_선언되어_있으며_연산할_문자열에_커스텀_구분자_사용_기본_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1;2;3,4:5");
            assertThat(output()).contains("결과 : 15");
        });
    }

    @Test
    void 커스텀_구분자가_가장_앞에_선언되어_있으며_연산할_문자열에_커스텀_구분자_사용_기본_구분자_미사용() {
        assertSimpleTest(() -> {
            run("//;\\n1;2;3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자가_중간에_선언되어_있으며_연산할_문자열에_커스텀_구분자_미사용_기본_구분자_사용() {
        assertSimpleTest(() -> {
            run("1,2//;\\n3:4,5,6:7:8");
            assertThat(output()).contains("결과 : 36");
        });
    }

    @Test
    void 커스텀_구분자가_중간에_선언되어_있으며_연산할_문자열에_커스텀_구분자_미사용_기본_구분자_미사용() {
        assertSimpleTest(() -> {
            run("123//;\\n456");
            assertThat(output()).contains("결과 : 579");
        });
    }

    @Test
    void 커스텀_구분자가_중간에_선언되어_있으며_연산할_문자열에_커스텀_구분자_사용_기본_구분자_사용() {
        assertSimpleTest(() -> {
            run("1,2//)\\n3)4:5)6,7:8");
            assertThat(output()).contains("결과 : 36");
        });
    }

    @Test
    void 커스텀_구분자가_중간에_선언되어_있으며_연산할_문자열에_커스텀_구분자_사용_기본_구분자_미사용() {
        assertSimpleTest(() -> {
            run("1//)\\n2)3)4");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

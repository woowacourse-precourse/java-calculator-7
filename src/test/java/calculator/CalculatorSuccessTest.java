package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class CalculatorSuccessTest extends NsTest {

    @Test
    void 빈_문자열() {
        assertSimpleTest(() -> {
            run("\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 단일_숫자() {
        assertSimpleTest(() -> {
            run("1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 앞자리가_0인_숫자() {
        assertSimpleTest(() -> {
            run("01");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 두자리_이상의_숫자() {
        assertSimpleTest(() -> {
            run("12");
            assertThat(output()).contains("결과 : 12");
        });
    }

    @Test
    void 크기가_큰_숫자() {
        assertSimpleTest(() -> {
            run("10000000000,1");
            assertThat(output()).contains("결과 : 10000000001");
        });
    }

    @Test
    void 기본_구분자만_사용() {
        assertSimpleTest(() -> {
            run("1,2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자만_사용() {
        assertSimpleTest(() -> {
            run("//?\\n13?4");
            assertThat(output()).contains("결과 : 17");
        });
    }

    @Test
    void 기본_구분자와_커스텀_구분자를_같이_사용() {
        assertSimpleTest(() -> {
            run("//?\\n1,2:3?4");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    void 숫자를_커스텀_구분자로_사용() {
        assertSimpleTest(() -> {
            run("//1\\n213");
            assertThat(output()).contains("결과 : 5");
        });
    }

    @Test
    void 추출된_숫자에_소수_포함() {
        assertSimpleTest(() -> {
            run("1,3.5");
            assertThat(output()).contains("결과 : 4.5");
        });
    }

    @Test
    void 점을_커스텀_구분자로_사용() {
        assertSimpleTest(() -> {
            run("//.\\n3.5,2");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    void 구분자가_2개_연속으로_등장() {
        assertSimpleTest(() -> {
            run("2,::3");
            assertThat(output()).contains("결과 : 5");
        });
    }

    @Test
    void 구분자_위치가_맨_앞이나_맨_뒤인_경우() {
        assertSimpleTest(() -> {
            run(",1,2,");
            assertThat(output()).contains("결과 : 3");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

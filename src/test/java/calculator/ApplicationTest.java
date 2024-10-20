package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {
    @BeforeEach
    void setUp() {
        
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

    // 정상 처리
    @Test
    void 아무것도_입력하지않음() {
        assertSimpleTest(() -> {
            run("");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 숫자_1개_입력_1자리수() {
        assertSimpleTest(() -> {
            run("1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 숫자_1개_입력_2자리수_이상() {
        assertSimpleTest(() -> {
            run("111");
            assertThat(output()).contains("결과 : 111");
        });
    }

    @Test
    void 숫자_1개_입력_int_범위_초과() {
        assertSimpleTest(() -> {
            run("2147483648");
            assertThat(output()).contains("결과 : 2147483648");
        });
    }

    @Test
    void 숫자_1개_입력_long_최대() {
        assertSimpleTest(() -> {
            run("9223372036854775807");
            assertThat(output()).contains("결과 : 9223372036854775807");
        });
    }

    @Test
    void 기본구분자가_한_종류만_있는_1() {
        assertSimpleTest(() -> {
            run("1,2,3,4,5,6,7,8,9,10");
            assertThat(output()).contains("결과 : 55");
        });
    }

    @Test
    void 기본구분자가_한_종류만_있는_2() {
        assertSimpleTest(() -> {
            run("1:2:3:4:5:6:7:8:9:10");
            assertThat(output()).contains("결과 : 55");
        });
    }

    @Test
    void 기본구분자가_모두_있는_() {
        assertSimpleTest(() -> {
            run("1,2:3:4,5,6:7,8:9,10");
            assertThat(output()).contains("결과 : 55");
        });
    }

    @Test
    void 커스텀구분자_특수문자_1() {
        assertSimpleTest(() -> {
            run("//@\\n1,2@3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀구분자_특수문자_2() {
        assertSimpleTest(() -> {
            run("//@\\n1@2@100");
            assertThat(output()).contains("결과 : 103");
        });
    }

    @Test
    void 커스텀구분자_특수문자_3() {
        assertSimpleTest(() -> {
            run("//$\\n1,2:3:4,5$6:7,8:9$10");
            assertThat(output()).contains("결과 : 55");
        });
    }

    @Test
    void 커스텀구분자_특수문자_4() {
        assertSimpleTest(() -> {
            run("//%\\n1%2%3%4");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    void 커스텀구분자_특수문자_5() {
        assertSimpleTest(() -> {
            run("//\\\\n1\\2\\3\\4");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    void 커스텀구분자_한글_또는_영어_1() {
        assertSimpleTest(() -> {
            run("//\\\\n1\\2\\3\\4");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    void 커스텀구분자_한글_또는_영어_2() {
        assertSimpleTest(() -> {
            run("//B\\n1B2B100");
            assertThat(output()).contains("결과 : 103");
        });
    }

    @Test
    void 커스텀구분자_한글_또는_영어_3() {
        assertSimpleTest(() -> {
            run("//x\\n1,2:3:4,5x6:7,8:9x10");
            assertThat(output()).contains("결과 : 55");
        });
    }

    @Test
    void 커스텀구분자_한글_또는_영어_4() {
        assertSimpleTest(() -> {
            run("//한\\n1한2한3한4");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

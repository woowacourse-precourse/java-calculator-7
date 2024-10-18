package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {
//    @Test
//    void 항상_통과() {
//        assertSimpleTest(() -> {
//            assertThat(true).isTrue();
//        });
//    }

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

    // 주어진 케이스
    @Test
    void 빈문자열() {
        assertSimpleTest(() -> {
            run("");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 기본_구분자_쉼표_한번() {
        assertSimpleTest(() -> {
            run("1,2");
            assertThat(output()).contains("결과 : 3");
        });
    }

    @Test
    void 기본_구분자_쉼표_두번() {
        assertSimpleTest(() -> {
            run("1,2,3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 기본_구분자_쉼표_한번_콜론_한번() {
        assertSimpleTest(() -> {
            run("1,2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자_한개_3번_사용() {
        assertSimpleTest(() -> {
            run("//;\n1;2;3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    // 에러 케이스
    @Test
    void 음수기호_맨앞() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("-1,2"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 음수기호_중간() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("1,-2"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    // 정상 케이스

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

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

    // 정상 케이스
    @Test
    void 빈문자열() {
        assertSimpleTest(() -> {
            run("\n"); // TODO 이렇게 안하면 java.util.NoSuchElementException: No line found 이렇게 되는데...
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 기본_구분자_한번() {
        String[] inputStrings = {"1,2", "1:2"};
        for (String inputString : inputStrings) {
            assertSimpleTest(() -> {
                run(inputString);
                assertThat(output()).contains("결과 : 3");
            });
        }
    }

    @Test
    void 기본_구분자_두번() {
        String[] inputStrings = {"1,2,3", "1:2:3", "1,2:3", "1:2,3"};
        for (String inputString : inputStrings) {
            assertSimpleTest(() -> {
                run(inputString);
                assertThat(output()).contains("결과 : 6");
            });

        }
    }

    @Test
    void 커스텀_구분자_한개_3번_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1;2;3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자_여러글자_1번_사용() {
        assertSimpleTest(() -> {
            run("//;@\\n1;@2");
            assertThat(output()).contains("결과 : 3");
        });
    }

    @Test
    void 커스텀_구분자_기본_구분자_모두_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1;2:3,4");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    void 구분자가_앞뒤에_있을_경우() {
        String[] inputStrings = {":1:2", "1:2:", ",1:2", "1:2,", ",1,2", "1,2,"};
        for (String inputString : inputStrings) {
            assertSimpleTest(() -> {
                run(inputStrings);
                assertThat(output()).contains("결과 : 3");
            });
        }
    }

    @Test
    void 커스텀_구분자가_특수문자1() {
        String[] inputStrings = {"//#\\n1#2", "//!\\n1!2", "//@\\n1@2", "//\\$\\n1$2", "//%\\n1%2", "//\\^\\n1^2",
                "//&\\n1&2", "//\\*\\n1*2", "//\\(\\n1(2", "//\\)\\n1)2", "//-\\n1-2", "//\\+\\n1+2", "//=\\n1=2",
                "//\\|\\n1|2"};
        for (String inputString : inputStrings) {
            assertSimpleTest(() -> {
                run(inputString);
                assertThat(output()).contains("결과 : 3");
            });

        }
    }

    // TODO
//    @Test
//    void 커스텀_구분자가_특수문자2() {
//        String[] inputStrings = {"//'\\n1'2", "//\"\\n1\"2", "//\t\\n1\t2", "//\\n\\n1\n2",
//                "//\0\\n1\02", "//\\\\n1\2"};
//        for (String inputString : inputStrings) {
//            assertSimpleTest(() -> {
//                run(inputString);
//                assertThat(output()).contains("결과 : 3");
//            });
//
//        }
//    }

    // 에러 케이스
    @Test
    void 음수기호_포함() {
        String[] inputStrings = {"-1,2", "1,-2", "-1:2", "1:-2"};
        for (String inputString : inputStrings) {
            assertSimpleTest(() -> {
                assertThatThrownBy(() -> runException(inputString))
                        .isInstanceOf(IllegalArgumentException.class);
            });
        }
    }

    @Test
    void 잘못된_커스텀구분자() {
        String[] inputStrings = {"/;\\n1;2", "//;\\1;2", "\\n;//1;2"};
        for (String inputString : inputStrings) {
            assertSimpleTest(() -> {
                assertThatThrownBy(() -> runException(inputString))
                        .isInstanceOf(IllegalArgumentException.class);
            });
        }
    }

    @Test
    void 커스텀_구분자_여러글자_일부_사용() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("//;@\\n1;2"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

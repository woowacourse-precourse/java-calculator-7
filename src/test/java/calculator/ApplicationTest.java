package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {

    @Nested
    class HappyTest {

        @Test
        void 콤마_구분자를_사용하면_성공한다() {
            assertSimpleTest(() -> {
                run("1,2,3");
                assertThat(output()).contains("결과 : 6");
            });
        }

        @Test
        void 콜론_구분자를_사용하면_성공한다() {
            assertSimpleTest(() -> {
                run("1:2:3");
                assertThat(output()).contains("결과 : 6");
            });
        }

        @Test
        void 콜론과_콤마를_혼용하면_성공한다() {
            assertSimpleTest(() -> {
                run("1,2:3");
                assertThat(output()).contains("결과 : 6");
            });
        }

        @Test
        void 각_양수의_길이가_길어도_성공한다() {
            assertSimpleTest(() -> {
                run("11,22:333");
                assertThat(output()).contains("결과 : 366");
            });
        }

        @Test
        void 구분자가_맨앞에_있어도_성공한다() {
            assertSimpleTest(() -> {
                run(",16");
                assertThat(output()).contains("결과 : 16");
            });
        }

        @Test
        void 구분자가_맨뒤에_있어도_성공한다() {
            assertSimpleTest(() -> {
                run("16,");
                assertThat(output()).contains("결과 : 16");
            });
        }

        @Test
        void 숫자와_구분자_모두_없어도_성공한다() {
            assertSimpleTest(() -> {
                run("\n");
                assertThat(output()).contains("결과 : 0");
            });
        }

        @Test
        void 커스텀_구분자는_성공한다() {
            assertSimpleTest(() -> {
                run("//;\\n1;2;3");
                assertThat(output()).contains("결과 : 6");
            });
        }

        @Test
        void 커스텀_구분자의_길이가_2_이상이어도_성공한다() {
            assertSimpleTest(() -> {
                run("//&=;\\n1&=;1&=;&=;&=;&=;2&=;3&=;4&=;1&=;2&=;3&=;4&=;1&=;2&=;3&=;1&=;2&=;3&=;4");
                assertThat(output()).contains("결과 : 37");
            });
        }

        @Test
        void 커스텀_구분자가_정규식_문자여도_성공한다() {
            assertSimpleTest(() -> {
                run("//^\\n1^2^3");
                assertThat(output()).contains("결과 : 6");
            });
        }
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

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

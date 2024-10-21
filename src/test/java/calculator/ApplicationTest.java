package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
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
    void 커스텀_구분자가_숫자인_경우_예외_발생() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//1\\n1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자의_길이가_1이_아닌_경우_예외_발생() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//abc\\n1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자가_공백이_아닌_경우_Input에_공백이_포함되면_예외_발생() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//a\\n1, 2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자가_공백이_아닌_경우_Input에_공백이_포함되면_예외_발생2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1 2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Test
    void 커스텀_구분자가_공백인_정상적인_경우() {
        assertSimpleTest(() -> {
            run("// \\n1 2 3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자가_마이너스_부호가_아닌_경우_Input에_음수가_포함되면_예외_발생() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//a\\-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자가_마이너스_부호인_정상적인_경우() {
        assertSimpleTest(() -> {
            run("//-\\n1-2-3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 입력_값이_없는_경우_0이_나와야_한다() {
        assertSimpleTest(() -> {
            run("\n");
            assertThat(output()).contains("결과 : 0");
        });
    }


    @Test
    void 구분자가_연속으로_나오면_예외가_발생해야_한다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자_양식이_맨_처음에_나오지_않으면_예외_발생() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,2,3//a\\n"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자가_점이_아닌_소수점이_포함된_Input은_예외_발생() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("1.1,2.2"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Nested
    class 정상적으로_입력된_경우_합_계산이_제대로_돼야_한다 {
        @Test
        void 정상적인_경우_1() {
            assertSimpleTest(() -> {
                run("//a\\n10a20a30");
                assertThat(output()).contains("결과 : 60");
            });
        }

        @Test
        void 정상적인_경우_2() {
            assertSimpleTest(() -> {
                run("1,2,3");
                assertThat(output()).contains("결과 : 6");
            });
        }

        @Test
        void 정상적인_경우_3() {
            assertSimpleTest(() -> {
                run("11,22:33");
                assertThat(output()).contains("결과 : 66");
            });
        }

    }

    @Nested
    class 구분자를_기준으로_양_옆으로_숫자가_없다면_예외가_발생해야_함 {
        @Test
        void 구분자를_기준으로_양_옆으로_숫자가_없다면_예외가_발생해야_한다1() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("1,2,3,"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        void 구분자를_기준으로_양_옆으로_숫자가_없다면_예외가_발생해야_한다2() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException(","))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        void 구분자를_기준으로_양_옆으로_숫자가_없다면_예외가_발생해야_한다3() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException(",2"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }
    }

    @Test
    void 구분자_형식만_존재하는_경우_0이_나와야_한다() {
        assertSimpleTest(() -> {
            run("//a\\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 커스텀구분자가_마이너스_부호가_아닌데_음수가_나오는_경우_예외_발생() {
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

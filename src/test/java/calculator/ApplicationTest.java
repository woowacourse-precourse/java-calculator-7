package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import calculator.error.ErrorMessage;
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

    @Nested
    class EdgeCase {

        @Test
        void 양수가_아니면_실패한다1() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("-1,2,3"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage(ErrorMessage.UNSUPPORTED_NUMBER_EXCLUDE_POSITIVE.getDescription())
            );
        }

        @Test
        void 양수가_아니면_실패한다2() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("1,2:-3"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage(ErrorMessage.UNSUPPORTED_NUMBER_EXCLUDE_POSITIVE.getDescription())
            );
        }

        @Test
        void 양수가_아니면_실패한다3() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("1,2:3,0"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage(ErrorMessage.UNSUPPORTED_NUMBER_EXCLUDE_POSITIVE.getDescription())
            );
        }

        @Test
        void 구분자가_없으면_실패한다1() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("//\\n1123412341231234"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage(ErrorMessage.CANNOT_EMPTY_DELIMITER.getDescription())
            );
        }

        @Test
        void 구분자가_없으면_실패한다2() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("s"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage(ErrorMessage.CANNOT_EMPTY_DELIMITER.getDescription())
            );
        }

        @Test
        void 문자열이_없으면_실패한다1() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException(","))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage(ErrorMessage.CANNOT_EMPTY_TEXT.getDescription())
            );
        }

        @Test
        void 문자열이_없으면_실패한다2() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException(",:"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage(ErrorMessage.CANNOT_EMPTY_TEXT.getDescription())
            );
        }

        @Test
        void 문자열이_없으면_실패한다3() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("//4\\n"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage(ErrorMessage.CANNOT_EMPTY_TEXT.getDescription())
            );
        }

        @Test
        void 커스텀_구분자가_숫자면_실패한다() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("//4\\n1123412341231234"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage(ErrorMessage.UNSUPPORTED_CUSTOM_DELIMITER_NUMBER.getDescription())
            );
        }

        @Test
        void 기본_구분자_외_다른_구분자가_들어가면_실패한다() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("1,2v3:4"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage(ErrorMessage.UNSUPPORTED_CHAR_EXCLUDE_DELIMITER.getDescription())
            );
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

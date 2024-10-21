package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
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

    @Nested
    @DisplayName("기본 구분자 테스트")
    class BasicDelimiterTest {
        @Test
        void 쉼표_구분자() {
            assertSimpleTest(() -> {
                run("1,2,3");
                assertThat(output()).contains("결과 : 6");
            });
        }

        @Test
        void 콜론_구분자() {
            assertSimpleTest(() -> {
                run("1:2:3");
                assertThat(output()).contains("결과 : 6");
            });
        }

        @Test
        void 혼합_구분자() {
            assertSimpleTest(() -> {
                run("1,2:3");
                assertThat(output()).contains("결과 : 6");
            });
        }

        @Test
        void 많은_수의_숫자_더하기() {
            assertSimpleTest(() -> {
                run("1,2,3,4,5,6,7,8,9,10");
                assertThat(output()).contains("결과 : 55");
            });
        }

        @Test
        void 매우_큰_숫자의_합() {
            assertSimpleTest(() -> {
                run("1000000,2000000,3000000");
                assertThat(output()).contains("결과 : 6000000");
            });
        }
    }

    @Nested
    @DisplayName("커스텀 구분자 테스트")
    class CustomDelimiterTest {
        @Test
        void 단일_문자_구분자() {
            assertSimpleTest(() -> {
                run("//;\\n1;2;3");
                assertThat(output()).contains("결과 : 6");
            });
        }

        @Test
        void 여러_문자_구분자() {
            assertSimpleTest(() -> {
                run("//***\\n1***2***3");
                assertThat(output()).contains("결과 : 6");
            });
        }

        @Test
        void 숫자_구분자() {
            assertSimpleTest(() -> {
                run("//1\\n21314");
                assertThat(output()).contains("결과 : 9");
            });
        }

        @Test
        void 공백_구분자() {
            assertSimpleTest(() -> {
                run("// \\n1 2 3");
                assertThat(output()).contains("결과 : 6");
            });
        }

        @Test
        void 여러개의_커스텀_구분자() {
            assertSimpleTest(() -> {
                run("//;\\n//@\\n1;2@3");
                assertThat(output()).contains("결과 : 6");
            });
        }

        @Test
        void 여러_줄의_커스텀_구분자() {
            assertSimpleTest(() -> {
                run("//;\\n//@\\n//#\\n1;2@3#4");
                assertThat(output()).contains("결과 : 10");
            });
        }

        @Test
        void 특수문자_커스텀_구분자() {
            assertSimpleTest(() -> {
                run("//!@#$%^&*\\n1!@#$%^&*2!@#$%^&*3");
                assertThat(output()).contains("결과 : 6");
            });
        }

        @Test
        void 여러_자리_숫자_구분자() {
            assertSimpleTest(() -> {
                run("//999\\n1999299993");
                assertThat(output()).contains("결과 : 96");
            });
        }
    }

    @Nested
    @DisplayName("특수 케이스 테스트")
    class SpecialCaseTest {
        @Test
        void 빈_문자열_입력() {
            assertSimpleTest(() -> {
                run("\n");  // 테스트 내부 구현상, 완전히 빈 문자열은 예외가 발생하므로 개행 진행
                assertThat(output()).contains("결과 : 0");
            });
        }

        @Test
        void 공백만_있는_입력() {
            assertSimpleTest(() -> {
                run("   ");
                assertThat(output()).contains("결과 : 0");
            });
        }

        @Test
        void 구분자만_있는_입력() {
            assertSimpleTest(() -> {
                run(",,:,,");
                assertThat(output()).contains("결과 : 0");
            });
        }

        @Test
        void 구분자_없이_연속된_숫자() {
            assertSimpleTest(() -> {
                run("123");
                assertThat(output()).contains("결과 : 123");
            });
        }

        @Test
        void 커스텀_구분자_선언_후_기본_구분자_사용() {
            assertSimpleTest(() -> {
                run("//;\\n1,2,3");
                assertThat(output()).contains("결과 : 6");
            });
        }

        @Test
        void 중복된_커스텀_구분자_선언() {
            assertSimpleTest(() -> {
                run("//;\\n//;\\n1;2;3");
                assertThat(output()).contains("결과 : 6");
            });
        }

        @Test
        void 커스텀_구분자에_숫자_포함() {
            assertSimpleTest(() -> {
                run("//1a\\n11a21a3");
                assertThat(output()).contains("결과 : 6");
            });
        }
    }

    @Nested
    @DisplayName("예외 케이스 테스트")
    class ExceptionTest {
        @Test
        void 음수_입력() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("-1,2,3"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        void 숫자가_아닌_입력() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("1,a,3"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        void 소수_입력() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("1,2.5,3"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        void long_범위_초과() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("9223372036854775808"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        void 커스텀_구분자_형식_오류() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("//\\n1,2,3"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        void 커스텀_구분자_위치_오류() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("1,2,3//;\\n4,5"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
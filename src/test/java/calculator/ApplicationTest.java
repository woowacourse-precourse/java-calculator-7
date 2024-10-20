package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import calculator.separator.CustomSeparator;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {
    @Test
    void 커스텀_구분자_성공() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 음수_입력시_오류_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void Suffix_커스텀_구분자_오류_예외() {
        assertSimpleTest(
                () -> assertThatThrownBy(() -> runException("//#1#2#3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void Prefix_커스텀_구분자_오류_예외() {
        assertSimpleTest(
                () -> assertThatThrownBy(() -> runException("/^\\n1^2^3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자_다른거_썼을때_예외() {
        assertSimpleTest(
                () -> assertThatThrownBy(() -> runException("//^\\n1?2^3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 기본_구분자_썼을때_성공() {
        assertSimpleTest(
                () -> {
                    run("1,2,3");
                    assertThat(output()).contains("결과 : 6");
                }
        );
    }

    @Test
    void 기본_구분자_개수_초과시_오류() {
        assertSimpleTest(
                () -> assertThatThrownBy(() -> runException("1,,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 구분자가_숫자일시_오류() {
        assertSimpleTest(

                () -> assertThatThrownBy(() -> runException("//1\n21314"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_정규표현식_테스트() {
        String regex = "//([^0-9])\\\\n(\\d+\\1)*\\d+"; //\\이스케이프처리..
        String test = "//?\\n1?2?3";
        assertThat(test.matches(regex)).isEqualTo(true);
    }

    @Test
    void 커스텀_표현식_추출_테스트() {
        CustomSeparator separator = new CustomSeparator();
        List<Long> nums = separator.separate("//?\\n1?2?3");
        assertThat(nums).isEqualTo(List.of(1L, 2L, 3L));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}

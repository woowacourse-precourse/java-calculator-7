package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {
//    @Test
//    void 커스텀_구분자_사용() {
//        assertSimpleTest(() -> {
//            run("//;\\n1");
//            assertThat(output()).contains("결과 : 1");
//        });
//    }
//
//    @Test
//    void 예외_테스트() {
//        assertSimpleTest(() ->
//                assertThatThrownBy(() -> runException("-1,2,3"))
//                        .isInstanceOf(IllegalArgumentException.class)
//        );
//    }

    @Test
    @DisplayName("입력값에 커스텀 구분자가 들어갔는지 확인")
    void testHasCustomSeparator() {
        String test1 = "//;\\n1;2;3";
        assertThat(test1.contains(Application.CUSTOM_SEPARATOR_PREFIX) && test1.contains(
                Application.CUSTOM_SEPARATOR_SUFFIX)).isTrue();

        String test2 = "//n1;2;3";
        assertThat(test2.contains(Application.CUSTOM_SEPARATOR_PREFIX) && test2.contains(
                Application.CUSTOM_SEPARATOR_SUFFIX)).isTrue();

        String test3 = "\\n1;2;3";
        assertThat(test3.contains(Application.CUSTOM_SEPARATOR_PREFIX) && test3.contains(
                Application.CUSTOM_SEPARATOR_SUFFIX)).isTrue();
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

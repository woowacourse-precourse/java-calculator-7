package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
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

    @Test
    void 커스텀_구분자를_사용하여_덧셈을_할수있다() {
        // given
        String input = "//t\n1t2t3t4";
        int idx = input.indexOf("\n");
        String split = input.substring(2, idx);
        String substring = input.substring(idx + 1);
        System.out.println(substring);
        String[] splitNumbers = substring.split(split);
        int result = 0;

        // when
        for(String number : splitNumbers) {
            result += Integer.parseInt(number);
        }

        // then
        assertThat(result).isEqualTo(10);
    }

    @Test
    void 커스텀_구분자는_여러_글자를_사용할_수_있다() {
        // given

        // when

        // then
    }
}

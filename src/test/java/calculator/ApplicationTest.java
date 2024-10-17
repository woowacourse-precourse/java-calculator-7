package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

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
    void 다수의_커스텀_구분자_추출() {
        // 비교군
        Application.StringCalculator testCalculator = new Application.StringCalculator();
        testCalculator.delimiterArr.add(";");
        testCalculator.delimiterArr.add("m45i");

        // given
        String testDelimiterText = "//;\\n1//m45i\\n";

        // when
        Application.StringCalculator stringCalculator = new Application.StringCalculator();
        ArrayList<String> result = stringCalculator.extractDelimiter(testDelimiterText);

        // then
            assertThat(result).isEqualTo(testCalculator.delimiterArr);
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

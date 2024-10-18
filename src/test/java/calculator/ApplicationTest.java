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

    /*
     * splitByDelimiter 메서드 테스트
     * - 기본 구분자와 커스텀 구분자를 사용하여 문자열을 올바르게 분리하는지 검증
     */
    @Test
    void 기본_구분자로_문자열_분리() {
        String input = "1,2:3";
        String Delimiter = "[,|:]";
        String[] result = Application.splitByDelimiter(input, Delimiter);
        String[] answer = {"1", "2", "3"};
        assertThat(result).isEqualTo(answer);
    }
    @Test
    void 커스텀_구분자로_문자열_분리() {
        String input = "1;2;3";
        String Delimiter = ";";
        String[] result = Application.splitByDelimiter(input, Delimiter);
        String[] answer = {"1", "2", "3"};
        assertThat(result).isEqualTo(answer);
    }

    /*
     * sumNumbers 메서드 테스트
     */
    @Test
    void 숫자_계산() {
        String[] numbers = {"1", "2", "3"};
        int result = Application.sumNumbers(numbers);
        int answer = 6;
        assertThat(result).isEqualTo(answer);
    }


    // 커스텀 구분자가 문자열일 경우 subString에서의 구분자들이 모두 커스텀 구분자 문자열을 포함해야하는 테스트

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

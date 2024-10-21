package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {

    @Test
    void 커스텀_구분자로_문자열_분리() {
        String input = "//;\\n1;2;3";

        String[] result = Application.parseInput(input);

        assertThat(result).isEqualTo(new String[]{"1", "2", "3"});
    }

    @Test
    void 기본_구분자로_문자열_분리() {
        String input = "1,2:3";

        String[] result = Application.parseInput(input);

        assertThat(result).isEqualTo(new String[]{"1", "2", "3"});
    }

    @Test
    void 잘못된_구분자_형식_예외처리() {
        String input = "//\\n123";

        assertThatThrownBy(() -> {
            Application.parseInput(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구분자가 비어 있습니다. 구분자를 입력하세요.");
    }

    @Test
    void 기본_구분자로_숫자_분리() {
        Application application = new Application();
        String input = "1,2:3";

        String[] parsedNumbers = application.parseInput(input);

        assertThat(parsedNumbers).isEqualTo(new String[]{"1", "2", "3"});
    }

    @Test
    void 커스텀_구분자로_숫자_분리() {
        Application application = new Application();
        String input = "//;\\n1;2;3";

        String[] parsedNumbers = application.parseInput(input);

        assertThat(parsedNumbers).isEqualTo(new String[]{"1", "2", "3"});
    }

    @Test
    void 빈_문자열은_0을_반환() {
        Application application = new Application();
        String input = "";

        String[] parsedNumbers = application.parseInput(input);
        int sum = application.sumParsedNumbers(parsedNumbers);

        assertThat(sum).isEqualTo(0);
    }

    @Test
    void 커스텀_구분자_추출() {
        Application application = new Application();
        String input = "//;\\n1;2;3";

        String delimiter = application.extractCustomDelimiter(input);

        assertThat(delimiter).isEqualTo(";");
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

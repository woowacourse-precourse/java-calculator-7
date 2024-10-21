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

        InputProcessor inputProcessor = new InputProcessor(input);
        String[] result = inputProcessor.processInput();

        assertThat(result).isEqualTo(new String[]{"1", "2", "3"});
    }

    @Test
    void 기본_구분자로_문자열_분리() {
        String input = "1,2:3";

        InputProcessor inputProcessor = new InputProcessor(input);
        String[] result = inputProcessor.processInput();

        assertThat(result).isEqualTo(new String[]{"1", "2", "3"});
    }

    @Test
    void 잘못된_구분자_형식_예외처리() {
        String input = "//\n123";

        InputProcessor inputProcessor = new InputProcessor(input);

        assertThatThrownBy(inputProcessor::processInput)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 입력 형식입니다. 커스텀 구분자는 //과 \\n을 포함해야 합니다.");
    }

    @Test
    void 기본_구분자로_숫자_분리() {
        String input = "1,2:3";

        InputProcessor inputProcessor = new InputProcessor(input);
        String[] parsedNumbers = inputProcessor.processInput();

        assertThat(parsedNumbers).isEqualTo(new String[]{"1", "2", "3"});
    }

    @Test
    void 커스텀_구분자로_숫자_분리() {
        String input = "//;\\n1;2;3";

        InputProcessor inputProcessor = new InputProcessor(input);
        String[] parsedNumbers = inputProcessor.processInput();

        assertThat(parsedNumbers).isEqualTo(new String[]{"1", "2", "3"});
    }

    @Test
    void 빈_문자열은_0을_반환() {
        String input = "";

        InputProcessor inputProcessor = new InputProcessor(input);
        String[] parsedNumbers = inputProcessor.processInput();

        Calculator calculator = new Calculator();
        int sum = calculator.sum(parsedNumbers);

        assertThat(sum).isEqualTo(0);
    }

    @Test
    void 커스텀_구분자_추출() {
        String input = "//;\\n1;2;3";

        InputProcessor inputProcessor = new InputProcessor(input);
        String customDelimiter = inputProcessor.extractCustomDelimiter();

        assertThat(customDelimiter).isEqualTo(";");
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

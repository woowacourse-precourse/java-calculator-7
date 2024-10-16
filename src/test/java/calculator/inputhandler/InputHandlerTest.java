package calculator.inputhandler;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class InputHandlerTest extends NsTest {

    @Test
    void getInput() {
        String userInput = "1,2";

        assertSimpleTest(() -> {
            run(userInput);
            InputHandler inputHandler = new InputHandler();

            String result = inputHandler.getInput("덧셈할 문자열을 입력해 주세요.\n");
            assertThat(result).isEqualTo(userInput);
        });
    }

    @Override
    protected void runMain() {

    }
}
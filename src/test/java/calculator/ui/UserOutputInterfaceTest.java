package calculator.ui;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class UserOutputInterfaceTest {

    @Test
    void 내용전달() {
        final String message = "19282923";
        final StringBuilder result = new StringBuilder();
        final OutputUi outputUi = message1 -> {
            result.append(message1);
        };
        final UserOutputInterface userOutputInterface = new UserOutputInterface(outputUi);

        userOutputInterface.printResult(new ResultMessage(message));

        Assertions.assertThat(result.toString().equals("결과 : " + message));
    }

    @Test
    void 입력안내() {
        final StringBuilder result = new StringBuilder();
        final OutputUi outputUi = message1 -> {
            result.append(message1);
        };
        final UserOutputInterface userOutputInterface = new UserOutputInterface(outputUi);

        userOutputInterface.printInputInformation();

        Assertions.assertThat(result.toString()).isEqualTo("덧셈할 문자열을 입력해 주세요.");
    }
}
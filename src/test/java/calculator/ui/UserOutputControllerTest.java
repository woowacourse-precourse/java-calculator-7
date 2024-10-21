package calculator.ui;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class UserOutputControllerTest {

    @Test
    void 내용전달() {
        final String message = "19282923";
        final StringBuilder result = new StringBuilder();
        final OutputUi outputUi = new OutputUi() {
            @Override
            public void printMessage(String message) {
            }

            @Override
            public void printResult(String message) {
                result.append(message);
            }
        };
        final UserOutputController userOutputController = new UserOutputController(outputUi);

        userOutputController.printResult(new ResultMessage(message));

        Assertions.assertThat(result.toString().equals("결과 : " + message));
    }

    @Test
    void 입력안내() {
        final StringBuilder result = new StringBuilder();
        final OutputUi outputUi = new OutputUi() {
            @Override
            public void printMessage(String message) {
                result.append(message);
            }

            @Override
            public void printResult(String message) {
            }
        };
        final UserOutputController userOutputController = new UserOutputController(outputUi);

        userOutputController.printInputInformation();

        Assertions.assertThat(result.toString()).isEqualTo("덧셈할 문자열을 입력해 주세요.");
    }
}
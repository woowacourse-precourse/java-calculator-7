package calculator;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import calculator.view.InputView;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class InputViewTest {

    @AfterEach
    void closeConsole() {
        Console.close();
    }

    @Test
    void 정상_입력_테스트() {
        assertSimpleTest(() -> {
            // 모의 입력값 설정
            System.setIn(createUserInput("1,2,3"));
            assertThat(InputView.getInput()).isEqualTo("1,2,3");
        });
    }

    @Test
    void 빈_문자열_입력_테스트() {
        assertSimpleTest(() -> {
            // 모의 입력값 설정
            System.setIn(createUserInput("\n"));
            assertThat(InputView.getInput()).isEqualTo("");
        });
    }

    InputStream createUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
}

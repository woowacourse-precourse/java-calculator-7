package calculator.view;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import calculator.Application;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;


public class InputViewTest extends NsTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @AfterEach
    void closeConsole() {
        Console.close();
    }

    @Test
    void 입력_값_검증() {
        String input = "1,2:3";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        InputView inputView = new InputView();
        String result = inputView.getInputString();
        assertSimpleTest(() -> {
            assertThat(result).isEqualTo(input);
        });
    }

    @Test
    void 이스케이프코드_검증() {
        String input = "//&\\n1,2:3";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        InputView inputView = new InputView();
        String result = inputView.getInputString();
        assertSimpleTest(() -> {
            assertThat(result).isEqualTo(input);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

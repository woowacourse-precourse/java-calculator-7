package calculator.view;

import static org.assertj.core.api.Assertions.assertThat;

import calculator.Application;
import calculator.domain.Delimiter;
import calculator.domain.Number;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class OutputViewTest extends NsTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private OutputView outputView;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
        outputView = new OutputView();
    }

    @Test
    void 구분자_예외_메시지_출력_검증() {
        String invalidInput = "/?\\n1,2";

        try {
            Delimiter delimiter = new Delimiter(invalidInput);
            delimiter.splitString();
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            assertThat(outputStreamCaptor.toString().trim())
                    .isEqualTo("잘못된 입력입니다: 올바른 형식의 커스텀 구분자가 아닙니다.");
        }
    }

    @Test
    void 숫자_예외_메시지_출력_검증() {
        String invalidInput[] = {"1", "-5", "3"};

        try {
            Number number = new Number(invalidInput);
            number.convertStringToInt();
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            assertThat(outputStreamCaptor.toString().trim())
                    .isEqualTo("잘못된 입력입니다: 양수만 입력 가능합니다.");
        }
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

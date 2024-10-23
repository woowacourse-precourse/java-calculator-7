package calculator.view;

import calculator.entity.CalculationResult;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

class OutputViewTest {

    private final PrintStream originalSystemOut = System.out;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        // 매 테스트 실행 전에 System.out을 가로채기 위한 OutputStream 설정
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void tearDown() {
        // 테스트 후 원래의 System.out으로 복구
        System.setOut(originalSystemOut);
    }

    @Test
    void displayResult_테스트() {
        OutputView outputView = new OutputView();
        CalculationResult result = new CalculationResult(6);

        outputView.displayResult(result);

        // 출력된 메시지 검증
        String output = outputStream.toString().trim();
        assertThat(output).isEqualTo("결과 : 6");
    }

    @Test
    void displayError_테스트() {
        OutputView outputView = new OutputView();
        String errorMessage = "[ERROR] 잘못된 입력 값";

        outputView.displayError(errorMessage);

        // 출력된 메시지 검증
        String output = outputStream.toString().trim();
        assertThat(output).isEqualTo("[ERROR] 잘못된 입력 값");
    }
}

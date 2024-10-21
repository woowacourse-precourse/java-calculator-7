package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import view.CalculatorView;

class CalculatorViewTest {

    private CalculatorView calculatorView;

    @BeforeEach
    public void setUp() {
        calculatorView = new CalculatorView();
    }

    @Test
    void 입력테스트_빈문자열() {
        // Mock: 사용자 입력으로 엔터만 입력
        String simulatedInput = "\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        // 입력 확인
        String actualInput = calculatorView.getInput();
        assertEquals("", actualInput);
    }

    @Test
    void 입력테스트_빈입력스트림예외() {
        // Mock : 빈 입력 스트림이 들어올때
        System.setIn(new ByteArrayInputStream(new byte[0]));

        // IllegalArgumentException이 던져지는지 확인
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, calculatorView::getInput);
        assertEquals("Wrong input.", exception.getMessage());
    }
}

package calculator.service;

import calculator.view.InputView;
import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class InputServiceTest {

    private InputService inputService;

    @BeforeEach
    void setUp() {
        inputService = new InputService(new InputView());
    }

    @AfterEach
    void tearDown() {
        Console.close();
    }

    private void provideInput(String data) {
        ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    @Test
    void 유효한_입력값_반환() {
        String input = "1,2:3";
        provideInput(input);

        String result = inputService.getValidInput();

        assertEquals(input, result);
    }

    @Test
    void 빈_문자열_입력시_예외_발생() {
        provideInput("");

        assertThrows(IllegalArgumentException.class, () -> inputService.getValidInput());
    }

    @Test
    void 유효한_커스텀_구분자_입력_처리() {
        String input = "//;\\n1;2;3";
        provideInput(input);

        String result = inputService.getValidInput();

        assertEquals(input, result);
    }

    @Test
    void 유효하지_않은_커스텀_구분자_예외_발생() {
        String input = "//\\n1,2,3";
        provideInput(input);

        assertThrows(IllegalArgumentException.class, () -> inputService.getValidInput());
    }

    @Test
    void 커스텀_구분자_뉴라인_누락시_예외_발생() {
        String input = "//;1;2;3";
        provideInput(input);

        assertThrows(IllegalArgumentException.class, () -> inputService.getValidInput());
    }
}
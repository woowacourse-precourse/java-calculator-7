package calculator.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

// 테스트 순서 지정
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ConsoleInputTest {

    private ConsoleInput consoleInput;

    @BeforeEach
    public void setUp() {
        consoleInput = new ConsoleInput();
    }

    @Test
    @Order(1)
    @DisplayName("input으로 주어진 값이 정확히 출력되는지 확인")
    void input() {
        // given
        String input = "1,2:3";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // when
        String result = consoleInput.input();

        // then
        assertEquals(input, result);
        assertNotNull(result);
    }

    @Test
    @Order(2)
    @DisplayName("입력값이 잘못되었을 때 IllegalArgumentException이 발생하는지 확인")
    void shouldReturnNullWhenNoInputIsProvided() {
        // given

        // when // then
        assertThrows(IllegalArgumentException.class, () -> {
            consoleInput.input();
        });
    }
}

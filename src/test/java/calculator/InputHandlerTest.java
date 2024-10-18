package calculator;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

class InputHandlerTest {

    @AfterEach
    protected void cleanUp() {
        Console.close();
    }


    @Test
    @DisplayName("입력값이 정상적으로 들어오게 되는지")
    void test() {
        String given = "1:2:3";
        String expected = "1:2:3";
        System.setIn(new ByteArrayInputStream(given.getBytes()));
        InputHandler inputHandler = new InputHandler();

        String result = inputHandler.getInput();

        assertEquals(expected, result);
    }

    @Test
    @DisplayName("입력값이 정상적이지 않을경우  IllegalArgumentException 을 발생시키는지.")
    void test1() {
        String given = "-1:2:3";

        System.setIn(new ByteArrayInputStream(given.getBytes()));
        InputHandler inputHandler = new InputHandler();

        assertThrows(IllegalArgumentException.class, inputHandler::getInput);
    }


}

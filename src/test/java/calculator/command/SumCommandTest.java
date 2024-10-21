package calculator.command;

import static org.junit.jupiter.api.Assertions.*;

import calculator.service.command.SumCommand;
import org.junit.jupiter.api.Test;

class SumCommandTest {
    private final SumCommand sumCommand = new SumCommand();

    @Test
    void 아주_큰_숫자_계산() {
        String[] numbers = {"9999999999", "1"};
        String result = sumCommand.execute(numbers);
        assertEquals("10000000000", result);
    }
}
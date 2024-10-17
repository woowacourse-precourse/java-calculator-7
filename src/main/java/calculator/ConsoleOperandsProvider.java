package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class ConsoleOperandsProvider implements OperandsProvider {

    @Override
    public List<Long> getOperands() {
        String userInput = getUserInput();
        BasicNumberConverter converter = new BasicNumberConverter(userInput);
        return converter.convert();
    }

    private String getUserInput() {
        String input = Console.readLine().trim();
        if (input.isEmpty()) {
            throw new IllegalArgumentException("입력값이 존재하지 않습니다.");
        }
        return input;
    }

}

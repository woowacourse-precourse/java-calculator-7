package calculator.provider;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class ConsoleOperandsProvider implements OperandsProvider {

    private final PositiveLongParser longParser;

    public ConsoleOperandsProvider() {
        this.longParser = new PositiveLongParser();
    }

    @Override
    public List<Long> getOperands() {
        String userInput = getUserInput();
        BasicStringTokenizer stringTokenizer = new BasicStringTokenizer(userInput);
        List<String> tokens = stringTokenizer.tokenize();
        return parseToLong(tokens);
    }

    private String getUserInput() {
        String input = Console.readLine().trim();
        if (input.isEmpty()) {
            throw new IllegalArgumentException("입력값이 존재하지 않습니다.");
        }
        return input;
    }

    private List<Long> parseToLong(List<String> strings) {
        List<Long> parsed = new ArrayList<>();
        for (String string : strings) {
            parsed.add(longParser.parse(string));
        }
        return parsed;
    }

}

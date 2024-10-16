package calculator.io.input;

import calculator.converter.EscapeNewLineConverter;
import camp.nextstep.edu.missionutils.Console;

public class ConsoleInputHandler implements InputHandler {

    private EscapeNewLineConverter escapeNewLineConverter = new EscapeNewLineConverter();

    @Override
    public String getUserInput() {
        String userInput = Console.readLine();
        return convertEscapeNewLine(userInput);
    }

    private String convertEscapeNewLine(String input) {
        return escapeNewLineConverter.convert(input);
    }

}

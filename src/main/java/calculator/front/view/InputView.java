package calculator.front.view;

import calculator.front.enums.ViewMessage;
import calculator.front.input.TotalDelimitedInput;
import calculator.front.parser.CustomDelimiterParser;
import calculator.front.input.CustomDelimiterParsedInput;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public TotalDelimitedInput read() {
        System.out.println(ViewMessage.INPUT_MESSAGE.getMessage());
        return getTotalDelimitedInput(Console.readLine());
    }

    public TotalDelimitedInput getTotalDelimitedInput(String rawInput) {
        CustomDelimiterParsedInput customDelimiterParsedInput = CustomDelimiterParser.parse(rawInput);
        return TotalDelimitedInput.fromCustomDelimiterParseInput(customDelimiterParsedInput);
    }
}
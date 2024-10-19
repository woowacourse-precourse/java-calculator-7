package calculator.businessLogic;

import calculator.domain.CalculatorParam;

import java.util.List;

import static calculator.message.Message.구분자인덱스;
import static calculator.message.Message.입력안내문;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Input {

    private final Validator validator;
    private final Split split;

    protected Input() {
        this.validator = Validator.of();
        this.split = Split.of();
    }

    public static Input of() {
        return new Input();
    }

    public String getInput() {
        System.out.println(입력안내문);

        return readLine();
    }

    public CalculatorParam getUserNumber(String userInput) {
        CalculatorParam domain = CalculatorParam.of();

        splitEnter(userInput, domain);
        findDelimiters(userInput, domain);
        findNumbers(domain);
        return domain;
    }

    private void splitEnter(String userInput, CalculatorParam domain) {
        List<String> splitEnter = split.splitInputOfEnter(userInput);
        domain.splitStringNumbers(splitEnter);
    }

    private void findDelimiters(String userInput, CalculatorParam domain) {
        if(validator.validDelimiters(userInput)) {
            validator.isNullDelimiters(domain.getStringNumbers());
            List<String> splitInput = domain.getStringNumbers();
            List<Character> delimiter = splitInput.get(구분자인덱스).chars().mapToObj(c -> (char) c).toList();
            domain.changeUserDelimiters(delimiter);
        }
    }

    private void findNumbers(CalculatorParam domain) {
        split.splitNumberOfDelimiter(domain);
        List<Integer> parseNumbers = validator.tryParseInteger(domain.getStringNumbers());
        domain.parseUserNumbers(parseNumbers);
    }
}

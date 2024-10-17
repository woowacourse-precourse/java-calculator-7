package calculator;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputParam {

    private final Validator validator;
    private final Split split;

    protected InputParam() {
        this.validator = Validator.of();
        this.split = Split.of();
    }

    public static InputParam of() {
        return new InputParam();
    }

    public String getInput() {
        System.out.println("다음과 같이 입력해주세요\n");
        System.out.println("//구분자 \\n 계산할 숫자들을 구분자로 구별해주세요.\n");

        return readLine();
    }

    public CalculatorParamDomain getUserNumber(String userInput) {
        CalculatorParamDomain domain = CalculatorParamDomain.of();

        splitEnter(userInput, domain);
        findDelimiters(userInput, domain);
        findNumbers(domain);
        return domain;
    }

    private void splitEnter(String userInput, CalculatorParamDomain domain) {
        List<String> splitEnter = split.splitInputOfEnter(userInput);
        domain.splitStringNumbers(splitEnter);
    }

    private void findDelimiters(String userInput, CalculatorParamDomain domain) {
        if(validator.validDelimiters(userInput)) {
            validator.isNullDelimiters(domain.getStringNumbers());
            List<String> splitInput = domain.getStringNumbers();
            List<Character> delimiter = splitInput.get(2).chars().mapToObj(c -> (char) c).toList();
            domain.changeUserDelimiters(delimiter);
        }
    }

    private void findNumbers(CalculatorParamDomain domain) {
        split.splitNumberOfDelimiter(domain);
        List<Integer> parseNumbers = validator.tryParseInteger(domain.getStringNumbers());
        domain.parseUserNumbers(parseNumbers);
    }
}

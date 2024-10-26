package calculator.domain.service;

import calculator.domain.dto.DelimiterParserResult;
import java.util.ArrayList;
import java.util.List;

public class OperandParser {

    public List<String> parsingOperands(DelimiterParserResult delimParserResult) {
        ArrayList<String> delimiters = delimParserResult.getDelimiters();
        String removedString = delimParserResult.getRemovedString();

        String delimiterRegex = String.join("|", delimiters);
        List<String> operands = List.of(removedString.split(delimiterRegex));

        if (operands.isEmpty()) {
            for (String delimiter : delimiters) {
                if (removedString.contains(delimiter)) {
                    throw new IllegalArgumentException("구분자가 존재하지 않습니다.");
                } else {
                    throw new IllegalArgumentException("피연산자가 존재하지 않습니다.");
                }
            }
        }
        return operands;
    }
}

package calculator.service;

import static calculator.common.constant.Constants.REGEX_OR;

import calculator.model.Operand;
import calculator.model.Separator;
import calculator.model.Separators;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class OperandExtractor {

    private static final int TRAILING_SEPARATOR_REMOVE_OPTION_OFF = -1;

    private final Separators separators;

    public OperandExtractor(Separators separators) {
        this.separators = separators;
    }

    public List<Operand> extractOperands(String message) {
        List<String> operandCandidates = List.of(message.split(makeSplitRegex(), TRAILING_SEPARATOR_REMOVE_OPTION_OFF));
        return operandCandidates.stream()
                .map(Operand::from)
                .toList();
    }

    private String makeSplitRegex() {
        return separators.separators().stream()
                .map(Separator::separator)
                .map(Pattern::quote)
                .collect(Collectors.joining(REGEX_OR));
    }
}

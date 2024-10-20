package calculator.lexicalParser;

import calculator.operator.OperatorContainer;
import calculator.utils.CustomDeque;
import calculator.expression.Expression;
import calculator.operator.Operand;
import calculator.operator.Separator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ExpressionParser {
    private static final String REGEX_PREFIX = "^\\d+((?:";
    private static final String REGEX_SUFFIX = ")\\d+)*$";
    private static final String REGEX_NATURAL_NUMBER = "\\d+";
    private static final String REGEX_OR = "|";
    private static final Operand DEFAULT_OPERAND_FOR_EMPTY = Operand.of(0);
    private final OperatorContainer operatorContainer;
    private final Pattern expressionPattern;
    private final Pattern separatorSymbolPattern;

    public ExpressionParser(OperatorContainer operatorContainer) {
        this.operatorContainer = operatorContainer;
        String allowOneOfSymbolRegex = generateAllowOneOfSymbolRegex(operatorContainer.getSymbols());
        this.separatorSymbolPattern = Pattern.compile(allowOneOfSymbolRegex);
        this.expressionPattern = Pattern.compile(REGEX_PREFIX + allowOneOfSymbolRegex + REGEX_SUFFIX);
    }

    private String generateAllowOneOfSymbolRegex(List<String> symbols) {
        return String.join(REGEX_OR, symbols);
    }

    public Expression parse(String expression) {
        if (!isValidateExpression(expression)) {
            throw new IllegalArgumentException("Invalid expression: " + expression);
        }
        if(expression.isEmpty()) {
            return generateDefaulExpression();
        }
        CustomDeque<Operand> operandQueue = parseOperand(expression);
        CustomDeque<Separator> separatorQueue = parseSeparator(expression);
        return new Expression(separatorQueue, operandQueue);
    }

    private Expression generateDefaulExpression() {
        CustomDeque<Operand> operandDeque = new CustomDeque<>(List.of(DEFAULT_OPERAND_FOR_EMPTY));
        CustomDeque<Separator> separatorDeque = new CustomDeque<>();
        return new Expression(separatorDeque, operandDeque);
    }

    private boolean isValidateExpression(String expression) {
        if (expression.matches(REGEX_NATURAL_NUMBER) || expression.isEmpty()) {
            return true;
        }
        Matcher matcher = expressionPattern.matcher(expression);
        return matcher.matches();
    }

    private CustomDeque<Operand> parseOperand(String expression) {
        if (expression.isEmpty()) {
            return new CustomDeque<>(List.of(DEFAULT_OPERAND_FOR_EMPTY));
        }
        return Arrays.stream(expression.split(generateAllowOneOfSymbolRegex(operatorContainer.getSymbols())))
                .map(Integer::parseInt)
                .map(Operand::of)
                .collect(Collectors.toCollection(CustomDeque::new));
    }

    private CustomDeque<Separator> parseSeparator(String expression) {
        if (expression.isEmpty()) {
            return new CustomDeque<>();
        }
        CustomDeque<Separator> separatorDeque = new CustomDeque<>();
        Matcher matcher = separatorSymbolPattern.matcher(expression);
        while (matcher.find()) {
            separatorDeque.add(Separator.of(matcher.group()));
        }
        return separatorDeque;
    }
}

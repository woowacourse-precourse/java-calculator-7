package calculator.lexicalParser;

import calculator.utils.CustomDeque;
import calculator.expression.Expression;
import calculator.operator.Operand;
import calculator.operator.Separator;
import calculator.operator.Separators;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ExpressionParser {
    private final ExpressionValidator validator;
    private final Separators separators;
    private final Pattern pattern;

    public ExpressionParser(ExpressionValidator validator, Separators separators) {
        this.validator = validator;
        this.separators = separators;
        this.pattern = Pattern.compile(separators.toRegexAllowOneOfSeparator());
    }

    public Expression parse(String expression) {
        if (!validator.isValidateExpression(expression)) {
            throw new IllegalArgumentException("Invalid expression: " + expression);
        }
        CustomDeque<Operand> operandQueue = parseOperand(expression);
        CustomDeque<Separator> separatorQueue = parseSeparator(expression);
        return new Expression(separatorQueue, operandQueue);
    }

    private CustomDeque<Operand> parseOperand(String expression) {
        if(expression.isEmpty()) {
            return new CustomDeque<>();
        }
        return Arrays.stream(expression.split(separators.toRegexAllowOneOfSeparator()))
                .map(Integer::parseInt)
                .map(Operand::of)
                .collect(Collectors.toCollection(CustomDeque::new));
    }

    private CustomDeque<Separator> parseSeparator(String expression) {
        if(expression.isEmpty()) {
            return new CustomDeque<>();
        }
        CustomDeque<Separator> separatorDeque = new CustomDeque<>();
        Matcher matcher = pattern.matcher(expression);
        while (matcher.find()) {
            separatorDeque.add(new Separator(matcher.group()));
        }
        return separatorDeque;
    }
}

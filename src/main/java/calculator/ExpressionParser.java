package calculator;

import java.util.*;
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
        this.pattern = Pattern.compile(separators.toRegex());
    }

    public Expression parse(String expression) {
        if (!validator.isValidateExpression(expression)) {
            throw new IllegalArgumentException("Invalid expression: " + expression);
        }
        Queue<Integer> operandQueue = parseOperand(expression);
        Queue<Separator> separatorQueue = parseSeparator(expression);
        return new Expression(separatorQueue, operandQueue);
    }

    private Queue<Integer> parseOperand(String expression) {
        return Arrays.stream(expression.split(separators.toRegex()))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedList::new));
    }

    private Queue<Separator> parseSeparator(String expression) {
        Queue<Separator> separatorQueue = new LinkedList<>();
        Matcher matcher = pattern.matcher(expression);
        while (matcher.find()) {
            separatorQueue.add(new Separator(matcher.group()));
        }
        return separatorQueue;
    }
}

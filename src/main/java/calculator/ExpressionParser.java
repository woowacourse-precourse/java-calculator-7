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
        this.pattern = Pattern.compile(separators.toRegexAllowOneOfSeparator());
    }

    public Expression parse(String expression) {
        if (!validator.isValidateExpression(expression)) {
            throw new IllegalArgumentException("Invalid expression: " + expression);
        }
        Deque<Integer> operandQueue = parseOperand(expression);
        Deque<Separator> separatorQueue = parseSeparator(expression);
        return new Expression(separatorQueue, operandQueue);
    }

    private Deque<Integer> parseOperand(String expression) {
        if(expression.isEmpty()) {
            return new ArrayDeque<>();
        }
        return Arrays.stream(expression.split(separators.toRegexAllowOneOfSeparator()))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedList::new));
    }

    private Deque<Separator> parseSeparator(String expression) {
        if(expression.isEmpty()) {
            return new ArrayDeque<>();
        }
        Deque<Separator> separatorDeque = new LinkedList<>();
        Matcher matcher = pattern.matcher(expression);
        while (matcher.find()) {
            separatorDeque.add(new Separator(matcher.group()));
        }
        return separatorDeque;
    }
}

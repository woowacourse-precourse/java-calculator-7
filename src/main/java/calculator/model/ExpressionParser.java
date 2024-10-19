package calculator.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ExpressionParser {
    private static final String REPLACE_STRING = " ";
    private static final String SPLIT_REGEX = "\\s+";

    private static final String DEFAULT_RESULT = "0";

    private final String expression;

    public ExpressionParser(String expression) {
        expression = removeStandardDelimiters(expression);
        this.expression = removeCustomDelimiters(expression) + DEFAULT_RESULT;
    }

    private String removeStandardDelimiters(String expression){
        for(StandardDelimiterType standardDelimiterType : StandardDelimiterType.values()){
            expression = expression.replace(standardDelimiterType.getDelimiter(), REPLACE_STRING);
        }

        return expression;
    }

    private String removeCustomDelimiters(String expression){
        CustomDelimiter customDelimiter = new CustomDelimiter(expression);

        if(customDelimiter.getDelimiter() != null){
            expression = expression.replace(customDelimiter.getAffixDelimiter(), "");
        }
        return expression.replace(customDelimiter.getDelimiter(), REPLACE_STRING);
    }

    private Integer parseInteger(String character){
        try {
            return Integer.parseInt(character);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> stringToIntegerList(){
        return Arrays.stream(expression.split(SPLIT_REGEX))
            .map(this::parseInteger)
            .collect(Collectors.toList());
    }
}

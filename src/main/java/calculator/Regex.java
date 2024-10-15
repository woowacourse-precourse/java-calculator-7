package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

    private static final String CUSTOM_DELIMITER_REGEX = "^//(.)\\\\n(.*)";
    private static final String[] BASIC_DELIMITER = {",", ":"};
    private String customDelimiter;
    private String expression;
    private List<Integer> numbers = new ArrayList<>();

    public void inputExpression() {

        String input = Console.readLine();
        Pattern pattern = Pattern.compile(CUSTOM_DELIMITER_REGEX);
        Matcher matcher = pattern.matcher(input);

        if(matcher.find()){
            customDelimiter = matcher.group(1);
            expression = matcher.group(2);
        } else {
            expression = input;
        }

        Console.close();
    }
}

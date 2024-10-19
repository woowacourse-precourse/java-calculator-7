package calculator.splitor;

import calculator.InputString;

import java.util.List;

public class CustomSplitor extends Splitor {
    private final String custom_seperator;

    public CustomSplitor(InputString inputString, char seperator) {
        super(inputString);
        this.custom_seperator = String.valueOf(seperator);
    }

    @Override
    public List<String> split() {
        InputString substring = inputString.substring(5);

        String regex = String.format("[%s%s%s]", SEPERATOR_COLON, SEPERATOR_COMMA, custom_seperator);
        return List.of(substring.split(regex));
    }
}

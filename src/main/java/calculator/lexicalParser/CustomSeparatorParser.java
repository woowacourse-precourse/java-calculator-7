package calculator.lexicalParser;

import calculator.operator.Separator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomSeparatorParser {
    private static final CustomSeparatorParser INSTANCE = new CustomSeparatorParser();
    private static final String REGEX_CUSTOM_SEPARATION_DECLARATION = "^//(\\S+)\\\\n";
    private static final Pattern PATTERN = Pattern.compile(REGEX_CUSTOM_SEPARATION_DECLARATION);
    private static final String BLANK = "";

    private CustomSeparatorParser() {
    }

    public static CustomSeparatorParser getInstance() {
        return INSTANCE;
    }

    public Separator parse(String input) {
        Matcher matcher = PATTERN.matcher(input);
        if(matcher.find()) {
            String symbol = matcher.group(1);
            return Separator.of(symbol);
        }
        throw new IllegalArgumentException("Found no such pattern :" + REGEX_CUSTOM_SEPARATION_DECLARATION);
    }

    public boolean canParse(String input) {
        return PATTERN.matcher(input).find();
    }

    public String removeCustomSeparatorDeclaration(String input) {
        Matcher matcher = PATTERN.matcher(input);
        return matcher.replaceFirst(BLANK);
    }
}

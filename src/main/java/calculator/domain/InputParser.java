//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package calculator.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputParser {
    public InputParser() {
    }

    public ParsedInput parse(String input) {
        if (this.isEmpty(input)) {
            return this.handleEmptyInput();
        } else {
            return this.hasCustomDelimiter(input) ? this.handleCustomDelimiter(input) : this.handleDefaultDelimiter(input);
        }
    }

    private boolean isEmpty(String input) {
        return input == null || input.isEmpty();
    }

    private ParsedInput handleEmptyInput() {
        return new ParsedInput(new String[0]);
    }

    private boolean hasCustomDelimiter(String input) {
        return input.startsWith("//");
    }

    private ParsedInput handleCustomDelimiter(String input) {
        Matcher matcher = this.getCustomDelimiterMatcher(input);
        if (!matcher.find()) {
            throw new IllegalArgumentException("잘못된 형식의 커스텀 구분자입니다.");
        } else {
            String delimiter = this.getCustomDelimiter(matcher);
            String numbersPart = this.getNumbersPart(matcher);
            String[] numbers = this.splitNumbers(numbersPart, delimiter);
            return new ParsedInput(numbers);
        }
    }

    private Matcher getCustomDelimiterMatcher(String input) {
        return Pattern.compile("//(.+)\\\\n(.*)").matcher(input);
    }

    private String getCustomDelimiter(Matcher matcher) {
        return Pattern.quote(matcher.group(1));
    }

    private String getNumbersPart(Matcher matcher) {
        return matcher.group(2);
    }

    private ParsedInput handleDefaultDelimiter(String input) {
        String delimiter = ",|:";
        String[] numbers = this.splitNumbers(input, delimiter);
        return new ParsedInput(numbers);
    }

    private String[] splitNumbers(String input, String delimiter) {
        if (!input.contains(",\\n") && !input.contains(",,")) {
            String[] tokens = input.split(delimiter);
            String[] var4 = tokens;
            int var5 = tokens.length;

            for(int var6 = 0; var6 < var5; ++var6) {
                String token = var4[var6];
                if (token.trim().isEmpty()) {
                    throw new IllegalArgumentException("유효한 숫자가 아닙니다: 빈 문자열");
                }
            }

            return tokens;
        } else {
            throw new IllegalArgumentException("유효한 숫자가 아닙니다: 빈 문자열");
        }
    }
}

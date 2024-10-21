package calculator.stringcalculator;

import java.util.regex.Pattern;

public class DelimiterHandler {

    public String[] checkDelimiter(String input) {
        String basicDelimiter = "[,:]";

        if (input.startsWith("//")) {
            int deliEnd = input.indexOf("\\n");
            if (deliEnd != -1) {
                String customDelimiter = input.substring(2, deliEnd);

                if (customDelimiter.equals("-")) {
                    System.out.println("본 계산기는 양수 덧셈만을 지원합니다. 해당 값은 구분자로만 처리됩니다.");
                }

                String delimiters = basicDelimiter + "|" + Pattern.quote(customDelimiter);
                input = input.substring(deliEnd + 2);
                return input.split(delimiters);
            }
        }
        return input.split(basicDelimiter);
    }
}

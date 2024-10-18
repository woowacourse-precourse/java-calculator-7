package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorService {

    private final static String VALID_EXPRESSION_TEMPLATE = "^((//)(.*?)(\\\\n))?(\\d+([,:%s]{1}\\d+)+)";

    public CalculatorService() {
    }

    public static void validate(String input, String customSeparator) {
        String regex = String.format(VALID_EXPRESSION_TEMPLATE, customSeparator);

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        if (!matcher.matches()) {
            throw new IllegalArgumentException();
        }
    }

    public boolean isBlank(String input) {
        return input == null || input.trim().isEmpty();
    }

    /**
     * 유저 입력에서 커스텀 구분자 있으면 파싱 후 반환 아니면 빈 문자열 반환
     * @param input
     * @return
     */
    public String parseCustomSeparator(String input) {
        Pattern pattern = Pattern.compile("^//(.+?)\\\\n");
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return "";
    }

    public String[] splitBySeparator(String input, String customSeparator) {
        String regex = String.format("[,:%s]", customSeparator);
        Pattern pattern = Pattern.compile(regex);

        String prefixCustomSeparator = "^//(.+?)\\\\n";
        String processedInput = input.replaceFirst(prefixCustomSeparator, "");

        return processedInput.split(regex);
    }

    public long logic(String input) {

        if (isBlank(input)) {
            return 0;
        }
        String customSeparator = parseCustomSeparator(input);

        validate(input, customSeparator);

        return 1;
    }
}

package calculator;

import calculator.validator.CalculatorValidator;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorService {

    public CalculatorService() {
    }

    public boolean isBlank(String input) {
        return input == null || input.trim().isEmpty();
    }

    /**
     * 유저 입력에서 커스텀 구분자 있으면 파싱 후 반환 아니면 빈 문자열 반환
     *
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

        return input.split(regex);
    }

    private String removeCustomSeparatorPrefix(String input) {
        String prefixCustomSeparator = "^//(.+?)\\\\n";

        return input.replaceFirst(prefixCustomSeparator, "");
    }

    public long calculate(String[] numberStrings) {
        return Arrays.stream(numberStrings).mapToLong(Long::parseLong).sum();
    }

    public long logic(String input) {

        String customSeparator = parseCustomSeparator(input);

        CalculatorValidator.validate(input, customSeparator);

        String processedInput = removeCustomSeparatorPrefix(input);

        if (isBlank(processedInput)) {
            return 0;
        }

        String[] splitedInput = splitBySeparator(processedInput, customSeparator);

        long answer = calculate(splitedInput);

        return answer;
    }
}

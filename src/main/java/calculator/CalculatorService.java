package calculator;

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

    public long logic(String input) {

        if (isBlank(input)) {
            return 0;
        }

        return 1;
    }
}

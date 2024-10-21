package calculator.io.reader.util.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexValidator implements Validator {

    private static final String DEFAULT_SEPARATORS = ",|:";  // 쉼표와 콜론이 기본 구분자
    private static final String CUSTOM_SEPARATOR_PATTERN = "//([^0-9])\\\\n(.*)?";

    @Override
    public String validateInput(String input) {
        if (input.isBlank()) {
            return "";  // 빈 문자열일 경우 0을 반환
        }

        String numberPart = input;
        String customSeparator = "";

        // 정규표현식을 사용하여 커스텀 구분자가 있는지 확인
        Pattern customPattern = Pattern.compile(CUSTOM_SEPARATOR_PATTERN);
        Matcher matcher = customPattern.matcher(input);

        if (matcher.find()) {
            customSeparator = matcher.group(1);  // 커스텀 구분자 추출
            numberPart = matcher.group(2);       // 숫자 부분 추출
        }

        // 기본 구분자(쉼표, 콜론) 또는 커스텀 구분자를 합친 정규식 생성
        String separators = DEFAULT_SEPARATORS;
        if (!customSeparator.isEmpty()) {
            separators += "|" + Pattern.quote(customSeparator);  // 커스텀 구분자 추가
        }

        System.out.println("Separators: " + separators);  // 구분자 출력

        // 숫자와 구분자로만 이루어진 문자열인지 확인하는 정규표현식
        String validInputPattern = "^[0-9" + separators + "]*$";
        if (!numberPart.matches(validInputPattern)) {
            throw new IllegalArgumentException("Number part is invalid");
        }

        return numberPart;
    }
}

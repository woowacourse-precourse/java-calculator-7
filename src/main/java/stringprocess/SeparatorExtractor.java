package stringprocess;

import constant.ErrorMessage;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class SeparatorExtractor {

    private final String customSeparatorPrefix;
    private final String extractRegex;
    private List<String> customSeparators;


    //테스트환경에서는 \n가 문자열로 인식되지만 실제 런타입에서는 개행문자로 인식되는 문제가 있어 정규식을 상황에 맞게 받도록함
    public SeparatorExtractor(String customSeparatorPrefix, String extractRegex, List<String> customSeparators) {
        this.customSeparatorPrefix = customSeparatorPrefix;
        this.extractRegex = extractRegex;
        this.customSeparators = customSeparators;
    }

    public String extractCustomSeparator(String value) {
        if (!value.contains(customSeparatorPrefix)) {
            return value;
        }

        Pattern pattern = Pattern.compile(extractRegex);
        Matcher matcher = pattern.matcher(value);

        while (matcher.find()) {
            //커스텀 구분자 추출
            String separator = matcher.group(1);

            //커스텀 구분자 선언 시작 인덱스
            int declarationIndex = matcher.start();
            int firstIndex = value.indexOf(separator);

            if (firstIndex < declarationIndex) {
                throw new IllegalArgumentException(ErrorMessage.CUSTOM_SEPARATOR__DECLARATION_ORDER_ERROR);
            }

            if (separator.isEmpty()) {
                throw new IllegalArgumentException(ErrorMessage.SPACE_OR_CHANGING_CHAR_CANNOT_USE);
            }

            //커스텀 구분자에 숫자가 포함되면 예외 발생
            boolean isNumContains = separator.chars().anyMatch(c -> c >= '0' && c <= '9');
            if (isNumContains) {
                throw new IllegalArgumentException(ErrorMessage.CUSTOM_SEPARATOR_CONTAINS_NUM);
            }

            //구분자 리스트에 추출한 커스텀 구분자 추가
            customSeparators.add(separator);
        }

        // 커스텀 구분자 선언이 추출되고 남은 문자열 반환
        return matcher.replaceAll("").trim();
    }
}

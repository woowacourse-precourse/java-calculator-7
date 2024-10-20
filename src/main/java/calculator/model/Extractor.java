package calculator.model;

import java.util.List;

public class Extractor {

    private List<String> delimiters;

    // 기본 구분자 및 커스텀 구분자 추가
    public Extractor(String input) {
        this.delimiters = new ArrayList<>(List.of(",", ":"));
        extractCustomDelimiter(input).ifPresent(delimiters::add);
    }
    // 커스텀 구분자 추출
    private Optional<String> extractCustomDelimiter(String input) {
        return Optional.of(input)
                .filter(this::hasCustomDelimiter)
                .map(str -> {
                    int delimiterStart = str.indexOf("//") + 2;
                    int delimiterEnd = str.indexOf("\\n");
                    if (delimiterEnd == -1) {
                        throw new CustomException(ErrorCode.MISSING_CUSTOM_DELIMITER_END);
                    }
                    String customDelimiter = str.substring(delimiterStart, delimiterEnd);
                    return customDelimiter;
                });
    }
    }

}

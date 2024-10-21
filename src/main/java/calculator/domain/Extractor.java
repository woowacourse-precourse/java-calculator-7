package calculator.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Extractor {

    private static final String[] defaultSeparators = {":", ","};

    private List<Number> numbers;
    private Separator customSeparator;

    public Extractor(String input) {
        this.customSeparator = extractCustomSeparators(input);
        this.numbers = extractNumbers(input);
    }

    public Separator getCustomSeparators() {
        return customSeparator;
    }

    public List<Number> getNumbers() {
        return numbers;
    }

    public Separator extractCustomSeparators(String input) {
        if (input.startsWith("//") && input.contains("\\n")) {
            int delimiterIndex = input.indexOf("\\n");
            return new Separator(input.substring(2, delimiterIndex));
        }
        return null;
    }

    public List<Number> extractNumbers(String input) {
        if (customSeparator != null) {
            // 커스텀 구분자 부분 제거
            int delimiterIndex = input.indexOf("\\n");
            input = input.substring(delimiterIndex + 2);
        }

        // 기본 구분자와 커스텀 구분자를 모두 포함한 정규식 생성
        StringBuilder separatorPattern = new StringBuilder();
        for (String sep : defaultSeparators) {
            separatorPattern.append(Pattern.quote(sep)).append("|");
        }
        if (customSeparator != null) {
            separatorPattern.append(Pattern.quote(customSeparator.getSeparator())).append("|");
        }

        // 마지막 | 제거
        if (separatorPattern.length() > 0 && separatorPattern.charAt(separatorPattern.length() - 1) == '|') {
            separatorPattern.setLength(separatorPattern.length() - 1);
        }

        // 구분자로 입력 문자열을 분리
        String[] tokens = input.split(separatorPattern.toString());
        List<Number> numberList = new ArrayList<>();

        for (String token : tokens) {
            if (!token.isEmpty()) {
                validateSeparatorExistOneByOne(token, input);
                validateInputAnotherChar(token);
                numberList.add(new Number(Integer.parseInt(token)));  // 숫자 추가
            }
        }

        return numberList;
    }

    private void validateSeparatorExistOneByOne(String token, String input) {
        if (token == "" && input.length() != 0) {
            throw new IllegalArgumentException("[ERROR] 구분자는 한 개씩 존재해야 합니다.");
        }
    }

    private void validateInputAnotherChar(String token) {
        if (!token.matches("-?\\d+")) {
            throw new IllegalArgumentException("[ERROR] 구분자 이외의 문자가 입력되면 안됩니다.");
        }
    }
}

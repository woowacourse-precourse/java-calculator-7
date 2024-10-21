package calculator;

import java.util.regex.Pattern;

public class Validator {

    public void validateInput(String input) {
        if (input == null) {
            throw new IllegalArgumentException("입력이 null입니다.");
        }

        // 커스텀 구분자 추출 여부 확인
        String delimiter = ",";
        String numbersPart = input;
        boolean isCustomDelimiter = false;

        if (input.startsWith("//")) {
            isCustomDelimiter = true;
            delimiter = extractCustomDelimiter(input);
            numbersPart = input.substring(input.indexOf("\n") + 1);
        }

        // 구분자가 연속으로 나오지 않는지, 기본 구분자와 커스텀 구분자 혼용 금지
        validateDelimiterUsage(numbersPart, delimiter, isCustomDelimiter);

        // 음수 검증 : 커스텀 구분자를 제외한 숫자 부분에서 음수 검증
        validateNumbers(numbersPart, delimiter);
    }

    private void validateDelimiterUsage(String numbersPart, String delimiter, boolean isCustomDelimiter) {
        // 기본 구분자 패턴
        String defaultDelimiters = "[,:]";

        // 커스텀 구분자가 사용된 경우 기본 구분자를 허용하지 않음
        if (isCustomDelimiter && numbersPart.matches(".*" + defaultDelimiters + ".*")) {
            throw new IllegalArgumentException("커스텀 구분자를 사용할 때 기본 구분자를 함께 사용할 수 없습니다.");
        }

        // 모든 구분자가 연속해서 등장하는지 확인 (기본 구분자 또는 커스텀 구분자)
        String combinedDelimiters = Pattern.quote(delimiter) + "|" + defaultDelimiters;
        if (numbersPart.matches(".*(" + combinedDelimiters + "){2,}.*")) {
            throw new IllegalArgumentException("구분자가 연속으로 등장할 수 없습니다.");
        }
    }

    private void validateNumbers(String numbersPart, String delimiter) {
        String[] numbers = numbersPart.split(Pattern.quote(delimiter));
        for (String number : numbers) {
            if (!number.isEmpty()) {
                try {
                    if (Integer.parseInt(number) < 0) {
                        throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
                    }
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("유효하지 않은 숫자 형식입니다: " + number);
                }
            }
        }
    }

    private String extractCustomDelimiter(String input) {
        String delimiter = input.substring(2, input.indexOf("\n"));

        // 숫자를 구분자로 사용할 수 없음
        if (delimiter.matches("[0-9]")) {
            throw new IllegalArgumentException("숫자는 구분자로 사용할 수 없습니다.");
        }

        // 커스텀 구분자는 하나의 문자여야 함
        if (delimiter.length() != 1) {
            throw new IllegalArgumentException("커스텀 구분자는 하나의 문자여야 합니다.");
        }

        return delimiter;
    }


    // 기본 구분자인 쉼표, 콜론을 기준으로 문자열 검증
    public void validateDefaultDelimiters(String input) {
        // 빈 문자열인 경우 바로 통과
        if (input.isEmpty()) {
            return;
        }

        // 쉼표(,)와 콜론(:)만 있는지 확인 (숫자, 쉼표, 콜론만 허용)
        if (input.matches("[0-9,:]+")) {
            System.out.println("입력값이 올바른 형식입니다.");
        }
    }

    // 커스텀 구분자를 이용한 문자열을 검증하는 메서드
    public void validateCustomDelimiters(String input) {
        // "//[구분자]\n[숫자들]" 형식인지 확인
        String delimiter = input.substring(2, input.indexOf("\n"));
        String numbersPart = input.substring(input.indexOf("\n") + 1);

        // 커스텀 구분자와 숫자로만 구성되어 있는지 검증
        if (numbersPart.matches("[0-9" + Pattern.quote(delimiter) + "]+")) {
            System.out.println("커스텀 구분자를 사용한 입력값이 올바른 형식입니다.");
        }
    }
}

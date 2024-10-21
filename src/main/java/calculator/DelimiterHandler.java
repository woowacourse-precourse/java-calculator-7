package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DelimiterHandler {
    private String input;
    private String customDelimiter;
    private String remainInput;
    private String invalidDelimiter;

    public DelimiterHandler(String input) {
        this.input = input;
    }


    public String[] splitInput() {
        String delimiter = ",|:";

        Boolean bIsContainDelimiter = isContainDelimiter();

        // 커스텀 구분자도 없고 기본 구분자도 없을 경우
        if (!bIsContainDelimiter && !containsBasicDelimiter()) {
            invalidDelimiter = extractInvalidDelimiter();
            throw new IllegalArgumentException("잘못된 구분자: \"" + invalidDelimiter + "\" 입니다. 커스텀 구분자 형식( //구분자\\n )이 아니고 기본 구분자( , 이나 : )도 아닙니다.");
        }

        // 커스텀 구분자가 있을 때
        if (bIsContainDelimiter) {
            delimiter += "|" + Pattern.quote(customDelimiter);  // 커스텀 구분자 처리 (특수문자도 포함 가능)
            return remainInput.split(delimiter);
        }
        // 커스텀 구분자가 없을 때
        else {
            return input.split(delimiter, -1);  // 기본 구분자로 나눔
        }
    }

    // 커스텀 구분자가 포함되었는지 확인하는 메서드
    private boolean isContainDelimiter() {
        // 정규식으로 커스텀 구분자 패턴 (//구분자\n숫자들)을 탐색
        Pattern pattern = Pattern.compile("^//(.+)\\\\n(.*)");
        Matcher matcher = pattern.matcher(input);

        // 커스텀 구분자가 존재하면 처리
        if (matcher.find()) {
            customDelimiter = matcher.group(1);
            remainInput = matcher.group(2);  // 커스텀 구분자를 제외한 나머지 입력
            return true;
        }

        if ((!input.startsWith("//") && input.contains("\\n")) || (input.startsWith("//") && !input.contains("\\n"))) {
            throw new IllegalArgumentException("잘못된 커스텀 구분자 형식입니다. 커스텀 구분자 형식: //구분자\\n ");
        }
        return false;
    }

    // 기본 구분자가 포함되었는지 확인하는 메서드
    private boolean containsBasicDelimiter() {
        // 기본 구분자 , 또는 : 포함 여부 확인
        return input.contains(",") || input.contains(":");
    }

    // 잘못된 구분자가 있는지 확인하는 메서드
    private boolean containsInvalidDelimiter() {
        // 기본 구분자인 , 또는 : 외의 구분자가 있는지 검사
        String invalidDelimiters = "[^0-9,|:]";  // 숫자, 쉼표, 콜론 외의 모든 문자 확인
        Pattern pattern = Pattern.compile(invalidDelimiters);
        Matcher matcher = pattern.matcher(input);

        return matcher.find();  // 잘못된 구분자가 있으면 true 반환
    }

    // 잘못된 구분자를 추출하는 메서드
    private String extractInvalidDelimiter() {
        String invalidDelimiter = input.replaceAll("[0-9\\s]", "");
        return invalidDelimiter.isEmpty() ? "알 수 없는 구분자" : invalidDelimiter;
    }
}

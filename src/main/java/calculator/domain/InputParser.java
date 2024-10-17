package calculator.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputParser {

    // 기본 생성자
    public InputParser() {
    }

    // 입력 문자열을 파싱하여 ParsedInput 객체로 반환하는 메서드
    public ParsedInput parse(String input) {
        // 입력이 비어있으면 빈 배열로 처리
        if (this.isEmpty(input)) {
            return this.handleEmptyInput();
        }
        // 커스텀 구분자가 있는 경우와 기본 구분자(쉼표, 콜론) 처리를 구분
        return this.hasCustomDelimiter(input) ? this.handleCustomDelimiter(input) : this.handleDefaultDelimiter(input);
    }

    // 입력 문자열이 null이거나 비어있는지 확인
    private boolean isEmpty(String input) {
        return input == null || input.isEmpty();
    }

    // 빈 입력을 처리하여 빈 숫자 배열 반환
    private ParsedInput handleEmptyInput() {
        return new ParsedInput(new String[0]); // 빈 배열로 처리
    }

    // 커스텀 구분자가 있는지 확인 (입력 문자열이 "//"로 시작하는지 확인)
    private boolean hasCustomDelimiter(String input) {
        return input.startsWith("//");
    }

    // 커스텀 구분자를 처리하는 메서드
    private ParsedInput handleCustomDelimiter(String input) {
        Matcher matcher = this.getCustomDelimiterMatcher(input);

        // 커스텀 구분자의 형식이 맞지 않으면 예외 처리
        if (!matcher.find()) {
            throw new IllegalArgumentException("잘못된 형식의 커스텀 구분자입니다.");
        }

        // 커스텀 구분자를 추출
        String delimiter = matcher.group(1);

        // 구분자가 한 문자가 아니면 예외 발생
        if (delimiter.length() > 1) {
            throw new IllegalArgumentException("커스텀 구분자는 한 문자만 입력해야 합니다.");
        }

        // 구분자 뒤의 숫자 부분을 처리
        String numbersPart = this.getNumbersPart(matcher);
        String[] numbers = this.splitNumbers(numbersPart, delimiter);
        return new ParsedInput(numbers);
    }

    // 커스텀 구분자를 찾는 정규식 패턴을 사용하는 메서드
    private Matcher getCustomDelimiterMatcher(String input) {
        // "//구분자\n숫자들" 형식을 매칭하기 위한 정규식
        return Pattern.compile("//(.+)\\\\n(.*)").matcher(input);
    }

    // 구분자를 추출하는 메서드 (정규식 그룹에서 구분자 가져오기)
    private String getCustomDelimiter(Matcher matcher) {
        return matcher.group(1);
    }

    // 숫자 부분을 추출하는 메서드
    private String getNumbersPart(Matcher matcher) {
        return matcher.group(2);
    }

    // 기본 구분자(쉼표, 콜론)를 처리하는 메서드
    private ParsedInput handleDefaultDelimiter(String input) {
        String delimiter = ",|:"; // 기본 구분자 쉼표(,)와 콜론(:)
        String[] numbers = this.splitNumbers(input, delimiter);
        return new ParsedInput(numbers);
    }

    // 숫자를 구분자에 따라 분리하는 메서드
    private String[] splitNumbers(String input, String delimiter) {
        // 잘못된 구분자 조합을 확인하여 예외 발생
        if (!input.contains(",\\n") && !input.contains(",,")) {
            String[] tokens = input.split(delimiter);
            for (String token : tokens) {
                // 공백 또는 빈 문자열이 있으면 예외 발생
                if (token.trim().isEmpty()) {
                    throw new IllegalArgumentException("유효한 숫자가 아닙니다: 빈 문자열");
                }
            }
            return tokens;
        } else {
            // 잘못된 형식의 구분자에 대한 예외 처리
            throw new IllegalArgumentException("유효한 숫자가 아닙니다: 빈 문자열");
        }
    }
}

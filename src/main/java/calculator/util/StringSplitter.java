package calculator.util;

// 문자열을 주어진 구분자를 기준으로 분리하는 클래스
public class StringSplitter {

    private final StringValidator stringvalidator;

    // 의존성 주입
    public StringSplitter(StringValidator stringValidator) {
        this.stringvalidator = stringValidator;
    }
    // 문자열 분리 메서드
    public String[] splitString(String input) {
        String delimiter = stringvalidator.isValid(input);

        // 커스텀 구분자일 경우 숫자 부분만 추출
        if (input.startsWith("//")) {
            int index = input.indexOf("\\n");
            input = input.substring(index + 2);  // "\n" 이후의 숫자 부분만 추출
        }

        // 구분자를 이용해 문자열을 분리
        String[] numbers = input.split(delimiter);
        stringvalidator.validateNumbers(numbers);
        return numbers;
    }
}
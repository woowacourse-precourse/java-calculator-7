package calculator.model;

import java.util.regex.Pattern;

//입력 검증
public class InputValidator {

    //기본 구분자 입력값 검증: 쉼표 또는 콜론 외에는 모두 양수인지 검증
    public void validate(String input) {
        if(input == null || input.isEmpty()) {
            return;
        }
        if (input.startsWith("//")) {
            // 커스텀 구분자가 있을 때 처리
            validateCustomDelimiter(input);
        } else {
            // 기본 구분자(쉼표, 콜론) 처리
            validateDefaultDelimiter(input);
        }
    }

    // 기본 구분자 입력값 검증: 쉼표(,) 또는 콜론(:)
    private void validateDefaultDelimiter(String input) {
        String[] numbers = input.split(",|:");
        checkNegativeNumbers(numbers);
    }

    //커스텀 구분자 입력값 검증
    //`"//"`와 `"\n"` 사이에 커스텀 구분자 지정 가능
    //커스텀 구분자가 지정되면 기본 구분자 사용 불가
    //구분자와 구분자 설정 외에는 모두 양수인지 검증
    private void validateCustomDelimiter(String input) {

        // "//"로 시작하는지 확인
        if (!input.startsWith("//")) {
            throw new IllegalArgumentException("커스텀 구분자는 //로 시작해야 합니다.");
        }

        // '\n' 위치 파악 (찾지 못한 경우 예외 처리)
        int delimiterIndex = input.indexOf("\\n");
        if (delimiterIndex == -1 ) { //|| delimiterIndex <= 2
            throw new IllegalArgumentException("입력 형식이 잘못되었습니다. 커스텀 구분자는 //로 시작하고 \\n으로 끝나야 합니다.");
        }

        // "//"와 "\n" 사이 구분자 추출
        String delimiter = input.substring(2, delimiterIndex);

        // 구분자가 비어 있는지 확인
        if (delimiter.isEmpty()) {
            throw new IllegalArgumentException("구분자가 비어있을 수 없습니다.");
        }

        //구분자 이후 숫자 추출
        String numbersPart = input.substring(delimiterIndex +2); // 구분자 이후 숫자 부분 추출

        if (numbersPart.isEmpty()) {
            throw new IllegalArgumentException("숫자 부분이 비어 있습니다.");
        }

        //커스텀 구분자로 숫자 분리
        String[] numbers = numbersPart.split(Pattern.quote(delimiter));
        //음수 예외 처리
        checkNegativeNumbers(numbers);
    }

    //예외 처리(음수)
    //사용자 잘못된 값 입력 시 `IllegalArgumentException` 발생하여 프로그램 종료
    private void checkNegativeNumbers(String[] numbers) {
        for (String number : numbers) {
            if (!number.isEmpty()) { // 빈 문자열이 아닌 경우만 처리
                int num = Integer.parseInt(number);
                if (num < 0) {
                    throw new IllegalArgumentException("음수는 입력할 수 없습니다: " + num);
                }
            }
        }
    }
}

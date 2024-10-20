package calculator.model;

import java.util.regex.Pattern;

//입력 검증
public class InputValidator {

    //입력을 받아 검증하고 숫자 배열 반환
    public String[] validate(String input) {
        if(input == null || input.isEmpty()) {
            return new String[] {"0"};
        }

        if (input.startsWith("//")) {
            // 커스텀 구분자가 있을 때 처리
            return validateCustomDelimiter(input);
        } else {
            // 기본 구분자(쉼표, 콜론) 처리
            return validateDefaultDelimiter(input);
        }
    }

    // 기본 구분자 쉼표(,) 또는 콜론(:) 처리
    private String[] validateDefaultDelimiter(String input) {
        String[] numbers = input.split(",|:");
        checkNegativeNumbers(numbers);
        return numbers;
    }

    //커스텀 구분자 입력값 처리 및 검증
    //`"//"`와 `"\n"` 사이에 커스텀 구분자 지정 가능
    //커스텀 구분자가 지정되면 기본 구분자 사용 불가
    //구분자와 구분자 설정 외에는 모두 양수인지 검증
    private String[] validateCustomDelimiter(String input) {
        int delimiterIndex = input.indexOf("\\n");

        // '\n' 위치 파악 (찾지 못한 경우 예외 처리)
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
        return numbers;
    }

    //음수 검증
    //사용자 잘못된 값 입력 시 `IllegalArgumentException` 발생하여 프로그램 종료
    public void checkNegativeNumbers(String[] numbers) {
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

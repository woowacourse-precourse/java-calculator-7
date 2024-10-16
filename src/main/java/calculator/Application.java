package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        StringCalculator calculator = new StringCalculator();
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        try {
            int result = calculator.calculate(input);
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); // 예외 메시지 출력
        }
    }
}

class StringCalculator {
    public int calculate(String input) {
        if (input.isEmpty()) {
            return 0;
        }
        // 쉼표(,) 또는 콜론(:)을 구분자로 분리
        String delimiter = "[,:]";
        String[] numbers = input.split(delimiter);


        if (input.startsWith("//")) {
            int delimiterIndex = input.indexOf("\\n");
            delimiter = input.substring(2, delimiterIndex);  // 커스텀 구분자 추출
            numbers = input.substring(delimiterIndex + 2).split(delimiter);
        }

        return sum(numbers);
    }

        private int sum(String[] numbers) {
            int sum = 0;
            for (String number : numbers) {
                String trimmedNumber = number.trim();

                if(!isNumeric(trimmedNumber)){
                    throw new IllegalArgumentException("입력 값에 숫자가 아닌 값이 포함되어 있습니다: " + trimmedNumber);
                }

                sum += Integer.parseInt(number.trim()); // 공백 제거 후 정수 변환 및 더하기
            }
            return sum;
        }

        // 숫자인지 확인하는 메서드
        private boolean isNumeric(String str) {
            try {
                Integer.parseInt(str); // 정수로 변환 시도
                return true; // 변환 성공
            } catch (NumberFormatException e) {
                return false; // 변환 실패
            }
        }
    }
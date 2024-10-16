package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        StringCalculator calculator = new StringCalculator();
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        int result = calculator.calculate(input);
        System.out.println("결과 : " + result);
    }
}

class StringCalculator {
    public int calculate(String input) {
        if (input.isEmpty()) {
            return 0;
        }
        // 쉼표(,) 또는 콜론(:)을 구분자로 분리
        String delimiter = ",|:";
        String[] numbers = input.split(delimiter);


        if (input.startsWith("//")) {
            int delimiterIndex = input.indexOf("\\n");
            String customDelimiter = input.substring(2, delimiterIndex);  // 커스텀 구분자 추출
            delimiter += '|' + escapeDelimiter(customDelimiter);  // 기존 구분자에 커스텀 구분자를 추가
            numbers = input.substring(delimiterIndex + 2).split(delimiter);
        }

        return sum(numbers);
    }

        private int sum(String[] numbers) {
            int sum = 0;
            for (String number : numbers) {
                String trimmedNumber = number.trim();

                //숫자 아닌 문자면 예외처리
                if(!isNumeric(trimmedNumber)){
                    throw new IllegalArgumentException();
                }
                int num = Integer.parseInt(trimmedNumber);

                // 음수면 예외처리
                if(num < 0){
                    throw new IllegalArgumentException();
                }

                sum += num; // 공백 제거 후 정수 변환 및 더하기
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

    // 커스텀 구분자를 정규 표현식에 맞게 이스케이프하는 메서드
    private String escapeDelimiter(String delimiter) {
        return delimiter.replace("\\", "\\\\")
                .replace(".", "\\.")
                .replace("?", "\\?")
                .replace("+", "\\+")
                .replace("*", "\\*")
                .replace("^", "\\^")
                .replace("$", "\\$")
                .replace("(", "\\(")
                .replace(")", "\\)")
                .replace("[", "\\[")
                .replace("]", "\\]")
                .replace("{", "\\{")
                .replace("}", "\\}");
    }
    }
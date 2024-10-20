package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        String input = getInput();
        int sum = calculateSum(input);
        System.out.println("결과: " + sum);
    }

    // 입력 처리
    private static String getInput() {
        System.out.print("덧셈할 문자열을 입력해 주세요. : ");
        return Console.readLine();
    }

    // 계산 메서드
    private static int calculateSum(String input) {
        if (input == null || input.isEmpty()) {
            return 0; // 빈 문자열인 경우 0 반환
        }

        // \n -> \\n으로 변환
        input = input.replace("\\n", "\n");

        // 기본 구분자의 경우
        String delimiter = "[,:]";
        String numbersPart = input;

        // 커스텀 구분자의 경우
        if (input.startsWith("//")) {
            int customDelimiterStart = input.indexOf("//") + 2; // "//" 다음 인덱스
            int startNum = input.indexOf("\n");

            if (startNum != -1) {
                delimiter = input.substring(customDelimiterStart, startNum).trim(); // 커스텀 구분자
                numbersPart = input.substring(startNum + 1); // \n 이후의 부분
            }
        }

        // 구분자를 기준으로 숫자 추출
        String[] numbers = numbersPart.split(delimiter);

        return sumNumbers(numbers);
    }

    // 분리된 숫자 합 계산
    private static int sumNumbers(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            String trimNumber = number.trim();
            if (!trimNumber.isEmpty()) {
                sum += Integer.parseInt(trimNumber);
            }
        }
        return sum;
    }
}

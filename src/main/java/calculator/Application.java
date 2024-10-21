package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해주세요.");
        String input = Console.readLine();
        try {
            int result = add(input);
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 입력: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("알 수 없는 오류가 발생했습니다: " + e.getMessage());
            e.printStackTrace(); // 스택 트레이스를 출력하여 디버깅에 도움을 줌
        }
    }

    // 구분자로 잘라서 계산 결과를 반환하는 코드
    static int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String delimiter = ",|:"; // 기본 구분자

        // 커스텀 구분자가 있는지 확인
        if (input.contains("//")) {
            int delimiterStartIndex = input.indexOf("//") + 2;
            int delimiterEndIndex = input.indexOf("\n");
            String customDelimiter = input.substring(delimiterStartIndex, delimiterEndIndex); // 커스텀 구분자 추출
            delimiter = customDelimiter + "|" + delimiter; // 커스텀 구분자와 기본 구분자 결합
            input = input.substring(delimiterEndIndex + 1); // 숫자 부분만 남김
        }

        String[] numbers = input.split(delimiter);
        int sum = 0;

        for (String number : numbers) {
            if (!number.trim().isEmpty()) { // 공백을 제거하고 빈 문자열이 아닌지 확인
                int num = Integer.parseInt(number.trim()); // 문자열을 정수로 변환
                if (num < 0) {
                    throw new IllegalArgumentException("음수는 허용되지 않습니다: " + num);
                }
                sum += num;
            }
        }

        return sum;
    }
}

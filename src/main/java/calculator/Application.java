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
            e.printStackTrace();
        }
    }

    static int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String delimiter = ",|:"; // 기본 구분자

        // 커스텀 구분자가 있는지 확인
        if (input.contains("//")) {
            int delimiterStartIndex = input.indexOf("//") + 2; // "//" 이후의 구분자 시작 위치
            int delimiterEndIndex = input.indexOf("\n"); // \n의 위치

            // 디버깅용 출력: 인덱스가 정확한지 확인
            System.out.println("delimiterStartIndex: " + delimiterStartIndex);
            System.out.println("delimiterEndIndex: " + delimiterEndIndex);

            // \n이 없으면 오류 발생
            if (delimiterEndIndex == -1) {
                throw new IllegalArgumentException("잘못된 형식: \\n이 필요합니다.");
            }

            String customDelimiter = input.substring(delimiterStartIndex, delimiterEndIndex); // 커스텀 구분자 추출
            delimiter = customDelimiter + "|" + delimiter; // 커스텀 구분자와 기본 구분자 결합
            input = input.substring(delimiterEndIndex + 1); // 숫자 부분만 남김
        }

        String[] numbers = input.split(delimiter); // 구분자로 숫자 분리
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


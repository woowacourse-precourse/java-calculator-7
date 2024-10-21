package calculator;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 문자열 입력
        System.out.print("덧셈할 문자열을 입력해주세요 : ");
        String input = scanner.nextLine();

        // 입력 문자열 출력 (디버깅 용도)
        //System.out.println("입력된 문자열: " + input);
        //System.out.println("입력된 문자열에서 n의 위치: " + input.indexOf("n"));

        // 결과 출력
        int result = StringCalculator.add(input);
        System.out.println("결과 : " + result);

        scanner.close();
    }
}

class StringCalculator {
    public static int add(String input) {
        String[] numbers;
        String delimiters = ",:"; // 기본 구분자

        // 커스텀 구분자
        if (input.startsWith("//")) {
            if (input.contains("\\n")) {
                String customDelimiter = input.substring(2, input.indexOf("\\n"));
                delimiters += customDelimiter; // 기본 구분자에 커스텀 구분자 추가
                input = input.substring(input.indexOf("\\n") + 2); // \n 뒤의 문자열만 남김
            }
        }

        // 숫자 부분 분리
        numbers = splitNumbers(input, delimiters);

        // 각 숫자를 합산
        int sum = 0;
        for (String number : numbers) {
            number = number.trim(); // 공백 제거

            // 숫자로 변환 후 합산
            sum += Integer.parseInt(number);
        }
        return sum;
    }

    // 숫자를 분리하는 메서드
    private static String[] splitNumbers(String input, String delimiters) {
        return input.split("[" + delimiters + "]"); // 정규 표현식으로 구분자 처리
    }
}


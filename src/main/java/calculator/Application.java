package calculator;


import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;

public class Application {
    public static void main(String[] args) {

        System.out.println("덧셈할 문자열을 입력해 주세요.");

        // Console.readLine()으로 사용자로부터 입력 받기
        String input = Console.readLine();
        String separator = "[,:]";
        String numbers_string = input;

        // 커스텀 구분자가 있는지 확인
        if (input.startsWith("//")) {
            int newlineIndex = input.indexOf("\\n");
            if (newlineIndex != -1) {  // 줄바꿈 문자가 있는 경우에만
                // 커스텀 구분자 추출 및 숫자 부분 분리
                separator = input.substring(2, newlineIndex); //줄바꿈 전까지의 문자열을 구분자로 설정
                separator = escapeSpecialRegexChars(separator);
                numbers_string = input.substring(newlineIndex + 2);
            }
        }
        // 숫자 배열 생성
        String[] tokens = numbers_string.split(separator);
        int[] numbers = getNumbers(tokens);
        // 결과 계산
        int result = 0;
        for (int number : numbers) {
            result += number;
        }

        // 결과 출력
        System.out.println("결과 : " + result);

    }

    private static int[] getNumbers(String[] tokens) {
        int[] numbers = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            validateNumber(tokens[i]);
            numbers[i] = Integer.parseInt(tokens[i]);
        }
        return numbers;
    }

    private static void validateNumber(String number) {
        if (!number.matches("[0-9]+")) {
            throw new IllegalArgumentException("잘못된 값을 입력했습니다!(양수를 입력해주세요)");
        }
    }

    // 특수 문자를 사용하기 위해 이스케이프 처리하는 메서드
    private static String escapeSpecialRegexChars(String separator) {
        // 특수 문자를 이스케이프 처리하는 로직
        return separator.replaceAll("([\\\\*+\\[\\](){}|.^$?])", "\\\\$1");
    }
}

package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {


    }

    //1. 입력 받기
    private static String readInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        //커스텀 구분자 사용 시 다음줄 입력받기.
        if (input.startsWith("//") && input.contains("\n")) {
            String nextLine = Console.readLine();
            input += "\n" + nextLine;
        }
        return input;
    }

    //2. 커스텀 구분자 추출
    private static String extraDelimiter(String input) {
        String delimiter = ",|:";
        if (input.startsWith("//")) {
            int delimiterIndex = input.indexOf("\n");
            if (delimiterIndex == -1) {
                throw new IllegalArgumentException("입력 형식이 잘못되었습니다.");
            }
            delimiter = Pattern.quote(input.substring(2, delimiterIndex));
        }
        return delimiter;
    }

    //3.숫자와 문자열 분리
    private static String[] splitNumbers(String input, String delimiter) {
        return input.split(delimiter);// ex ) 1:2:3 을 구분자 기준으로 나눔
    }

    //4. 숫자 변환 및 합계 계산
    private static int calculateSum(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            if (number.isEmpty()) {
                continue;
            }
            int num = parseNumber(number);
            validateNegative(num);
            sum += num;
        }
        return sum;
    }

    //숫자 변환
    private static int parseNumber(String number) {
        try {
            return Integer.parseInt(number.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다");
        }
    }

    //음수 확인
    private static void validateNegative(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("음수는 허용되지 않습니다");
        }
    }
    //5. 결과출력
    private static void printResult(int result)
    {
        System.out.println("결과 : "+result);
    }

}

package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        String cuttingMark = ",|:";

        int sum = 0;

        if (input.trim().isEmpty()) {
            System.out.println("결과 : 0");
            return;
        } else if (input.startsWith("//") && input.contains("\\n")) {
            // 커스텀 구분자가 반드시 한 글자인 경우
            String customCuttingMark = input.substring(2, 3);
            String safeCustomCuttingMark = Pattern.quote(customCuttingMark);
            String combinedCuttingMark = cuttingMark + "|" + safeCustomCuttingMark;
            String cuttedNumbers = input.substring(5);
            String[] numbers = cuttedNumbers.split(combinedCuttingMark);
            sum = calculateSum(numbers);

        } else if (input.startsWith("//")) {
            // 커스텀 구분자가 여러 글자이고 개행문자 \n으로 커스텀 구분자를 입력 받을때.
            int endIndex = input.indexOf("\n");
            String customCuttingMark = input.substring(2, endIndex);
            String safeCustomCuttingMark = Pattern.quote(customCuttingMark);
            String combinedCuttingMark = cuttingMark + "|" + safeCustomCuttingMark;
            String cuttedNumbers = input.substring(endIndex + 1);
            String[] numbers = cuttedNumbers.split(combinedCuttingMark);
            sum = calculateSum(numbers);

        } else {
            // 기본 구분자 사용.
            String[] numbers = input.split(cuttingMark);
            sum = calculateSum(numbers);
        }

        System.out.println("결과 : " + sum);
    }

    private static int calculateSum(String[] numbers) {
        int sum = 0;
        int prevSum = 0;
        for (String number : numbers) {
            try {
                prevSum = sum;
                sum += Integer.parseInt(number);

                if (sum < prevSum) {
                    throw new IllegalArgumentException("양수의 숫자만 입력 할 수 있습니다.");
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("숫자 이외의 값이 입력 되었습니다.");
            }
        }
        return sum;
    }
}
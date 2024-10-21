package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static boolean isContainDigit(String str) {
        return str.matches(".*\\d.*");
    }

    public static boolean isContainNonDigit(String str) {
        return str.matches(".*\\D.*");
    }

    public static int getSum(String str, String separator) {
        String regex = "[" + separator + "]";
        String[] array = str.split(regex);

        int result = 0;
        for (String s : array) {
            // 예외처리: 정수로 변환할 수 없는 문자일 경우
            if (isContainNonDigit(s)) {
                throw new IllegalArgumentException();
            } else {
                int number = Integer.parseInt(s);
                // 예외처리: 양의 정수가 아닌 경우
                if (number <= 0) {
                    throw new IllegalArgumentException();
                }
                result += number;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String sep = ",:";
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String str = Console.readLine();

        if (str.startsWith("//")) {
            int idx = str.indexOf("\\n");
            // 예외처리: '\n'이 없는 경우
            if (idx == -1) {
                throw new IllegalArgumentException();
            }
            // 문자열 추출 후 새 구분자 문자열, 새 검사 문자열 선언
            String newSeparator = sep + str.substring(2, idx);
            String newStr = str.substring(idx + 2);
            // 예외처리: 새 구분자 문자열에 정수가 들어있는 경우
            if (isContainDigit(newSeparator)) {
                throw new IllegalArgumentException();
            }

            System.out.println("결과 : " + getSum(newStr, newSeparator));
        } else {
            System.out.println("결과 : " + getSum(str, sep));
        }

    }
}

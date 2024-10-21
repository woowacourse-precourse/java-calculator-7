package calculator;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        String customDelimiter = ",|:";

        String str = getStr();

        if (isEmptyInput(str)) {
            return;
        }

        // 커스텀 구분자 처리
        if (str.startsWith("//")) {
            int delimiterIndex = str.indexOf("\\n");

            if (delimiterIndex == -1) {
                throw new IllegalArgumentException("잘못된 구분자 형식입니다.");
            }

            customDelimiter = str.substring(2, delimiterIndex);
            str = str.substring(delimiterIndex + 2);
        }

        // 커스텀 문자 또는 기본 구분자로 분리
        String[] numbers = str.split(customDelimiter);

        try {
            int sum = 0;
            for (String number : numbers) {

                int parsedInt = Integer.parseInt(number);

                if (parsedInt < 0) {
                    throw new IllegalArgumentException("음수는 허용되지 않습니다: " + parsedInt);
                }

                sum += parsedInt;
            }
            System.out.println("결과 : " + sum);
        } catch (Exception e) {
            throw new IllegalArgumentException("잘못된 값을 입력하였습니다.");
        }
    }

    private static boolean isEmptyInput(String str) {
        if (str.isEmpty()) {
            System.out.println("결과 : 0");
            return true;
        }
        return false;
    }

    private static String getStr() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");

        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        return str;
    }
}

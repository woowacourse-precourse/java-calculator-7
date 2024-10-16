package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        int sum = 0;

        while (true) {
            // 빈 문자열, 엔터, 탭, null 입력
            if (input.isBlank() || input == null) {
                System.out.println("결과 : " + sum);
                break;
            }

            // 단일 숫자 입력
            if (isInteger(input)) {
                System.out.println("결과 : " + input);
                break;
            }

            // 쉼표, 콜론 구분자 처리
            if (input.contains(",") || input.contains(":")) {
                String[] commaSplit = input.split(",");
                for (String part : commaSplit) {
                    String[] colonSplit = part.split(":");
                    for (String number : colonSplit) {
                        sum += Integer.parseInt(number);
                    }
                }
                System.out.println("결과 : " + sum);
                break;
            }
        }
    }

    private static boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

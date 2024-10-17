package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    private static void checkIsValid(String str) {
        for (char x : str.toCharArray()) {
            if (!Character.isDigit(x)) {
                throw new IllegalArgumentException("문자열에 음수 혹은 숫자가 아닌 것은 포함될 수 없습니다.");
            }
        }
    }

    private static void checkCustomStyle(String str) {
        if (!str.startsWith("//")) {
            throw new IllegalArgumentException("커스텀 구분자의 입력 양식이 맞지 않습니다.");
        }
    }

    private static void checkCustomEmpty(String str) {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("커스텀 구분자는 빈 문자열이 될 수 없습니다");
        }
    }

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        int sum = 0;

        if (input.contains("//") && input.contains("\\n")) {
            checkCustomStyle(input);
            String custom = input.substring(input.indexOf("//") + 2, input.indexOf("\\n"));
            checkCustomEmpty(custom);
            String newInput = input.substring(input.indexOf("\\n") + 2);
            String replacedInput = newInput.replace(custom, ",");

            String[] strArrCustom = replacedInput.split("[,:]");

            for (String str : strArrCustom) {
                if (!str.isEmpty()) {
                    checkIsValid(str);
                    sum += Integer.parseInt(str);
                }
            }
        } else if (input.contains(",") || input.contains(":")) {
            String[] strArrBasic = input.split("[,:]");

            for (String str : strArrBasic) {
                if (!str.isEmpty()) {
                    checkIsValid(str);
                    sum += Integer.parseInt(str);
                }
            }
        } else if (input.isEmpty()) {
            sum = 0;
        }

        System.out.println("결과 : " + sum);
    }
}

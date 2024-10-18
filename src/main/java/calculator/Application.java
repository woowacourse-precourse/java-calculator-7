package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static String CustomSeparator(String input) {
        if (input.startsWith("//") && input.substring(3, 5).equals("\\n")) {
            return Character.toString(input.charAt(2));
        } else {
            return null;
        }
    }

    public static String[] StringSplit(String input) {
        String Separator = CustomSeparator(input);
        if (Separator != null) {
            input = input.substring(5);
        } else {
            Separator = ",|:";
        }
        return input.split(Separator);
    }

    public static int calculator(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        int sum = 0;
        String[] number = StringSplit(input);
        for (String numbers : number) {
            if (numbers.contains("-")) {
                throw new IllegalArgumentException("음수 기능은 지원하지 않습니다.");
            }
            sum += Integer.parseInt(numbers);
        }
        return sum;

    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        String SeparatorWithNum = Console.readLine();
        int sum = calculator(SeparatorWithNum);
        System.out.println("결과 : " + sum);

    }
}


package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String UserInput = "";

        try {
            UserInput = Console.readLine();
        } catch (NoSuchElementException e) {
            System.out.println("결과 : 0");
        }

        String RefinedInput [] = Refiner(UserInput);
        int sum = Calculator(RefinedInput);

        System.out.println("결과 : "+sum);
    }

    public static String[] Refiner(String UserInput) {
        String defaultChar = ",|:";
        String customChar = "";

        if (UserInput.startsWith("//")) {
            int index = UserInput.indexOf("\\n");
            customChar = UserInput.substring(2, index);
            UserInput = UserInput.substring(index + 2);

            if (customChar.length() > 1) {
                throw new IllegalArgumentException("커스텀 구분자는 하나만 입력 가능합니다.");
            } else if (customChar.length() == 0) {
                throw new IllegalArgumentException("커스텀 구분자가 입력되지 않았습니다.");
            }
        }
        defaultChar += "|" + customChar;

        String RefinedInput[] = UserInput.split(defaultChar);
        return(RefinedInput);
    }

    public static int Calculator(String[] RefinedInput) {
        int sum = 0;
        for (String input : RefinedInput) {
            if (!input.isEmpty()) {
                try {
                    int number = Integer.parseInt(input.trim());
                    if (number < 0) {
                        throw new IllegalArgumentException("양수만 입력할 수 있습니다.");
                    }
                    else {
                        sum += number;
                    }
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("입력되지 않은 구분자입니다.");
                }
            }
        }
        return sum;
    }
}

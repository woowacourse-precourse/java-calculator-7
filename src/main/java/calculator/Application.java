package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력하세요.");
        String input = Console.readLine();
        System.out.println(calculate(input));
    }

    public static int calculate(String input) {
        int result;

        if (isBlank(input)) {
            result = 0;
        } else if (isNumber(input)) {
            result = Integer.parseInt(input);
        } else {
            if (isCustom(input)) {
                result = useCustomSeparator(input);
            } else {
                result = basicSeparator(input);
            }

        }
        System.out.println("결과 : " + result);
        return result;
    }

    public static boolean isBlank(String str) {
        return str == null || str.trim().isBlank();
    }

    public static boolean isNumber(String str) {
        try {
            Integer.parseInt(str.trim());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isCustom(String str) {
        return str.startsWith("//");
    }


    public static int useCustomSeparator(String str) {
        int separatorIndex = str.indexOf("\\n");
        String customSeparator = str.substring(2, separatorIndex);
        String numbers = str.substring(separatorIndex + 2);
        return numberSum(numbers.split(Pattern.quote(customSeparator)));
    }

    public static int basicSeparator(String str) {
        return numberSum(str.split("[,:]"));
    }

    public static int numberSum(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            int num = makeInt(number);
            checkMinus(num);
            sum += num;
        }
        return sum;
    }

    public static int makeInt(String number) {
        try {
            return Integer.parseInt(number.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkMinus(int number) {
        if (number < 0) {
            throw new IllegalArgumentException();
        }
    }
}

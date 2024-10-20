package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String str = Console.readLine();

        if (isBlank(str)) {
            System.out.println(0);
        } else {
            // string to int 반환
            if (isCustom(str)) {
                int result = useCustomSeparator(str);
                System.out.println(result);
            }
            // string to int 반환
            else {
                int result = basicSeparator(str);
                System.out.println(result);
            }
        }

    }

    public static boolean isBlank(String str) {
        return (str == null || str.trim().isEmpty());
    }

    public static boolean isCustom(String str) {
        return str.startsWith("//") && str.contains("\n");
    }

    //IllegalArgumentException 생각
    public static int useCustomSeparator(String str) {
        int separatorIndex = str.indexOf("\n");
        String customSeparator = str.substring(2, separatorIndex);
        String numbersTmp = str.substring(separatorIndex + 1);
        String[] numbers = numbersTmp.split(customSeparator);
        System.out.println("구분자 추출");
        return numberSum(numbers);
    }


    public static int basicSeparator(String str) {
        String[] numbers = str.split("[,:]");
        return numberSum(numbers);
    }

    public static int numberSum(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            int num = makeInt(number);
            if (num < 0) {
                throw new IllegalArgumentException();
            }
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
}
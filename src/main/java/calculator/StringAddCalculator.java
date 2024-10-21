package calculator;

import java.util.Arrays;

public class StringAddCalculator {
    public static int splitInput(String input){
        if(isNullOrEmpty(input)){
            return 0;
        }

        String[] numbers = splitString(input);
        return sumNumbers(numbers);
    }

    private static boolean isNullOrEmpty(String input){
        return input == null || input.isEmpty();
    }

    private static String[] splitString(String input){
        String delimiter = ",|:";

        if (input.startsWith("//")) {
            int delimiterIndex = input.indexOf("\\n");
            if (delimiterIndex == -1) {
                throw new IllegalArgumentException("구분자 지정 형식이 올바르지 않습니다. '\\n'이 필요합니다.");
            }
            delimiter = input.substring(2,delimiterIndex);
            String anotherDelimiter = "|".concat(input.substring(2, delimiterIndex));
            input = input.substring(delimiterIndex + 2);
            delimiter = delimiter.concat(anotherDelimiter);
        }

        return input.split(delimiter);
    }

    private static int sumNumbers(String[] numbers){
        int sum = 0;
        for(String number : numbers){
            int num;
            if(isNullOrEmpty(number)){
                num = 0;
            } else {
                num = checkNumber(number);
            }
            sum += num;
        }
        return sum;
    }

    private static int checkNumber(String number) {
        int num;
        try{
            num = Integer.parseInt(number);
            if(num < 0){
                throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자 혹은 구분자만 입력해주세요.");
        }
        return num;
    }
}

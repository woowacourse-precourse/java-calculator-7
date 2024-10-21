package calculator;

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

        //커스텀 구분자 추가 과정
        if (input.startsWith("//")) {
            int delimiterIndex = input.indexOf("\\n");
            wrongInputFormat(delimiterIndex); // 구분자 지정 형식이 올바르지 않을 경우

            String anotherDelimiter = "|".concat(input.substring(2, delimiterIndex));
            input = input.substring(delimiterIndex + 2);
            delimiter = delimiter.concat(anotherDelimiter);
        }

        return input.split(delimiter);
    }

    private static void wrongInputFormat(int delimiterIndex){
        if (delimiterIndex == -1) {
            throw new IllegalArgumentException("구분자 지정 형식이 올바르지 않습니다. '\\n'이 필요합니다.");
        }
    }

    private static int sumNumbers(String[] numbers){
        int sum = 0;
        for(String number : numbers){
            int num = arrayEmptyStringCheck(number);
            sum += num;
        }
        return sum;
    }

    private static int arrayEmptyStringCheck(String number){
        if (isNullOrEmpty(number)) {
            return 0;
        }
        return checkNumber(number);
    }

    private static int checkNumber(String number) {
        int num;
        try{
            num = Integer.parseInt(number);
            negativeNumberCheck(num);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자 혹은 구분자만 입력해주세요.");
        }
        return num;
    }

    private static void negativeNumberCheck(int num){
        if(num < 0){
            throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
        }
    }
}

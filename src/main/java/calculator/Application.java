package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        int sum = 0;

        String[] numbers = delimiter(input);
        sum = calulator(numbers);


        System.out.println("결과 : " + sum);
    }

    private static String[] delimiter(String input) {
        String default_Delimiters = ",|:";
        if (input.isEmpty()) {
            return null;
        }
        if (input.startsWith("//") && input.contains("\\n")) {
            int endIndex = input.indexOf("\\n");
            String number = input.substring(endIndex + 2);
            String custom_Delimiters = input.substring(2, endIndex);

            if ( custom_Delimiters.matches("[+-]?\\d*(\\.\\d+)?")) {
                throw new IllegalArgumentException();
            }
            if (number.isEmpty()) {
                return null;
            }
            return number.split(custom_Delimiters);
        }
        return input.split(default_Delimiters);
    }

    private static int calulator(String[] numbers) {
        List<Integer> listNumber = new ArrayList<>();
        int sum = 0;
        if ( numbers == null ){
            return sum;
        }
        for (String number : numbers){
            listNumber.add(parseInt(number));
        }
        sum = listNumber.stream().mapToInt(i -> i).sum();

        return sum;
    }

    private static int parseInt(String numbers){
        try {
            return Integer.parseInt(numbers);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }
    }
}

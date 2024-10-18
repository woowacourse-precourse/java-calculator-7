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
        if (input.isEmpty()){
            return null;
        }
        String default_Delimiters = ",|:";
        return input.split(default_Delimiters);
    }

    private static int calulator(String[] numbers) {
        List<Integer> listNumber = new ArrayList<>();
        int sum = 0;
        if (numbers == null){
            return sum;
        }
        for (String number : numbers){
            listNumber.add(Integer.parseInt(number));
        }
        sum = listNumber.stream().mapToInt(i -> i).sum();

        return sum;
    }

}

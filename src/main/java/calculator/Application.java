package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        try {
            System.out.println("덧셈할 문자열을 입력해 주세요.");
            String input = Console.readLine();
            int res = calSum(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private static int calSum(String input) {
        if(input.isEmpty()){
            return 0;
        }
        String separator = ",|;";
        String numbers = input;

        if(input.startsWith("//")){
            Matcher matcher = Pattern.compile("//(.)\\n(.*)").matcher(input);
            if(matcher.find()){
                separator = Pattern.quote(matcher.group(1));
                numbers = matcher.group(2);
            }
        }
        return Arrays.stream(numbers.split(separator))
                .mapToInt(Application::parseNumbers)
                .sum();
    }

    private static int parseNumbers(String numbers) {
        int number = Integer.parseInt(numbers);
        if(number < 0){
            throw new IllegalArgumentException();
        }
        return number;
    }
}

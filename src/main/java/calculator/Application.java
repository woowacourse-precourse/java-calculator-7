package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        System.out.print("덧셈할 문자열을 입력해주세요.");
        String input = readLine().trim();

        try{
            input = input.replace("\\n", "\n");
            int result = add(input);
            System.out.println("결과 : "+result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static int add(String input) {
        if(input == null || input.isEmpty()) {
            return 0;
        }

        String delimiter = "[,:|;]";

        if(input.startsWith("//")){
            Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(input);
            if(matcher.find()){
                String customDelimiter = matcher.group(1);
                delimiter = customDelimiter + "|" + delimiter;
                input = matcher.group(2);
            }else{
                throw new IllegalArgumentException("Invalid input");
            }
        }
        return sum(input, delimiter);

    }

    private static int sum(String numbers, String delimiter){
        String[] tokens = numbers.split(delimiter);
        int sum = 0;

        for(String token : tokens){
            if (!token.isEmpty()) { // 빈 문자열은 무시
                sum += Integer.parseInt(token);
            }
        }

        return sum;
    }
}

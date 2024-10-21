package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class StringCalculator{
    public static int add(String input){
        //String[] numbers = input.split(",|:");
        if (input == null || input.isEmpty()){
            return 0;
        }
        String delimiter = ",|:";

        Matcher matcher = Pattern.compile("//(.)\\\\n(.*)").matcher(input);
        if (matcher.find()){
            String customDelimiter = Pattern.quote(matcher.group(1));
            input = matcher.group(2);
            String[] numbers = input.split(customDelimiter);
            return sumNumbers(numbers);
        }
        String[] numbers = input.split(delimiter);
        return sumNumbers(numbers);

    }

    private static int sumNumbers(String[] numbers){
        int sum = 0;
        for (String number : numbers){
            number = number.trim();
            if (!number.isEmpty()){
                try{
                    int parsedNumber = Integer.parseInt(number);
                    if (parsedNumber <= 0){
                        throw new IllegalArgumentException("양수만 입력가능합니다: " + parsedNumber);
                    }
                    sum += parsedNumber;
                } catch(NumberFormatException e) {
                    throw new IllegalArgumentException("숫자 형식이 잘못됬습니다." + number);
                }
            }
        }
        return sum;
    }
}


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        // System.out.println("입력값: " + input);
        try{
            int result = StringCalculator.add(input);
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e){
            System.err.println("에러 : " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e){
            System.err.println("기타 오류가 발생했습니다.");
            e.printStackTrace();
        }

    }
}
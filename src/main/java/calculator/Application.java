package calculator;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("덧셈할 문자열을 입력해 주세요.\n");
        String input = scanner.nextLine();
        int sum = 0;

        if (input.startsWith("//")) {
            // 커스텀 문자열 사용
            String [] customInfo = input.split("\\\\n", 2);
            if (customInfo[0].equals("//") && customInfo[1].startsWith("\\n")){
                String numbersString = customInfo[1].substring(2);
                String[] parsedInput = numbersString.split(",|:|\\\\n");
                for (String number : parsedInput) {
                    sum += Integer.parseInt(number);
                }
            }
            else{
                String customString = Pattern.quote(customInfo[0].substring(2));
                String numbersString = customInfo[1];
                String[] parsedInput = numbersString.split(String.format("%s|,|:", customString));
                for (String number : parsedInput) {
                    sum += Integer.parseInt(number);
                }
            }
        }
        else {
            // 커스텀 문자열 미사용
            String[] parsedInput = input.split("[,:]");

            for (String s : parsedInput) {
                sum += Integer.parseInt(s);
            }
        }
        System.out.println("결과 : " + sum);
    }
}
package calculator;
import java.util.Arrays;
import  java.util.Scanner;
public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = scanner.nextLine();
        int result = calculator(input);
        System.out.println("결과 : " + result);
        scanner.close();

    }

    public static int calculator(String input) {
        if (input.isEmpty()) {
            return 0;
        }
        String delimiter = ",|:";
        if (input.startsWith("//")) {
            int delimiterIndex = input.indexOf("\\n");
            for (int i = 2; i < delimiterIndex; i++) {
                delimiter += "|" + input.charAt(i);
            }
            input = input.substring(delimiterIndex + 2);
        }
        System.out.println(delimiter);
        String[] tokens = input.split(delimiter);
        System.out.println(Arrays.toString(tokens));
        int sum = 0;
        for (String token : tokens) {
            try {
                sum += Integer.parseInt(token);

        }  catch(NumberFormatException e){
            throw new IllegalArgumentException("잘못된 입력입니다. :" + token);
        }
    }
        return  sum;
    }
}


package calculator;
import java.util.Scanner;

public class Application {
    public static int add(String input){
        if(input.isEmpty()){
            return 0;
        }
    

        String delimiter = ",|:|\\n";
                    

        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\n");
            if(delimiterEndIndex > 0){
            delimiter = input.substring(2, delimiterEndIndex);
            input = input.substring(delimiterEndIndex + 1); 
        }
    }

        String[] numbers = input.split(delimiter);
        int sum = 0;
        
        for (String number : numbers) {
            try{
                int num = Integer.parseInt(number.trim());
                if(num < 0){
                    throw new IllegalArgumentException("음수는 입력할 수 없습니다: " + number);
                }
                sum += num;
            } catch (NumberFormatException error){
                throw new IllegalArgumentException("잘못된 입력입니다: " + number);
            }
    }
    return sum;
}

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){
        System.out.println("덧셈할 문자열을 입력해주세요.");
        String input = scanner.nextLine();
        
            try{
                int result = add(input);
                System.out.println("결과 : " + result);
            } catch (IllegalArgumentException error){
                System.out.println("오류 :" + error.getMessage());
            }
        }
    }
}

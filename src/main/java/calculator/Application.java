package calculator;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("덧셈할 문자열을 입력해 주세요.\n");

        try{
            final String input = scanner.nextLine();
            int result = makeCalculation(input);
            printResult(result);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        } finally {
            scanner.close();
        }
    }


    public static int makeCalculation(final String input) {
        int i = 0;
        int sum = 0;
        String Num = "0";
        char custom = '\u0000';

        if(input.length() >= 5) {
            String subS = input.substring(0,2);
            String subN = input.substring(3,5);
            if (subS.equals("//") && subN.equals("\\n")) {
                custom = input.charAt(2);
                i=5;
            }
        }

        while (i != input.length()) {
            char curVal = input.charAt(i);

            if(curVal >= '0' && curVal <= '9') {
               Num += Character.toString(curVal);
            } else if(curVal == ',' || curVal == ':' || curVal == custom) {
                sum += Integer.parseInt(Num);
                Num = "0";
            } else{
                throw new IllegalArgumentException();
            }
            ++i;
        }

        sum += Integer.parseInt(Num); //마지막 숫자
        return sum;
    }


    public static void printResult(int result){
        System.out.println("결과 : " + result);
    }


}


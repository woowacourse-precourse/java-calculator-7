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
            return;
        } finally {
            scanner.close();
        }
    }


    public static int makeCalculation(final String input) throws IllegalArgumentException {
        int i = 0;
        int sum = 0;
        String Num = "";

        while (i != input.length()) {
            char curVal = input.charAt(i);

            if(curVal >= '0' && curVal <= '9') {
               Num += Character.toString(curVal);
            } else if(curVal == ',' || curVal == ':') {
                sum += Integer.parseInt(Num);
                Num = "";
            } else if(curVal == '/'){
                char nxtVal = input.charAt(i+1);
                if(nxtVal == '/'){
                    find_escapeN();
                } else{
                    throw new IllegalArgumentException();
                }

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

    public static void find_escapeN() {
        //\n을 찾는 알고리즘
    }
}


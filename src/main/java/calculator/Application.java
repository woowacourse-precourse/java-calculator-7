package calculator;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        /**
         * 기능
         * 1. 기본조건: , 와 ; 처리
         * 2. 커스텀 구분자 ex)//,\n
         * 3. 예외처리: IllegalArgumentException 발생 후 종료
         */

        Scanner scanner = new Scanner(System.in);
        System.out.print("덧셈할 문자열을 입력해 주세요.\n");


        try{
            final String input = scanner.nextLine();
            int result = makeCalculation(input);
            printResult(result);
        } catch (Exception e) {
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
            char curNum = input.charAt(i);

            if(curNum >= '0' && curNum <= '9') {
               Num += Character.toString(curNum);
            } else if(curNum == ',' || curNum == ':') {
                sum += Integer.parseInt(Num);
                Num = "";
            }
            ++i;
            //2. 만약, "/나올시 //?\n인지 탐색"
        }

        sum += Integer.parseInt(Num); //마지막 숫자
        return sum;
    }


    static void printResult(int result){
        System.out.println("결과 : " + result);
    }
}



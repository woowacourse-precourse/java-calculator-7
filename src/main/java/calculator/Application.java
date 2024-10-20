package calculator;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.print("덧셈할 문자열을 입력해 주세요.\n");

            try{
                final String input = scanner.nextLine();
                int result = makeCalculation(input);
                printResult(result);
            } catch (IllegalArgumentException e) {
                scanner.close();
                return;
            }
        }
    }


    public static int makeCalculation(final String input) throws IllegalArgumentException {
        int i = 0;
        int sum = 0;
        String Num = "0";

        while (i != input.length()) {
            char curVal = input.charAt(i);

            if(curVal >= '0' && curVal <= '9') {
               Num += Character.toString(curVal);
            } else if(curVal == ',' || curVal == ':') {
                sum += Integer.parseInt(Num);
                Num = "";
            } else if(curVal == '/'){
                if( (i+1) <= input.length() ) {
                    char nxtVal = input.charAt(i+1); /*Index Out of Bounds 처리 해줘야함*/
                    if(nxtVal == '/'){
                        i = FindEscapeN(i+2, input);
                        sum += Integer.parseInt(Num);
                        Num = "";

                    } else{
                        throw new IllegalArgumentException();
                    }
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

    public static int FindEscapeN(int idx, final String input) {

        while( idx != input.length() ) { //\n 검색
            char curVal = input.charAt(idx);
            if (curVal == '\\') {
                if( (idx+1) <= input.length() )  {
                    char nxtVal = input.charAt(idx+1);
                    if(nxtVal == 'n'){  //\n 검색 성공
                        return idx+1;
                    } else{
                        ++idx; continue; //\n 아닐시, \을 커스텀 구분자의 일부로 판단
                    }
                }
            }
            ++idx;
        }

        throw new IllegalArgumentException(); //검색 실패*/
    }
}


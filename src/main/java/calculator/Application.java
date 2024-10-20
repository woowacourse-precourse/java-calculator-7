package calculator;

import java.util.Scanner;

public class Application {
    private static int normalDeliCal(String st){
        int result = 0;

        for(int i = 0; i < st.length(); i++){
            if(48 <= st.charAt(i) && st.charAt(i) < 58){
                result += st.charAt(i) - 48;
            }
            else if( ! (st.charAt(i) == ',' || st.charAt(i) == ':')){
                throw new IllegalArgumentException();
            }
        }

        return result;
    }
    private static int customDeliCal(char deli, String st){
        int result = 0;

        for(int i = 0; i < st.length(); i++){
            if(48 <= st.charAt(i) && st.charAt(i) < 58){
                result += st.charAt(i) - 48;
            }
            else if(st.charAt(i) != deli){
                throw new IllegalArgumentException();
            }
        }

        return result;
    }
    private static boolean checkCustomDeli(String st){

        if(st.substring(0, 2).equals("//") && st.substring(3,5).equals("\\n")){
            return true;
        }
        return false;
    }

    private static int Calculator(String st){

        boolean isCustom = checkCustomDeli(st);

        if(!isCustom){
            return normalDeliCal(st);
        }
        else{
            return customDeliCal(st.charAt(2), st.substring(5));
        }
    }
    public static void main(String[] args) {
        // 프로그램 구현
        Scanner sc = new Scanner(System.in);
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = sc.nextLine();

        int answer = Calculator(input);
        System.out.printf("결과 : %d", answer);
    }
}

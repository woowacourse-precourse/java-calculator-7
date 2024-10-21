package calculator;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int sum = 0;

        for(int i=0; i<str.length(); i++){
            if(isNumber(str.charAt(i))){
                sum += Integer.parseInt(String.valueOf(str.charAt(i)));
            }
        }
        System.out.println("결과 : " + sum);
    }
    public static boolean isNumber(char str){
        try{
            int num = Integer.parseInt(String.valueOf(str));
            return true;
        }catch(NumberFormatException e) {
            return false;
        }
    }
}

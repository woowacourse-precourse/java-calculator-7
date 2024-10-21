package calculator;

import camp.nextstep.edu.missionutils.Console;


public class Application {
    public static void main(String[] args) {
        //사용자로부터 문자열 입력 받기
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String inputStr = Console.readLine();
        int answer = 0;
        if(isNull(inputStr)){
            displayResult(answer);
        }else{
            //사용자 입력 문자열 분리하기 with 기본 구분자
            splitBasic(inputStr);
        }
        Console.close();
    }
    private static String[] splitBasic(String inputStr) {
        return inputStr.split(",|:");
    }
    private static void displayResult(int result) {
        System.out.println("결과: " + result);
    }
    private static boolean isNull(String s) {
        return s == null || s.isEmpty();
    }
}

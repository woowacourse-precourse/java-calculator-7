package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Calculator {
    /**
     * 문자열 계산기를 실행하는 함수
     * **/
    public static void run(){
        int sum = 0;
        String str = input();
        // 빈 문자열이면 "0"을 반환
        if(!str.isEmpty()) {
            String[] strArr = operator(str);
            sum = add(strArr);
        }
        // 결과 출력하기
        System.out.printf("결과 : %d", sum);
    }

    /**
     * 문자열 입력받기
     * **/
    private static String input(){
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }

    /**
     * 구분자에 따라 문자열 분리하는 함수
     * **/
    private static String[] operator(String str){
        if(str.startsWith("//") && str.substring(3,5).equals("\\n")){
            String op = str.substring(2,3);
            str = str.substring(5);
            // 백슬래시 구분자 처리
            if (op.equals("\\")) {
                op = "\\\\";
            }
            return str.split(op);
        }else {
            return str.split(",|:");
        }
    }

    /**
     * 숫자를 합하는 함수
     * **/
    private static int add(String[] strArr){
        int sum = 0;
        for(String i : strArr){
            try {
                int num = Integer.parseInt(i);
                if (!i.matches("[+-]?\\d*(\\.\\d+)?") || num <= 0) {
                    throw new IllegalArgumentException("0 또는 음수는 허용되지 않습니다.");
                }
                sum += num;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("숫자가 올바르게 입력되지 않았습니다.");
            }
        }
        return sum;
    }
}
package calculator;

import camp.nextstep.edu.missionutils.Console;




public class Application {



    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");

        String input = Console.readLine();
        if(input.equals("")){
            System.out.println("결과 : 0");
            return;
        }
        int sum = 0;
        String delimiter = ",|:";

        try{
            if(input.startsWith("//")){
                if(input.charAt(3)=='\\'&&input.charAt(4)=='n') {
                    String customDelimiter = String.valueOf(input.charAt(2));
                    customDelimiter = customDelimiter.replaceAll("([\\\\\\[\\]{}()*+?^$|.])", "\\\\$1");
                    delimiter += "|" + customDelimiter;
                    input = input.substring(5);
                } else{
                    throw new IllegalArgumentException("유효하지 않은 구분자 형식입니다.");
                }
            }
        }
        catch(Exception e){
            System.out.println("error: " + e.getMessage());
        }
        String[] numbers = input.split(delimiter, -1);

        for (String number : numbers) {
            if(number.equals(""))
                continue;
            try{
                int num=0;
                try {
                    num = Integer.parseInt(number);
                } catch (NumberFormatException e) { // 숫자가 아닌 경우 IllegalArgumentException 발생
                    throw new IllegalArgumentException("잘못된 숫자 형식입니다.");
                }
                if(num<0)
                    throw new IllegalArgumentException("양의 정수가 아닙니다.");
                sum += num;
            } catch (IllegalArgumentException e){
                System.out.println("error: " + e.getMessage());
            }
        }



        System.out.println("결과 : " + sum);
    }
}

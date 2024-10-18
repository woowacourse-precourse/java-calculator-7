package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String str = Console.readLine();
        Console.close();

    }

    public static long parseLong(String str){
        try{
            long num = Long.parseLong(str);
            if(num <= 0){
                throw new IllegalArgumentException();
            }
            return num;
        }catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }
    }

}

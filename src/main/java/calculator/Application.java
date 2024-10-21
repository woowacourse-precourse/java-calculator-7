package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        int sum;
        if (nullCheck(input)){
            sum = 0;
            System.out.println("결과 : " + sum);
        } else {
            String[] inputs = stringSplit(input);
            for (String str : inputs) {
                System.out.println(str);
            }
        }//if end
    }//main() end

    private static String[] stringSplit(String input){
            return input.split(",|:");
    }//stringSplit() end


    private static boolean nullCheck(String input) {
        return input.isEmpty() || input.trim().isEmpty();
    }//nullCheck() end

}//class end

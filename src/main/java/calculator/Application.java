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
        if(input.startsWith("//")){
            int separEndIndex = input.indexOf("\\n");
            if(separEndIndex != -1){
                String customSeparator = input.substring(2, separEndIndex);
                String numbers = input.substring(separEndIndex+2);
                return numbers.split(customSeparator);
            } else {
                throw new IllegalArgumentException("잘못된 형식입니다. \\n을 포함하여 다시 입력해주세요");
            }//if end
        } else {
            return input.split(",|:");
        }//if end
    }//stringSplit() end

    private static boolean nullCheck(String input) {
        return input.isEmpty() || input.trim().isEmpty();
    }//nullCheck() end

}//class end

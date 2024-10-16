package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        int sum = 0;

        if(input.contains(",") || input.contains(":")) {
            for(int i = 0; i < input.length(); i++){
                if(String.valueOf(input.charAt(i)).equals(",")) {
                    continue;
                }else if(String.valueOf(input.charAt(i)).equals(":")) {
                    continue;
                }else {
                    sum += Character.getNumericValue(input.charAt(i));
                }
            }
        }

        System.out.println("결과 : " + sum);
    }
}

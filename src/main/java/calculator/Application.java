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

        if(input.contains("//") && input.contains("\\n")) {
            String custom = input.substring(input.indexOf("//")+2, input.indexOf("\\n"));
            String newInput = input.substring(input.indexOf("\\n")+2);
            for(int i = 0; i < newInput.length(); i++) {
                if(String.valueOf(newInput.charAt(i)).equals(custom)) {
                    continue;
                }else {
                    sum += Character.getNumericValue(newInput.charAt(i));
                }
            }
        }

        System.out.println("결과 : " + sum);
    }
}

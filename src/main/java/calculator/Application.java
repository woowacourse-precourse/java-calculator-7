package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        int sum = 0;

        if(input.contains("//") && input.contains("\\n")) {
            String custom = input.substring(input.indexOf("//")+2, input.indexOf("\\n"));
            String newInput = input.substring(input.indexOf("\\n")+2);
            String replacedInput = newInput.replace(custom, ",");

            String[] strArrCustom = replacedInput.split("[,:]");

            for(String str : strArrCustom) {
                if(!str.isEmpty()) {
                    sum += Integer.parseInt(str);
                }
            }
        }else if(input.contains(",") || input.contains(":")) {
            String[] strArrBasic = input.split("[,:]");

            for(String str : strArrBasic) {
                if(!str.isEmpty()) {
                    sum += Integer.parseInt(str);
                }
            }
        }else if(input.isEmpty()) {
            sum = 0;
        }

        System.out.println("결과 : " + sum);
    }
}

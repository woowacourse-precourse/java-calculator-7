package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String inputStr= Console.readLine();
        String[] splitStr;

        if(inputStr.startsWith("//")){
            inputStr=changeString(inputStr);
        }

        splitStr=changeToArray(inputStr);

        int answer= Arrays.stream(splitStr)
                        .mapToInt(Integer::parseInt)
                                .sum();

        System.out.println("결과 : "+answer);
    }

    public static String changeString(String input){
        input= input.substring(4);
        String index= input.substring(2,3);
        input=input.replace(index,",");

        return input;
    }

    public static String[] changeToArray(String changeInput){
        String [] toArray= changeInput.split(",|;");

        for (int i = 0; i < toArray.length; i++) {
            toArray[i] = toArray[i].replaceAll("[^0-9]", "");
        }

        return toArray;
    }

}

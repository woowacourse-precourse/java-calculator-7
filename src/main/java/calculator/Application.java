package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;

public class Application {


    public static void main(String[] args) {

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String inputStr= Console.readLine();

        try{
            Method method= new Method();

            String[] splitStr;

            if(inputStr.startsWith("//")){
                inputStr=method.changeString(inputStr);
            }

            splitStr=method.changeToArray(inputStr);

            int answer= Arrays.stream(splitStr)
                    .mapToInt(Integer::parseInt)
                    .sum();

            System.out.println("결과 : "+answer);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

}
